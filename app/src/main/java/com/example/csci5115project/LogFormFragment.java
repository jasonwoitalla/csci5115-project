package com.example.csci5115project;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LogFormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogFormFragment extends Fragment
    implements AdapterView.OnItemSelectedListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private final int CAMERA_PERMISSION_CODE = 1;
    private final int CAMERA_REQUEST_CODE = 2;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LogFormFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LogFormFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LogFormFragment newInstance(String param1, String param2) {
        LogFormFragment fragment = new LogFormFragment();
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

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_log_form, container, false);

        Spinner spin = root.findViewById(R.id.deviceCategory);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.device_categories, R.layout.spiner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

        ImageView preview = (ImageView) root.findViewById(R.id.picturePreview);

        // Camera Work

        // Get Picture After Photo
        ActivityResultLauncher<Intent> cameraActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                            preview.setImageBitmap(thumbnail);
                        }
                    }
                }
        );

        // Get Camera Permission
        ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                new ActivityResultCallback<Boolean>() {
                    @Override
                    public void onActivityResult(Boolean result) {
                        if(result) { // permission granted
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            cameraActivityResultLauncher.launch(intent);
                        } else {
                            Toast.makeText(getActivity(), "Please accept camera permissions if you want to take a picture of your device", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        Button addPhoto = (Button) root.findViewById(R.id.addPicture);
        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getPermission()) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraActivityResultLauncher.launch(intent);
                } else {
                    requestPermissionLauncher.launch(Manifest.permission.CAMERA);
                }
            }
        });

        Button logButton = (Button) root.findViewById(R.id.confirmLogButton);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentUtil.replaceFragment(getActivity(), new ConfirmationFragment());
            }
        });

        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private boolean getPermission() {
        return ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED;
    }
}