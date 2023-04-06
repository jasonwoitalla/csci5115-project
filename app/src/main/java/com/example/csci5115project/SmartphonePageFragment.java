package com.example.csci5115project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SmartphonePageFragment extends Fragment {
    SmartphoneComment spFragment = new SmartphoneComment();
    public SmartphonePageFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SmartphonePageFragment newInstance() {
        SmartphonePageFragment fragment = new SmartphonePageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.smartphone_product, container, false);

        root.findViewById(R.id.backToInfoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentUtil.replaceFragment(getActivity(), new NotificationFragment());
            }
        });
        root.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentUtil.replaceFragment(getActivity(), new BluetoothComment());
                addComment(view);
            }
        });
        return root;
    }
    public void addComment(View view){

        EditText editText = getActivity().findViewById(R.id.editTextCommentSection);
        String message = editText.getText().toString();
        spFragment.commentList.add((new Comment(0,0,message,"anon_user")));
        System.out.println(message);
        FragmentUtil.replaceFragment(getActivity(), spFragment);//MAY NEED BACKSTACK
//        Intent intent = new Intent(this, BluetoothComment.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//   //     commentList.add(new Comment(0,0,message,"anon_user"));
//
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }
}
