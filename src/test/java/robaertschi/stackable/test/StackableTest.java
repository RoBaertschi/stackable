package robaertschi.stackable.test;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.S2CPlayChannelEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.test.GameTest;
import net.minecraft.util.registry.Registry;
import robaertschi.stackable.api.IDefinedStackableItem;

public class StackableTest implements ModInitializer {
    private static class TestItem extends Item implements IDefinedStackableItem {

        public TestItem(Settings settings) {
            super(settings);
        }

        @Override
        public int getMaxStackSize() {
            return 16;
        }

        @Override
        public String getWarning() {
            return "This mod is not compatible.";
        }

        @Override
        public String getForceWarning() {
            return "Dont force this mod!";
        }

        @Override
        public boolean allowForcedStackSize() {
            return false;
        }
    }

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, "test_item", new TestItem(new Item.Settings().group(ItemGroup.MISC)));
    }
}
