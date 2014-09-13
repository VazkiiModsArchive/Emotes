package vazkii.emotes.client.emote;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

public class EmoteWave extends EmoteBase {

	public EmoteWave(EntityPlayer player, ModelBiped model) {
		super(player, model);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 200F).target(-pi * 0.9F))
			.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Z, 300F).target(pi * -0.3F).repeatYoyo(5, 0F))
			.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 200F).target(0F));
	
		return timeline;
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.RIGHT_ARM_X;
	}

}
