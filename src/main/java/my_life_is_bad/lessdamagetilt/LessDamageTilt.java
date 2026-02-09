package my_life_is_bad.lessdamagetilt;

import my_life_is_bad.configurationsbackport.common.config.Config;
import my_life_is_bad.configurationsbackport.common.config.ConfigManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = LessDamageTilt.MOD_ID)
public class LessDamageTilt {
    public static final String MOD_ID = "lessdamagetilt";

    @Config(modid = MOD_ID)
    public static class Configuration {
        @Config.Comment("Range: 0%-100%")
        @Config.RangeInt(min = 0, max = 100)
        @Config.SlidingOption
        public static int modifier = 100;
    }

    @Mod.EventHandler
    public void onFMLConstructionEvent(FMLConstructionEvent event) {
        ConfigManager.sync(MOD_ID, Config.Type.INSTANCE);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals(MOD_ID)) {
            ConfigManager.sync(MOD_ID, Config.Type.INSTANCE);
        }
    }
}
