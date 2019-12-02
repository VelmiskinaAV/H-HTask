package ru.arvelm.lesson_4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }
    public void onClick(View v) {

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.home:
                Toast.makeText(this, "Домик", Toast.LENGTH_SHORT).show();
                break;
            case R.id.info:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Важное сообщение!")
                        .setMessage("!!!")
                        .setCancelable(false)
                        .setNegativeButton("ОК",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
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
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<AddData> myDataset = new ArrayList<AddData>() ;

        mRecyclerView = findViewById(R.id.recyclerView);

        AddData newData = new AddData(1, R.drawable.ic_bill, "Квитанции", "- 40 080,55 \u20BD ", true);
        myDataset.add(newData);
        newData = new AddData(1, R.drawable.ic_counter, "Счетчики", "Подайте показания", true);
        myDataset.add(newData);
        newData = new AddData(1, R.drawable.ic_installment, "Рассрочка", "Сл. платеж 25.02.2018", false);
        myDataset.add(newData);
        newData = new AddData(1, R.drawable.ic_insurance, "Страхование", "Полис до 12.01.2019", false);
        myDataset.add(newData);
        newData = new AddData(1, R.drawable.ic_tv, "Интернет и ТВ", "Баланс 350 \u20BD", false);
        myDataset.add(newData);
        newData = new AddData(1, R.drawable.ic_homephone, "Домофон", "Подключен", false);
        myDataset.add(newData);
        newData = new AddData(1, R.drawable.ic_guard, "Охрана", "Нет", false);
        myDataset.add(newData);
        newData = new AddData(2, R.drawable.ic_uk_contacts, "Контакты УК и служб", "", false);
        myDataset.add(newData);
        newData = new AddData(2, R.drawable.ic_request, "Мои заявки", "", false);
        myDataset.add(newData);
        newData = new AddData(2, R.drawable.ic_about, "Памятка жителя А101", "", false);
        myDataset.add(newData);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, myDataset);
        mRecyclerView.setAdapter(myAdapter);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public static void onAttachedToRecyclerView(RecyclerView recyclerView, final RecyclerView.Adapter adapter, final int pinnedHeaderType) {
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup oldSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (adapter.getItemViewType(position) == pinnedHeaderType) {
                        return gridLayoutManager.getSpanCount();
                    }
                    if (oldSizeLookup != null) {
                        return oldSizeLookup.getSpanSize(position);
                    }
                    return 1;
                }
            });
        }
    }

}
