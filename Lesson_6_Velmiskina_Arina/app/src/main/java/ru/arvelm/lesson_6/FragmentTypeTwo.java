package ru.arvelm.lesson_6;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentTypeTwo extends Fragment {

    public FragmentTypeTwo(){ }

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_type_two, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL);
        Drawable divider = ContextCompat.getDrawable(getActivity(), R.drawable.divider);
        decoration.setDrawable(divider);
        recyclerView.addItemDecoration(decoration);

        List<AddData> dataList = new ArrayList<AddData>() ;

        AddData newData = new AddData(1, R.drawable.ic_water_cold, "Холодная вода", "536644", R.drawable.ic_alert, "25.03.18", true);
        dataList.add(newData);
        newData = new AddData(1, R.drawable.ic_water_hot, "Горячая вода", "536644", R.drawable.ic_alert, "25.03.18", true);
        dataList.add(newData);
        newData = new AddData(2, R.drawable.ic_electro_copy, "Электроэнергия", "536644", 0, "16.02.18 25.02.18", false);
        dataList.add(newData);

        MyAdapter adapter = new MyAdapter(dataList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        return rootView;
    }


}
