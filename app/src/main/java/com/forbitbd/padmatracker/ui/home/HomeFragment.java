package com.forbitbd.padmatracker.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.forbitbd.padmatracker.R;
import com.forbitbd.padmatracker.adapter.DeviceAdapter;
import com.forbitbd.padmatracker.model.Device;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements HomeContract.View{

    private HomePresenter mPresenter;
    private RecyclerView recyclerView;
    private DeviceAdapter adapter;
    private ArrayList<Device> deviceList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new HomePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        deviceList = new ArrayList<>();
        deviceList.add(new Device("Abid Ahmed", "01821465858", R.drawable.dfsdf,
                "Dhaka Metro Cha-13-6425", "Bike", "01881269553",
                "9.0 Km Per Lit"));

        deviceList.add(new Device("Saimul Hoque", "01881269553", R.drawable.dfsdf,
                "Chatto Metro Ka-53-2336", "Car", "01982204475",
                "10.0 Km Per Lit"));
        adapter = new DeviceAdapter(getContext(),deviceList);
        recyclerView.setAdapter(adapter);
        return view;
    }
}