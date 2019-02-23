package com.example.tiago.bikeshare1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class BikeShareActivity extends AppCompatActivity {



    private Button StartRide;
    private Button EndRide;
    private static RidesDB sRidesDB;
    private ListView mListView;
    private Adapter mAdapter;


    private Ride newRide = new Ride("", "" ,"");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_share);
        sRidesDB = RidesDB.get(this);
        List<Ride> values = sRidesDB.getRidesDB();

        mAdapter = new RideArrayAdapter(this,values);
        mListView = (ListView) findViewById(R.id.main_list_view);
        mListView.setAdapter((ListAdapter) mAdapter);
        StartRide = (Button) findViewById(R.id.start_ride);
        EndRide = (Button) findViewById(R.id.end_ride);


        StartRide.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             Intent intent = StartRideActivity.newIntent(BikeShareActivity.this);
                                             startActivity(intent);
                                         }
                                     }
        );
        EndRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = EndRideActivity.newIntent(BikeShareActivity.this);
                startActivity(intent);
            }
        });

    }
}
