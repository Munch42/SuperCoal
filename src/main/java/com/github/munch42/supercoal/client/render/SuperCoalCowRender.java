package com.github.munch42.supercoal.client.render;

import com.github.munch42.supercoal.SuperCoal;
import com.github.munch42.supercoal.client.models.SuperCoalCowModel;
import com.github.munch42.supercoal.entities.SuperCoalCowEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class SuperCoalCowRender extends LivingRenderer<SuperCoalCowEntity, SuperCoalCowModel> {

    public SuperCoalCowRender(EntityRendererManager manager){
        super(manager, new SuperCoalCowModel(), 0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(SuperCoalCowEntity entity) {
        return SuperCoal.location("textures/entity/super_coal_cow.png");
    }

    public static class RenderFactory implements IRenderFactory<SuperCoalCowEntity>{
        @Override
        public EntityRenderer<? super SuperCoalCowEntity> createRenderFor(EntityRendererManager manager) {
            return new SuperCoalCowRender(manager);
        }
    }
}
