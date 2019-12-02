package ru.arvelm.lesson_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static Intent createStartIntent(Context context) {
        return new Intent(context, SecondActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button buttonGoToThree = findViewById(R.id.bottonGoToThree);
        buttonGoToThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ThirdActivity.createStartIntent(SecondActivity.this);
                //intent.putExtra("time", System.currentTimeMillis());
                startActivity(intent);
            }
        });
    }
}
