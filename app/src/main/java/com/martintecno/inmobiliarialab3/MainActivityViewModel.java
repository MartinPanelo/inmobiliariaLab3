package com.martintecno.inmobiliarialab3;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.martintecno.inmobiliarialab3.API.ApiClient;
import com.martintecno.inmobiliarialab3.modelo.Inmueble;
import com.martintecno.inmobiliarialab3.modelo.Propietario;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    private MutableLiveData<Propietario> propietarioM;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public LiveData<Propietario> getpropietarioM() {
        if(propietarioM==null){
            propietarioM=new MutableLiveData<>();
        }
        return propietarioM;
    }

    public void cargarPropietario(){

        Propietario p = ApiClient.getApi().obtenerUsuarioActual();
        propietarioM.setValue(p);
    }











}
