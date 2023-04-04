package com.example.csci5115project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneComment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Comment> commentList;
    RecyclerView recyclerView;

    public SmartphoneComment() {
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SmartphoneComment.
     */
    // TODO: Rename and change types and number of parameters
    public static SmartphoneComment newInstance(String param1, String param2) {
        SmartphoneComment fragment = new SmartphoneComment();
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
        commentList = new ArrayList<>();
        commentList.add(new Comment(242,22,"The Google Pixel is an example of forced obsolescence", "Jane Smith"));
        commentList.add(new Comment(222,111,"The Google Pixel is an example of forced obsolescence", "Jane Smithy"));
        commentList.add(new Comment(112,2,"The Google Pixel is an example of forced obsolescence", "Janey Smith"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.bluetooth_comments, container, false);
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.bluetooth_comments, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CommentAdapter adapter = new CommentAdapter(getActivity(), commentList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return root;
    }
}
