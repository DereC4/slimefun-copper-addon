package me.derec.transmutation;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CopperTransmutator extends SlimefunItem
{
    public CopperTransmutator(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(category, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {
        //Item handler?
        BlockUseHandler guyRightClick = this::guyRightClicksThing;
        addItemHandler(guyRightClick);

    }

    private void guyRightClicksThing(PlayerRightClickEvent event)
    {
        if(event.getPlayer().getInventory().contains(Material.IRON_NUGGET))
        {
            event.getPlayer().getInventory().addItem(new ItemStack((Material.IRON_INGOT)));
        }
    }

}
