package com.github.ob_yekt.simpleskills.mixin.CRAFTING;

import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.screen.CraftingScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CraftingScreenHandler.class)
public interface CraftingScreenHandlerAccessor {
    @Accessor("input")
    RecipeInputInventory getCraftingInventory();
}