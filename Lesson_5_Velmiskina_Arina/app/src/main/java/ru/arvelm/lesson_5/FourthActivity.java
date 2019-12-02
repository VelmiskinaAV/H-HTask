package ru.arvelm.lesson_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class FourthActivity extends AppCompatActivity {

    public static Intent createStartIntent(Context context) {
        return new Intent(context, FourthActivity.class);
    }

    public String getCurrentTimeStamp(Object date) {
        SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatData.format(date);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Bundle arguments = getIntent().getExtras();

        TextView textViewDate = findViewById(R.id.textViewDate);
        textViewDate.setText(getCurrentTimeStamp(arguments.get("time")));

        Button buttonGoToFourAgain = findViewById(R.id.buttonGoToFourAgain);

        buttonGoToFourAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FourthActivity.createStartIntent(FourthActivity.this);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("time", System.currentTimeMillis());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }
}
