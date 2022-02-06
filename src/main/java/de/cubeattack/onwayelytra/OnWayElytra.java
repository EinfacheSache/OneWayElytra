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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;

import static org.apache.commons.io.IOUtils.DEFAULT_BUFFER_SIZE;

public class OnWayElytra extends JavaPlugin {

    public static HashMap<UUID, ItemStack> safeChestPlate= new HashMap<>();

    private static OnWayElytra plugin;
    public static String PREFIX = "§7[§bCube§7] ";

    @Override
    public void onLoad() {
        try {
            FileUtils.copyToFile(this.getResource("config.yml"), new File("plugins/config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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