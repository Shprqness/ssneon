package club.shprqness.ssneon.logging;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class LogCommand extends Command {


    public LogCommand(){
        super("log");
    }


    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof ProxiedPlayer) {
            if (sender.hasPermission("ssneon.logs")) {


                ProxiedPlayer p = (ProxiedPlayer) sender;

                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Incorrect Usage: '/log <name>'");
                    return;
                }
                ProxiedPlayer p1 = BungeeCord.getInstance().getPlayer(args[0]);

                String address = p1.getAddress().toString();
                String uuid = p1.getUniqueId().toString();
                String name = p1.getName();
                p.sendMessage(new TextComponent(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "                                              "));
                p.sendMessage(new TextComponent(ChatColor.YELLOW + "Logged information for the user " + ChatColor.GREEN + name + ChatColor.YELLOW + " »"));
                p.sendMessage(new TextComponent(ChatColor.YELLOW + "IP Address » " + ChatColor.GREEN + address));
                p.sendMessage(new TextComponent(ChatColor.YELLOW + "UUID » " + ChatColor.GREEN + uuid));
                if (p1.isForgeUser()) {
                    p.sendMessage(new TextComponent(ChatColor.YELLOW + "Forge » " + ChatColor.GREEN + "true"));
                } else {
                    p.sendMessage(new TextComponent(ChatColor.YELLOW + "Forge » " + ChatColor.GREEN + "false"));
                }
                p.sendMessage(new TextComponent(ChatColor.YELLOW + "Ping » " + ChatColor.GREEN + p1.getPing()));

                p.sendMessage(new TextComponent(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "                                              "));


            }
        }



    }
}
