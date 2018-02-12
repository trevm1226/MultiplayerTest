package server;

import mayflower.Actor;
import mayflower.Timer;
import mayflower.World;
import mayflower.net.Server;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServerWorld extends World
{
    private Server server;
    private Timer timer;

    public ServerWorld(Server server)
    {
        timer = new Timer(750000);
        this.server = server;
    }

    @Override
    public void addObject(Actor a, int x, int y)
    {
        super.addObject(a, x, y);
        System.out.println("Adding: "+ a + " to " + x +", " + y);
    }

    @Override
    public void act()
    {
        if(timer.isDone())
        {
            List<BoxActor> actors = getObjects(BoxActor.class);
            for(Actor actor : actors)
            {
                actor.move(10);
                if(actor.isAtEdge())
                {
                    while(actor.isAtEdge())
                        actor.move(-1);
                    actor.turn(180);
                }
            }

            //System.out.println("tick: " + this.getObjects().size());
            //System.out.println("tick: " + server);
            timer.reset();
            if(null != server)
            {
                server.send(this.toString());
            }
        }
    }

    public String toString()
    {
        String str = "";

        List<BoxActor> actors = getObjects(BoxActor.class);
        for(Actor actor : actors)
        {
            str += actor.toString() + ":";
        }

        return str;
    }
}
