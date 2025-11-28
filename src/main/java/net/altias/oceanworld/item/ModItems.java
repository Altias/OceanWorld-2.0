package net.altias.oceanworld.item;

import net.altias.oceanworld.OceanWorld;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OceanWorld.MODID);

    public static final DeferredItem<Item> SEA_KEY= ITEMS.register("sea_key",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
