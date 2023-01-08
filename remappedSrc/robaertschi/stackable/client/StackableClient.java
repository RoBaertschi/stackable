package robaertschi.stackable.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.text.Text;
import robaertschi.stackable.Stackable;

public class StackableClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            for (Text i :
                    Stackable.warning) {
                assert client.player != null;
                client.player.sendMessage(i);
            }
        });
    }
}
