package robaertschi.stackable.mixin;

import net.minecraft.item.Item;
import net.minecraft.registry.Registry;;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Registry.class)
public class ItemRegistryMixin {
    @Inject(method = "register(Lnet/minecraft/registry/Registry;Lnet/minecraft/util/Identifier;Ljava/lang/Object;)Ljava/lang/Object;", at = @At("HEAD"))
    private static <V, T> void register(Registry<V> registry, Identifier id, T entry, CallbackInfoReturnable<T> cir) {
        if(entry instanceof Item) {

        }
    }
}
