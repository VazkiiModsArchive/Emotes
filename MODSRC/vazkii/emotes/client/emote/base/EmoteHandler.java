package vazkii.emotes.client.emote.base;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public final class EmoteHandler {

	public static Map<String, Class<? extends EmoteBase>> emoteMap = new HashMap();
	private static WeakHashMap<EntityPlayer, EmoteBase> playerEmotes = new WeakHashMap();
	
	public static void putEmote(EntityPlayer player, String emoteName) {
		if(emoteName.contains(emoteName))
			putEmote(player, emoteMap.get(emoteName));
	}
	
	public static void putEmote(EntityPlayer player, Class<? extends EmoteBase> clazz) {
		RenderPlayer render = (RenderPlayer) RenderManager.instance.entityRenderMap.get(EntityPlayer.class);
		ModelBiped model = render.modelBipedMain;
		try {
			playerEmotes.put(player, clazz.getConstructor(EntityPlayer.class, ModelBiped.class).newInstance(player, model));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateEmotes(Entity e) {
		if(e instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) e;
			
			if(playerEmotes.containsKey(player)) {
				EmoteBase emote = playerEmotes.get(player);
				if(emote.isDone())
					playerEmotes.remove(player);
				else emote.update();
			}
		}
	}
	
}
