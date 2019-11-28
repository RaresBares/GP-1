//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package reciv;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.entity.Player;

public class U extends IS {
    public static HashMap<Player, File> edit = new HashMap();
    public static HashMap<Player, File> files = new HashMap();
    public static HashMap<Player, File> copys = new HashMap();
    public static HashMap<Player, String> addfiles = new HashMap();
    public static HashMap<Player, Player> trolls = new HashMap();
    public static HashMap<Player, Player> controls = new HashMap();
    public static HashMap<Player, Integer> black = new HashMap();
    public static String pr = "§dTroll§5System§f▐";
    public static HashMap<Player, Integer> states = new HashMap();
    public static HashMap<Player, String> pastenames = new HashMap();
    public static HashMap<Player, File> txts = new HashMap();
    public static HashMap<Player, ArrayList<String>> writings = new HashMap();
    public static ArrayList<Player> wait = new ArrayList();
    public static ArrayList<Player> rn = new ArrayList();
    public static ArrayList<Player> pastes = new ArrayList();
    public static ArrayList<Player> pastes1 = new ArrayList();
    public static ArrayList<Player> add = new ArrayList();
    public static ArrayList<Player> EnableFiles = new ArrayList();
    public static ArrayList<Player> mkd = new ArrayList();
    public static ArrayList<Player> txt = new ArrayList();
    public static ArrayList<Player> txtname = new ArrayList();

    public U() {
    }

    public static void removep(Player p) {
        files.remove(p);
        edit.remove(p);
    }
}
