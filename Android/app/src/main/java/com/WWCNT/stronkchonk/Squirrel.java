package com.WWCNT.stronkchonk;

public class Squirrel {
    //Attributes;
    private int id;
    private int size;
    private int chonklevel;
    private String name;

    public Squirrel(int id, int size, int chonklevel, String name) {
        this.id = id;
        this.size = size;
        this.chonklevel = chonklevel;
        this.name = name;
    }

    //Get/Set
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return size;
    }
    public void setChonklevel(int chonklevel){
        this.chonklevel = chonklevel;
    }
    public int getChonklevel(){
        return chonklevel;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
