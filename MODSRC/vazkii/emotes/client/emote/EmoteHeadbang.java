package vazkii.emotes.client.emote;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;

public class EmoteHeadbang extends EmoteBase {

	public EmoteHeadbang(EntityPlayer player, ModelBiped model) {
		super(player, model);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		float pi = (float) Math.PI;
		Timeline timeline = Timeline.createSequence().beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 40F).target(-pi))
				.push(Tween.to(model, ModelAccessor.HEAD_X, 40F).target(0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Y, 40F).target(0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Z, 40F).target(0F))
				.end().beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 30F).target(-pi + 2F).repeatYoyo(11, 0F))
				.push(Tween.to(model, ModelAccessor.HEAD_X, 30F).target(pi - 2F).repeatYoyo(11, 0F))
				.end().beginSequence()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 60F).target(0F))
				.end();
				
		return timeline;
	}

}
