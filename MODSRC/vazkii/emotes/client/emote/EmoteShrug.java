package vazkii.emotes.client.emote;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

public class EmoteShrug extends EmoteBase {

	public EmoteShrug(EntityPlayer player, ModelBiped model, ModelBiped armorModel, ModelBiped armorLegsModel) {
		super(player, model, armorModel, armorLegsModel);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createParallel()
			.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Z, 400F).target(0.7F).repeatYoyo(1, 0F))
			.push(Tween.to(model, ModelAccessor.LEFT_ARM_Z, 400F).target(-0.7F).repeatYoyo(1, 0F))
			.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(-0.7F).repeatYoyo(1, 0F))
			.push(Tween.to(model, ModelAccessor.LEFT_ARM_X, 400F).target(-0.7F).repeatYoyo(1, 0F));
		
		return timeline;
	}
	
	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.RIGHT_ARM || part == ModelAccessor.LEFT_ARM;
	}
}
