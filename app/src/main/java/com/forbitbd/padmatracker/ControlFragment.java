package com.forbitbd.padmatracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.padmatracker.adapter.ControlAdapter;
import com.forbitbd.padmatracker.adapter.DeviceAdapter;
import com.forbitbd.padmatracker.model.Control;
import com.forbitbd.padmatracker.model.Device;
import com.forbitbd.padmatracker.ui.home.HomePresenter;

import java.util.ArrayList;


public class ControlFragment extends Fragment {

//    private RecyclerView recyclerView;
//    private ControlAdapter adapter;
//    private ArrayList<Control> controlList;

    public ControlFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_control, container, false);

//        recyclerView = view.findViewById(R.id.recyclerview);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4,RecyclerView.VERTICAL,false);
//        recyclerView.setLayoutManager(gridLayoutManager);

//        controlList = new ArrayList<>();
//        controlList.add(new Control("Map", R.drawable.ic_baseline_map_24));
//        controlList.add(new Control("Edit", R.drawable.ic_baseline_edit_24));
//        controlList.add(new Control("Settings", R.drawable.ic_baseline_settings_24));
//        controlList.add(new Control("Call", R.drawable.ic_baseline_call_24));
//        adapter = new ControlAdapter(getContext(),controlList);
//        recyclerView.setAdapter(adapter);

        return view;
    }
}