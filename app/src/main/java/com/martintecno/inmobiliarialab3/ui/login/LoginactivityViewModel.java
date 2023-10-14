package com.martintecno.inmobiliarialab3.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.martintecno.inmobiliarialab3.API.ApiClient;
import com.martintecno.inmobiliarialab3.MainActivity;
import com.martintecno.inmobiliarialab3.modelo.Propietario;
import com.martintecno.inmobiliarialab3.ui.home.HomeFragment;

public class LoginactivityViewModel extends AndroidViewModel {

    private Context context;

    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 1000;

    public LoginactivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
    }

    public void IniciarSesion(String usuario, String contraseña) {

        if(ApiClient.getApi().login(usuario, contraseña) != null){
            Intent intent = new Intent(context, MainActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }else{
            Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    public void HacerLlamada(SensorEvent sensor) {

        if(sensor.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = sensor.values[0];
            float y = sensor.values[1];
            float z = sensor.values[2];
            long curTime = System.currentTimeMillis();
            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;
                float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 10000;
                if (speed > SHAKE_THRESHOLD) {

                    String TelefonoI = "26648743520000";

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+TelefonoI));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
                last_x = x;
                last_y = y;
                last_z = z;
            }
        }

    }


}
