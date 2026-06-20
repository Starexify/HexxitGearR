package net.nova.hexxit_gear.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.util.Mth;

public abstract class BaseHelmetModel extends EntityModel<HumanoidRenderState> {
  public final ModelPart helmet;

  protected BaseHelmetModel(ModelPart root) {
    super(root);
    this.helmet = root.getChild("helmet");
  }

  @Override
  public void setupAnim(HumanoidRenderState renderState) {
    float f = renderState.swimAmount;
    boolean flag = renderState.isFallFlying;

    this.helmet.xRot = renderState.xRot * ((float) Math.PI / 180F);
    this.helmet.yRot = renderState.yRot * ((float) Math.PI / 180F);
    if (flag) {
      this.helmet.xRot = (-(float) Math.PI / 4F);
    }
    else if (f > 0.0F) {
      this.helmet.xRot = Mth.rotLerpRad(f, this.helmet.xRot, (-(float) Math.PI / 4F));
    }

    if (renderState.isCrouching) this.helmet.y += 4.2F;
  }
}