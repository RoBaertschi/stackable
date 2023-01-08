package robaertschi.stackable.mixin;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Registry.class)
public class ItemRegistryMixin {
    @Inject(method = "register(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/registry/RegistryKey;Ljava/lang/Object;)Ljava/lang/Object;", at = @At("HEAD"))
    private static <V, T> void register(Registry<V> registry, RegistryKey<V> key, T entry, CallbackInfoReturnable<T> cir) {
        if(entry instanceof Item) {

        }
    }
}
