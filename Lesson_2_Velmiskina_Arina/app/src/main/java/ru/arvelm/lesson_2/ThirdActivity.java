package ru.arvelm.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity {

    public static Intent createStartIntent(Context context) {
        return new Intent(context, ThirdActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
}
