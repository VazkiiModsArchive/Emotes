package vazkii.emotes.client.emote.base;

import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public final class EmoteHandler {

	public static Map<String, Class<? extends EmoteBase>> emoteMap = new TreeMap();
	private static WeakHashMap<EntityPlayer, EmoteBase> playerEmotes = new WeakHashMap();
	
	public static void putEmote(EntityPlayer player, String emoteName) {
		if(emoteMap.containsKey(emoteName))
			putEmote(player, emoteMap.get(emoteName));
		else player.addChatComponentMessage(new ChatComponentText("That emote doesn't exist. Try /emote list.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
	}
	
	public static void putEmote(EntityPlayer player, Class<? extends EmoteBase> clazz) {
		ModelBiped model = getPlayerModel();
		try {
			if(playerEmotes.containsKey(player))
				player.addChatComponentMessage(new ChatComponentText("You're already doing an emote.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
			else playerEmotes.put(player, clazz.getConstructor(EntityPlayer.class, ModelBiped.class).newInstance(player, model));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateEmotes(Entity e) {
		if(e instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) e;
			
			if(playerEmotes.containsKey(player)) {
				EmoteBase emote = playerEmotes.get(player);
				if(emote.isDone()) {
					playerEmotes.remove(player);
					ModelBiped model = getPlayerModel();
					
					model.bipedHead.rotateAngleZ = 0F;
					model.bipedHeadwear.rotateAngleZ = 0F;
					model.bipedBody.rotateAngleZ = 0F;
					model.bipedRightLeg.rotateAngleZ = 0F;
					model.bipedLeftLeg.rotateAngleZ = 0F;
				}
				else emote.update();
			}
		}
	}
	
	private static ModelBiped getPlayerModel() {
		RenderPlayer render = (RenderPlayer) RenderManager.instance.entityRenderMap.get(EntityPlayer.class);
		return render.modelBipedMain;
	}
	
	public static IChatComponent buildEmoteListStr() {
		final String split = "{\"text\":\", \"},";
		final String button = "{\"text\":\"[%emote%]\",\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/emote %emote%\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"Click to execute this emote\",\"color\":\"yellow\"}}},";
		
		String str = "[{\"text\":\"Emote List: \"},";
		for(String emote : emoteMap.keySet())
			str = str + button.replaceAll("%emote%", emote) + split;
		str = str.replaceAll(Pattern.quote("," + split) + "$", "]");
		
		return IChatComponent.Serializer.func_150699_a(str);
	}
	
}
