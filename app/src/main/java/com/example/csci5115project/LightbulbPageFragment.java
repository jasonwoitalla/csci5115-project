package com.example.csci5115project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class LightbulbPageFragment extends Fragment {
    public LightbulbPageFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LightbulbPageFragment newInstance() {
        LightbulbPageFragment fragment = new LightbulbPageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.lightbulb_product, container, false);

        root.findViewById(R.id.backToInfoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentUtil.replaceFragment(getActivity(), new NotificationFragment());
            }
        });

        return root;
    }
}
