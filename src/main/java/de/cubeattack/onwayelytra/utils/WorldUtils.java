package de.cubeattack.onwayelytra.utils;

import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class WorldUtils {

    private static final YamlConfiguration Config = FileUtils.yamlConfiguration;

    public static boolean CheckLocation(Player p){
        double radius = Config.getDouble("Radius");
        World world = Bukkit.getWorld(Objects.requireNonNull(Config.getString("SpawnLocation.WorldName")));
        if(Config.getBoolean("UseWorldSpawn")) {
            if (OnWayElytra.getPlugin().getServer().getWorld("world") == null) return false;
            Location location = Objects.requireNonNull(OnWayElytra.getPlugin().getServer().getWorld("world")).getSpawnLocation();
            double x = location.getX();
            double y = location.getY();
            double z = location.getZ();
            if (p.getLocation().getX() <= x + radius && p.getLocation().getX() >= x + -radius) {
                if (p.getLocation().getZ() <= z + radius && p.getLocation().getZ() >= z + -radius) {
                    return p.getLocation().getY() >= y - radius;
                }
            }
        }else {
            double x = Config.getDouble("SpawnLocation.X");
            double y = Config.getDouble("SpawnLocation.Y");
            double z = Config.getDouble("SpawnLocation.Z");
            if(p.getWorld().getName().equals(world.getName())) {
                if (p.getLocation().getX() <= x + radius && p.getLocation().getX() >= x + -radius) {
                    if (p.getLocation().getZ() <= z + radius && p.getLocation().getZ() >= z + -radius) {
                        return p.getLocation().getY() >= y - radius;
                    }
                }
            }
        }
        return false;
    }
}
