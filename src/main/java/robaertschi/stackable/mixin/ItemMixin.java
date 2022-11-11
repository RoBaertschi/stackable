package robaertschi.stackable.mixin;

import net.minecraft.item.Item;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import robaertschi.stackable.Stackable;
import robaertschi.stackable.api.IDefinedStackableItem;

@Mixin(Item.class)
public class ItemMixin {
    @Mutable
    @Shadow @Final private int maxCount;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(Item.Settings settings, CallbackInfo ci) {
        if(Stackable.config.onlyStackables && maxCount > 1) {
            maxCount = Stackable.config.stackSize;
        }
        if (Stackable.config.onlyUnstackables && maxCount <= 1) {
            maxCount = Stackable.config.stackSize;
        }

        if(!( Stackable.config.onlyStackables || Stackable.config.onlyUnstackables)) {
            maxCount = Stackable.config.stackSize;
        }

        if(this instanceof IDefinedStackableItem) {
            if (Stackable.config.forceStackSize) {
                if(((IDefinedStackableItem) this).getForceWarning() != null && !((IDefinedStackableItem) this).allowForcedStackSize() && !Stackable.config.turnWarningsOff) {
                    var text = new LiteralTextContent(((IDefinedStackableItem) this).getForceWarning());
                    Stackable.warning.add(MutableText.of(text).setStyle(Style.EMPTY.withColor(TextColor.parse("#ffd500"))));
                }

            }
            if (((IDefinedStackableItem) this).getWarning() != null && !Stackable.config.turnWarningsOff) {
                var text = new LiteralTextContent( ((IDefinedStackableItem) this).getWarning());
                Stackable.warning.add(MutableText.of(text).setStyle(Style.EMPTY.withColor(TextColor.parse("#ff0000"))));
            }

            if (Stackable.config.forceStackSize) {
                maxCount = Stackable.config.stackSize;
                return;
            }

            maxCount = Math.min(((IDefinedStackableItem) this).getMaxStackSize(), Stackable.config.stackSize);

        }

    }
}
