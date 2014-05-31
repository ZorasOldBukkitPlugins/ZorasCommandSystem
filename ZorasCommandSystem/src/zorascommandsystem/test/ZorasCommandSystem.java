package zorascommandsystem.test;

import org.bukkit.plugin.java.JavaPlugin;

import zorascommandsystem.bukkitcompat.BukkitCommandSystem;

public class ZorasCommandSystem extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		BukkitCommandSystem cs = new BukkitCommandSystem(this);
		
		cs.registerCommand("some stuff", new TestCommand("some stuff"));
		cs.registerCommand("maggots * {good|bad}", new TestCommand("maggots"));
		cs.registerCommand("{snoo|pingas}", new TestCommand("snoopingas"));
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
