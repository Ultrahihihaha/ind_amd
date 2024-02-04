package com.example.individual;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class IronSection extends AppCompatActivity {
    private final double P_ir = 125.0;//тепловий опір однієї секції радіатора стального
    @Override
    protected void onCreate(Bundle savedInstanceState) { //back
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron_section);

        Button btnBack = findViewById(R.id.btnBack_ir);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Закрити поточну активність і повернутися на головну сторінку
            }
        });

        Button btnCalculate_st = findViewById(R.id.btnCalculate_ir);
        btnCalculate_st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                // Отримайте значення з полів введення
                double a = Double.parseDouble(((EditText) findViewById(R.id.editTextLengthRoom_ir)).getText().toString());//довжина кімнати
                double a1 = Double.parseDouble(((EditText) findViewById(R.id.editTextWindowHeight_ir)).getText().toString());//довжина вікна
                double a3 = Double.parseDouble(((EditText) findViewById(R.id.editTextDoorWidth_ir)).getText().toString());//ширина дверей кімнати
                double b = Double.parseDouble(((EditText) findViewById(R.id.editTextWidthRoom_ir)).getText().toString());//ширина кімнати
                double h = Double.parseDouble(((EditText) findViewById(R.id.editTextHeightRoom_ir)).getText().toString());//висота кімнати
                double h1 = Double.parseDouble(((EditText) findViewById(R.id.editTextWindowHeight_ir)).getText().toString());//висота вікна
                double h3 = Double.parseDouble(((EditText) findViewById(R.id.editTextDoorHeight_ir)).getText().toString());//висота дверей кімнати

                // Розрахунок Q та N за формулами
                double qResult = calculateQ(a, a1, a3, b, h, h1, h3);
                double nResult = calculateN(qResult);

                // Виведення результату
                TextView textViewResult = findViewById(R.id.textResult_ir);
                textViewResult.setText("Q Результат: " + qResult + "\n N Результат: " + nResult);
            }
        });
    }

    // Функція для обчислення Q за вказаною формулою
    private double calculateQ(double a, double a1, double a3, double b, double h, double h1, double h3) {
        return (1 * (a * h) * 40) * 2 + (1 * ((a - a1) * (h - h1)) * 40) + (1 * (a1 * h1) * 40)
                + (1 * ((a - a3) * (h - h3)) * 40) + (1 * (a3 * h3) * 40) + (1 * (a * b) * 40) * 2;
    }

    // Функція для обчислення N за вказаною формулою
    private double calculateN(double q) {
        return (q / 0.9) / P_ir; // Замініть P=50 значенням відповідно до ваших потреб
    }
}