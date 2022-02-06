package de.cubeattack.onwayelytra.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {
    public static ItemStack getElytra(){
        ItemStack elytra = new ItemStack(Material.ELYTRA);

        elytra.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
        elytra.addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1);

        ItemMeta elytraMeta = elytra.getItemMeta();
        elytraMeta.setUnbreakable(true);
        elytraMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        elytraMeta.setDisplayName("Einweg Elytra");

        elytra.setItemMeta(elytraMeta);

        return elytra;
    }
}
