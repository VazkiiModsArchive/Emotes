package vazkii.emotes.client.emote;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;

public class EmoteGangnamStyle extends EmoteBase {

	public EmoteGangnamStyle(EntityPlayer player, ModelBiped model) {
		super(player, model);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(-pi / 2 + 0.2F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 400F).target(-pi / 2 - 0.2F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Y, 400F).target(-pi / 4 + 0.15F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Y, 400F).target(pi / 4 - 0.15F))
				.push(Tween.to(model, ModelAccessor.RIGHT_LEG_Z, 200F).target(pi / 6))
				.push(Tween.to(model, ModelAccessor.LEFT_LEG_Z, 200F).target(-pi / 6))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 200F).target(-pi / 2 + 0.8F).repeatYoyo(16, 0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 200F).target(-pi / 2 + 0.4F).repeatYoyo(16, 0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_LEG_Z, 200F).target(pi / 6 + 0.4F).repeatYoyo(8, 200F))
				.push(Tween.to(model, ModelAccessor.LEFT_LEG_Z, 200F).delay(200F).target(-pi / 6 - 0.4F).repeatYoyo(8, 200F))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Y, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Y, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_LEG_Z, 200F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_LEG_Z, 200F).target(0F))
			.end();
		
			return timeline;	
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.LEFT_ARM || part == ModelAccessor.RIGHT_ARM || part == ModelAccessor.LEFT_LEG || part == ModelAccessor.RIGHT_LEG;
	}

}
