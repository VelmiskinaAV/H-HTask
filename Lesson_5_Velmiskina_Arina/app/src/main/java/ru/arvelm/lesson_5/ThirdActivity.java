package ru.arvelm.lesson_5;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class ThirdActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    public static Intent createStartIntent(Context context) {
        return new Intent(context, ThirdActivity.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
            //Snackbar.make(data, data.getStringExtra("text"), Snackbar.LENGTH_LONG).show();
            TextView textViewResult = findViewById(R.id.textViewResult);
            textViewResult.setText(data.getStringExtra("text"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button buttonGoToMain = findViewById(R.id.buttonGoToMain);
        buttonGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainActivity.createStartIntent(ThirdActivity.this);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        Button  buttonGoToFive = findViewById(R.id.buttonGoToFive);
        buttonGoToFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FifthActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
}
