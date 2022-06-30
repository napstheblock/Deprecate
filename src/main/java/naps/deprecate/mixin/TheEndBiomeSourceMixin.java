package naps.deprecate.mixin;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.TheEndBiomeSource;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;


    @Mixin(TheEndBiomeSource.class)
    public abstract class TheEndBiomeSourceMixin {
        @Shadow @Final private Biome end;

        @Shadow @Final private SimplexNoise islandNoise;
        @Shadow @Final private Biome highlands;
        @Shadow @Final private Biome midlands;
        @Shadow @Final private Biome islands;
        @Shadow @Final private Biome barrens;

        @Shadow @Final private Registry<Biome> biomes;

        /**
         * @author OutEnd Team
         * @reason legacy code. unused now. (keeping it here for a few more versions just in case)
         */

        //TODO: switch to inject instead of overwrite


}
