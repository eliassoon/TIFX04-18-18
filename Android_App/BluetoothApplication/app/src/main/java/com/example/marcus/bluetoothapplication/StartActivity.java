package com.example.marcus.bluetoothapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class StartActivity extends Activity {
    private ICommunication btHandler;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        btHandler = BluetoothHandler.getInstance();
    }

    public void connectRaspberry(View v){
        progressBar.setVisibility(View.VISIBLE);
        btHandler.connect();
        if(btHandler.isConnected()){
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "Raspberry connected", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), ConnectedActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Failed to connect", Toast.LENGTH_LONG).show();
        }
        progressBar.setVisibility(View.GONE);
    }

}
