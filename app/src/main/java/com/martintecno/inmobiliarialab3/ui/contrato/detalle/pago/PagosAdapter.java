package com.martintecno.inmobiliarialab3.ui.contrato.detalle.pago;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.martintecno.inmobiliarialab3.API.ApiClient;
import com.martintecno.inmobiliarialab3.R;
import com.martintecno.inmobiliarialab3.modelo.Inmueble;
import com.martintecno.inmobiliarialab3.modelo.Inquilino;
import com.martintecno.inmobiliarialab3.modelo.Pago;
import com.martintecno.inmobiliarialab3.ui.inquilino.InquilinoAdapter;

import java.util.List;

public class PagosAdapter extends RecyclerView.Adapter<PagosAdapter.ViewHolder> {

    private List<Pago> listaPagos;
    private Context context;

    private LayoutInflater li;


    public PagosAdapter(List<Pago> listaP, Context context, LayoutInflater li) {
        this.listaPagos = listaP;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public PagosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=li.inflate(R.layout.item_pago,parent,false);

        return new PagosAdapter.ViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return listaPagos.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView CodigoPago;
        private TextView NroPago;
        private TextView CodigoContrato;
        private TextView Importe;
        private TextView FechaPago;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            CodigoPago = itemView.findViewById(R.id.TVCodigoPago);
            NroPago = itemView.findViewById(R.id.TVNroPago);
            CodigoContrato = itemView.findViewById(R.id.TVCodigoContrato);
            Importe = itemView.findViewById(R.id.TVInportePago);
            FechaPago = itemView.findViewById(R.id.TVFechaPago);

        }
    }
    @Override
    public void onBindViewHolder(@NonNull PagosAdapter.ViewHolder holder, int position) {

        holder.CodigoPago.setText(String.valueOf(listaPagos.get(position).getIdPago()));
        holder.NroPago.setText(String.valueOf(listaPagos.get(position).getNumero()));
        holder.CodigoContrato.setText(String.valueOf(listaPagos.get(position).getContrato().getIdContrato()));
        holder.Importe.setText(String.valueOf(listaPagos.get(position).getImporte()));
        holder.FechaPago.setText(listaPagos.get(position).getFechaDePago());

    }
}