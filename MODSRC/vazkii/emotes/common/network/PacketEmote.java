package vazkii.emotes.common.network;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.network.PacketBuffer;
import vazkii.emotes.common.Emotes;
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
		Emotes.proxy.handlePacket(message);
		return null;
	}
	
}
