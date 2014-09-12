package vazkii.emotes.common;

import net.minecraft.entity.Entity;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = "Emotes", name = "Emotes", version = "1.0")
public class Emotes {

	@SidedProxy(clientSide = "vazkii.emotes.client.ClientProxy", serverSide = "vazkii.emotes.common.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}
	
}
