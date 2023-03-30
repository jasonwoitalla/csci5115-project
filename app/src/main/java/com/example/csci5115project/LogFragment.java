package com.example.csci5115project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import devices.Device;
import devices.DeviceAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Device> deviceList;
    RecyclerView recyclerView;

    public LogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LogFragment newInstance(String param1, String param2) {
        LogFragment fragment = new LogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_log, container, false);

        Button logDeviceButton = (Button) root.findViewById(R.id.logDeviceButton);
        logDeviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new LogFormFragment());
            }
        });

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        deviceList = new ArrayList<>();

        deviceList.add(
                new Device(
                        "iPhone 17",
                        R.drawable.iphone_image
                ));

        deviceList.add(
                new Device(
                        "iPhone 5c",
                        R.drawable.iphone_image
                ));

        deviceList.add(
                new Device(
                        "iPhone 88",
                        R.drawable.iphone_image
                ));

        deviceList.add(
                new Device(
                        "Surface Pro 4",
                        R.drawable.surface
                ));

        deviceList.add(
                new Device(
                        "Macbook",
                        R.drawable.macbook
                ));

        deviceList.add(
                new Device(
                        "iPhone 2",
                        R.drawable.iphone_image
                ));

        deviceList.add(
                new Device(
                        "Macbook Air",
                        R.drawable.macbook
                ));

        deviceList.add(
                new Device(
                        "Surface Pro 18",
                        R.drawable.surface
                ));

        DeviceAdapter adapter = new DeviceAdapter(getActivity(), deviceList);
        recyclerView.setAdapter(adapter);

        return root;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}