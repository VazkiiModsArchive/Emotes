package vazkii.emotes.common.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("vEmotes");

	public static void init() {
		INSTANCE.registerMessage(PacketEmote.class, PacketEmote.class, 0, Side.CLIENT);
	}
	
}
