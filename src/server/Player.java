package server;

import mayflower.Actor;

public class Player extends Actor {
    private String color;
    private int ID;
    public Player(int id){
        ID = id;
    }
    public void setColor(String c){
        color = c;
    }
    public String getColor(){
        return color;
    }
    public void setActor(){

    }

    public void act(){

    }
}
