package de.cubeattack.onwayelytra.utils;

import de.cubeattack.onwayelytra.config.Config;
import org.bukkit.entity.Player;

public class CheckLocation {

    public static double x = 0;
    public static double y = 0;
    public static double z = 0;

    public static boolean CheckLocation(Player p){
        if(Config.yamlConfiguration.contains("Settings.World.IsSpawnSet")) {
            if (Config.yamlConfiguration.getBoolean("Settings.World.IsSpawnSet")) {
                x = Config.yamlConfiguration.getDouble("Settings.World.SpawnPoint.X");
                y = Config.yamlConfiguration.getDouble("Settings.World.SpawnPoint.Y");
                z = Config.yamlConfiguration.getDouble("Settings.World.SpawnPoint.Z");
                if (p.getLocation().getX() <= x + 17 && p.getLocation().getX() >= x + -15) {
                    if (p.getLocation().getZ() <= z + 49 && p.getLocation().getZ() >= z + -41) {
                        if (p.getLocation().getY() >= y - 60) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
