package naps.deprecate;

import naps.deprecate.registry.BiomeRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Deprecate.MOD_ID)
public class Deprecate {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "deprecate";

    public Deprecate() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::setupClient);

        BiomeRegistry.init();
    }
    private void setupClient(final FMLClientSetupEvent event) {
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }
}


