package com.martintecno.inmobiliarialab3.ui.inquilino.detalle;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.martintecno.inmobiliarialab3.modelo.Inquilino;

public class DetalleInquilinoViewModel extends AndroidViewModel {

    private Context context;

    private MutableLiveData<Inquilino> itemM;
    public DetalleInquilinoViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }


    public LiveData<Inquilino> getItemM(){
        if(itemM==null){

            itemM=new MutableLiveData<>();
        }
        return itemM;

    }


    public void CargarItem(Bundle bundle) {

        Inquilino item = (Inquilino) bundle.getSerializable("itemalquilado");

        itemM.setValue(item);

    }
















}