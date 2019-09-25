package com.example.teste1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class ocorrenciaCadastro extends Fragment implements DadosInterface{


    public ocorrenciaCadastro() {
        // Required empty public constructor
    }
private  ArrayAdapter<CharSequence> municipiosArray;
    private Spinner municipioSpinner;
    private TextView data;
    private TextView hora;
    private Spinner coderecSpinnder;
    private ArrayAdapter<CharSequence> coderecArray;
    private EditText cobrad;
    private EditText endereco;
    private EditText descricao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ocorrencia_cadastro, container, false);


        cobrad = (EditText)view.findViewById(R.id.COBRAD);
        descricao = (EditText)view.findViewById(R.id.descDesastre);
        data = (TextView)view.findViewById(R.id.data);
        hora = (TextView)view.findViewById(R.id.hora);
        municipioSpinner = (Spinner)view.findViewById(R.id.municipio);
        municipiosArray = ArrayAdapter.createFromResource(getContext(), R.array.municipioCadastrados, android.R.layout.simple_spinner_item);
        municipiosArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        municipioSpinner.setAdapter(municipiosArray);
        endereco = (EditText)view.findViewById(R.id.endereco);

        coderecSpinnder = (Spinner)view.findViewById((R.id.COREDEC));
        coderecArray = ArrayAdapter.createFromResource(getContext(), R.array.CODEREC, android.R.layout.simple_spinner_item);
        coderecArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coderecSpinnder.setAdapter(coderecArray);

        Calendar calender = Calendar.getInstance();
        Date data1 = new Date();

        calender.setTime(data1);
        Date dataAtual = calender.getTime();
        SimpleDateFormat horaAtual = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");

        data.setText((String)dataFormat.format(dataAtual));
        hora.setText((String)horaAtual.format(dataAtual));
        return view;
    }

    @Override
    public void getDados(JSONObject json) throws JSONException {

        String dados = "ocorrencia{";

        json.put("municipio", municipioSpinner.getSelectedItem().toString());
        json.put("coderec", coderecSpinnder.getSelectedItem().toString());
        json.put("cobrad", cobrad.getText().toString());
        json.put("hora", hora.getText().toString());
        json.put("data", data.getText().toString());
        json.put("endereco", endereco.getText().toString());
        json.put("descricao", descricao.getText().toString());







    }

    @Override
    public Boolean verficaDados() {


        if(descricao.getText().toString().isEmpty()){
            descricao.requestFocus();
            return false;
        }

        if(cobrad.getText().toString().isEmpty() ){
            cobrad.requestFocus();
            return false;
        }

        if(endereco.getText().toString().isEmpty()){
            endereco.requestFocus();
            return false;
        }




        return true;
    }
}
