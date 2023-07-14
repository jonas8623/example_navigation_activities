package com.example.imc.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.imc.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonCalculate;
    private EditText editTextName, editTextWeight, editTextHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();
        navigateResultActivity();
    }

    private void initActivity() {
        editTextName = findViewById(R.id.editName);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculate = findViewById(R.id.buttonCalculateResultActivity);
    }

    private void navigateResultActivity() {
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                double weight = Double.parseDouble(editTextWeight.getText().toString());
                double height = Double.parseDouble(editTextHeight.getText().toString());

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("weight", weight);
                intent.putExtra("height", height);
                startActivity(intent);
            }
        });
    }
}