package com.example.teste1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class ocorrenciaCadastro extends Fragment {


    public ocorrenciaCadastro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ocorrencia_cadastro, container, false);
        TextView data = (TextView)view.findViewById(R.id.data);
        TextView hora = (TextView)view.findViewById(R.id.hora);
        Spinner municipioSpinner = (Spinner)view.findViewById(R.id.municipio);
        ArrayAdapter<CharSequence> municipiosArray = ArrayAdapter.createFromResource(getContext(), R.array.municipioCadastrados, android.R.layout.simple_spinner_item);
        municipiosArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        municipioSpinner.setAdapter(municipiosArray);

        Spinner coderecSpinnder = (Spinner)view.findViewById((R.id.COREDEC));
        ArrayAdapter<CharSequence> coderecArray = ArrayAdapter.createFromResource(getContext(), R.array.CODEREC, android.R.layout.simple_spinner_item);
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

}
