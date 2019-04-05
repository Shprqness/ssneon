package club.shprqness.ssneon.logging;

import club.shprqness.ssneon.Neon;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Logging implements Listener {


    @EventHandler
    public void loggger(PostLoginEvent e){

        ProxiedPlayer p = e.getPlayer();
        for (ProxiedPlayer staff : BungeeCord.getInstance().getPlayers()) {
            if (Neon.instance.tlogs.contains(staff)) {
                staff.sendMessage(new TextComponent(ChatColor.GREEN + p.getName() + ChatColor.YELLOW + " has joined with the ip address " + ChatColor.GREEN + p.getAddress().toString()));
            }
        }


    }


}
