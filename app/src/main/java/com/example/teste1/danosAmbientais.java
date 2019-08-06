package com.example.teste1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class danosAmbientais extends Fragment {


    EditText desalojadosQuant;
    EditText desabrigadosQuant;
    EditText contamincaoAr;



    public danosAmbientais() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        desalojadosQuant = (EditText) getView().findViewById(R.id.desabrigadosQuant);
        desabrigadosQuant = (EditText) getView().findViewById(R.id.desabrigadosQuant);
        contamincaoAr = (EditText) getView().findViewById(R.id.contamincaoAr);


        return inflater.inflate(R.layout.fragment_danos_ambientais, container, false);
    }


    public boolean validate(){

        if(desalojadosQuant)


        return true;
    }

}
