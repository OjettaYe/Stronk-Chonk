package com.WWCNT.stronkchonk;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private View homeView;

    private Spinner hours;
    private Spinner minutes;

    private TextView textCountdown;
    private CountDownTimer countdownTimer;

    private ImageView frame1;
    private boolean frame1vis;

    private Button startButton;
    private Button resetButton;

    private long START_TIME_IN_MILLIS;
    private long timeLeftInMillis;

    private boolean timerRunning;
    private boolean changedTime; // TODO: detect changed time

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         homeView = inflater.inflate(R.layout.fragment_home, container, false);
      
      getActivity().setTitle("Stronk Chonk");

         hours = homeView.findViewById(R.id.hours);
         ArrayAdapter<CharSequence> hoursAdapter = ArrayAdapter.createFromResource(getContext(),
                 R.array.hours, android.R.layout.simple_spinner_item);
         hoursAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         hours.setAdapter(hoursAdapter);

         minutes = homeView.findViewById(R.id.minutes);
         ArrayAdapter<CharSequence> minutesAdapter = ArrayAdapter.createFromResource(getContext(),
                 R.array.minutes, android.R.layout.simple_spinner_item);
         minutesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         minutes.setAdapter(minutesAdapter);

         frame1 = homeView.findViewById(R.id.liftchonk1);
         frame1vis = true;

         textCountdown = homeView.findViewById(R.id.countdownTimer);

         startButton = homeView.findViewById(R.id.startButton);
         startButton.setOnClickListener(this);

         resetButton = homeView.findViewById(R.id.resetButton);
         resetButton.setOnClickListener(this);
         resetButton.setVisibility(View.INVISIBLE);

         START_TIME_IN_MILLIS = 3600000;
         timeLeftInMillis = START_TIME_IN_MILLIS;

         return homeView;
    }

    private void updateTime(){
        String selectedHours = hours.getSelectedItem().toString();
        String selectedMinutes = minutes.getSelectedItem().toString();
        int hou = Integer.parseInt(selectedHours) * 3600000;
        int min = Integer.parseInt(selectedMinutes) * 60000;
        int time = hou + min;
        if (time == 0){
            START_TIME_IN_MILLIS = 3600000;
        } else {
            START_TIME_IN_MILLIS = time;
        }
    }

    // countdown code from https://gist.github.com/codinginflow/58fddb4dcdb35ce7a7ff78aaa607c6ee

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.startButton:
                if (timerRunning){
                    pauseTimer();
                } else {
                    startTimer();
                }
                break;

            case R.id.resetButton:
                resetTimer();
                break;
        }
    }

    private void startTimer() {
        updateTime();
        countdownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
                toggleChonk();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                startButton.setText("Start");
                startButton.setVisibility(View.INVISIBLE);
                resetButton.setVisibility(View.VISIBLE);
            }

        }.start();

        timerRunning = true;
        startButton.setText("pause");
        resetButton.setVisibility(View.INVISIBLE);

    }

    private void pauseTimer() {
        countdownTimer.cancel();
        timerRunning = false;
        startButton.setText("Start");
        resetButton.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        updateTime();
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        resetButton.setVisibility(View.INVISIBLE);
        startButton.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textCountdown.setText(timeLeftFormatted);
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
