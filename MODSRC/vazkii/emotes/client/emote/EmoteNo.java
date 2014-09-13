package vazkii.emotes.client.emote;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

public class EmoteNo extends EmoteBase {

	public EmoteNo(EntityPlayer player, ModelBiped model, ModelBiped armorModel, ModelBiped armorLegsModel) {
		super(player, model, armorModel, armorLegsModel);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.HEAD_X, 300F).target(0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Y, 300F).target(0.2F))
				.push(Tween.to(model, ModelAccessor.HEAD_Z, 300F).target(0F))
			.end()
			.push(Tween.to(model, ModelAccessor.HEAD_Y, 300F).target(-0.2F).repeatYoyo(4, 0F))
			.push(Tween.to(model, ModelAccessor.HEAD_Y, 300F).target(0F));
				
		return timeline;
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.HEAD;
	}

}
