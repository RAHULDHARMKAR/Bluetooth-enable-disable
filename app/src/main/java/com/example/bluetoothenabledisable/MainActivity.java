package com.example.bluetoothenabledisable;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton blueonoff;
    BluetoothAdapter bluetooth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blueonoff = findViewById(R.id.toogle);
        bluetooth = BluetoothAdapter.getDefaultAdapter();
        blueonoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if(isChecked){
                  startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),0);
              }else{
                  bluetooth.disable();
              }
            }
        });
    }
}
