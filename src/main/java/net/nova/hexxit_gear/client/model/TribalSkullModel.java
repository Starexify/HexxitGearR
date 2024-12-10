package net.nova.hexxit_gear.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.nova.hexxit_gear.HexxitGearR;

public class TribalSkullModel extends BaseHelmetModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(HexxitGearR.rl("tribal_skull"), "main");
    public static final String TEXTURE = HexxitGearR.rl("textures/models/armor/tribal_skull.png").toString();

    public TribalSkullModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F))
                .texOffs(25, 5).addBox(-5.5F, -7.8F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 0).addBox(4.5F, -7.8F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(25, 5).addBox(6.5F, -8.8F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 35, 16);
    }
}
