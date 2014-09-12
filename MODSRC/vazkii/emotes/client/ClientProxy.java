package vazkii.emotes.client;

import net.minecraft.client.model.ModelBiped;
import vazkii.emotes.client.emote.EmoteWave;
import vazkii.emotes.client.emote.base.EmoteHandler;
import vazkii.emotes.client.emote.base.ModelAccessor;
import vazkii.emotes.common.CommonProxy;
import aurelienribon.tweenengine.Tween;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class ClientProxy extends CommonProxy {

	public static float delta = 0F;
	
	@Override
	public void init() {
		super.init();
		Tween.registerAccessor(ModelBiped.class, new ModelAccessor());
		FMLCommonHandler.instance().bus().register(this);
		
		initEmotes();
	}
	
	private void initEmotes() {
		EmoteHandler.emoteMap.put("wave", EmoteWave.class);

	}
	
	@SubscribeEvent
	public void onRenderStart(RenderTickEvent event) {
		if(event.phase == Phase.START)
			delta = event.renderTickTime;
	}
}
