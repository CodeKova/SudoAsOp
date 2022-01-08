package com.codekova.sudoasop.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SudoAsOp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(command.getName().equalsIgnoreCase("sudoasop"))
        {
            if(args.length == 0 || args.length < 2){
                sender.sendMessage(ChatColor.RED+"Usage /sudoasop <Player> <Command>");
                return true;
            }
            if(Bukkit.getPlayer(args[0]) == null)
            {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9[SudoAsOp]&c Player "+args[0]+" Not Found"));
                return true;
            }
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            StringBuilder commandSBuilder = new StringBuilder();
            for(int i = 1 ; i < args.length ; i++)
            {
                commandSBuilder.append(args[i]);
                commandSBuilder.append(" ");
            }
            String targetcommand = commandSBuilder.toString();
            if(targetPlayer.isOp()){
                targetPlayer.performCommand(targetcommand);
                return true;
            }else{
                try
                {
                 targetPlayer.setOp(true);
                 targetPlayer.performCommand(targetcommand);
                 targetPlayer.setOp(false);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    targetPlayer.setOp(false);
                    return true;
                }
                return true;
            }






        }


        return true;
    }
}
