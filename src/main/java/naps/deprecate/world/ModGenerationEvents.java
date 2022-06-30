package naps.deprecate.world;

import naps.deprecate.Deprecate;
import naps.deprecate.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Deprecate.MOD_ID)
public class ModGenerationEvents {
    @SubscribeEvent
    public static void ModWorldGeneration(final BiomeLoadingEvent event) {
        ModTreeGeneration.generateTrees(event);
    }
}