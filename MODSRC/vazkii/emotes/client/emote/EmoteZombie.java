package vazkii.emotes.client.emote;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

public class EmoteZombie extends EmoteBase {

	public EmoteZombie(EntityPlayer player, ModelBiped model, ModelBiped armorModel, ModelBiped armorLegsModel) {
		super(player, model, armorModel, armorLegsModel);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createParallel()
			.beginSequence()
				.push(Tween.set(model, ModelAccessor.HEAD_X).target(0F))
				.push(Tween.set(model, ModelAccessor.HEAD_Y).target(0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Z, 1000F).target(pi / 6))
				.push(Tween.to(model, ModelAccessor.HEAD_Z, 2000F).target(-pi / 6).repeatYoyo(3, 0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Z, 500F).target(0F))
			.end()
			.beginSequence()
				.beginParallel()
					.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 1000F).target(-pi / 2 + 0.3F))
					.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 1000F).target(-pi / 2 - 0.3F))
				.end()
				.beginParallel()
					.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 1000F).target(-pi / 2 - 0.3F).repeatYoyo(7, 0F))
					.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 1000F).target(-pi / 2 + 0.3F).repeatYoyo(7, 0F))
				.end()
				.beginParallel()
					.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 500F).target(0F))
					.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 500F).target(0F))
				.end()
			.end();
			
		return timeline;
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.HEAD || part == ModelAccessor.LEFT_ARM || part == ModelAccessor.RIGHT_ARM;
	}

}
