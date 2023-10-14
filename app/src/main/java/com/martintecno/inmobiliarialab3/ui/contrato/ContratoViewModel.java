package com.martintecno.inmobiliarialab3.ui.contrato;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.martintecno.inmobiliarialab3.API.ApiClient;
import com.martintecno.inmobiliarialab3.modelo.Contrato;
import com.martintecno.inmobiliarialab3.modelo.Inmueble;

import java.util.List;

public class ContratoViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<List<Inmueble>> listaInmuebleAlquiladosM;


    public ContratoViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }


    public LiveData<List<Inmueble>> getListaM(){
        if(listaInmuebleAlquiladosM==null){

            listaInmuebleAlquiladosM=new MutableLiveData<>();
        }
        return listaInmuebleAlquiladosM;

    }

    public void cargarLista(){

        listaInmuebleAlquiladosM.setValue(ApiClient.getApi().obtenerPropiedadesAlquiladas());

    }


}