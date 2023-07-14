package com.example.imc.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.imc.R;

public class ResultActivity extends AppCompatActivity {

    private Button button;
    private TextView textViewName, textViewResult;
    private String name;
    double weight, height;
    Bundle data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        createActivity();
        getData();
    }

    private void createActivity() {
        button = findViewById(R.id.buttonCalculateResultActivity);
        textViewName = findViewById(R.id.textViewName);
        textViewResult = findViewById(R.id.textViewResult);
    }

    private void getData() {
        data = getIntent().getExtras();
        name = data.getString("name");
        weight = data.getDouble("weight");
        height = data.getDouble("height");
    }
}