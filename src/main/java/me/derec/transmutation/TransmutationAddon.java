package me.derec.transmutation;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

public class TransmutationAddon extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml. Aidan we dont need anything for this yet other than to disable certain things once we add them
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
//Stuff

        }

        //Category creation
        NamespacedKey transmutateCategoryID = new NamespacedKey(this, "Transmutation");
        CustomItem transmutateCategoryItem = new CustomItem(Material.DIAMOND, "&4Transmutation!");
        Category transmutateCategory = new Category(transmutateCategoryID, transmutateCategoryItem);

        //Our First Item!
        SlimefunItemStack transmuItemStack = new SlimefunItemStack("testWand",Material.STICK,"Test Wand", "This is item lore");
        ItemStack[] testWandRecipe = {
                new ItemStack(Material.STICK), null, new ItemStack(Material.STICK),
                null, null, null,
                null, null, null
        };
        SlimefunItem testWand = new SlimefunItem(transmutateCategory, transmuItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, testWandRecipe);
        testWand.register(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
