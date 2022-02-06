package de.cubeattack.onwayelytra.utils;

import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CheckLocation {

    public static boolean CheckLocation(Player p){
        if (OnWayElytra.getPlugin().getServer().getWorld("world")== null) return false;
        Location location = Objects.requireNonNull(OnWayElytra.getPlugin().getServer().getWorld("world")).getSpawnLocation();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
            if (p.getLocation().getX() <= x + 17 && p.getLocation().getX() >= x + -15) {
                if (p.getLocation().getZ() <= z + 49 && p.getLocation().getZ() >= z + -41) {
                    return p.getLocation().getY() >= y - 60;
                }
            }
        return false;
    }
}
