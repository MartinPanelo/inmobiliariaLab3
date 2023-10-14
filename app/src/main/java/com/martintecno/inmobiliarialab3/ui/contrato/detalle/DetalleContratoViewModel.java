package com.martintecno.inmobiliarialab3.ui.contrato.detalle;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.martintecno.inmobiliarialab3.API.ApiClient;
import com.martintecno.inmobiliarialab3.MainActivity;
import com.martintecno.inmobiliarialab3.R;
import com.martintecno.inmobiliarialab3.modelo.Contrato;
import com.martintecno.inmobiliarialab3.modelo.Inquilino;
import com.martintecno.inmobiliarialab3.modelo.Pago;
import com.martintecno.inmobiliarialab3.ui.contrato.detalle.pago.ListaPagosFragment;

import java.util.List;

public class DetalleContratoViewModel extends AndroidViewModel {


    private Context context;

    private MutableLiveData<Contrato> itemM;
    public DetalleContratoViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }


    public LiveData<Contrato> getItemM(){
        if(itemM==null){

            itemM=new MutableLiveData<>();
        }
        return itemM;

    }


    public void CargarItem(Bundle bundle) {

        Contrato item = (Contrato) bundle.getSerializable("contrato");

        itemM.setValue(item);

    }


    public void verPagos(View view) {



        Bundle bundle = new Bundle();

        Contrato contrato = itemM.getValue();

        bundle.putSerializable("contratoPago", contrato);


        Navigation.findNavController(view).
                navigate(R.id.listaPagosFragment,bundle);

    }
}