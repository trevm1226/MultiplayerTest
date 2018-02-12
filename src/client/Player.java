package client;

import mayflower.Actor;

public class Player extends Actor{
    private String color;
    public Player()
    {
        color = null;
    }

    @Override
    public void act() {

    }

    public void setColor(String c)
    {
        color = c;
    }

    public String getColor() {
        return color;
    }
}
