package io.github.ergunmalay.onemorelife.listeners;

import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class onDeathEvent implements Listener {

    public static final HashMap<UUID, Long> HEALTH_AMOUNT = new HashMap<>();

    public static Set<UUID> getAllPlayerHealth() {return HEALTH_AMOUNT.keySet(); }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        long heartCount1 = HEALTH_AMOUNT.get(player.getUniqueId());
        if (heartCount1 >= 20) {
            player.setGameMode(GameMode.SPECTATOR);
        } else {
            heartCount1 = heartCount1 + 2;
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(heartCount1);
            HEALTH_AMOUNT.put(player.getUniqueId(), heartCount1);
        }

    }
}
