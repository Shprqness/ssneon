package club.shprqness.ssneon.request;

import club.shprqness.ssneon.Neon;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ToggleHelp extends Command {


    public ToggleHelp(){
        super("togglehelp");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            if (sender.hasPermission("ssneon.togglehelp")) {
                ProxiedPlayer p = (ProxiedPlayer) sender;
                if (!Neon.instance.trequests.contains(p)) {
                    Neon.instance.trequests.add(p);
                    p.sendMessage(new TextComponent(ChatColor.GREEN + "You've toggled requests!"));
                    return;
                }
                if (Neon.instance.trequests.contains(p)) {
                    Neon.instance.trequests.remove(p);
                    p.sendMessage(new TextComponent(ChatColor.RED + "You've toggled requests!"));
                }
            }
        }
    }
}
