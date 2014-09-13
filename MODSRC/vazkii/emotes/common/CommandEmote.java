package vazkii.emotes.common;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.common.network.PacketEmote;
import vazkii.emotes.common.network.PacketHandler;

public class CommandEmote extends CommandBase {

	@Override
	public String getCommandName() {
		return "emote";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "<emote>";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if(args.length > 0 && sender instanceof EntityPlayer)
			PacketHandler.INSTANCE.sendToAll(new PacketEmote(args[0], sender.getCommandSenderName()));
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		return p_71519_1_ instanceof EntityPlayer;
	}

}
