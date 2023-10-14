package com.martintecno.inmobiliarialab3.ui.Inmueble;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.martintecno.inmobiliarialab3.API.ApiClient;
import com.martintecno.inmobiliarialab3.modelo.Inmueble;

import java.util.List;

public class InmuebleViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<List<Inmueble>> listaInmuebleM;


    public InmuebleViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }


    public LiveData<List<Inmueble>> getListaM(){
        if(listaInmuebleM==null){

            listaInmuebleM=new MutableLiveData<>();
        }
        return listaInmuebleM;

    }

    public void cargarLista(){

        listaInmuebleM.setValue(ApiClient.getApi().obtnerPropiedades());

    }













}