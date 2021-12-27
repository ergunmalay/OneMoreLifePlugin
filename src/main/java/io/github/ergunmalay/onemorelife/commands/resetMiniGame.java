package io.github.ergunmalay.onemorelife.commands;

import io.github.ergunmalay.onemorelife.OneMoreLife;
import io.github.ergunmalay.onemorelife.listeners.onDeathEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static io.github.ergunmalay.onemorelife.listeners.onDeathEvent.HEALTH_AMOUNT;
import static io.github.ergunmalay.onemorelife.listeners.onDeathEvent.getAllPlayerHealth;

public class resetMiniGame implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!(sender instanceof Player)) {
            System.out.println("You're not a player");
            return false;
        }

        for (UUID player : onDeathEvent.getAllPlayerHealth()) {
            HEALTH_AMOUNT.replace(player, 2L);
            Player p = Bukkit.getServer().getPlayer(player);
            p.setHealth(0);
            Bukkit.getServer().broadcastMessage("Resetting One More Life");
        }

        return true;
    }
}
