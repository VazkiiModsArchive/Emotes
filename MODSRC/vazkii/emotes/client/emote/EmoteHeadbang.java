package vazkii.emotes.client.emote;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

public class EmoteHeadbang extends EmoteBase {

	public EmoteHeadbang(EntityPlayer player, ModelBiped model, ModelBiped armorModel, ModelBiped armorLegsModel) {
		super(player, model, armorModel, armorLegsModel);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(-pi))
				.push(Tween.to(model, ModelAccessor.HEAD_X, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Y, 400F).target(0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Z, 400F).target(0F))
			.end()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 300F).target(-pi + 2F).repeatYoyo(11, 0F))
				.push(Tween.to(model, ModelAccessor.HEAD_X, 300F).target(pi - 2F).repeatYoyo(11, 0F))
			.end()
			.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 600F).target(0F));
				
		return timeline;
	}
	
	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.RIGHT_ARM || part == ModelAccessor.HEAD;
	}

}
