package com.github.munch42.supercoal.lists;

import com.github.munch42.supercoal.SuperCoal;
import com.github.munch42.supercoal.entities.SuperCoalBlobEntity;
import com.github.munch42.supercoal.entities.SuperCoalCowEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class SuperCoalEntities {
    public static EntityType<?> SUPER_COAL_COW = EntityType.Builder.create(SuperCoalCowEntity::new, EntityClassification.CREATURE).build(SuperCoal.modid + ":super_coal_cow").setRegistryName(SuperCoal.location("super_coal_cow"));
    public static EntityType<?> SUPER_COAL_BLOB = EntityType.Builder.create(SuperCoalBlobEntity::new, EntityClassification.CREATURE).build(SuperCoal.modid + ":super_coal_blob").setRegistryName(SuperCoal.location("super_coal_blob"));

    public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(
                ItemList.super_coal_cow_egg = registerEntitySpawnEgg(SUPER_COAL_COW, 0x1e40b0,0x7a21a3, "super_coal_cow_egg"),
                ItemList.super_coal_blob_egg = registerEntitySpawnEgg(SUPER_COAL_BLOB, 0x28c8e0, 0xe31bb4, "super_coal_blob_egg")
        );
    }

    public static void registerEntityWorldSpawns(){
        registerEntityWorldSpawn(SUPER_COAL_COW, Biomes.PLAINS, Biomes.BEACH, Biomes.JUNGLE, Biomes.FOREST);
        registerEntityWorldSpawn(SUPER_COAL_BLOB, Biomes.PLAINS, Biomes.BEACH, Biomes.JUNGLE, Biomes.FOREST);
    }

    public static Item registerEntitySpawnEgg(EntityType<?> type, int colour1, int colour2, String name){
        SpawnEggItem item = new SpawnEggItem(type, colour1, colour2, new Item.Properties().group(SuperCoal.supercoal));
        item.setRegistryName(SuperCoal.location(name));
        return item;
    }

    public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes){
        for(Biome biome : biomes){
            if(biome != null){
                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 100, 1, 10));
            }
        }
    }
}
