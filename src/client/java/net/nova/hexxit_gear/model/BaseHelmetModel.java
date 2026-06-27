package net.nova.hexxit_gear.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

public abstract class BaseHelmetModel extends EntityModel<HumanoidRenderState> {
  public final ModelPart head;

  protected BaseHelmetModel(ModelPart root) {
    super(root);
    this.head = root.getChild("head");
  }

  @Override
  public void setupAnim(HumanoidRenderState state) {}
}