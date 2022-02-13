package de.cubeattack.onwayelytra.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class InventoryMove implements Listener {

    @EventHandler
    public static void onItemMove(InventoryInteractEvent e){
        e.getWhoClicked().sendMessage(e.getResult().name());
    }
}
