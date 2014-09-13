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
		float pi = (float) Math.PI;
		Timeline timeline = Timeline.createSequence().beginSequence()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 200F).target(-pi * 0.9F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Z, 300F).target(pi * -0.3F).repeatYoyo(7, 0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 200F).target(0F))
				.end();
		
		return timeline;
	}

}
