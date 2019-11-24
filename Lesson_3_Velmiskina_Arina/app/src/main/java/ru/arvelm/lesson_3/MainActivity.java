package ru.arvelm.lesson_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static ru.arvelm.lesson_3.R.mipmap.image_person;

public class MainActivity extends AppCompatActivity {

    public static Intent createStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonLayout = findViewById(R.id.buttonLayout);
        buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = TestActivity2.createStartIntent(MainActivity.this);
                startActivity(intent);
            }
        });


        Button buttonConstraint = findViewById(R.id.buttonConstraint);
        buttonConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = TestActivity.createStartIntent(MainActivity.this);
                startActivity(intent);
            }
        });



    }


}
