package naps.deprecate.registry;

import com.teamabnormals.blueprint.core.util.BiomeUtil;
import naps.deprecate.Deprecate;
import naps.deprecate.world.biomes.LeaflessForest;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Objects;

public class BiomeRegistry {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, Deprecate.MOD_ID);

    public static final RegistryObject<Biome> LEAFLESS_FOREST = BIOMES.register("leafless_forest",
            () -> new LeaflessForest().getBiome());
    private static final HashMap<Biome, Float> MOD_BIOMES_WEIGHT_RANGES = new HashMap<>();

    private static final HashMap<ResourceLocation, Biome> MOD_BIOMES = new HashMap<>();
    private static final HashMap<Biome, Float> MOD_BIOME_WEIGHTS = new HashMap<>();

    public static void init() {
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, modid = Deprecate.MOD_ID)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerEvent(RegistryEvent.Register<Biome> event) {
            register(LEAFLESS_FOREST.get(), LEAFLESS_FOREST.getId(), .5f, .25f, event);
        }
    }

    public static Biome[] getBiomes() {
        return MOD_BIOMES.values().toArray(new Biome[0]);
    }

    public static float getWeightForBiome(Biome biome) {
        return MOD_BIOME_WEIGHTS.get(biome);

    }


    private static void register(Biome biome, ResourceLocation registryName, float weight, float weightRange, RegistryEvent.Register<Biome> event) {
        ResourceKey<Biome> key =  ResourceKey.create(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));
        BiomeUtil.addEndBiome(key, (int)weight);
        MOD_BIOMES.put(registryName, ForgeRegistries.BIOMES.getValue(registryName));
        MOD_BIOME_WEIGHTS.put(getBiomes()[MOD_BIOME_WEIGHTS.size()],weight);
        MOD_BIOMES_WEIGHT_RANGES.put(getBiomes()[MOD_BIOMES_WEIGHT_RANGES.size()],weightRange);
    }

    public static float getWeightRangeForBiome(Biome biome) {
        return MOD_BIOMES_WEIGHT_RANGES.get(biome);
    }
}
