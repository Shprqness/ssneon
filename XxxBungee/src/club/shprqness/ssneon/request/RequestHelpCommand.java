package club.shprqness.ssneon.request;

import club.shprqness.ssneon.Neon;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class RequestHelpCommand extends Command {


    public RequestHelpCommand(){
        super("helpop");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer){
            ProxiedPlayer p = (ProxiedPlayer) sender;

            if(args.length == 0){
                p.sendMessage(new TextComponent(ChatColor.RED + "Incorrect Usage: '/helpop <message here>'"));
                return;
            }

            if(Neon.instance.trequests.size() == 0){
                p.sendMessage(new TextComponent(ChatColor.RED + "There are no online staff at the moment."));
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                sb.append(args[i]).append(" ");
            }

            for (ProxiedPlayer staff : BungeeCord.getInstance().getPlayers()) {
              //  if (staff.hasPermission("ssneon.helpopmsg") && Neon.instance.trequests.contains(staff)) {
                    staff.sendMessage(ChatColor.RED + "[HELPOP] " + ChatColor.YELLOW + sb.toString() + ChatColor.GREEN+
                            " » " + p.getName());
               // }
            }

            p.sendMessage(new TextComponent(ChatColor.GREEN + "Request has been sent to all online staff!"));

        }
    }
}
