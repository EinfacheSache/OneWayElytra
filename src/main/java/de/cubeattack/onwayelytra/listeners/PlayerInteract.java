package de.cubeattack.onwayelytra.listeners;

import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.WeatherType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class PlayerInteract implements Listener {

    public static double x;
    public static double y;
    public static double z;

    @EventHandler
    public static void onPlayerInteract(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_AIR){
            Player player = e.getPlayer();
            ItemStack item = e.getItem();
            PlayerInventory playerInventory = player.getInventory();
            Material materialInMainHand = player.getInventory().getItemInMainHand().getType();
            Material materialInOffHand = player.getInventory().getItemInOffHand().getType();
            if(player.getInventory().getChestplate() == null) return;
            if(!Objects.requireNonNull(player.getInventory().getChestplate().getItemMeta()).getDisplayName().contains("Einweg Elytra"))return;
            if (materialInMainHand == Material.FIREWORK_ROCKET && e.getHand() == EquipmentSlot.HAND ||
                    materialInOffHand == Material.FIREWORK_ROCKET && e.getHand() == EquipmentSlot.OFF_HAND) {
                e.setCancelled(true);
                player.sendMessage(OnWayElytra.getPREFIX() + "§cDu kannst keine §4Raketen §cbenutzen wenn du eine §6Einweg Elytra §cbenutzt.");
            }else if(materialInMainHand == Material.TRIDENT && e.getHand() == EquipmentSlot.HAND){
                playerInventory.setItemInMainHand(null);
                blockTrident(player, item);
            }else if (materialInOffHand == Material.TRIDENT && e.getHand() == EquipmentSlot.OFF_HAND) {
                playerInventory.setItemInOffHand(null);
                blockTrident(player, item);
            }
        }
    }

    private static void blockTrident(Player player, ItemStack item){
        Bukkit.getScheduler().runTaskLater(OnWayElytra.getPlugin(), new Runnable()  {
            @Override
            public void run() {
                PlayerInventory playerInventory = player.getInventory();
                player.sendMessage(OnWayElytra.getPREFIX() + "§cDu kannst keine §4Trident §cbenutzen wenn du eine §6Einweg Elytra §cbenutzt.");
                if (playerInventory.getItemInMainHand().getType().equals(Material.AIR)) {
                    playerInventory.setItemInMainHand(item);
                } else {
                    playerInventory.setItemInOffHand(item);
                }
            }
        }, 1);
    }
}
