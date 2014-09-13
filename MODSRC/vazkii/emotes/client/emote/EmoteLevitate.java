package vazkii.emotes.client.emote;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;

public class EmoteLevitate extends EmoteBase {

	public EmoteLevitate(EntityPlayer player, ModelBiped model) {
		super(player, model);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Z, 2000F).target(-pi / 2))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Z, 2000F).target(pi / 2))
				.push(Tween.to(model, ModelAccessor.LEFT_LEG_Z, 2000F).target(-pi / 2))
				.push(Tween.to(model, ModelAccessor.RIGHT_LEG_Z, 2000F).target(pi / 2))
			.end()
			.pushPause(2000F)
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Z, 500F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Z, 500F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_LEG_Z, 500F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_LEG_Z, 500F).target(0F))
			.end();

		return timeline;
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.LEFT_ARM || part == ModelAccessor.RIGHT_ARM || part == ModelAccessor.LEFT_LEG || part == ModelAccessor.RIGHT_LEG;
	}

}
