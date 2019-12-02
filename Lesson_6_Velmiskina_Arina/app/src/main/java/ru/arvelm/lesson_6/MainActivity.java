package ru.arvelm.lesson_6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    String[] text = {"1", "2"};
    int[] images= {R.drawable.ic_mood_black, R.drawable.ic_sentiment_dissatisfied};
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.smile:
                Toast.makeText(this, "Smile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sad:
                Toast.makeText(this, "Sad", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action1:
                Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action2:
                Toast.makeText(this, "234", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action3:
                Toast.makeText(this, "345", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Back", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new FragmentTypeOne());

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPage);
        if (viewPager != null) {
            viewPager.setAdapter(new SimplePagerAdapter(this));
        }

        Button buttonShow = findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.getMenu().removeItem(R.id.action_mail);
                viewPager.getResources().getDrawable(R.drawable.ic_arrow_back);
                viewPager.getResources().getText(1, "text");
                bottomNavigationView.getMenu().add(viewPager.toString());
            }
        });

        Button buttonHide = findViewById(R.id.buttonHide);
        buttonHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    bottomNavigationView.getMenu().removeItem(R.id.viewPage);


            }
        });

    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.action_map:
                fragment = new FragmentTypeOne();
                menuItem.setChecked(true);
                break;
            case R.id.action_dial:
                fragment = new FragmentTypeTwo();
                menuItem.setChecked(true);
                break;
            case R.id.action_mail:
                fragment = new FragmentTypeThree();
                menuItem.setChecked(true);
                break;
            case R.id.viewPage:
                fragment = new FragmentForViewPager();
                menuItem.setChecked(true);
        }
        return loadFragment(fragment);
    }



}
