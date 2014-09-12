package vazkii.emotes.common;

import vazkii.emotes.common.network.PacketEmote;
import vazkii.emotes.common.network.PacketHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;

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

}
