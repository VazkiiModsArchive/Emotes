package vazkii.emotes.client.emote;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;

public class EmoteFacepalm extends EmoteBase {

	public EmoteFacepalm(EntityPlayer player, ModelBiped model, ModelBiped armorModel, ModelBiped armorLegsModel) {
		super(player, model, armorModel, armorLegsModel);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
				.beginParallel()
					.push(Tween.to(model, ModelAccessor.HEAD_X, 1000F).target(0.2F))
					.push(Tween.to(model, ModelAccessor.HEAD_Y, 1000F).target(0F))
					.push(Tween.to(model, ModelAccessor.HEAD_Z, 1000F).target(0F))
					.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 400F).target(-pi + 0.8F))
					.push(Tween.to(model, ModelAccessor.LEFT_ARM_Z, 400F).target(-1F))
				.end()
				.push(Tween.to(model, ModelAccessor.HEAD_Y, 300F).target(0.05F))
				.push(Tween.to(model, ModelAccessor.HEAD_Y, 300F).target(-0.05F).repeatYoyo(4, 0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Y, 300F).target(0F))
				.beginParallel()
					.push(Tween.to(model, ModelAccessor.HEAD_X, 500F).target(0F))
					.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 600F).target(0F))
					.push(Tween.to(model, ModelAccessor.LEFT_ARM_Z, 600F).target(0F))
				.end();
		
		return timeline;
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.HEAD || part == ModelAccessor.LEFT_ARM;
	}

}
