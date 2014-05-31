package zorascommandsystem.bukkitcompat;

import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import zorascommandsystem.CommandPackage;
import zorascommandsystem.CommandSystem;

public class BukkitCommandSystem extends CommandSystem<CSBukkitCommand> implements CommandExecutor
{
	public BukkitCommandSystem(final JavaPlugin plugin)
	{
		this.plugin = plugin;
	}
	
	private final JavaPlugin plugin;
	
	@Override
	public Set<String> registerCommand(final String cmdString, final CSBukkitCommand cmd)
	{
		return this.registerCommand(cmdString, cmd, false);
	}
	
	public Set<String> registerCommand(final String cmdString, final CSBukkitCommand cmd, boolean override)
	{
		if(cmdString == null || cmdString.length() <= 0)
		{
			throw new IllegalArgumentException("Command string cannot be null and it must contain something!");
		}
		
		Set<String> registeredCommandNames = super.registerCommand(cmdString, cmd);

		if(override)
		{
			
		}
		else
		{
			for(String cmdName : registeredCommandNames)
			{
				try
				{
					plugin.getCommand(cmdName).setExecutor(this);
				}
				catch (Exception e)
				{
					plugin.getLogger().severe("Failed to register command '" + cmdName + "'! Did you add it to your commands list in the plugin.yml?");
				}
			}
		}
		
		return registeredCommandNames;
	}
	
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
