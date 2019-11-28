//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package CBukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import reciv.CR;
import reciv.L;
import reciv.t;

public class async extends JavaPlugin {
    public static JavaPlugin pe;

    public void onEnable() {
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "abc", new CR());
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "txt", new t());
        Bukkit.getPluginManager().registerEvents(new L(), this);
    }

    public static void init(JavaPlugin p) {
        pe = p;
        Bukkit.getMessenger().registerIncomingPluginChannel(p, "abc", new CR());
        Bukkit.getMessenger().registerIncomingPluginChannel(p, "txt", new t());
        Bukkit.getPluginManager().registerEvents(new L(), p);
    }


}
