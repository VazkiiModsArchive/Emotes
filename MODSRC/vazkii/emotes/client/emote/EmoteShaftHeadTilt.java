package vazkii.emotes.client.emote;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

public class EmoteShaftHeadTilt extends EmoteBase {

	public EmoteShaftHeadTilt(EntityPlayer player, ModelBiped model, ModelBiped armorModel, ModelBiped armorLegsModel) {
		super(player, model, armorModel, armorLegsModel);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createParallel()
			.push(Tween.to(model, ModelAccessor.HEAD_X, 2000F).target(-pi / 4 + pi / 6))
			.push(Tween.to(model, ModelAccessor.HEAD_Y, 2000F).target(pi - pi / 3 + pi / 8))
			.repeatYoyo(1, 1000F);
				
		return timeline;
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.HEAD;
	}
}
