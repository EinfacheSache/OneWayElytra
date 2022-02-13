package de.cubeattack.onwayelytra.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Objects;

import static de.cubeattack.onwayelytra.OnWayElytra.getSettings;

public class WorldUtils  {

    private static final double radius = getSettings().getRadius();

    public static boolean CheckLocation(Player p){
        double x;
        double y;
        double z;
        if (!isActiveInWorld(p.getWorld().getName())) {return false;}
        if(getSettings().isUseWorldSpawn()) {
            Location spawnLocation = Objects.requireNonNull(p.getWorld().getSpawnLocation());
            x = spawnLocation.getX();
            y = spawnLocation.getY();
            z = spawnLocation.getZ();
        }else {
            x = getSettings().getX();
            y = getSettings().getY();
            z = getSettings().getZ();
        }
        if (p.getLocation().getX() <= x + radius && p.getLocation().getX() >= x -radius) {
            if (p.getLocation().getZ() <= z + radius && p.getLocation().getZ() >= z -radius) {
                return p.getLocation().getY() >= y - radius;
            }
        }
        return false;
    }

    public static boolean isActiveInWorld(String worldName) {
        try {
            if(getSettings().isInWorldIsActive() && worldName.equalsIgnoreCase("world"))return true;
            if(getSettings().isInNetherActive() && worldName.equalsIgnoreCase("nether"))return true;
            if(getSettings().isInEndActive() && worldName.equalsIgnoreCase("end"))return true;
        } catch (NullPointerException ignored) {}
        return false;
    }
}
