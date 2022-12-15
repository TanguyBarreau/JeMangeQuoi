package com.example.jemangequoi.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jemangequoi.R;

public class AccueilActivity extends AppCompatActivity {

    private Button mTrouverRecette;
    private Button mPlanningRepas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        mTrouverRecette = findViewById(R.id.button_chercher_recette);
        mPlanningRepas = findViewById(R.id.button_planning_repas);

        mTrouverRecette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent trouverRecetteActivityIntent = new Intent(AccueilActivity.this, TrouverRecetteActivity.class);
            startActivity(trouverRecetteActivityIntent);

            }
        });

        mPlanningRepas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent planningRepasActivityIntent = new Intent(AccueilActivity.this, PlanningRepasActivity.class);
                startActivity(planningRepasActivityIntent);

            }
        });

    }
}