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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class danosAmbientais extends Fragment implements DadosInterface{
   private CheckBox contamincaoAgua;
   private  CheckBox contamincaoSolo;
   private  CheckBox contamincaoAr;
   private  EditText AguaQuant;
   private EditText SoloQuant;
   private EditText ArQuant;



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
        ArQuant = (EditText)view.findViewById(R.id.quantidadeAr);
        SoloQuant = (EditText)view.findViewById(R.id.quantidadeSolo);



        contamincaoAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    ArQuant.setVisibility(View.VISIBLE);
                }else{
                    ArQuant.setVisibility(View.INVISIBLE);
                }
            }
        });

        contamincaoSolo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SoloQuant.setVisibility(View.VISIBLE);
                }else{

                    SoloQuant.setVisibility(View.INVISIBLE);
                }
            }
        });


        contamincaoAgua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    AguaQuant.setVisibility(View.VISIBLE);
                }else{
                    AguaQuant.setVisibility(View.INVISIBLE);
                }
            }
        });









        return view;
    }





    @Override
    public Boolean verficaDados(){

        if(contamincaoSolo.isChecked()){
            if(SoloQuant.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Você não informou a quantide de pessoas atingidas", Toast.LENGTH_LONG);

                SoloQuant.requestFocus();
                return false;
            }
        }

        if(contamincaoAr.isChecked()){
            if(ArQuant.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Você não informou a quantide de pessoas atingidas", Toast.LENGTH_LONG);

                ArQuant.requestFocus();
                return false;
            }
        }


        if(contamincaoAgua.isChecked()){
            if(AguaQuant.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Você não informou a quantide de pessoas atingidas", Toast.LENGTH_LONG);
                AguaQuant.requestFocus();
                return false;
            }
        }


        return true;

    }


    @Override
    public void getDados(JSONObject json) throws JSONException {






        if(verficaDados()) {





            if(contamincaoAgua.isChecked()) {
                json.put("contaminacao_agua", AguaQuant.getText());
            }else{
                json.put("contaminacao_agua", 0);
            }




            if(contamincaoSolo.isChecked()) {

                json.put("contaminacao_solo", SoloQuant.getText());
            }else{
                json.put("contaminacao_solo", 0);
            }





            if(contamincaoAr.isChecked()) {

                json.put("contaminacao_ar", ArQuant.getText());
            }else{
                json.put("contaminacao_ar", 0);

            }

        }


    }

}


