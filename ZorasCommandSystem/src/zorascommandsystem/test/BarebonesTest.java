package zorascommandsystem.test;

import zorascommandsystem.CommandSystem;

public class BarebonesTest
{
	public static void main(String[] args)
	{
		CommandSystem<Runnable> cs = new CommandSystem<Runnable>();
		cs.registerCommand("stuff", new Runnable() {

			@Override
			public void run()
			{
				System.out.println("boo!");
			}
			
		});
		
		cs.makeCommandPackage("stuff").getCommand().run();
	}
}
