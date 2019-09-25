package com.example.teste1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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

import org.json.JSONObject;

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
    private LocalizacaoAtual localizador = new LocalizacaoAtual(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("CADASTRO DE VISTORIA");
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.pager);

        final pagerAdapter pager = new pagerAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.titlesTabs));
        viewPager.setAdapter(pager);



        tabLayout.setupWithViewPager(viewPager);

        for(int count = 0; count < 6; count++)
        pager.instantiateItem(viewPager, count);


        final FloatingActionButton fab = findViewById(R.id.fab);


        final JSONObject jsonEnviar =  new JSONObject();;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Local3", localizador.getLocation());


                ocorrenciaCadastro ocorrencia = (ocorrenciaCadastro) pager.getRegisteredFragment(0);
                danosHumanos humanos = (danosHumanos) pager.getRegisteredFragment(1);
                danosMateriais materiais = (danosMateriais) pager.getRegisteredFragment(2);
                danosAmbientais ambientais = (danosAmbientais) pager.getRegisteredFragment(3);
                danosEconomicos economicos = (danosEconomicos) pager.getRegisteredFragment(4);
                iahframento iah = (iahframento) pager.getRegisteredFragment(5);
//
                try {
                    ocorrencia.getDados(jsonEnviar);
                    humanos.getDados(jsonEnviar);
                    materiais.getDados(jsonEnviar);
                    ambientais.getDados(jsonEnviar);
                    economicos.getDados(jsonEnviar);
                    iah.getDados(jsonEnviar);

                } catch (Exception e) {
                    Log.d("Exep", e.getLocalizedMessage() + " " + e.getMessage());
                }


           Log.d("Json", jsonEnviar.toString());



//envio daqui

//st = new SocketTask("192.168.1.55", 6666, 5000) {
//    @Override
//    protected void onProgressUpdate(String... values) {
//        super.onProgressUpdate(values);
//    }
//};
//
//
//st.execute(dado);



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
