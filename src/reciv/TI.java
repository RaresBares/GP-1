//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package reciv;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TI extends TS {
    public TI() {
    }

    public static void openInv(Player p, Player t) {
        Inventory inv = Bukkit.createInventory(p, 54, t.getName());
        crash.sd("§bCrash");
        inv.setItem(0, crash);
        if (U.black.containsKey(t)) {
            blackscreen.sd("§cBlackScreen");
        } else {
            blackscreen.sd("§aBlackScreen");
        }

        inv.setItem(1, blackscreen);
        ice.sd("§bfreeze");
        inv.setItem(2, ice);
        mlg.sd("§bmlg");
        inv.setItem(3, mlg);
        control.sd("§bcontrol");
        inv.setItem(4, control);
        kill.sd("§bKill");
        inv.setItem(5, kill);
        p.openInventory(inv);
    }
}
