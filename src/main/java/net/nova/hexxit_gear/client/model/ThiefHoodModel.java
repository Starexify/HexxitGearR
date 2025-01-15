package net.nova.hexxit_gear.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.nova.hexxit_gear.HexxitGearR;

public class ThiefHoodModel extends BaseHelmetModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(HexxitGearR.rl("thief_hood"), "main");
    public static final ResourceLocation TEXTURE = HexxitGearR.rl("textures/models/armor/thief_hood.png");

    public ThiefHoodModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(-4.0F, -8.0F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition hood_back_3_r1 = root.addOrReplaceChild("hood_back_3_r1", CubeListBuilder.create().texOffs(47, 1).addBox(-2.0F, -11.1F, 5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
        PartDefinition hood_back_2_r1 = root.addOrReplaceChild("hood_back_2_r1", CubeListBuilder.create().texOffs(45, 4).addBox(-3.0F, -10.55F, 4.75F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition hood_back_1_r1 = root.addOrReplaceChild("hood_back_1_r1", CubeListBuilder.create().texOffs(43, 9).addBox(-4.0F, -9.75F, 4.5F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 35);
    }
}
