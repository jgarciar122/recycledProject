package com.example.recyclerapp;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerapp.ViewComida;
import com.example.recyclerapp.databinding.FragmentDetalleBinding;


public class FragmentDetalle extends Fragment {
    private FragmentDetalleBinding binding;
    private ViewComida viewComida;

    public FragmentDetalle() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewComida = new ViewModelProvider(requireActivity()).get(ViewComida.class);
        viewComida.getComidaEscogida().observe(getViewLifecycleOwner(), itemComida -> {
            if(itemComida != null) {
                binding.nombreViewDetalle.setText(itemComida.getNombre());
                binding.imagenViewDetalle.setImageResource(itemComida.getImage());
                binding.descripViewDetalle.setText(itemComida.getDescripcion());
                binding.tipoViewDetalle.setText(itemComida.getTipo());
            }
        });

        //Con esto comprobamos como está orientado (si horizontal o vertical):
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.backButton.setVisibility(View.VISIBLE);
            binding.backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewComida.eliminarSeleccion();
                    NavController navController = Navigation.findNavController(view);
                    navController.popBackStack();
                }
            });
        }
    }
}