package robaertschi.stackable.util;

import net.minecraft.item.Item;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.TextColor;
import robaertschi.stackable.Stackable;
import robaertschi.stackable.api.IDefinedStackableItem;
import robaertschi.stackable.mixin.ItemRegistryMixin;

public class Utils {
    public static int defineMaxCount(int maxCount, Item instance) {

        int newMaxCount;

        if (!Stackable.config.useMultiplier) {
            newMaxCount = Stackable.config.stackSize;
        } else {
            newMaxCount = maxCount * Stackable.config.stackMultiplier;
            if (newMaxCount <= 0) {
                Stackable.warning.add(MutableText.of(new LiteralTextContent("Error: Your Mutltiplier setting needs to be higher then 0.")).setStyle(Style.EMPTY.withColor(TextColor.parse("#ff0000"))));
                return maxCount;
            }
        }

        if (Stackable.config.onlyStackables && maxCount > 1) {
            maxCount = newMaxCount;
        }
        if (Stackable.config.onlyUnstackables && maxCount <= 1) {
            maxCount = newMaxCount;
        }

        if (!(Stackable.config.onlyStackables || Stackable.config.onlyUnstackables)) {
            maxCount = newMaxCount;
        }

        if (instance instanceof IDefinedStackableItem) {
            if (Stackable.config.forceStackSize) {
                if (((IDefinedStackableItem) instance).getForceWarning() != null && !((IDefinedStackableItem) instance).allowForcedStackSize() && !Stackable.config.turnWarningsOff) {
                    var text = new LiteralTextContent(((IDefinedStackableItem) instance).getForceWarning());
                    Stackable.warning.add(MutableText.of(text).setStyle(Style.EMPTY.withColor(TextColor.parse("#ffd500"))));
                }

            }
            if (((IDefinedStackableItem) instance).getWarning() != null && !Stackable.config.turnWarningsOff) {
                var text = new LiteralTextContent(((IDefinedStackableItem) instance).getWarning());
                Stackable.warning.add(MutableText.of(text).setStyle(Style.EMPTY.withColor(TextColor.parse("#ff0000"))));
            }

            if (Stackable.config.forceStackSize) {
                maxCount = newMaxCount;
                return maxCount;
            }

            maxCount = Math.min(((IDefinedStackableItem) instance).getMaxStackSize(), newMaxCount);
        }
        return maxCount;

    }
}