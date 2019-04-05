package club.shprqness.ssneon;

import club.shprqness.ssneon.logging.LogCommand;
import club.shprqness.ssneon.logging.Logging;
import club.shprqness.ssneon.logging.ToggleLogs;
import club.shprqness.ssneon.request.RequestHelpCommand;
import club.shprqness.ssneon.request.ToggleHelp;
import club.shprqness.ssneon.staffchat.StaffChatCommand;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.ArrayList;

public class Neon extends Plugin {


    /*
    Coded by ya boi Shprqness
    xxx
    Shprqness Development
     */

    public static Neon instance;




    public ArrayList<ProxiedPlayer> talerts = new ArrayList<>();
    public ArrayList<ProxiedPlayer> trequests = new ArrayList<>();
    public ArrayList<ProxiedPlayer> tstaffchat = new ArrayList<>();
    public ArrayList<ProxiedPlayer> treports = new ArrayList<>();
    public ArrayList<ProxiedPlayer> tlogs = new ArrayList<>();



    @Override
    public void onEnable() {
        instance = this;
        commands();
        events();
    }

    public void commands(){
        getProxy().getPluginManager().registerCommand(this, new ToggleLogs());
        getProxy().getPluginManager().registerCommand(this, new LogCommand());
        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand());
        getProxy().getPluginManager().registerCommand(this, new RequestHelpCommand());
        getProxy().getPluginManager().registerCommand(this, new ToggleHelp());
    }

    public void events(){
        getProxy().getPluginManager().registerListener(this, new Logging());

    }

}
