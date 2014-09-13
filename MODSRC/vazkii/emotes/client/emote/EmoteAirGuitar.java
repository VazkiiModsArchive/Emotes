package vazkii.emotes.client.emote;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;

public class EmoteAirGuitar extends EmoteBase {

	public EmoteAirGuitar(EntityPlayer player, ModelBiped model, ModelBiped armorModel, ModelBiped armorLegsModel) {
		super(player, model, armorModel, armorLegsModel);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.HEAD_X, 400F).target(0.4F))
				.push(Tween.to(model, ModelAccessor.HEAD_Y, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Z, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 400F).target(-pi * 0.9F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Y, 400F).target(-pi / 2))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(-pi / 2 + 0.8F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Y, 400F).target(-pi / 2 + 0.5F))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.HEAD_X, 100F).target(0.2F).repeatYoyo(18, 0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 100F).target(-pi / 2 + 0.2F).repeatYoyo(18, 0F))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.HEAD_X, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Y, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Y, 400F).target(0F))
			.end();
	
		return timeline;
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.HEAD || part == ModelAccessor.LEFT_ARM || part == ModelAccessor.RIGHT_ARM;
	}

}
