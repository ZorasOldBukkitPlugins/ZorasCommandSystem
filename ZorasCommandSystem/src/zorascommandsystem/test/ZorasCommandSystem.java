package zorascommandsystem.test;

import org.bukkit.plugin.java.JavaPlugin;

import zorascommandsystem.bukkitcompat.BukkitCommandSystem;

public class ZorasCommandSystem extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		BukkitCommandSystem cs = new BukkitCommandSystem(this);
		
		cs.registerCommand("some", new TestCommand());
		cs.registerCommand("maggots", new TestCommand());
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
