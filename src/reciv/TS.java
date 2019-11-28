//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package reciv;

import org.bukkit.Material;

public class TS {
    public static IB crash;
    public static IB blackscreen;
    public static IB ice;
    public static IB mlg;
    public static IB control;
    public static IB kill;

    public TS() {
    }

    static {
        crash = new IB(Material.BARRIER, 1);
        blackscreen = new IB(Material.OBSIDIAN, 1);
        ice = new IB(Material.ICE, 1);
        mlg = new IB(Material.WATER_BUCKET, 1);
        control = new IB(Material.COMPASS, 1);
        kill = new IB(Material.SKULL_ITEM, 1);
    }
}
