package com.company;
/**
 * class representing a (x,y) coordinate on map
 * */
public class Location {
    private int x;
    private int y;
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /** generate random location between [0,10] */
    public static Location generateRandomLocation(){
        int max=10, min=0;
        int xPos = (int)(Math.random() * ((max - min) + 1));
        int yPos = (int)(Math.random() * ((max - min) + 1));
        return new Location(xPos, yPos);
    }
}
