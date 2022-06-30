package naps.deprecate.world.biomes;


import naps.deprecate.Deprecate;
import naps.deprecate.world.gen.ModConfiguredFeatures;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;



public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, Deprecate.MOD_ID);

    public static final RegistryObject<Biome> LEAFLESS_FOREST = BIOMES.register("leafless_forest",
            ModBiomes::createLeaflessForest);

    private static Biome createLeaflessForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        generationSettings.surfaceBuilder(ModSurfaceConfigs.LEAFLESS_SURFACE_BUILDER);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,  ModConfiguredFeatures.LEAFLESS_TREE
                .decorated(Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED)
                .decorated(FeatureDecorator.COUNT_EXTRA
                        .configured(new FrequencyWithExtraChanceDecoratorConfiguration(
                                2, 0.1f, 1))));

        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND)
                .depth(.1f).scale(.5f).temperature(0.5F).downfall(0.5F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                .waterColor(4159204).waterFogColor(329011)
                        .fogColor(10518688).skyColor(0).build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build()).build();
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
