package com.example.micha.mappe3s300378;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MySettings extends AppCompatActivity {

    private ToggleButton vib;
    private ToggleButton scr;
    private ToggleButton fla;
    private SeekBar      sSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        vib = findViewById(R.id.bVib);
        scr = findViewById(R.id.bScr);
        fla = findViewById(R.id.bFla);
        sSpeed = findViewById(R.id.bSpeed);
        fetchPreff();
        sSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                savePreff();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

    }



    public void onClickVib(View view) {
        if (scr.isChecked()==true || fla.isChecked()==true){
            scr.setChecked(false);
            fla.setChecked(false);
            vib.setChecked(true);
        }
        if (scr.isChecked()==false && fla.isChecked()==false && vib.isChecked()==false){
            vib.setChecked(true);
            toastMessageLong(getString(R.string.min1));
        }
        savePreff();
    }

    public void onClickScreen(View view) {
        boolean permission;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permission = Settings.System.canWrite(this);
        } else {
            permission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
        }
        if (!permission) {
            fla.setChecked(false);
            scr.setChecked(false);
            vib.setChecked(true);
            toastMessageLong(getString(R.string.writeNeed));
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
            startActivity(intent);
            return;
        }

        if (vib.isChecked()==true || fla.isChecked()==true){
            scr.setChecked(true);
            fla.setChecked(false);
            vib.setChecked(false);
        }
        if (scr.isChecked()==false && fla.isChecked()==false && vib.isChecked()==false){
            scr.setChecked(true);
            toastMessageLong(getString(R.string.min1));
        }
        savePreff();
    }

    public void onClickFka(View view) {
        Boolean hasFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if(!hasFlash){
            fla.setChecked(false);
            scr.setChecked(false);
            vib.setChecked(true);
            toastMessageLong(getString(R.string.noCam));
            return;
        }
        else {
            ActivityCompat.requestPermissions(MySettings.this,new String[]{Manifest.permission.CAMERA},1);
            ActivityCompat.requestPermissions(MySettings.this,new String[]{Manifest.permission.VIBRATE},1);
        }


        if (scr.isChecked()==true || vib.isChecked()==true){
            scr.setChecked(false);
            fla.setChecked(true);
            vib.setChecked(false);
        }
        if (scr.isChecked()==false && fla.isChecked()==false && vib.isChecked()==false){
            fla.setChecked(true);
            toastMessageLong(getString(R.string.min1));
        }
        savePreff();
    }

    private void fetchPreff(){
        SharedPreferences sharedPref = getSharedPreferences("MySettings", Context.MODE_PRIVATE);
        Boolean buttVib     = sharedPref.getBoolean ("vib",     false);
        Boolean buttScr     = sharedPref.getBoolean ("screen",  false);
        Boolean buttFla     = sharedPref.getBoolean ("flash",   false);
        int     buttSpeed   = sharedPref.getInt     ("speed",   5);

        vib.setChecked(buttVib);
        scr.setChecked(buttScr);
        fla.setChecked(buttFla);
        sSpeed.setProgress(buttSpeed);
    }

    private void savePreff(){
        SharedPreferences sharedPref = getSharedPreferences("MySettings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("vib", vib.isChecked());
        editor.putBoolean("screen", scr.isChecked());
        editor.putBoolean("flash", fla.isChecked());
        editor.putInt("speed",sSpeed.getProgress());
        editor.apply();
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void toastMessageLong(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
