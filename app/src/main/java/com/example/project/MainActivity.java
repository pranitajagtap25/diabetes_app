package com.example.project;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextGlucose;
    private Button buttonCheck;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGlucose = findViewById(R.id.editTextGlucose);
        buttonCheck = findViewById(R.id.buttonCheck);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDiabetes();
            }
        });
    }

    private void checkDiabetes() {
        String glucoseText = editTextGlucose.getText().toString().trim();

        if (!glucoseText.isEmpty()) {
            double glucoseLevel = Double.parseDouble(glucoseText);

            if (glucoseLevel > 126) {
                textViewResult.setText("High Glucose Level. Possible Diabetes.");
            } else {
                textViewResult.setText("Normal Glucose Level.");
            }
        } else {
            textViewResult.setText("Please enter a valid glucose level.");
        }
    }
}
