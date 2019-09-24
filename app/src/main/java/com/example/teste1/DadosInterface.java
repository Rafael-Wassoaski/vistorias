package com.example.teste1;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public interface DadosInterface {

    public void getDados(JSONObject json) throws JSONException;

    public Boolean verficaDados();
}
