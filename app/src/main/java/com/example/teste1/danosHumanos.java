package com.example.teste1;

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


public class danosHumanos extends Fragment implements DadosInterface{

    CheckBox desalojados;
    CheckBox desabrigados;
    CheckBox desaparecidos;
    CheckBox feridos;
    CheckBox enfermos;
    CheckBox mortos;
    CheckBox isolados;
    CheckBox atingidos;
    CheckBox afetados;

    EditText desalojadosQuant;
    EditText desabrigadosQuant;
    EditText desaparecidosQuant;
    EditText feridosQuant;
    EditText enfermosQuant;
    EditText mortosQuant;
    EditText isoladosQuant;
    EditText atingidosQuant;
    EditText afetadosQuant;

    Map<CheckBox, EditText> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        lista = new HashMap<>();
        View view = inflater.inflate(R.layout.fragment_danos_humanos, container, false);
        desalojados = (CheckBox)view.findViewById(R.id.desalojados);
        desalojadosQuant = (EditText)view.findViewById(R.id.desalojadosQuant);
        desabrigados = (CheckBox)view.findViewById(R.id.desabrigados);
        desabrigadosQuant = (EditText)view.findViewById(R.id.desabrigadosQuant);
        desaparecidos = (CheckBox)view.findViewById(R.id.desaparecidos);
        feridos = (CheckBox)view.findViewById(R.id.feridos);
        enfermos = (CheckBox)view.findViewById(R.id.enfermos);
        mortos = (CheckBox)view.findViewById(R.id.mortos);
        isolados = (CheckBox)view.findViewById(R.id.isolados);
        atingidos = (CheckBox)view.findViewById(R.id.atingidos);
        afetados = (CheckBox)view.findViewById(R.id.afetados);

        desaparecidosQuant = (EditText)view.findViewById(R.id.desaparecidosQuant);
        feridosQuant = (EditText)view.findViewById(R.id.feridosQuant);
        enfermosQuant = (EditText)view.findViewById(R.id.enfermosQuant);
        mortosQuant = (EditText)view.findViewById(R.id.mortosQuant);
        isoladosQuant = (EditText)view.findViewById(R.id.isoladosQuant);
        atingidosQuant = (EditText)view.findViewById(R.id.atingidosQuant);
        afetadosQuant = (EditText)view.findViewById(R.id.afetadosQuant);

        lista.put(desalojados, desalojadosQuant);
        lista.put(desabrigados, desabrigadosQuant);
        lista.put(desaparecidos, desaparecidosQuant);
        lista.put(feridos, feridosQuant);
        lista.put(enfermos, enfermosQuant);
        lista.put(mortos, mortosQuant);
        lista.put(isolados, isoladosQuant);
        lista.put(atingidos, atingidosQuant);
        lista.put(afetados, afetadosQuant);

        for(Map.Entry<CheckBox, EditText> entrada : lista.entrySet()){

            CheckBox checkBox = entrada.getKey();
            final EditText editText = entrada.getValue();

           editText.setVisibility(View.INVISIBLE);
        }


        for(Map.Entry<CheckBox, EditText> entrada : lista.entrySet()){

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

        for(Map.Entry<CheckBox, EditText> entrada : lista.entrySet()){

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



        for(Map.Entry<CheckBox, EditText> entrada : lista.entrySet()){

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
