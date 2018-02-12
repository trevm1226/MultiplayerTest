package client;

import mayflower.Keyboard;
import mayflower.Mayflower;

import java.util.HashMap;
import java.util.Map;

public class ClientRunner extends Mayflower
{
    public ClientRunner()
    {
        super("Client", 800, 600);
    }
    @Override
    public void init()
    {
        String ip = Mayflower.ask("Connect to what IP address?");
        if("".equals(ip))
            ip = "localhost";

        GameClient client = new GameClient(ip);
        InputManager im = new InputManager(client);

        Map<Integer, String> keys = new HashMap<Integer, String>();
        keys.put(Keyboard.KEY_W, "up");
        keys.put(Keyboard.KEY_A, "left");
        keys.put(Keyboard.KEY_S, "down");
        keys.put(Keyboard.KEY_D, "right");
        im.setKeyMap(keys);

        GameWorld world = new ChooseAvatarWorld(im);
        client.setWorld(world);

        Mayflower.setWorld(world);
    }

    public static void main(String[] args)
    {
        new ClientRunner();
    }
}
