package com.example.imc.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imc.R;
import com.example.imc.activities.models.PersonModel;

public class MainActivity extends AppCompatActivity {

    private Button buttonCalculate;
    private EditText editTextName, editTextWeight, editTextHeight;

    private String name;
    private double weight;
    private double height;

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

                if (validateField(editTextName) && validateField(editTextHeight) && validateField(editTextWeight)) {
                    name = editTextName.getText().toString();
                    weight = Double.parseDouble(editTextWeight.getText().toString());
                    height = Double.parseDouble(editTextHeight.getText().toString());
                } else {
                    Toast.makeText(MainActivity.this, "Campo inválido", Toast.LENGTH_LONG).show();
                    return;
                }


                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
//                intent.putExtra("name", name);
//                intent.putExtra("weight", weight);
//                intent.putExtra("height", height);
                PersonModel personModel = new PersonModel();
                personModel.setName(name);
                personModel.setWeight(weight);
                personModel.setHeight(height);
                intent.putExtra("person", personModel);
                startActivity(intent);
            }
        });
    }

    private boolean validateField(EditText editText) {
        return !TextUtils.isEmpty(editText.getText().toString());
    }
}