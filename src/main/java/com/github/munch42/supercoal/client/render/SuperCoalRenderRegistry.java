package com.github.munch42.supercoal.client.render;

import com.github.munch42.supercoal.entities.SuperCoalBlobEntity;
import com.github.munch42.supercoal.entities.SuperCoalCowEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class SuperCoalRenderRegistry {
    public static void registerEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(SuperCoalCowEntity.class, new SuperCoalCowRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(SuperCoalBlobEntity.class, SuperCoalBlobRender::new);
    }
}
