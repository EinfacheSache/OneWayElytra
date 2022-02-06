package de.cubeattack.onwayelytra.utils;

import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Objects;

public class Settings {

    private final boolean UseWorldSpawn;
    private final boolean inWorldIsActive;
    private final boolean inNetherActive;
    private final boolean inEndActive;
    private final Double radius;
    private final Double x;
    private final Double y;
    private final Double z;

    public Settings(){
        ErrorHandel.checkConfigHasError(FileUtils.getFile());
        FileUtils.copyToFile(Objects.requireNonNull(OnWayElytra.getPlugin().getResource("config.yml")));
        YamlConfiguration config = FileUtils.getYamlConfiguration();
        this.UseWorldSpawn = config.getBoolean("UseWorldSpawn");
        this.inWorldIsActive = config.getBoolean("ActiveWorlds.World");
        this.inNetherActive = config.getBoolean("ActiveWorlds.Nether");
        this.inEndActive = config.getBoolean("ActiveWorlds.End");
        this.radius = config.getDouble("Radius");
        this.x = config.getDouble("SpawnLocation.X");
        this.y = config.getDouble("SpawnLocation.Y");
        this.z = config.getDouble("SpawnLocation.Z");
    }

    public boolean isUseWorldSpawn() {
        return UseWorldSpawn;
    }

    public boolean isInWorldIsActive() {
        return inWorldIsActive;
    }

    public boolean isInNetherActive() {
        return inNetherActive;
    }

    public boolean isInEndActive() {
        return inEndActive;
    }

    public Double getRadius() {
        return radius;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getZ() {
        return z;
    }
}
