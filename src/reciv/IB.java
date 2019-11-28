//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package reciv;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IB extends ItemStack {
    public static ArrayList<IB> i = new ArrayList();
    public ItemMeta m = super.getItemMeta();

    public IB(Material t, int a) {
        super(t, a);
        i.add(this);
    }

    public void sd(String a) {
        this.m.setDisplayName(a);
        this.rl();
    }

    public IB(Material t, int a, short in) {
        super(t, a, in);
        i.add(this);
    }

    public void rl() {
        super.setItemMeta(this.m);
    }
}
