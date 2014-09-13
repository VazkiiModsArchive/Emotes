package vazkii.emotes.client;

import net.minecraft.client.model.ModelBiped;
import vazkii.emotes.client.emote.EmoteExorcist;
import vazkii.emotes.client.emote.EmoteHeadbang;
import vazkii.emotes.client.emote.EmoteWave;
import vazkii.emotes.client.emote.EmoteZombie;
import vazkii.emotes.client.emote.base.EmoteHandler;
import vazkii.emotes.client.emote.base.ModelAccessor;
import vazkii.emotes.common.CommonProxy;
import aurelienribon.tweenengine.Tween;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class ClientProxy extends CommonProxy {

	public static float time = 0F;
	public static float delta = 0F;

	@Override
	public void init() {
		super.init();
		Tween.registerAccessor(ModelBiped.class, new ModelAccessor());
		FMLCommonHandler.instance().bus().register(this);
		
		initEmotes();
	}
	
	private void initEmotes() {
		EmoteHandler.emoteMap.put("exorcist", EmoteExorcist.class);
		EmoteHandler.emoteMap.put("headbang", EmoteHeadbang.class);
		EmoteHandler.emoteMap.put("wave", EmoteWave.class);
		EmoteHandler.emoteMap.put("zombie", EmoteZombie.class);
	}
	
	@SubscribeEvent
	public void onRenderStart(RenderTickEvent event) {
		if(event.phase == Phase.START) {
			float ctime = (float) Math.floor(time) + event.renderTickTime;
			delta = (ctime - time) * 50;
			time = ctime;
		}
	}
	
	@SubscribeEvent
	public void onTick(ClientTickEvent event) {
		if(event.phase == Phase.START)
			time = (float) Math.ceil(time);
	}
}
