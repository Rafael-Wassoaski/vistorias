package com.example.teste1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.HashMap;


public class danosMateriais extends Fragment {


    private HashMap<CheckBox, EditText> materiais = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_danos_materiais, container, false);

        materiais.put((CheckBox)view.findViewById(R.id.atingidos), (EditText)view.findViewById(R.id.UHatingidosQuanto));
        materiais.put((CheckBox)view.findViewById(R.id.danificadas), (EditText)view.findViewById(R.id.UHdanificadosQuant));
        materiais.put((CheckBox)view.findViewById(R.id.interditadas), (EditText)view.findViewById(R.id.UHinterditadasQuant));
        return view;
    }


}
