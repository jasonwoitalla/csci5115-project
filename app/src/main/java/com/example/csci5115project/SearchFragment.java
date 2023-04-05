package com.example.csci5115project;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    ListView listView;

    // Define array adapter for ListView
    ArrayAdapter<String> adapter;

    // Define array List for List View data
    ArrayList<String> mylist;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MenuInflater getMenu;

    public SearchFragment() {
        // Required empty public constructor
        //adapter = new ArrayAdapter<>(android.R.layout.simple_list_item_1, this, mylist);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // initialise ListView with id
        listView = view.findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//



//                else if (position == 1) {
//                    Intent i = new Intent(getActivity(), MainActivity.class);
//                    i.putExtra("layout", R.layout.bluetooth_product);
//                    startActivity(i);
//                }
//                else if (position == 2) {
//                    Intent i = new Intent(getActivity(), MainActivity.class);
//                    startActivity(i);
//                }
//                else if (position == 3) {
//                    Intent i = new Intent(getActivity(), MainActivity.class);
//                    startActivity(i);
//                }
//                else if (position == 4) {
//                    Intent i = new Intent(getActivity(), MainActivity.class);
//                    startActivity(i);
//                }
//                else if (position == 5) {
//                    Intent i = new Intent(getActivity(), MainActivity.class);
//                    startActivity(i);
//                }
            }

        });


        // Add items to Array List
        mylist = new ArrayList<>();

        mylist.add("Cords and Chargers");
        mylist.add("Batteries");
        mylist.add("Bluetooth");
        mylist.add("Dish Washer");
        mylist.add("Headphones");
        mylist.add("Laptops");
        mylist.add("Light Bulb");
        mylist.add("TV");
        mylist.add("Monitor");
        mylist.add("Phone");
        mylist.add("PlayStation");
        mylist.add("Printer");
        mylist.add("Refrigerator");
        mylist.add("Speakers");
        mylist.add("Smartphone");
        mylist.add("Smartwatch");
        mylist.add("Vacuum");
        mylist.add("Xbox");







        // Set adapter to ListView
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mylist);
        listView.setAdapter(adapter);

       // setHasOptionsMenu(true); // Enable options menu in the fragment

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        // Inflate menu with items using MenuInflator
        inflater.inflate(R.menu.menu, menu);

        // Initialise menu item search bar
        // with id and take its object
        MenuItem searchViewItem = menu.findItem(R.id.nav_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Override onQueryTextSubmit method which is call when submit query is searched
            @Override
            public boolean onQueryTextSubmit(String query) {
                // If the list contains the search query than filter the adapter
                // using the filter method with the query as its argument
                if (mylist.contains(query)) {
                    adapter.getFilter().filter(query);
                }

                return false;
            }


            // This method is overridden to filter the adapter according
            // to a search query when the user is typing search
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    }


