package ru.arvelm.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button  buttonFirstActivity = findViewById(R.id.buttonFirstActivity);
        buttonFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FirstActivity.createStartIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        Button buttonSecondActivity = findViewById(R.id.buttonSecondActivity);
        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SecondActivity.createStartIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        Button buttonThirdActivity = findViewById(R.id.buttonThirdActivity);
        buttonThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ThirdActivity.createStartIntent(MainActivity.this);
                startActivity(intent);
            }
        });


    }
}
