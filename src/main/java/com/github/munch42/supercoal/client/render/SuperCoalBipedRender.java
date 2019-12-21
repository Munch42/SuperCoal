package com.github.munch42.supercoal.client.render;

import com.github.munch42.supercoal.SuperCoal;
import com.github.munch42.supercoal.client.models.SuperCoalBipedModel;
import com.github.munch42.supercoal.entities.SuperCoalBipedEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SuperCoalBipedRender extends MobRenderer<SuperCoalBipedEntity, SuperCoalBipedModel> {

    public SuperCoalBipedRender(EntityRendererManager manager){
        super(manager, new SuperCoalBipedModel(), 0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(SuperCoalBipedEntity entity) {
        return SuperCoal.location("textures/entity/super_coal_biped.png");
    }
}
