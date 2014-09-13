package vazkii.emotes.client.emote;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

public class EmoteClap extends EmoteBase {

	public EmoteClap(EntityPlayer player, ModelBiped model, ModelBiped armorModel, ModelBiped armorLegsModel) {
		super(player, model, armorModel, armorLegsModel);
	}
	
	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(-pi / 2))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 400F).target(-pi / 2))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Y, 400F).target(-pi / 4 + 0.25F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Y, 400F).target(pi / 4 - 0.25F))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Y, 100F).target(-pi / 4 + 0.4F).repeatYoyo(11, 0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Y, 100F).target(pi / 4 - 0.4F).repeatYoyo(11, 0F))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Y, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.LEFT_ARM_Y, 400F).target(0F))
			.end();
		
		return timeline;
	}
	
	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.RIGHT_ARM || part == ModelAccessor.LEFT_ARM;
	}

}
