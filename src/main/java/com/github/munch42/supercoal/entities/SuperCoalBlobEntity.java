package com.github.munch42.supercoal.entities;

import com.github.munch42.supercoal.lists.SuperCoalEntities;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.world.World;

public class SuperCoalBlobEntity extends CreatureEntity {
    public SuperCoalBlobEntity(EntityType<? extends CreatureEntity> type, World worldIn){
        super((EntityType<? extends CreatureEntity>) SuperCoalEntities.SUPER_COAL_BLOB, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.25d));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25d);
    }
}
