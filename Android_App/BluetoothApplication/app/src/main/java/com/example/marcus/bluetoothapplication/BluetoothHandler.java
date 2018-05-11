package com.example.marcus.bluetoothapplication;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.UUID;

public class BluetoothHandler implements ICommunication {

    private final String TAG = "BLUETOOTH_DEBUG_TAG";
    private final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final BluetoothHandler btHandler = new BluetoothHandler();

    private BluetoothAdapter btAdapter;
    private BluetoothSocket btSocket;
    private OutputStream outputStream;
    private InputStream inputStream;

    private boolean connected;
    public boolean isConnected(){ return connected;}

    private BluetoothHandler(){
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        checkAdapter();
    }

    @Override
    public void connect(){
        if(!connected) return;
        String address = "B8:27:EB:52:B9:EC";
        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        try {
            btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e) {
            Log.e(TAG, "Socket create failed", e);
        }

        btAdapter.cancelDiscovery();
        // Establish the connection.  This will block until it connects.
        try {
            btSocket.connect();
        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2) {
                Log.e(TAG, "Could not close the client socket");
            }
        }
        if(connected = btSocket.isConnected()){
            manageStreams();
        }
    }

    @Override
    public String send() {
        if(!connected) return null;

        // Send ping message to server
        String message = "ping";
        byte[] msgBuffer = message.getBytes();
        try{
            outputStream.write(msgBuffer);
        }catch (IOException e){
            Log.e(TAG, "Failed to write to outputStream");
            return null;
        }

        // Handle response
        byte[] buffer = new byte[1024];
        int numBytes;

        while(true){
            try{
                numBytes = inputStream.read(buffer);
                return new String(buffer, Charset.forName("UTF-8"));
            }catch (IOException e){
                Log.e(TAG, "Input stream was disconnected", e);
            }
        }
    }

    public static BluetoothHandler getInstance() {
        return btHandler;
    }


    private void manageStreams(){
        InputStream tmpIn;
        OutputStream tmpOut;

        try {
            tmpIn = btSocket.getInputStream();
        } catch (IOException e) {
            Log.e(TAG, "Error occurred when creating input stream", e);
            return;
        }

        try{
            tmpOut = btSocket.getOutputStream();
        }catch (IOException e){
            Log.e(TAG, "Error occurred when creating output stream", e);
            return;
        }

        inputStream = tmpIn;
        outputStream = tmpOut;
    }

    private boolean checkAdapter(){
        if(btAdapter == null){
            return false;
        }else {
            connected = btAdapter.isEnabled();
            return connected;
        }
    }
}
