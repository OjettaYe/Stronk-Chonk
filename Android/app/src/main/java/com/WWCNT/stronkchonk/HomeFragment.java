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
import android.widget.TextView;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private View homeView;

    private ImageView frame1;
    private boolean frame1vis;

    private Button startButton;
    private Button resetButton;
    private boolean running;
    private boolean atZero;
    private TextView tvLong;

    private Chronometer chrono;
    private long elapsedMillis = 0;

    private Chronometer chronorest;
    private int RestImage = 0;

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

        tvLong = (TextView) homeView.findViewById(R.id.StoredLong);

        chronorest = homeView.findViewById(R.id.stopwatchREST);
        startStopwatchRest();
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
                    chronorest.stop();
                    chronorest.setBase(SystemClock.elapsedRealtime());
                    startButton.setText("Pause");
                }
                break;
            case R.id.resetButton:
                resetStopwatch();
        }
    }

    private void startStopwatch() {
        chrono.setVisibility(View.VISIBLE);
        if (atZero) {
            chrono.setBase(SystemClock.elapsedRealtime());
        }
        else{
            chrono.setBase(SystemClock.elapsedRealtime() - elapsedMillis);
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
        tvLong.setVisibility(View.INVISIBLE);
        resetButton.setVisibility(View.INVISIBLE);
    }

    private void pauseStopwatch() {
        running = false;
        elapsedMillis = SystemClock.elapsedRealtime() - chrono.getBase();
        chrono.setBase(SystemClock.elapsedRealtime());
        chrono.stop();
        //Convert milli seconds to seconds/minutes
        long minutes = (elapsedMillis/1000)/60;
        long seconds = (elapsedMillis/1000)%60;
        String minstring = String.format("%02d", minutes);
        String secstring = String.format("%02d", seconds);
        String output = minstring+":"+secstring;
        chrono.setVisibility(View.INVISIBLE);

//        TextView tvLong = (TextView) homeView.findViewById(R.id.StoredLong);
        tvLong.setText(output);
        tvLong.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.VISIBLE);
    }

    private void resetStopwatch() {
        elapsedMillis = 0;
        chrono.setVisibility(View.VISIBLE);
        tvLong.setVisibility(View.INVISIBLE);
        chrono.setBase(SystemClock.elapsedRealtime());
        atZero = true;
        startStopwatchRest();
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
    //Chonk at rest
    private void toggleRestChonk(){
        if (RestImage == 0){
            frame1.setImageResource(R.drawable.squirrel0000);
            RestImage++;
        } else if (RestImage== 1){
            frame1.setImageResource(R.drawable.squirrel0001);
            RestImage++;
        } else if (RestImage== 2){
            frame1.setImageResource(R.drawable.squirrel0002);
            RestImage++;
        } else if (RestImage== 3){
            frame1.setImageResource(R.drawable.squirrel0003);
            RestImage++;
        } else if (RestImage== 4){
            frame1.setImageResource(R.drawable.squirrel0004);
            RestImage++;
        }else if (RestImage== 5){
            frame1.setImageResource(R.drawable.squirrel0003);
            RestImage++;
        }else if (RestImage== 6){
            frame1.setImageResource(R.drawable.squirrel0002);
            RestImage++;
        }else {
            frame1.setImageResource(R.drawable.squirrel0001);
            RestImage = 0;
        }
    }
    private void startStopwatchRest() {
        chronorest.setBase(SystemClock.elapsedRealtime());
        chronorest.start();
        chronorest.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                toggleRestChonk();
            }
        });
//        chrono.setVisibility(View.INVISIBLE);
        tvLong.setVisibility(View.INVISIBLE);
        resetButton.setVisibility(View.INVISIBLE);
    }

}
