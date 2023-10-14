package com.martintecno.inmobiliarialab3.ui.perfil;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;
import com.martintecno.inmobiliarialab3.R;
import com.martintecno.inmobiliarialab3.databinding.FragmentHomeBinding;
import com.martintecno.inmobiliarialab3.databinding.FragmentPerfilBinding;
import com.martintecno.inmobiliarialab3.modelo.Propietario;
import com.martintecno.inmobiliarialab3.ui.home.HomeViewModel;

public class PerfilFragment extends Fragment {

    FragmentPerfilBinding binding;
    PerfilViewModel perfilViewModel;

    private Propietario PActual = null;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        perfilViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);

        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        perfilViewModel.getpropietarioM().observe(getActivity(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                PActual = propietario;
                binding.ETPerfilNroPropietario.setText(String.valueOf(propietario.getId()));
                binding.ETPerfinDni.setText(String.valueOf(propietario.getDni()));
                binding.ETPerfilNombre.setText(propietario.getNombre());
                binding.ETPerfilApellido.setText(propietario.getApellido());
                binding.ETPerfilEmail.setText(propietario.getEmail());
                binding.ETPerfilTelefono.setText(propietario.getTelefono());
                binding.ETPerfilPass.setText(propietario.getContraseña());
                binding.IVPerfilFoto.setImageResource(propietario.getAvatar());

            }
        });


        perfilViewModel.getModoEdicionM().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.BTNPerfilEditar.setText("GUARDAR PERFIL");
                binding.ETPerfinDni.setEnabled(aBoolean);
                binding.ETPerfilNombre.setEnabled(aBoolean);
                binding.ETPerfilApellido.setEnabled(aBoolean);
                binding.ETPerfilEmail.setEnabled(aBoolean);
                binding.ETPerfilTelefono.setEnabled(aBoolean);
                binding.ETPerfilPass.setEnabled(aBoolean);
            }
        });

        perfilViewModel.getModoGuardarM().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.BTNPerfilEditar.setText("EDITAR PERFIL");
                binding.ETPerfinDni.setEnabled(aBoolean);
                binding.ETPerfilNombre.setEnabled(aBoolean);
                binding.ETPerfilApellido.setEnabled(aBoolean);
                binding.ETPerfilEmail.setEnabled(aBoolean);
                binding.ETPerfilTelefono.setEnabled(aBoolean);
                binding.ETPerfilPass.setEnabled(aBoolean);
                // Propietario propietario = new Propietario()
                perfilViewModel.actualizarPerfil(
                        binding.ETPerfilNroPropietario.getText().toString(),
                        binding.ETPerfinDni.getText().toString(),
                        binding.ETPerfilApellido.getText().toString(),
                        binding.ETPerfilNombre.getText().toString(),
                        binding.ETPerfilEmail.getText().toString(),
                        binding.ETPerfilTelefono.getText().toString(),
                        binding.ETPerfilPass.getText().toString(),
                        PActual.getAvatar()
                     );

            }
        });



        binding.BTNPerfilEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfilViewModel.ModoModificarPerfil(binding.BTNPerfilEditar.getText().toString());
            }
        });

        perfilViewModel.cargarPropietario();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
      //  binding = null;
    }
}