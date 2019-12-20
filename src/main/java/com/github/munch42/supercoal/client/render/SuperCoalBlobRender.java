package com.github.munch42.supercoal.client.render;

import com.github.munch42.supercoal.SuperCoal;
import com.github.munch42.supercoal.client.models.SuperCoalBlobModel;
import com.github.munch42.supercoal.client.models.SuperCoalCowModel;
import com.github.munch42.supercoal.entities.SuperCoalBlobEntity;
import com.github.munch42.supercoal.entities.SuperCoalCowEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class SuperCoalBlobRender extends MobRenderer<SuperCoalBlobEntity, SuperCoalBlobModel> {

    public SuperCoalBlobRender(EntityRendererManager manager){
        super(manager, new SuperCoalBlobModel(), 0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(SuperCoalBlobEntity entity) {
        return SuperCoal.location("textures/entity/super_coal_blob.png");
    }
}
