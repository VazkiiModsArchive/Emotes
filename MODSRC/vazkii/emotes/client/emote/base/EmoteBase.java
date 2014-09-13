package vazkii.emotes.client.emote.base;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.ClientProxy;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public abstract class EmoteBase {

	public static final float pi = (float) Math.PI;
	
	public TweenManager emoteManager;
	private ModelBiped model;
	private EmoteState state;
	
	private boolean done = false;
	
	public EmoteBase(EntityPlayer player, ModelBiped model) {
		emoteManager = new TweenManager();
		state = new EmoteState(this);
		this.model = model;
		
		getTimeline(player, model).start(emoteManager).setCallback(new TweenCallback() {
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				if(type == COMPLETE)
					done = true;
			}
		});
	}
	
	public abstract Timeline getTimeline(EntityPlayer player, ModelBiped model);
	
	public abstract boolean usesBodyPart(int part);
	
	public void update() {
		state.load(model);
		emoteManager.update(ClientProxy.delta);
		state.save(model);
	}
	
	public boolean isDone() {
		return done;
	}
	
}
