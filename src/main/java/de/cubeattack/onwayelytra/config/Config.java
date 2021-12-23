package de.cubeattack.onwayelytra.config;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    public static File file = new File("world//Spawn.yml");
    public static YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
}
