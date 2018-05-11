package com.example.marcus.bluetoothapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ConnectedActivity extends Activity {

    ICommunication btHandler;
    IDataParser jsonHandler;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connected);

        textView = findViewById(R.id.simplePresentation);
        btHandler = BluetoothHandler.getInstance();
    }

    public void sendData(View v){
        jsonHandler = new JsonHandler(btHandler.send());
        textView.setText(jsonHandler.toString());
    }

}
