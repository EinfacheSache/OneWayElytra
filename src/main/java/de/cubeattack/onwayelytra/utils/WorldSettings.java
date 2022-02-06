package de.cubeattack.onwayelytra.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Objects;

public class WorldSettings {
    YamlConfiguration config = FileUtils.yamlConfiguration;
    World world;

    public WorldSettings(){
        this.world = Bukkit.getWorld(Objects.requireNonNull(config.getString("SpawnLocation.WorldName")));
    }

    public World getWorld() {
        return world;
    }
}
