package de.cubeattack.onwayelytra;

import de.cubeattack.onwayelytra.listeners.JoinListener;
import de.cubeattack.onwayelytra.listeners.PlayerChangeWorld;
import de.cubeattack.onwayelytra.listeners.PlayerInteract;
import de.cubeattack.onwayelytra.listeners.PlayerMove;
import de.cubeattack.onwayelytra.utils.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class OnWayElytra extends JavaPlugin {

    public static HashMap<UUID, ItemStack> safeChestPlate= new HashMap<>();

    private static OnWayElytra plugin;
    public static String PREFIX = "§7[§bCube§7] ";

    @Override
    public void onLoad() {
        FileUtils.copyToFile(Objects.requireNonNull(this.getResource("config.yml")));
    }

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new PlayerMove(), this);
        pluginManager.registerEvents(new PlayerChangeWorld(), this);
        pluginManager.registerEvents(new PlayerInteract(), this);

        this.getLogger().fine("[OnWayElytra] Enabled successful");
    }

    @Override
    public void onDisable() {
        this.getLogger().fine("[OnWayElytra] Disabled successful");
    }

    public static OnWayElytra getPlugin() {
        return plugin;
    }
}