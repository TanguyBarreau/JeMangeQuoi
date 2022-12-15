package com.example.jemangequoi.controller;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jemangequoi.R;
import com.example.jemangequoi.model.LivreRecettes;
import com.example.jemangequoi.model.Recette;

import java.util.Locale;

public class TrouverRecetteActivity extends AppCompatActivity {

    private EditText mAliment1;
    private EditText mAliment2;
    private EditText mAliment3;
    private EditText mTypeDePlat;
    private Spinner mRestrictions;
    private String mValueSpinnerRestrictions = "";
    private Button mTrouverRecette;
    private TextView mResultatsRecherche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trouver_recette);

        mAliment1 = findViewById(R.id.edittext_aliment_1);
        mAliment2 = findViewById(R.id.edittext_aliment_2);
        mAliment3 = findViewById(R.id.edittext_aliment_3);
        mTypeDePlat = findViewById(R.id.edittext_type_de_plat);
        mRestrictions = findViewById(R.id.spinner_restrictions);
        mTrouverRecette = findViewById(R.id.button_trouver_recette);
        mResultatsRecherche = findViewById(R.id.textview_resultats_recherche);

        mAliment2.setEnabled(false);
        mAliment3.setEnabled(false);
        //mTrouverRecette.setEnabled(false);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_restrictions, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mRestrictions.setAdapter(adapter);

        LivreRecettes livreRecettes = new LivreRecettes();

        mAliment1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {            }
            @Override
            public void afterTextChanged(Editable s) {
                mAliment2.setEnabled(!s.toString().isEmpty());
            }
        });

        mAliment2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {            }
            @Override
            public void afterTextChanged(Editable s) {
                mAliment3.setEnabled(!s.toString().isEmpty());
            }
        });

        mTypeDePlat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mTrouverRecette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String resultatsRecherche = livreRecettes.getRecettes(
                        mTypeDePlat.getText().toString(),
                        mAliment1.getText().toString(),
                        mAliment2.getText().toString(),
                        mAliment3.getText().toString(),
                        mValueSpinnerRestrictions
                );

                if (!resultatsRecherche.isEmpty()) {
                    mResultatsRecherche.setText(resultatsRecherche);
                } else {
                    mResultatsRecherche.setText("Aucune recette ne correspond aux critères !");
                }

            }
        });

        mRestrictions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                mValueSpinnerRestrictions = parent.getItemAtPosition(position).toString().toLowerCase(Locale.ROOT);
                /*
                Adapter adapterrr = parent.getAdapter();
                //Recette employee = (Recette) adapterrr.getItem(position);
                Toast.makeText(getApplicationContext(), "Selected Employee: " + parent.getItemAtPosition(position) ,Toast.LENGTH_SHORT).show();
                */
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Toast.makeText(getApplicationContext(), "bnote Employee: " ,Toast.LENGTH_SHORT).show();
            }
        });

    }


}