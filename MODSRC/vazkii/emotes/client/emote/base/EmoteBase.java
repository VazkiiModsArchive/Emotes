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
	private ModelBiped armorModel;
	private ModelBiped armorLegsModel;
	private EmoteState state;
	
	private boolean done = false;
	
	public EmoteBase(EntityPlayer player, ModelBiped model, ModelBiped armorModel, ModelBiped armorLegsModel) {
		emoteManager = new TweenManager();
		state = new EmoteState(this);
		this.model = model;
		this.armorModel = armorModel;
		this.armorLegsModel = armorLegsModel;

		startTimeline(player, model, true);
		startTimeline(player, armorModel, false);
		startTimeline(player, armorLegsModel, false);
	}
	
	void startTimeline(EntityPlayer player, ModelBiped model, boolean callback) {
		Timeline timeline = getTimeline(player, model).start(emoteManager);
		if(callback)
			timeline.setCallback(new FinishCallback());
	}
	
	public abstract Timeline getTimeline(EntityPlayer player, ModelBiped model);
	
	public abstract boolean usesBodyPart(int part);
	
	public void update(boolean doUpdate) {
		state.load(model);
		state.load(armorModel);
		state.load(armorLegsModel);
		if(doUpdate) {
			emoteManager.update(ClientProxy.delta);
			state.save(model);
		}
	}
	
	public boolean isDone() {
		return done;
	}
	
	private class FinishCallback implements TweenCallback {
		
		@Override
		public void onEvent(int type, BaseTween<?> source) {
			if(type == COMPLETE)
				done = true;
		}
		
	}
	
}
