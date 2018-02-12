package server;

import client.Player;
import mayflower.Actor;
import mayflower.Direction;
import mayflower.MayflowerHeadless;
import mayflower.World;
import mayflower.net.Server;

import java.util.HashMap;
import java.util.Map;

public class ServerGame extends MayflowerHeadless
{
    private Map<Integer, Actor> actors;
    private ServerWorld world;
    private Player player;
    private int numPlayers;

    public ServerGame(Server server)
    {
        super("Server", 800, 600);
        actors = new HashMap<Integer, Actor>();
        player = new Player();

        world = new ServerWorld(server);
        this.setWorld(world);
    }

    public void process(int i, String s)
    {
        Actor actor = actors.get(i);
        String[] split = s.split(" ");
        if(actor != null)
        {
            switch(split[0])
            {
                case "up":
                    actor.setRotation(Direction.NORTH);
                    break;
                case "down":
                    actor.setRotation(Direction.SOUTH);
                    break;
                case "left":
                    actor.setRotation(Direction.WEST);
                    break;
                case "right":
                    actor.setRotation(Direction.EAST);
                    break;
                case "picked":
                    String color = split[1];
                    player.setColor(color);
                    numPlayers++;
                    if(numPlayers >= 4)
                    {
                        //start world
                    }
            }
            //actor.move(10);
        }
    }

    public void join(int i)
    {
        Actor actor = new BoxActor();
        int x = (int)(Math.random() * 700) + 50;
        int y = (int)(Math.random() * 500) + 50;
        world.addObject(actor, x, y);

        actors.put(i, actor);
    }

    public void leave(int i)
    {
        Actor actor = actors.get(i);
        if(null != actor)
        {
            world.removeObject(actor);
        }
    }

    @Override
    public void init()
    {
    }
}
