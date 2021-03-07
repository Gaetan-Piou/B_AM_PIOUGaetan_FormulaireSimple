package com.example.piougaetan_formulairesimple;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView message = (TextView) view.findViewById(R.id.Bienvenue);

        String sNom = getArguments().getString("Nom");
        String sMdp = getArguments().getString("Mdp");
        String sGenre = getArguments().getString("Genre");
        String textGenre;

        if(sGenre == getResources().getString(R.string.radioH)) {
            textGenre = getResources().getString(R.string.genreH) + " " + sGenre;
        } else {
            textGenre = getResources().getString(R.string.genreF) + " " + sGenre;
        }

        String sTexte = getResources().getString(R.string.bonjour) + " " + sNom + " " + getResources().getString(R.string.mdp) + " " + sMdp + " " + textGenre;

        message.setText(sTexte);

        view.findViewById(R.id.btn_retour).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}