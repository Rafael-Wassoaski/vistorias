package com.example.teste1;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<DadosInterface> fragmentos = new ArrayList<DadosInterface>();
    private String dado;
    private SocketTask st;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("CADASTRO DE VISTORIA");
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.pager);

        final pagerAdapter pager = new pagerAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.titlesTabs));
        viewPager.setAdapter(pager);

        tabLayout.setupWithViewPager(viewPager);







        final FloatingActionButton fab = findViewById(R.id.fab);





        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dado = "{";

                    ocorrenciaCadastro ocorrencia = (ocorrenciaCadastro)pager.getRegisteredFragment(0);
                    danosHumanos humanos = (danosHumanos)pager.getRegisteredFragment(1);
                    danosMateriais materiais = (danosMateriais)pager.getRegisteredFragment(2);
                    danosAmbientais ambientais = (danosAmbientais)pager.getRegisteredFragment(3);
                    danosEconomicos economicos = (danosEconomicos)pager.getRegisteredFragment(4);
                    iahframento iah = (iahframento)pager.getRegisteredFragment(5);
//
try {
    dado+=ocorrencia.getDados() + "\n";
    dado+=humanos.getDados()+ "\n";
    dado+=ambientais.getDados()+ "\n";
    dado += economicos.getDados()+ "\n";
    dado+=iah.getDados()+ "\n";
    dado+=materiais.getDados()+ "\n";
}catch (Exception e){
    Log.d("Exep", e.getLocalizedMessage() + " " + e.getMessage());
}


dado+="}";

try {
    fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
        @Override
        public void onSuccess(Location location) {
            if(location!=null){
                Log.d("Local", location.toString());
            }
        }
    });
}catch (Exception e ){
    e.printStackTrace();
}




st = new SocketTask("192.168.1.70", 23456, 5000) {
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
};


st.execute(dado);



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
