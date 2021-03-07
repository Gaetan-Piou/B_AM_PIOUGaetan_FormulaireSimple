package com.example.piougaetan_formulairesimple;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


public class FirstFragment extends Fragment {

    private EditText username = null;
    private EditText password = null;
    private RadioGroup genre = null;

    private String sUsername = null;
    private String sPassword = null;
    private String sGenre = null;

    private boolean genreSelect = false;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        username = (EditText)view.findViewById(R.id.username);
        password = (EditText)view.findViewById(R.id.password);
        genre = (RadioGroup)view.findViewById(R.id.genre);


        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                sUsername = (String) username.getText().toString();
            }
        });


        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                sPassword = (String) password.getText().toString();
            }
        });


        genre.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                genreSelect = true;

                if (checkedId == R.id.H) {
                    sGenre = getResources().getString(R.string.radioH);
                } else if (checkedId == R.id.F) {
                    sGenre = getResources().getString(R.string.radioF);
                }
            }
        });


        view.findViewById(R.id.btn_connexion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(sUsername != "" && sPassword != "" & genreSelect == true) {

                    Bundle Form = new Bundle();
                    Form.putString("Nom", sUsername);
                    Form.putString("Mdp", sPassword);
                    Form.putString("Genre", sGenre);

                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment, Form);

                } else {
                    Toast.makeText(getContext(), getArguments().getString("erreur"), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}