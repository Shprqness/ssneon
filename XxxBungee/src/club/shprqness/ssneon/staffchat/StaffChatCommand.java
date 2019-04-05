package club.shprqness.ssneon.staffchat;

import club.shprqness.ssneon.Neon;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffChatCommand extends Command {


    public StaffChatCommand() {
        super("sc");
    }


    @Override
    public void execute(CommandSender sender, String[] args) {

        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;

            if (p.hasPermission("ssneon.staffchat")) {
                if (args.length == 0) {
                    if (!Neon.instance.tstaffchat.contains(p)) {
                        Neon.instance.tstaffchat.add(p);
                        p.sendMessage(new TextComponent(ChatColor.GREEN + "You've toggled staff chat!"));
                        return;
                    }
                    if (Neon.instance.tstaffchat.contains(p)) {
                        Neon.instance.tstaffchat.remove(p);
                        p.sendMessage(new TextComponent(ChatColor.RED + "You've toggled staff chat!"));
                        return;
                        }
                    }
               }

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < args.length; i++) {
                    sb.append(args[i]).append(" ");
                }

                for (ProxiedPlayer staff : BungeeCord.getInstance().getPlayers()) {
                    //if (staff.hasPermission("ssneon.staffchat") && Neon.instance.tstaffchat.contains(staff)) {
                        staff.sendMessage(ChatColor.GREEN + "[Staff Chat] " + ChatColor.YELLOW + sb.toString() + ChatColor.GREEN+
                                " » " + p.getName());
                   //}
                }


            }


        }
    }
