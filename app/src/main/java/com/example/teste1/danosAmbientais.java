package com.example.teste1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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

        View view = inflater.inflate(R.layout.fragment_danos_ambientais, container, false);
        desalojadosQuant = (EditText) view.findViewById(R.id.desabrigadosQuant);
        desabrigadosQuant = (EditText) view.findViewById(R.id.desabrigadosQuant);
        contamincaoAr = (EditText) view.findViewById(R.id.contamincaoAr);



        return inflater.inflate(R.layout.fragment_danos_ambientais, container, false);
    }


    public boolean validate(){


        Toast toast = Toast.makeText(, "Passou", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();


        return true;
    }

}
