package de.cubeattack.onwayelytra.listeners;

import de.cubeattack.onwayelytra.OnWayElytra;
import de.cubeattack.onwayelytra.utils.WorldUtils;
import de.cubeattack.onwayelytra.utils.ItemCreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.PlayerInventory;

import java.util.Objects;

public class PlayerMove implements Listener {

    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent e){
        PlayerInventory inv = e.getPlayer().getInventory();
        if(WorldUtils.CheckLocation(e.getPlayer())){
            if(inv.getChestplate() == null){
                inv.setChestplate(ItemCreator.getElytra());
            }else{
                if(Objects.requireNonNull(e.getPlayer().getInventory().getChestplate()).getType() != Material.ELYTRA) {
                    for (int i = 0; i < 36; i++) {
                        if (inv.getItem(i) == null) {
                            inv.setItem(i, inv.getChestplate());
                            inv.setChestplate(ItemCreator.getElytra());
                            return;
                        }
                    }
                    e.getPlayer().sendMessage(OnWayElytra.getPREFIX() + "§4§lDa dein Inventar voll ist wurde deine Chestplate in den Zwischenspeicher gespeichert. Verlassen den Server nicht bis du deine Chestplate wieder hast!");
                    OnWayElytra.getSafeChestPlate().put(e.getPlayer().getUniqueId(), inv.getChestplate());
                    inv.setChestplate(ItemCreator.getElytra());
                }
            }
        }else{
            if(inv.getChestplate() != null){
                if(Objects.requireNonNull(inv.getChestplate().getItemMeta()).getDisplayName().contains("Einweg Elytra")){
                    Player p = e.getPlayer();
                    if(!e.getPlayer().isGliding()){
                        if (p.getLocation().add(0.0D, -1.0D, 0.0D).getBlock().getType() != Material.AIR) {
                            p.getInventory().setChestplate(null);
                            if(OnWayElytra.getSafeChestPlate().containsKey(p.getUniqueId())) {
                                p.getInventory().setChestplate(OnWayElytra.getSafeChestPlate().get(p.getUniqueId()));
                                //noinspection SuspiciousMethodCalls
                                OnWayElytra.getSafeChestPlate().remove(p);
                            }
                        }
                    }
                }
            }
        }
    }
}
