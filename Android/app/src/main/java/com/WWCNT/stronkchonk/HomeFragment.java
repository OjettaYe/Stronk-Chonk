package com.WWCNT.stronkchonk;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private View homeView;
    private Chronometer chrono;
    private Button startButton;
    private Button stopButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         homeView = inflater.inflate(R.layout.fragment_home, container, false);
         chrono = homeView.findViewById(R.id.simpleChronometer);
         startButton = homeView.findViewById(R.id.startButton);
         startButton.setOnClickListener(this);
         stopButton = homeView.findViewById(R.id.stopButton);
         stopButton.setOnClickListener(this);
         return homeView;

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.startButton:
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                break;
            case R.id.stopButton:
                chrono.stop();
                break;
        }
    }
}
