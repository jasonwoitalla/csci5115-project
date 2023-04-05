package com.example.csci5115project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class SmartwatchPageFragment extends Fragment {
    public SmartwatchPageFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SmartwatchPageFragment newInstance() {
        SmartwatchPageFragment fragment = new SmartwatchPageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.smartwatch_product, container, false);

        root.findViewById(R.id.backToInfoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentUtil.replaceFragment(getActivity(), new NotificationFragment());
            }
        });

        return root;
    }
}
