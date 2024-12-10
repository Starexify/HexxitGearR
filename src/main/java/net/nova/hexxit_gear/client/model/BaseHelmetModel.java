package net.nova.hexxit_gear.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public class BaseHelmetModel<T extends Entity> extends EntityModel<T> {
    public final ModelPart root;

    public BaseHelmetModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.root.xRot = headPitch / (180F / (float) Math.PI);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
