package ru.arvelm.lesson_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FifthActivity extends AppCompatActivity {

    public TextView textViewData;
    public Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        Button buttonDeliverResult = findViewById(R.id.buttonDeliverResult);
        buttonDeliverResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextResult = findViewById(R.id.editTextDeliver);

                Intent intent = new Intent();
                intent.putExtra("text", editTextResult.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        textViewData = findViewById(R.id.textViewClassData);
        data = new Data();

        if (savedInstanceState != null) {
            String message = savedInstanceState.getString("message");
            textViewData.setText(message);
        }

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText  editTextResult = findViewById(R.id.editTextClassData);
                data.value = editTextResult.getText().toString();
                textViewData.setText(data.value);
                editTextResult.setText("");
            }
        });

    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putString("message", data.value);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        data.value = savedInstanceState.getString("message");
    }

}


