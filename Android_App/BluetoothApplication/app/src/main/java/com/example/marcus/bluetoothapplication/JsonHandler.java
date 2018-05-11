package com.example.marcus.bluetoothapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class JsonHandler implements IDataParser{

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Double> distances = new ArrayList<>();
    private ArrayList<Double> angles = new ArrayList<>();

    JsonHandler(String jsonString){
        formatData(createJson(jsonString));
    }

    public String toString(){

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.size(); i++){
            result.append("Hov: ").append(names.get(i)).append(", Avstånd: ").append(distances.get(i).toString()).append("m, Vinkel: ").append(angles.get(i).toString()).append(" \n");
        }
        return result.toString();
    }

    private void formatData(JSONObject json){
        if(json == null) return;

        try{
            JSONArray hovar = json.getJSONArray("hovar");
            for (int i = 0; i < hovar.length(); i++){
                JSONObject hov = hovar.getJSONObject(i);
                names.add(hov.getString("hov"));
                JSONObject data = hov.getJSONObject("data");
                distances.add(data.getDouble("distance"));
                angles.add(data.getDouble("angle"));
            }
        }catch (JSONException e){
            Log.e("ERROR", "Could not extract json data from retrieved string", e);
        }
    }

    private JSONObject createJson(String data){
        try{
            return new JSONObject(data);
        }catch (JSONException e){
            Log.e("Error", "Could not construct Json object", e);
            return null;
        }
    }
}
