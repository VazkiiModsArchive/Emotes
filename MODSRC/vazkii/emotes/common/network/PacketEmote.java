package vazkii.emotes.common.network;

import java.io.IOException;

import vazkii.emotes.client.emote.base.EmoteHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketEmote implements IMessage, IMessageHandler<PacketEmote, IMessage> {

	public String emoteName;
	public String playerName;

	public PacketEmote() { }

	public PacketEmote(String name, String player) {
		this.emoteName = name;
		this.playerName = player;
	}
	
	@Override
	public void fromBytes(ByteBuf buffer) {
		PacketBuffer packet = new PacketBuffer(buffer);
		try {
			emoteName = packet.readStringFromBuffer(32);
			playerName = packet.readStringFromBuffer(32);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		PacketBuffer packet = new PacketBuffer(buffer);
		try {
			packet.writeStringToBuffer(emoteName);
			packet.writeStringToBuffer(playerName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IMessage onMessage(PacketEmote message, MessageContext context) {
		World world = Minecraft.getMinecraft().theWorld;
		EntityPlayer player = world.getPlayerEntityByName(message.playerName);
		if(player != null) {
			if(message.emoteName.equals("list"))
				player.addChatComponentMessage(new ChatComponentText(EmoteHandler.buildEmoteListStr()));
			else EmoteHandler.putEmote(player, message.emoteName);
		}
		
		return null;
	}
	
}
