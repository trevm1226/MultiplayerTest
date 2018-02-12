package server;

import client.GameClient;
import mayflower.Actor;
import mayflower.Direction;
import mayflower.MayflowerHeadless;
import mayflower.World;
import mayflower.net.Server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerGame extends MayflowerHeadless
{
    private Map<Integer, Actor> actors;
    private ServerWorld world;
    private Player player;
    private Server serv;
    private int numPlayers;
    public ServerGame(Server server)
    {
        super("Server", 800, 600);
        actors = new HashMap<Integer, Actor>();
        player = new Player(1);
        numPlayers = 0;
        serv = server;
        world = new ServerWorld(server);
        this.setWorld(world);

    }

    public void process(int i, String s)
    {
        Actor actor = new Player(i);
        System.out.println(actor.toString());
        //if(!"".equals(s)){
           // System.out.println(s);
       // }
        String[] split = s.split(" ");
        if(actor != null)
        {
            System.out.println(split[0]);
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
                case"pickedcolor":
                    String color = split[1];
                    player.setColor(color);
                    serv.send("changeWorld:waiting:" + player.getColor());
                    break;
                case"worldchanged":
                    numPlayers++;
                    System.out.println("num players:" + numPlayers);
                    if(numPlayers >= 3){
                        //set world to play
                    }
                    else{
                        System.out.println(numPlayers);
                        System.out.println("players " + numPlayers);
                        serv.send("updateLobby:" + numPlayers);
                    }
                    break;
            }
            //actor.move(10);
        }
    }

    public void join(int i)
    {

    }

    public void leave(int i)
    {

    }

    @Override
    public void init()
    {
    }
}
