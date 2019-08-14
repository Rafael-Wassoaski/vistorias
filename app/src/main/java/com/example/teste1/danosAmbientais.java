package com.example.teste1;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class danosAmbientais extends Fragment {


    CheckBox contamincaoAgua;
    CheckBox contamincaoSolo;
    CheckBox contamincaoAr;
    EditText AguaQuant;



    public danosAmbientais() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_danos_ambientais, container, false);
        contamincaoAgua = (CheckBox) view.findViewById(R.id.contaminacaoAgua);
        contamincaoSolo = (CheckBox) view.findViewById(R.id.ContaminacaoSolo);
        contamincaoAr = (CheckBox) view.findViewById(R.id.contaminacaoAr);
        AguaQuant = (EditText)view.findViewById(R.id.AguaQuantidade);




        return inflater.inflate(R.layout.fragment_danos_ambientais, container, false);
    }



    public String getDados(){

        String dados = "{";

        dados += "Agua: "+contamincaoAgua.isChecked()+",";
        dados += "Solo: "+contamincaoSolo.isChecked()+",";
        dados += "Ar: "+contamincaoAr.isChecked()+"}";

        return dados;


    }

}
