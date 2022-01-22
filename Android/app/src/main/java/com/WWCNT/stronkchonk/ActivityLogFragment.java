package com.WWCNT.stronkchonk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.sql.Time;
import java.util.ArrayList;

public class ActivityLogFragment extends Fragment {
    private View actLogView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        actLogView = inflater.inflate(R.layout.fragment_activitylog, container, false);
        //Test Workouts
        Time timetest = Time.valueOf("14:00:00");
        Workout w1 = new Workout(1,"ChonkWork1",timetest, timetest, 30, 50);
        Workout w2 = new Workout(2,"ChonkWork2",timetest, timetest, 20, 50);
        Workout w3 = new Workout(3,"ChonkWork3",timetest, timetest, 50, 50);
        Workout w4 = new Workout(4,"ChonkWork4",timetest, timetest, 90, 50);

        ArrayList<Workout> workoutTests = new ArrayList<>();
        workoutTests.add(w1);
        workoutTests.add(w2);
        workoutTests.add(w3);
        workoutTests.add(w4);

        WorkoutListAdapter adapter = new WorkoutListAdapter(getActivity(), R.layout.adapter_view_layout, workoutTests);
        ListView aListView = actLogView.findViewById(R.id.listView);
        aListView.setAdapter(adapter);



        //End Test Worouts
        return actLogView;
    }

}
