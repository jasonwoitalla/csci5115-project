package com.example.csci5115project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class BluetoothPageFragment extends Fragment {
    BluetoothComment btFragment = new BluetoothComment();
    public BluetoothPageFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BluetoothPageFragment newInstance() {
        BluetoothPageFragment fragment = new BluetoothPageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        btFragment.commentList = new ArrayList<>();
//        btFragment.commentList.add(new Comment(242,22,"The Google Pixel is an example of forced obsolescence", "Jane Smith"));
//        btFragment.commentList.add(new Comment(222,111,"The Google Pixel is an example of forced obsolescence", "Jane Smithy"));
//        btFragment.commentList.add(new Comment(112,2,"The Google Pixel is an example of forced obsolescence", "Janey Smith"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.bluetooth_product, container, false);

        root.findViewById(R.id.backToInfoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentUtil.replaceFragment(getActivity(), new NotificationFragment());
            }
        });

        root.findViewById(R.id.bluetoothComment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentUtil.replaceFragment(getActivity(), new BluetoothComment());
                addComment(view);
            }
        });


        return root;
    }
    public void addComment(View view){

        EditText editText = getActivity().findViewById(R.id.editText);
        String message = editText.getText().toString();
        btFragment.commentList.add((new Comment(0,0,message,"anon_user")));
        FragmentUtil.replaceFragment(getActivity(), btFragment);//MAY NEED BACKSTACK

    }
}
