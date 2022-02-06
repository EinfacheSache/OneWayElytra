package de.cubeattack.onwayelytra.listeners;

import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Objects;


public class PlayerInteract extends OnWayElytra implements Listener {

    public static double x;
    public static double y;
    public static double z;

    @EventHandler
    public static void onPlayerInteract(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_AIR){
            Player p = e.getPlayer();
            if(p.getInventory().getChestplate() == null) return;
            if(Objects.requireNonNull(p.getInventory().getChestplate().getItemMeta()).getDisplayName().contains("Einweg Elytra")){
                Material material = p.getInventory().getItemInMainHand().getType();
                if (material == Material.FIREWORK_ROCKET && e.getHand() == EquipmentSlot.HAND) {
                    e.setCancelled(true);
                    p.sendMessage(OnWayElytra.getPREFIX() + "§cDu kannst keine §4Raketen §cbenutzen wenn du eine §6Einweg Elytra §cbenutzt.");
                }else if(material == Material.TRIDENT && e.getHand() == EquipmentSlot.HAND){
                    x = getSettings().getX();
                    y = getSettings().getY();
                    z = getSettings().getZ();
                    x = x + 0.5;
                    z = z + 0.5;
                    Location loc = new Location(p.getWorld(), x, y ,z);
                    p.teleport(loc);
                    p.sendMessage(OnWayElytra.getPREFIX() + "§cDu kannst keine §4Trident §cbenutzen wenn du eine §6Einweg Elytra §cbenutzt.");
                }
                /*
                p.getInventory().getItemInOffHand();
                PlayerInventory inv = e.getPlayer().getInventory();
                Material m = p.getInventory().getItemInOffHand().getType();
                if (m == Material.FIREWORK_ROCKET && e.getHand() == EquipmentSlot.OFF_HAND) {
                    e.setCancelled(true);
                    p.sendMessage(OnWayElytra.getPREFIX() + "§cDu kannst keine §4Raketen §cbenutzen wenn du eine §6Einweg Elytra §cbenutzt.");
                }else if (m == Material.TRIDENT && e.getHand() == EquipmentSlot.OFF_HAND) {
                    if(FileUtils.getYamlConfiguration().contains("Settings.World.IsSpawnSet")) {
                        if (FileUtils.getYamlConfiguration().getBoolean("Settings.World.IsSpawnSet")) {
                            x = FileUtils.getYamlConfiguration().getDouble("Settings.World.SpawnPoint.X");
                            y = FileUtils.getYamlConfiguration().getDouble("Settings.World.SpawnPoint.Y");
                            z = FileUtils.getYamlConfiguration().getDouble("Settings.World.SpawnPoint.Z");
                            x = x + 0.5;
                            z = z + 0.5;
                            Location loc = new Location(OnWayElytra.getPlugin().getServer().getWorld("world"), x, y, z);
                            p.teleport(loc);
                        }
                    }
                }
                 */
            }
        }
    }
}
