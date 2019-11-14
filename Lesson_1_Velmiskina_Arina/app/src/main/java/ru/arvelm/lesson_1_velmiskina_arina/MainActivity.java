package ru.arvelm.lesson_1_velmiskina_arina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonFirstAct, buttonSecondAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFirstAct = findViewById(R.id.buttonFirstAct);





        buttonFirstAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(FirstActivity.newIntent(MainActivity.this));
                // startActivity(new Intent(MainActivity.this, FirstActivity.class));
            }
        });

        buttonSecondAct = findViewById(R.id.buttonSecondAct);

        buttonSecondAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SecondActivity.newIntent(MainActivity.this));
               // Intent intent = new Intent(MainActivity.this, SecondActivity.class);
               // startActivity(intent);
            }
        });
    }
}
