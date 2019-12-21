package com.github.munch42.supercoal;

import com.github.munch42.supercoal.client.render.SuperCoalRenderRegistry;
import com.github.munch42.supercoal.generation.OreGeneration;
import com.github.munch42.supercoal.lists.SuperCoalEntities;
import com.github.munch42.supercoal.lists.BlockList;
import com.github.munch42.supercoal.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SuperCoal.modid)
public class SuperCoal {
    public static final String modid = "supercoal";
    public static SuperCoal instance;
    private static final Logger logger = LogManager.getLogger(modid);

    public static final ItemGroup supercoal = new SuperCoalItemGroup();

    public SuperCoal(){
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){
        OreGeneration.setupOreGen();
    }

    private void clientRegistries(final FMLClientSetupEvent event){
        SuperCoalRenderRegistry.registerEntityRenders();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents{
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event){
            event.getRegistry().registerAll(
                // Normal Items
                ItemList.super_coal = new Item(new Item.Properties().group(supercoal)).setRegistryName(location("super_coal")),

                // BlockItems
                ItemList.super_coal_ore = new BlockItem(BlockList.super_coal_ore, new Item.Properties().group(supercoal)).setRegistryName(BlockList.super_coal_ore.getRegistryName()),
                ItemList.super_coal_ore_nether = new BlockItem(BlockList.super_coal_ore_nether, new Item.Properties().group(supercoal)).setRegistryName(BlockList.super_coal_ore_nether.getRegistryName()),
                ItemList.super_coal_ore_end = new BlockItem(BlockList.super_coal_ore_end, new Item.Properties().group(supercoal)).setRegistryName(BlockList.super_coal_ore_end.getRegistryName())
            );

            SuperCoalEntities.registerEntitySpawnEggs(event);

            logger.info("Items Registered");
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event){
            event.getRegistry().registerAll(
                    BlockList.super_coal_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.STONE)).setRegistryName(location("super_coal_ore")),
                    BlockList.super_coal_ore_nether = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.STONE)).setRegistryName(location("super_coal_ore_nether")),
                    BlockList.super_coal_ore_end = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.STONE)).setRegistryName(location("super_coal_ore_end"))
            );

            logger.info("Blocks Registered");
        }

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){
            event.getRegistry().registerAll(
                    SuperCoalEntities.SUPER_COAL_COW,
                    SuperCoalEntities.SUPER_COAL_BLOB,
                    SuperCoalEntities.SUPER_COAL_BIPED
            );

            SuperCoalEntities.registerEntityWorldSpawns();
        }
    }

    public static ResourceLocation location(String name){
        return new ResourceLocation(modid, name);
    }
}
