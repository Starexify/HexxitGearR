package net.nova.hexxit_gear.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.nova.hexxit_gear.HexxitGearR;

public class ScaleHelmetModel extends BaseHelmetModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(HexxitGearR.rl("scale_helmet"), "main");
    public static final ResourceLocation TEXTURE = HexxitGearR.rl("textures/models/armor/scale_helmet.png");

    public ScaleHelmetModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(-4.0F, -8.0F, -4.75F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(41, 0).addBox(-6.0F, -7.0F, -2.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(50, 2).addBox(-7.0F, -8.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(57, 4).addBox(-8.0F, -8.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 9).addBox(-9.0F, -8.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 9).addBox(-9.0F, -6.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(41, 0).addBox(5.0F, -7.0F, -2.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(50, 2).addBox(6.0F, -8.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(57, 4).addBox(7.0F, -8.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 9).addBox(7.0F, -8.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 9).addBox(7.0F, -6.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 35);
    }
}
