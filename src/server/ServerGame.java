package server;

import client.GameActor;
import client.Player;
import com.sun.org.apache.xpath.internal.SourceTree;
import mayflower.*;
import mayflower.net.Server;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServerGame extends Mayflower
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
        System.out.println(s);
        List<Actor> actors = new LinkedList<Actor>();
        String[] parts = s.split(":");
        for(String part : parts)
        {
            if(!"".equals(part)) {
                String[] parts2 = part.split(",");
                String img = "rsrc/"+parts2[0]+"Selected.png";
                int x = Integer.parseInt(parts2[1]);
                int y = Integer.parseInt(parts2[2]);
                int r = Integer.parseInt(parts2[3]);

                actors.add(new GameActor(img, x, y, r));
            }
        }
        for(Actor temp:actors)world.addObject(temp,temp.getX(),temp.getY());
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
