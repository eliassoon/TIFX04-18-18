package com.example.marcus.bluetoothapplication;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public interface ICommunication {
    void connect();
    String send();
    boolean isConnected();
}
