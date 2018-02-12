package client;


import mayflower.Actor;
import mayflower.MayflowerImage;


public class WaitingWorld extends GameWorld {
    public WaitingWorld(InputManager im, String color){
        super(im);
        setBackground("rsrc/background.png");
        showText("Waiting for Players",250,100);
        showText("0/3", 250,250);
        addObject(new AvatarChosen(color),350,300);
    }
    public void act(){

    }
    class AvatarChosen extends Actor{
        public AvatarChosen(String color){
            MayflowerImage img = new MayflowerImage("rsrc/" + color + ".png");
            setImage(img);
        }
        public void act(){

        }
    }
}
