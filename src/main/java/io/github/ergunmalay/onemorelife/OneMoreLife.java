package io.github.ergunmalay.onemorelife;


import io.github.ergunmalay.onemorelife.commands.resetMiniGame;
import io.github.ergunmalay.onemorelife.listeners.ServerJoin;
import io.github.ergunmalay.onemorelife.listeners.onDeathEvent;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class OneMoreLife extends JavaPlugin {

    @Getter
    private static OneMoreLife plugin;

    @Override
    public void onLoad() {

        plugin = this;

    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        PluginManager pluginManager = Bukkit.getPluginManager();
        System.out.println("Plugin booted up!");

        pluginManager.registerEvents(new onDeathEvent(), this);
        pluginManager.registerEvents(new ServerJoin(),this);
        getCommand("resetOneMoreLife").setExecutor(new resetMiniGame());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
