package com.example.individual;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSteel = findViewById(R.id.btnSteel);
        Button btnIron = findViewById(R.id.btnIron);
        Button btnAluminum = findViewById(R.id.btnAluminum);
        Button btnBimetallic = findViewById(R.id.btnBimetallic);

        btnSteel.setOnClickListener(new View.OnClickListener() { // go to steal
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SteelSectionActivity.class));
            }
        });

        btnIron.setOnClickListener(new View.OnClickListener() {// go to iron
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IronSection.class));
            }
        });

        btnAluminum.setOnClickListener(new View.OnClickListener() {// go to aluminium
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AluminumSection.class));
            }
        });

        btnBimetallic.setOnClickListener(new View.OnClickListener() {// go to bimetallic
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BimetallicSection.class));
            }
        });
    }
}
