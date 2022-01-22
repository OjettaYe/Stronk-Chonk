package com.WWCNT.stronkchonk;

import java.sql.Time;

public class Workout {
    //Attributes
    private int id;
    private String name;
    private Time startTime;
    private Time endTime;
    private int length;
    private int exp;

    //Get/Set Methods
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
    public Time getStartTime(){
        return startTime;
    }
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    public Time getEndTime() {
        return endTime;
    }
    public void setLength(int length){
        this.length = length;
    }
    public int getLength(){
        return length;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public int getExp() {
        return exp;
    }
}
