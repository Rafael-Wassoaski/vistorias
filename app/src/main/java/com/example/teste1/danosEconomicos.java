package com.example.teste1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;


public class danosEconomicos extends Fragment implements DadosInterface{

    private HashMap<CheckBox, EditText> economicos = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_danos_economicos, container, false);

        economicos.put((CheckBox)view.findViewById(R.id.danosAgricultura), (EditText)view.findViewById(R.id.agriculturaQuant));
        economicos.put((CheckBox)view.findViewById(R.id.danosPecuária), (EditText)view.findViewById(R.id.pecuariaQuant));
        economicos.put((CheckBox)view.findViewById(R.id.danosComercio), (EditText)view.findViewById(R.id.comercioQuant));
        economicos.put((CheckBox)view.findViewById(R.id.danosIndustria), (EditText)view.findViewById(R.id.industriaQuant));
        economicos.put((CheckBox)view.findViewById(R.id.danosServicos), (EditText)view.findViewById(R.id.servicosQuant));

        for(Map.Entry<CheckBox, EditText> entrada : economicos.entrySet()){


            final EditText editText = entrada.getValue();

            editText.setVisibility(View.INVISIBLE);
        }


        for(Map.Entry<CheckBox, EditText> entrada : economicos.entrySet()){

            CheckBox checkBox = entrada.getKey();
            final EditText editText = entrada.getValue();

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(compoundButton.isChecked()){
                        editText.setVisibility(View.VISIBLE);
                    }else{
                        editText.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }


        return view;
    }

    @Override
    public String getDados() {
        String dados = "{";

        for(Map.Entry<CheckBox, EditText> entrada : economicos.entrySet()){

            CheckBox checkBox = entrada.getKey();
            final EditText editText = entrada.getValue();

            if(checkBox.isChecked()){

                dados += checkBox.getText().toString() + ": "+ editText.getText().toString() + ",";
            }
        }



        dados += "}";

        return dados;
    }

    @Override
    public Boolean verficaDados() {
        for(Map.Entry<CheckBox, EditText> entrada : economicos.entrySet()){

            CheckBox checkBox = entrada.getKey();
            final EditText editText = entrada.getValue();

            if(checkBox.isChecked() && editText.getText().toString().isEmpty()){
                editText.requestFocus();
                return  false;
            }
        }

        return true;
    }
}
