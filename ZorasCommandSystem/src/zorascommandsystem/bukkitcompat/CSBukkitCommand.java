package zorascommandsystem.bukkitcompat;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface CSBukkitCommand
{
	public boolean execute(CommandSender sender, Player player, String[] preArgs, String[] args);
}
