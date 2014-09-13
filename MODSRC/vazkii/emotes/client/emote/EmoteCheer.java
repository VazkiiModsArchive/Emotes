package vazkii.emotes.client.emote;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;

public class EmoteCheer extends EmoteBase {

	public EmoteCheer(EntityPlayer player, ModelBiped model) {
		super(player, model);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Z, 400F).target(pi - 0.5F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Z, 400F).target(-pi + 0.5F))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 150F).target(-0.6F).repeatYoyo(11, 0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 150F).target(-0.6F).repeatYoyo(11, 0F))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Z, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Z, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 400F).target(0F))
			.end();
		
		return timeline;
	}
	
	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.RIGHT_ARM || part == ModelAccessor.LEFT_ARM;
	}
}
