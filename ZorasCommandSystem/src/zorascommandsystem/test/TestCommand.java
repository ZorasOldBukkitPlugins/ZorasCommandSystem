package zorascommandsystem.test;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import zorascommandsystem.bukkitcompat.CSBukkitCommand;

public class TestCommand implements CSBukkitCommand
{
	@Override
	public boolean execute(CommandSender sender, Player player, String cmdName, String[] preArgs, String[] args)
	{
		System.out.println("cmdName: " + cmdName);
		System.out.println("Command sent!");
		System.out.println("preArgs: " + Arrays.asList(preArgs).toString());
		System.out.println("args: " + Arrays.asList(args).toString());
		return true;
	}
}
