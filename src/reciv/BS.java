//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package reciv;

import CBukkit.async;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BS {
    public BS() {
    }

    public static void blackp(Player p) {
        int i = Bukkit.getScheduler().scheduleAsyncRepeatingTask(async.pe, new Runnable() {
            public void run() {
            }
        }, 0L, 2L);
        U.black.put(p, i);
    }
}
