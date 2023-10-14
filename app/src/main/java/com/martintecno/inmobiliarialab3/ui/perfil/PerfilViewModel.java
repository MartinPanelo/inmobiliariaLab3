package com.martintecno.inmobiliarialab3.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.martintecno.inmobiliarialab3.API.ApiClient;
import com.martintecno.inmobiliarialab3.modelo.Propietario;

public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> propietarioM;

    private MutableLiveData<Boolean> modoEdicionM;

    private MutableLiveData<Boolean> modoGuardarM;

    private Context context;



    public PerfilViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Propietario> getpropietarioM() {
        if (propietarioM == null) {
            propietarioM = new MutableLiveData<>();
        }
        return propietarioM;
    }

    public LiveData<Boolean> getModoGuardarM() {
        if (modoGuardarM == null) {
            modoGuardarM = new MutableLiveData<>();
        }
        return modoGuardarM;
    }

    public LiveData<Boolean> getModoEdicionM() {
        if (modoEdicionM == null) {
            modoEdicionM = new MutableLiveData<>();
        }
        return modoEdicionM;
    }

    public void cargarPropietario() {

    //    if(propietarioM.getValue() == null){
            propietarioM.setValue(ApiClient.getApi().obtenerUsuarioActual());
    //    }


    }

    public void actualizarPerfil(String id,String dni, String apellido, String nombre, String email, String password, String telefono, int avatar) {
        {

            if (id == null || dni == null || apellido == null || nombre == null || email == null || password == null || telefono == null) {
                Toast.makeText(context, "No esta permitido dejar campos vacios", Toast.LENGTH_SHORT).show();
            } else {
                Propietario propietario = new Propietario(
                Integer.parseInt(id),
                Long.parseLong(dni),
                nombre,
                apellido,
                email,
                password,
                telefono,
                avatar
                );
                ApiClient.getApi().actualizarPerfil(propietario);
                propietarioM.setValue(propietario);
            }


        }

    }

    public void ModoModificarPerfil(String modo) {
        if (modo.equals("EDITAR PERFIL")) {
            modoEdicionM.setValue(true);
        } else {
            modoGuardarM.setValue(false);
        }
    }


}