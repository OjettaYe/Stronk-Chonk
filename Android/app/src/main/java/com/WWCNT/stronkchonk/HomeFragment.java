package com.WWCNT.stronkchonk;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private View homeView;

    private ImageView frame1;
    private boolean frame1vis;

    private Button startButton;
    private Button resetButton;
    private boolean running;
    private boolean atZero;

    private Chronometer chrono;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         homeView = inflater.inflate(R.layout.fragment_home, container, false);
      
      getActivity().setTitle("Stronk Chonk");

         frame1 = homeView.findViewById(R.id.liftchonk1);
         frame1vis = true;

         startButton = homeView.findViewById(R.id.startButton);
         startButton.setOnClickListener(this);

         resetButton = homeView.findViewById(R.id.resetButton);
         resetButton.setOnClickListener(this);
         resetButton.setVisibility(View.INVISIBLE);

         chrono = homeView.findViewById(R.id.stopwatch);
         atZero = true;

         return homeView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.startButton:
                if (running) {
                    pauseStopwatch();
                    startButton.setText("Start");
                } else {
                    startStopwatch();
                    startButton.setText("Pause");
                }
                break;
            case R.id.resetButton:
                resetStopwatch();
        }
    }

    private void startStopwatch() {
        if (atZero) {
            chrono.setBase(SystemClock.elapsedRealtime());
        }
        chrono.start();

        chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            @Override
            public void onChronometerTick(Chronometer chronometer) {
                toggleChonk();
            }
        });

        atZero = false;
        running = true;
        resetButton.setVisibility(View.INVISIBLE);
    }

    private void pauseStopwatch() {
        running = false;
        chrono.stop();
        resetButton.setVisibility(View.VISIBLE);
    }

    private void resetStopwatch() {
        chrono.setBase(SystemClock.elapsedRealtime());
        atZero = true;
    }

    private void toggleChonk(){
        if (frame1vis){
            frame1.setImageResource(R.drawable.lifting_chonk_2);
            frame1vis = false;
        } else {
            frame1.setImageResource(R.drawable.lifting_chonk_1);
            frame1vis = true;
        }
    }

}
