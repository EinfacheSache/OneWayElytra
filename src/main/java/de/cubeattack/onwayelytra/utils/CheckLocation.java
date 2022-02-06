package de.cubeattack.onwayelytra.utils;

import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CheckLocation {

    private static final YamlConfiguration Config = de.cubeattack.onwayelytra.config.Config.yamlConfiguration;

    public static boolean CheckLocation(Player p){
        if(Config.getBoolean("UseWorldSpawn")) {
            if (OnWayElytra.getPlugin().getServer().getWorld("world") == null) return false;
            Location location = Objects.requireNonNull(OnWayElytra.getPlugin().getServer().getWorld("world")).getSpawnLocation();
            double x = location.getX();
            double y = location.getY();
            double z = location.getZ();
            if (p.getLocation().getX() <= x + 17 && p.getLocation().getX() >= x + -15) {
                if (p.getLocation().getZ() <= z + 49 && p.getLocation().getZ() >= z + -41) {
                    return p.getLocation().getY() >= y - 60;
                }
            }
        }else {
            World world = Bukkit.getWorld(Objects.requireNonNull(Config.getString("SpawnLocation.WorldName")).toLowerCase());
            double x = Config.getDouble("SpawnLocation.X");
            double y = Config.getDouble("SpawnLocation.Y");
            double z = Config.getDouble("SpawnLocation.Z");
            if(p.getWorld().getName().equals(world.getName())) {
                if (p.getLocation().getX() <= x + 17 && p.getLocation().getX() >= x + -15) {
                    if (p.getLocation().getZ() <= z + 49 && p.getLocation().getZ() >= z + -41) {
                        return p.getLocation().getY() >= y - 60;
                    }
                }
            }
        }
        return false;
    }
}
