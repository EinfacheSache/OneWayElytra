package de.cubeattack.onwayelytra.utils;

import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

public class ErrorHandel {
    public static void checkConfigHasError(File file) {
        YamlConfiguration config = FileUtils.getYamlConfiguration();
        if(file == null){
            Bukkit.getLogger().log(Level.SEVERE, "File cannot be null");
            return;
        }
        try {
            config.load(file);
        } catch (FileNotFoundException ignored) {}
        catch (IOException | InvalidConfigurationException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot load " + file + ChatColor.DARK_RED + "\nEs wurde ein Error in der Config gefunden. Bitte überprüfen Sie diese.");
            return;
        }
        StringBuilder error = new StringBuilder();
        if (!config.contains("UseWorldSpawn")) {
            error.append("UseWorldSpawn, ");
        }
        if(!config.contains("ActiveWorlds.World")) {
            error.append("ActiveWorlds.World, ");
        }
        if(!config.contains("ActiveWorlds.Nether")){
            error.append("ActiveWorlds.Nether, ");
        }
        if(!config.contains("ActiveWorlds.End")) {
            error.append("ActiveWorlds.End, ");
        }
        if(!config.contains("Radius")) {
            error.append("Radius, ");
        }
        if(!config.contains("SpawnLocation.X")){
            error.append("SpawnLocation.X, ");
        }
        if(!config.contains("SpawnLocation.Y")){
            error.append("SpawnLocation.Y, ");
        }
        if(!config.contains("SpawnLocation.Z")){
            error.append("SpawnLocation.Z, ");
        }
        if (error.length() != 0) {
            OnWayElytra.getPlugin().getLogger().severe("Es Fehlen die Folgenden Settings in der Config: " + ChatColor.DARK_RED + error.substring(0, error.length() -2));
        }
    }
}
