package my_life_is_bad.lessdamagetilt.mixin;

import my_life_is_bad.lessdamagetilt.LessDamageTilt;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer {
    @ModifyArg(method = "hurtCameraEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;rotate(FFFF)V", ordinal = 2), index = 0)
    private float modifyDamageTilt(float originalAngle) {
        return originalAngle * ((float) LessDamageTilt.Configuration.modifier /100);
    }
}
