package ru.arvelm.lesson_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static ru.arvelm.lesson_3.R.mipmap.image_person;

public class TestActivity2 extends AppCompatActivity {

    public static Intent createStartIntent(Context context) {
        return new Intent(context, TestActivity2.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.actionWrite:
                Toast.makeText(this, "Записать", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainActivity.createStartIntent(TestActivity2.this);
                startActivity(intent);
            }
        });

        Person person = new Person("Карта №7898769 \nСпециалист", image_person, "Анастасия", "Антонина", "anykee.box@gmail.ru", "HIE023UOI88", "Санкт-Петербург");

        ImageView imagePerson = findViewById(R.id.imagePerson);
        imagePerson.setImageResource(person.image);

        TextView textView = findViewById(R.id.textView);
        textView.setText(person.id);

        TextView name = findViewById(R.id.name);
        name.setText(person.name);
        TextView surname = findViewById(R.id.surname);
        surname.setText(person.surname);


        TextView login = findViewById(R.id.login);
        login.setText(person.login);

        TextView email = findViewById(R.id.email);
        email.setText(person.email);

        TextView region = findViewById(R.id.region);
        region.setText(person.region);

        ImageButton imageButtonRegion = findViewById(R.id.imageButtonRegion);
        imageButtonRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button buttonExit = findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View V){

            }
        });

    }
    }
