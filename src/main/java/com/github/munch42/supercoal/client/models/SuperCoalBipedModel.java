package com.github.munch42.supercoal.client.models;

import com.github.munch42.supercoal.entities.SuperCoalBipedEntity;
import com.github.munch42.supercoal.entities.SuperCoalBlobEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SuperCoalBipedModel extends EntityModel<SuperCoalBipedEntity> {
    private final RendererModel RightLeg;
    private final RendererModel LeftLeg;
    private final RendererModel Body;

    public SuperCoalBipedModel() {
        textureWidth = 64;
        textureHeight = 32;

        RightLeg = new RendererModel(this);
        RightLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
        RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 0, -6.0F, -9.0F, -2.0F, 4, 9, 4, 0.0F, false));

        LeftLeg = new RendererModel(this);
        LeftLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
        LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 0, 2.0F, -9.0F, -2.0F, 4, 9, 4, 0.0F, false));

        Body = new RendererModel(this);
        Body.setRotationPoint(0.0F, 24.0F, 0.0F);
        Body.cubeList.add(new ModelBox(Body, 0, 0, -6.0F, -19.0F, -5.0F, 12, 10, 10, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 35, 0, -4.0F, -25.0F, -3.0F, 8, 6, 6, 0.0F, false));
    }

    @Override
    public void render(SuperCoalBipedEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngle(entityIn, limbSwing, limbSwingAmount);
        RightLeg.render(scale);
        LeftLeg.render(scale);
        Body.render(scale);
    }

    public void setRotationAngle(SuperCoalBipedEntity modelRenderer, float limbSwing, float limbSwingAmount) {
        this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        //this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        //this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    }
}
