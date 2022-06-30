package naps.deprecate.world.gen;

import naps.deprecate.world.biomes.ModBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;
import com.teamabnormals.blueprint.core.util.BiomeUtil;

import java.util.Objects;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

public class ModBiomeGeneration {
    public static void generateBiomes() {
        addBiome(ModBiomes.LEAFLESS_FOREST.get(),BiomeManager.BiomeType.WARM, 20, END, SPOOKY);
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        ResourceKey<Biome> key =  ResourceKey.create(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type,new BiomeManager.BiomeEntry(key, weight));
    }
}
