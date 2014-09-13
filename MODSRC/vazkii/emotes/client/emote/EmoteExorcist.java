package vazkii.emotes.client.emote;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;

public class EmoteExorcist extends EmoteBase {

	public EmoteExorcist(EntityPlayer player, ModelBiped model) {
		super(player, model);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createParallel()
			.push(Tween.to(model, ModelAccessor.HEAD_Y, 7500F).target(pi * 2))
			.push(Tween.to(model, ModelAccessor.HEAD_X, 750F).target(-0.05F).repeatYoyo(9, 0F));
		
		return timeline;
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.HEAD;
	}

}
