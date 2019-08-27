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


public class danosMateriais extends Fragment implements DadosInterface{


    private HashMap<CheckBox, EditText> materiais = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_danos_materiais, container, false);

        materiais.put((CheckBox)view.findViewById(R.id.atingidos), (EditText)view.findViewById(R.id.UHatingidosQuanto));
        materiais.put((CheckBox)view.findViewById(R.id.danificadas), (EditText)view.findViewById(R.id.UHdanificadosQuant));
        materiais.put((CheckBox)view.findViewById(R.id.interditadas), (EditText)view.findViewById(R.id.UHinterditadasQuant));
        materiais.put((CheckBox)view.findViewById(R.id.destruidas), (EditText)view.findViewById(R.id.UHdestruidasQuant));
        materiais.put((CheckBox)view.findViewById(R.id.instalacaoSaude), (EditText)view.findViewById(R.id.saudeQuant));
        materiais.put((CheckBox)view.findViewById(R.id.instalacoesComunitarias), (EditText)view.findViewById(R.id.comunitariasQuant));
        materiais.put((CheckBox)view.findViewById(R.id.instalacoesEnsino), (EditText)view.findViewById(R.id.ensinoQuant));
        materiais.put((CheckBox)view.findViewById(R.id.obrasPublicas), (EditText)view.findViewById(R.id.obrasQuant));
        materiais.put((CheckBox)view.findViewById(R.id.interrupcaoServicos), (EditText)view.findViewById(R.id.servicosQuant));


        for(Map.Entry<CheckBox, EditText> entrada : materiais.entrySet()){

            CheckBox checkBox = entrada.getKey();
            final EditText editText = entrada.getValue();

            editText.setVisibility(View.INVISIBLE);
        }


        for(Map.Entry<CheckBox, EditText> entrada : materiais.entrySet()){

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

        for(Map.Entry<CheckBox, EditText> entrada : materiais.entrySet()){

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

        for(Map.Entry<CheckBox, EditText> entrada : materiais.entrySet()){

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

