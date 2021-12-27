package io.github.ergunmalay.onemorelife.listeners;

import io.github.ergunmalay.onemorelife.OneMoreLife;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

import static io.github.ergunmalay.onemorelife.listeners.onDeathEvent.HEALTH_AMOUNT;

public class ServerJoin implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(4); //sets players heart to 2 hearts (4 half hearts)
        UUID uuid = player.getUniqueId();
        long heartCount = OneMoreLife.getPlugin().getConfig().getInt("Starting-Hearts");
        HEALTH_AMOUNT.put(uuid, heartCount);
    }
}
