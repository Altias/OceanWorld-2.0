package net.altias.oceanworld.block;

import net.altias.oceanworld.OceanWorld;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(OceanWorld.MODID);

    public static final DeferredBlock<CustomPortalBlock> SEA_PORTAL = registerBlock("sea_portal",
            () -> new CustomPortalBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
