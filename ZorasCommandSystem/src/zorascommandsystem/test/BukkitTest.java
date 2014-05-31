package zorascommandsystem.test;

import org.bukkit.plugin.java.JavaPlugin;

import zorascommandsystem.bukkitcompat.BukkitCommandSystem;

public class BukkitTest extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		BukkitCommandSystem cs = new BukkitCommandSystem(this);
		
		cs.registerCommand("some stuff", new TestCommand());
		cs.registerCommand("maggots * {good|bad}", new TestCommand());
		cs.registerCommand("{snoo|pingas}", new TestCommand());
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
