package ru.arvelm.lesson_1_velmiskina_arina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.SortedSet;
import java.util.TreeSet;

public class FirstActivity extends AppCompatActivity {

    public TextView textViewResult;
    public EditText editText;
    public SortedSet<String> listOfStudent = new TreeSet<>();

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, FirstActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textViewResult = findViewById(R.id.textViewResult);
        Button buttonAddData =  findViewById(R.id.buttonAddData);

        buttonAddData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editText = findViewById(R.id.editText);

                if (!editText.toString().equals("")) {
                    listOfStudent.add(editText.getText().toString());
                    editText.setText("");
                }
            }
        });

        Button showData = findViewById(R.id.buttonShowData);

        showData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StringBuilder setText = new StringBuilder();
                for (String i : listOfStudent) {
                    setText.append(i);
                    setText.append("\n");
                }

                textViewResult.setText(setText);
            }
        });
    }
}
