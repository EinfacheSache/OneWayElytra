package de.cubeattack.onwayelytra.listeners;

import de.cubeattack.onwayelytra.config.Config;
import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.PlayerInventory;


public class PlayerInteract implements Listener {

    public static double x;
    public static double y;
    public static double z;

    @EventHandler
    public static void onPlayerInteract(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_AIR){
            Player p = e.getPlayer();
            if(p.getInventory().getChestplate() == null) return;
            if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Einweg Elytra")){
                if(p.getInventory().getItemInMainHand().getType() != null) {
                    Material m = p.getInventory().getItemInMainHand().getType();
                    if (m == Material.FIREWORK_ROCKET && e.getHand() == EquipmentSlot.HAND) {
                        e.setCancelled(true);
                        p.sendMessage(OnWayElytra.PREFIX + "§cDu kannst keine §4Raketen §cbenutzen wenn du eine §6Einweg Elytra §cbenutzt.");
                        return;
                    }else if(m == Material.TRIDENT && e.getHand() == EquipmentSlot.HAND){
                        if(Config.yamlConfiguration.contains("Settings.World.IsSpawnSet")) {
                            if (Config.yamlConfiguration.getBoolean("Settings.World.IsSpawnSet")) {
                                x = Config.yamlConfiguration.getDouble("Settings.World.SpawnPoint.X");
                                y = Config.yamlConfiguration.getDouble("Settings.World.SpawnPoint.Y");
                                z = Config.yamlConfiguration.getDouble("Settings.World.SpawnPoint.Z");
                                x = x + 0.5;
                                z = z + 0.5;
                                Location loc = new Location(OnWayElytra.getPlugin().getServer().getWorld("world"), x, y ,z);
                                p.teleport(loc);
                                p.sendMessage(OnWayElytra.PREFIX + "§cDu kannst keine §4Trident §cbenutzen wenn du eine §6Einweg Elytra §cbenutzt.");
                            }
                        }
                        return;
                    }
                }
                if(p.getInventory().getItemInOffHand() != null) {
                    PlayerInventory inv = e.getPlayer().getInventory();
                    Material m = p.getInventory().getItemInOffHand().getType();
                    if (m == Material.FIREWORK_ROCKET && e.getHand() == EquipmentSlot.OFF_HAND) {
                        e.setCancelled(true);
                        p.sendMessage(OnWayElytra.PREFIX + "§cDu kannst keine §4Raketen §cbenutzen wenn du eine §6Einweg Elytra §cbenutzt.");
                    }else if (m == Material.TRIDENT && e.getHand() == EquipmentSlot.OFF_HAND) {
                        if(Config.yamlConfiguration.contains("Settings.World.IsSpawnSet")) {
                            if (Config.yamlConfiguration.getBoolean("Settings.World.IsSpawnSet")) {
                                x = Config.yamlConfiguration.getDouble("Settings.World.SpawnPoint.X");
                                y = Config.yamlConfiguration.getDouble("Settings.World.SpawnPoint.Y");
                                z = Config.yamlConfiguration.getDouble("Settings.World.SpawnPoint.Z");
                                x = x + 0.5;
                                z = z + 0.5;
                                Location loc = new Location(OnWayElytra.getPlugin().getServer().getWorld("world"), x, y, z);
                                p.teleport(loc);
                            }
                        }
                    }
                }
            }
        }
    }
}
