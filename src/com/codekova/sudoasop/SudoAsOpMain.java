package com.codekova.sudoasop;

import com.codekova.sudoasop.commands.SudoAsOp;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SudoAsOpMain extends JavaPlugin {


    public void onEnable()
    {

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"[SudoAsOP] Plugin Enabled");
        getCommand("sudoasop").setExecutor(new SudoAsOp());
    }


    public void onDisable()
    {


        getServer().getConsoleSender().sendMessage(ChatColor.RED+"[SudoAsOP] Plugin Disabled");
    }
}
