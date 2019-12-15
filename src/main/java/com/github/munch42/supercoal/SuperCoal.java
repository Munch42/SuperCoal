package com.github.munch42.supercoal;

import com.github.munch42.supercoal.lists.ItemList;
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

    public SuperCoal(){
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){

    }

    private void clientRegistries(final FMLClientSetupEvent event){

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents{
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event){
            event.getRegistry().registerAll(
                ItemList.super_coal = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("super_coal"))
            );

            logger.info("Items Registered");
        }

        private static ResourceLocation location(String name){
            return new ResourceLocation(modid, name);
        }
    }
}
