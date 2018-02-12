package client;

import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.MayflowerImage;
import server.Player;

public class ChooseAvatarWorld extends GameWorld {
    private Player p;
    private ColorOption co1;
    private ColorOption co2;
    private ColorOption co3;
    private ColorOption co4;
    private InputManager input;
    public ChooseAvatarWorld(InputManager im){
        super(im);
        input = im;
        p = new server.Player();
        setBackground("rsrc/background.png");
        showText("Choose Avatar",250,100);
        co1 = new ColorOption("red");
        co2 = new ColorOption("Yellow");
        co3 = new ColorOption("Green");
        co4 = new ColorOption("blue");
        addObject(co1,100,300);
        addObject(co2,250,300);
        addObject(co3,400,300);
        addObject(co4,550,300);
    }
    @Override
    public void act() {

    }
    public class ColorOption extends Actor {
        private MayflowerImage img;
        private String color;
        public ColorOption(String file){
            img = new MayflowerImage("rsrc/" + file + ".png");
            setImage(img);
            //img.scale(20);
            color = file;
        }

        @Override
        public void act() {
            if(Mayflower.mouseClicked(this)){
                OnClick();

            }
        }
        public void OnClick(){
            input.send("pickedcolor " + color);
            //Mayflower.setWorld(new WaitingWorld(input,color));
        }
    }
}
