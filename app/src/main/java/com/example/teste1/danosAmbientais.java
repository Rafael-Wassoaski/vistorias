package com.example.teste1;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class danosAmbientais extends Fragment {


    private CheckBox contamincaoAgua;
   private  CheckBox contamincaoSolo;
   private  CheckBox contamincaoAr;
   private  EditText AguaQuant;



    public danosAmbientais() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_danos_ambientais, container, false);
        contamincaoAgua = (CheckBox) view.findViewById(R.id.contaminacaoAgua);

        contamincaoAgua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d("ola", "opa");
            }
        });
        contamincaoSolo = (CheckBox) view.findViewById(R.id.ContaminacaoSolo);
        contamincaoAr = (CheckBox) view.findViewById(R.id.contaminacaoAr);
        AguaQuant = (EditText)view.findViewById(R.id.AguaQuantidade);

        AguaQuant.setVisibility(View.INVISIBLE);




        return inflater.inflate(R.layout.fragment_danos_ambientais, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }




    public String getDados(){

        String dados = "{";

        dados += "Agua: "+contamincaoAgua.isChecked()+",";
        dados += "Solo: "+contamincaoSolo.isChecked()+",";
        dados += "Ar: "+contamincaoAr.isChecked()+"}";

        return dados;


    }

}
