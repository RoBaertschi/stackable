package robaertschi.stackable.mixin;

import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import robaertschi.stackable.util.Utils;

@Mixin(Item.class)
public class ItemMixin {
    @Mutable
    @Shadow @Final private int maxCount;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(Item.Settings settings, CallbackInfo ci) {
        maxCount = Utils.defineMaxCount(maxCount, ((Item)(Object)this));
    }
}
