package com.WWCNT.stronkchonk;

import java.util.ArrayList;

public class User {
    //Attributes.
    private int id;
    private String name;
    private ArrayList<Workout> workouts;

    public User(String name, int id){
        this.name = name;
        this.id = id;
    }

    //GetSet Methods;
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //NOTE: I don't think we should use these two get/set methods.
    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }
    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }
    //Method to add a workout.
    public void addWorkout(Workout workout){
        workouts.add(workout);
    }
}
