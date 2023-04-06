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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BluetoothComment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BluetoothComment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Comment> commentList = new ArrayList<>();
    RecyclerView recyclerView;

    public BluetoothComment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BluetoothComment.
     */
    // TODO: Rename and change types and number of parameters
    public static BluetoothComment newInstance(String param1, String param2) {
        BluetoothComment fragment = new BluetoothComment();
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
        //initializing the productlist

        commentList.add(new Comment(242,22,"Sony WH-1000XM4 heaphones last really long!", "Sonya Smith"));
        commentList.add(new Comment(222,111,"Logitech has good cheap bluetooth mice", "Lo-Gi Tek"));
        commentList.add(new Comment(112,2,"Airpods work with bluetooth too", "Steven Careers"));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.bluetooth_comments, container, false);
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.bluetooth_comments, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CommentAdapter adapter = new CommentAdapter(getActivity(), commentList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return root;
    }
}