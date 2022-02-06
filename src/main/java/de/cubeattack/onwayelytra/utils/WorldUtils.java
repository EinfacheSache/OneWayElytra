package de.cubeattack.onwayelytra.utils;

import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class WorldUtils extends OnWayElytra {

    private static final YamlConfiguration Config = FileUtils.getYamlConfiguration();
    private static final double radius = getSettings().getRadius();

    public static boolean CheckLocation(Player p){
        if(getSettings().isUseWorldSpawn()) {
            Location location = Objects.requireNonNull(p.getWorld().getSpawnLocation());
            double x = location.getX();
            double y = location.getY();
            double z = location.getZ();
            if (p.getLocation().getX() <= x + radius && p.getLocation().getX() >= x + -radius) {
                if (p.getLocation().getZ() <= z + radius && p.getLocation().getZ() >= z + -radius) {
                    return p.getLocation().getY() >= y - radius;
                }
            }
        }else {
            double x = getSettings().getX();
            double y = getSettings().getY();
            double z = getSettings().getZ();
            if(isActiveInWorld(p.getWorld().getName())) {
                if (p.getLocation().getX() <= x + radius && p.getLocation().getX() >= x + -radius) {
                    if (p.getLocation().getZ() <= z + radius && p.getLocation().getZ() >= z + -radius) {
                        return p.getLocation().getY() >= y - radius;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isActiveInWorld(String worldName) {
        try {
            if(getSettings().isInWorldActive() && worldName.equalsIgnoreCase("world"))return true;
            if(getSettings().isInNetherActive() && worldName.equalsIgnoreCase("nether"))return true;
            if(getSettings().isInEndActive() && worldName.equalsIgnoreCase("end"))return true;
        } catch (NullPointerException ignored) {}
        return false;
    }
}
