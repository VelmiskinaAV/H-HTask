package ru.arvelm.lesson_1_velmiskina_arina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    public EditText editText;
    TextView textViewResult;
    HashMap<String, Student> studentList = new HashMap<>();

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.editText);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonAddData = findViewById(R.id.buttonAddData);

        editText.setOnEditorActionListener( new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    try {
                        String text = editText.getText().toString();
                        String[] textArray = text.trim().split(" ");

                        if (text.equals("") || textArray.length < 4) {
                            throw new Exception("Введите 4 параметра");
                        }

                        String name = textArray[0];
                        String surname = textArray[1];
                        String grade = textArray[2];
                        String year = textArray[3];
                        Student student = new Student(name, surname, grade, year);
                        Random value = new Random();
                        String id = String.valueOf(value.nextInt());
                        studentList.put(id, student);
                        editText.setText("");
                    }
                    catch(Exception e){
                        textViewResult.setText(e.getMessage());
                    }

                    return true;
                }

                return false;
            }
        });

        buttonAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder allText = new StringBuilder();
                for(String i: studentList.keySet()){
                    allText.append(i);
                    allText.append(" ");
                    allText.append(studentList.get(i). returnValue());
                    allText.append("\n");
                }
                textViewResult.setText(allText);
            }
        });
    }
}
