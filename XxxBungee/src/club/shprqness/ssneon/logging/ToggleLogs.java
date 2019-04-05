package club.shprqness.ssneon.logging;

import club.shprqness.ssneon.Neon;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ToggleLogs extends Command {

    public ToggleLogs(){
        super("togglelogs");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof ProxiedPlayer) {
            if (sender.hasPermission("ssneon.logs")) {
                ProxiedPlayer p = (ProxiedPlayer) sender;
                if (!Neon.instance.tlogs.contains(p)) {
                    Neon.instance.tlogs.add(p);
                    p.sendMessage(new TextComponent(ChatColor.GREEN + "You've toggled alerts!"));
                    return;
                }
                if (Neon.instance.tlogs.contains(p)) {
                    Neon.instance.tlogs.remove(p);
                    p.sendMessage(new TextComponent(ChatColor.RED + "You've toggled alerts!"));
                }
            }
        }

    }
}
