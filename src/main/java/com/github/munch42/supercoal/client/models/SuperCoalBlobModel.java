package com.github.munch42.supercoal.client.models;

import com.github.munch42.supercoal.entities.SuperCoalBlobEntity;
import com.github.munch42.supercoal.entities.SuperCoalCowEntity;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SuperCoalBlobModel extends EntityModel<SuperCoalBlobEntity> {
    private RendererModel bb_main;

    public SuperCoalBlobModel() {
        textureWidth = 16;
        textureHeight = 16;

        bb_main = new RendererModel(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -5.0F, -1.0F, -5.0F, 10, 1, 10, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.0F, -2.0F, -4.0F, 8, 1, 8, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -3.0F, -3.0F, -3.0F, 6, 1, 6, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 3, -2.0F, -4.0F, -2.0F, 4, 1, 4, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 4, -1.0F, -5.0F, -1.0F, 2, 1, 2, 0.0F, false));
    }

    @Override
    public void render(SuperCoalBlobEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        bb_main.render(scale);
    }

    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
