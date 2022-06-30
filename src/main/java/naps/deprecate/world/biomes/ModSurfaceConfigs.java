package naps.deprecate.world.biomes;

import naps.deprecate.Deprecate;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class ModSurfaceConfigs {
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> LEAFLESS_SURFACE_BUILDER =
            register("leafless_surface", SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(
                    Blocks.GRASS_BLOCK.defaultBlockState(),
                    Blocks.STONE.defaultBlockState(),
                    Blocks.END_STONE.defaultBlockState())));

    private static <T extends SurfaceBuilderBaseConfiguration> ConfiguredSurfaceBuilder<T> register(String name,
                                                                                                    ConfiguredSurfaceBuilder<T> surfaceBuilder) {
        return Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(Deprecate.MOD_ID, name), surfaceBuilder);
    }
}

