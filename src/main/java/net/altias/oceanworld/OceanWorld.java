package net.altias.oceanworld;

import net.altias.oceanworld.block.ModBlocks;
import net.altias.oceanworld.item.ModItems;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.CustomPortalRegistrationEvent;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(OceanWorld.MODID)
public class OceanWorld {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "oceanworld";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public OceanWorld(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerPortals);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }


    private void registerPortals(CustomPortalRegistrationEvent event) {
        // We need to register the portal
        event.register(
                // Here is where we start to register the portal in the common setup event
                CustomPortalBuilder.beginPortal()
                        .frameBlock(Blocks.PRISMARINE)
                        .tintColor(18, 18, 112)
                        .lightWithItem(ModItems.SEA_KEY.get())
                        .customPortalBlock(ModBlocks.SEA_PORTAL)
                        .returnDim(ResourceLocation.parse("overworld"), true)
                        .destDimID(ResourceLocation.parse("oceanworld:deepsea"))


        );
    }

}
