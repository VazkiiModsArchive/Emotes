package vazkii.emotes.client.emote;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;

public class EmoteRun extends EmoteBase {

	public EmoteRun(EntityPlayer player, ModelBiped model) {
		super(player, model);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 100F).target(-pi / 4))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 100F).target(pi / 4))
				.push(Tween.to(model, ModelAccessor.LEFT_LEG_X, 100F).target(pi / 4))
				.push(Tween.to(model, ModelAccessor.RIGHT_LEG_X, 100F).target(-pi / 4))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 200F).target(pi / 4).repeatYoyo(10, 0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 200F).target(-pi / 4).repeatYoyo(10, 0F))
				.push(Tween.to(model, ModelAccessor.LEFT_LEG_X, 200F).target(-pi / 4).repeatYoyo(10, 0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_LEG_X, 200F).target(pi / 4).repeatYoyo(10, 0F))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 100F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 100F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_LEG_X, 100F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_LEG_X, 100F).target(0F))
			.end();

		return timeline;
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.LEFT_ARM || part == ModelAccessor.RIGHT_ARM || part == ModelAccessor.LEFT_LEG || part == ModelAccessor.RIGHT_LEG;
	}

}
