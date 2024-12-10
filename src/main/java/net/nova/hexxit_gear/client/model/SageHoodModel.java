package net.nova.hexxit_gear.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.nova.hexxit_gear.HexxitGearR;

public class SageHoodModel extends BaseHelmetModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(HexxitGearR.rl("sage_hood"), "main");
    public static final String TEXTURE = HexxitGearR.rl("textures/models/armor/sage_hood.png").toString();

    public SageHoodModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -9.0F, -6.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(-4.0F, -4.0F, -5.5F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 24.0F, 1.0F));

        PartDefinition hood_back_2_r1 = root.addOrReplaceChild("hood_back_2_r1", CubeListBuilder.create().texOffs(45, 0).addBox(-2.5F, -10.5F, 4.75F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(43, 5).addBox(-3.5F, -10.0F, 4.0F, 7.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }
}
