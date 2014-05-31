package zorascommandsystem.bukkitcompat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import zorascommandsystem.CommandPackage;
import zorascommandsystem.CommandSystem;

public class BukkitCommandSystem extends CommandSystem<CSBukkitCommand> implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args)
	{
		System.out.println("on command!");
		
		System.out.println("creating command string");
		StringBuilder commandString = new StringBuilder();
		commandString.append(cmd.getName()).append(" ");
		for(int ii = 0; ii < args.length; ii++)
		{
			commandString.append(args[ii]).append(" ");
			System.out.println("appending " + args[ii]);
		}
		commandString.setLength(commandString.length() - 1);
		System.out.println("command finished");
		
		System.out.println("requesting command for '" + commandString.toString() + "'");
		CommandPackage<CSBukkitCommand> pack = super.makeCommandPackage(commandString.toString());
		
		if(pack.isNull())
		{
			sendUnknownCommandMessage(sender);
			return true;
		}
		else
		{
			CSBukkitCommand csCommand = pack.getCommand();
			
			Player player = null;
			if(sender instanceof Player)
			{
				player = (Player) sender;
			}
			
			return csCommand.execute(sender, player, pack.getPreArgs(), pack.getArgs());
		}
	}
	
	public void sendUnknownCommandMessage(CommandSender sender)
	{
		sender.sendMessage("Unknown command!");
	}
}
