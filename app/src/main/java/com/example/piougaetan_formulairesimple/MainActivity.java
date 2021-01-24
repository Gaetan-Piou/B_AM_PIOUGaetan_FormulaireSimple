package com.example.piougaetan_formulairesimple;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setActivityBackgroundColor(int color) {
        View background = findViewById(R.id.background);
        background.setBackgroundColor(color);
    }

    public void login(View v){
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);
        RadioGroup genre = (RadioGroup)findViewById(R.id.genre);
        RadioButton genreSelectionne;

        String sUsername = username.getText().toString();
        String sPassword = password.getText().toString();
        int boutonSelectionne = genre.getCheckedRadioButtonId();
        String texteGenre;

        if(sUsername != "" && sPassword != "" & boutonSelectionne != -1) {
            String texteBienvenue = getResources().getString(R.string.bonjour) + " " + sUsername + ", " + getResources().getString(R.string.mdp) + " " + sPassword;
            Toast.makeText(this, texteBienvenue, Toast.LENGTH_LONG).show();

            genreSelectionne = findViewById(boutonSelectionne);
            texteGenre = genreSelectionne.getText().toString();

            if(texteGenre == getResources().getString(R.string.radioH)) {
                setActivityBackgroundColor(R.color.bleu);
            } else {
                setActivityBackgroundColor(R.color.rouge);
            }

        } else {
            Toast.makeText(this, getResources().getString(R.string.erreur), Toast.LENGTH_LONG).show();
        }
    }
}