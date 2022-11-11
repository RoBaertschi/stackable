package robaertschi.stackable;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.text.Text;
import robaertschi.stackable.config.ModConfig;

import java.util.ArrayList;
import java.util.List;

public class Stackable implements ModInitializer {

    public static ModConfig config = AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new).getConfig();
    public static List<Text> warning = new ArrayList<>();

    @Override
    public void onInitialize() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            for (Text i :
                    warning) {
                assert client.player != null;
                client.player.sendMessage(i);
            }
        });
    }
}
