package com.github.munch42.supercoal.generation;

import com.github.munch42.supercoal.lists.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {

    private static final EndOreFeature END_OREGEN = new EndOreFeature(null);

    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    private static final CountRangeConfig super_coal_ore_cfg = new CountRangeConfig(1000, 40, 0, 128);
    private static final int super_coal_ore_veinsize = 7;
    private static final CountRangeConfig super_coal_ore_nether_cfg = new CountRangeConfig(1000, 10, 0, 128);
    private static final int super_coal_ore_nether_veinsize = 7;
    private static final CountRangeConfig super_coal_ore_end_cfg = new CountRangeConfig(1000, 10, 0, 128);
    private static final int super_coal_ore_end_veinsize = 7;

    public static void setupOreGen(){
        for (Biome biome: ForgeRegistries.BIOMES.getValues()) {
            // we have no End ores, so skip those.
            if (biome.getCategory() == Biome.Category.THEEND) {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(END_OREGEN,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        BlockList.super_coal_ore_end.getDefaultState(),
                                        super_coal_ore_end_veinsize),
                                Placement.COUNT_RANGE, super_coal_ore_end_cfg));
                continue;
            }
            // Nether Ore generation.
            if (biome.getCategory() == Biome.Category.NETHER) {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                            Biome.createDecoratedFeature(Feature.ORE,
                                    new OreFeatureConfig(
                                            OreFeatureConfig.FillerBlockType.NETHERRACK,
                                            BlockList.super_coal_ore_nether.getDefaultState(),
                                            super_coal_ore_nether_veinsize),
                                    Placement.COUNT_RANGE, super_coal_ore_nether_cfg));

                // skip overworld generation, obviously.
                continue;
            } // end-if biome Category.NETHER

            // Overworld-type Ore generation
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        BlockList.super_coal_ore.getDefaultState(),
                                        super_coal_ore_veinsize),
                                Placement.COUNT_RANGE, super_coal_ore_cfg));
            }

    }
}
