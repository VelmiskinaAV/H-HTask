package ru.arvelm.lesson_1_velmiskina_arina;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textViewResult = (TextView) findViewById(R.id.textViewResult);
        Button buttonAddData = (Button) findViewById(R.id.buttonAddData);

        buttonAddData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editText = (EditText) findViewById(R.id.editText);

                if (editText.toString() != "") {
                    listOfStudent.add(editText.getText().toString());
                    editText.setText("");
                }
            }
        });

        Button showData = (Button) findViewById(R.id.buttonShowData);

        showData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String setText = "";
                for (String i : listOfStudent) {
                    setText += i;
                    setText += "\n";
                }

                textViewResult.setText(setText);
            }
        });
    }
}
