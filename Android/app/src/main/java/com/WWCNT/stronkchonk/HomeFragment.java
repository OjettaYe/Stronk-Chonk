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
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Locale;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private long START_TIME_IN_MILLIS = 600000;
    private View homeView;

    private TextView textCountdown;
    private CountDownTimer countdownTimer;

    private Button startButton;
    private Button resetButton;

    private boolean timerRunning;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         homeView = inflater.inflate(R.layout.fragment_home, container, false);
         getActivity().setTitle("Stronk Chonk");
         textCountdown = homeView.findViewById(R.id.countdownTimer);
         startButton = homeView.findViewById(R.id.startButton);
         startButton.setOnClickListener(this);
         resetButton = homeView.findViewById(R.id.resetButton);
         resetButton.setOnClickListener(this);
         resetButton.setVisibility(View.INVISIBLE);
         return homeView;

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
        countdownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
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

}
