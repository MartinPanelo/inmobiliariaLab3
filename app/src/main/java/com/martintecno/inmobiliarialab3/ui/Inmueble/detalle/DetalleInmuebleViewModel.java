package com.martintecno.inmobiliarialab3.ui.Inmueble.detalle;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.martintecno.inmobiliarialab3.API.ApiClient;
import com.martintecno.inmobiliarialab3.modelo.Inmueble;

public class DetalleInmuebleViewModel extends AndroidViewModel {

    private Context context;


    private MutableLiveData<Inmueble> itemM;
    public DetalleInmuebleViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public LiveData<Inmueble> getItemM(){
        if(itemM==null){

            itemM=new MutableLiveData<>();
        }
        return itemM;

    }



    public void CargarItem(Bundle bundle) {

        Inmueble item = (Inmueble) bundle.getSerializable("iteminmueble");

        itemM.setValue(item);

    }

    public void setEstado(boolean checked) {

        itemM.getValue().setEstado(checked);


        ApiClient.getApi().actualizarInmueble(itemM.getValue());

    }
}