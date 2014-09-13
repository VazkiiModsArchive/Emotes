package vazkii.emotes.client.emote;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

public class EmotePoint extends EmoteBase {

	public EmotePoint(EntityPlayer player, ModelBiped model, ModelBiped armorModel, ModelBiped armorLegsModel) {
		super(player, model, armorModel, armorLegsModel);
	}
	
	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(-pi / 2).repeatYoyo(1, 1000F));
		
		return timeline;
	}
	
	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.RIGHT_ARM;
	}

}
