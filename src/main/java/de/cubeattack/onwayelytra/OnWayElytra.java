package de.cubeattack.onwayelytra;

import de.cubeattack.onwayelytra.listeners.*;
import de.cubeattack.onwayelytra.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class OnWayElytra extends JavaPlugin {

    private static final HashMap<UUID, ItemStack> safeChestPlate= new HashMap<>();
    private static final String PREFIX = "§7[§bCube§7] ";

    private static Settings settings;
    private static OnWayElytra plugin;

    @Override
    public void onLoad() {
        plugin = this;
        settings = new Settings();
    }

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new PlayerMove(), this);
        pluginManager.registerEvents(new PlayerChangeWorld(), this);
        pluginManager.registerEvents(new PlayerInteract(), this);

        this.getLogger().info(ChatColor.GREEN + "Enabled successful by CubeAttack");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(ChatColor.RED + "Disabled successful by CubeAttack");
    }

    public static Settings getSettings() {
        return settings;
    }

    public static HashMap<UUID, ItemStack> getSafeChestPlate() {
        return safeChestPlate;
    }

    public static String getPREFIX() {
        return PREFIX;
    }

    public static OnWayElytra getPlugin() {
        return plugin;
    }
}