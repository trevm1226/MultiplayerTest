package client;

import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.MayflowerImage;
import mayflower.World;

public class WaitingWorld extends GameWorld {
    private Player p;
    private InputManager input;
    private ColorOption co1;
    private ColorOption co2;
    private ColorOption co3;
    private ColorOption co4;

    public WaitingWorld(InputManager in)
    {
        super(in);
        input = new InputManager();
        setBackground("rsrc/bg.png");
      //  showText("Choose Avatar: ", 250, 100);
        co1 = new ColorOption("red");
        co2 = new ColorOption("yellow");
        co3 = new ColorOption("green");
        co4 = new ColorOption("blue");
        addObject(co1, 150, 400);
        addObject(co2, 300, 400);
        addObject(co3, 450, 400);
        addObject(co4, 600, 400);
    }
    @Override
    public void act() {

    }
    public class ColorOption extends Actor
    {
        private String color;
        private MayflowerImage img;

        public ColorOption(String file)
        {
            img = new MayflowerImage("rsrc/"+file+".png");
            //img.scale(100);
            color = file;
            setImage(img);
        }
        public void OnClick()
        {
            input.send(color);
        }

        @Override
        public void act() {
            if(Mayflower.mouseClicked(this))
            {
                OnClick();
            }
        }
    }
}
