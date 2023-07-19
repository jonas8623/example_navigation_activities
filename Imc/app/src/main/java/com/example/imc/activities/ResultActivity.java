package com.example.imc.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.imc.R;
import com.example.imc.activities.models.PersonModel;

public class ResultActivity extends AppCompatActivity {

    private Button button;
    private TextView textViewName, textViewResult;
    private String name;
    double weight, height;
    Bundle data;

    private PersonModel personModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        createActivity();
        getData();
        calculateImc();
        navigateHome();
    }

    private void createActivity() {
        textViewName = findViewById(R.id.textViewName);
        textViewResult = findViewById(R.id.textViewResult);
    }

    private void getData() {
        data = getIntent().getExtras();
//        name = data.getString("name");
//        weight = data.getDouble("weight");
//        height = data.getDouble("height");
        personModel = (PersonModel) data.getSerializable("person");
        name = personModel.getName();
        weight = personModel.getWeight();
        height = personModel.getHeight();
    }

    private void calculateImc() {
        double imc = weight / (height * height);
        if (imc < 17) textViewResult.setTextColor(Color.rgb(244, 67, 54)); // Vermelho
        else if (imc >= 17 && imc < 18.5)
            textViewResult.setTextColor(Color.rgb(255, 193, 7)); // Amarelo
        else if (imc >= 18.5 && imc < 25)
            textViewResult.setTextColor(Color.rgb(0, 150, 136));// Verde
        else if (imc >= 25 && imc < 30.5)
            textViewResult.setTextColor(Color.rgb(255, 193, 7));// Amarelo
        else if (imc > 30) textViewResult.setTextColor(Color.rgb(244, 67, 54)); // Vermelho

        displayResult(imc);
    }

    private void displayResult(double imc) {
        textViewResult.setText(String.format("%.2f", imc));
        textViewName.setText(name + " seu imc é:");
    }

    private void navigateHome() {
        findViewById(R.id.buttonBackHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}