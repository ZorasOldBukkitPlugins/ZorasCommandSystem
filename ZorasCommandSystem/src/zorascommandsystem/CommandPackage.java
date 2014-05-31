package zorascommandsystem;

public class CommandPackage<T>
{
	CommandPackage()
	{
		this.command = null;
		this.preArgs = null;
		this.args = null;
		
		this.isNull = true;
	}
	
	CommandPackage(T command, String[] preArgs, String[] args)
	{
		this.command = command;
		this.preArgs = preArgs;
		this.args = args;
		
		this.isNull = false;
	}
	
	private final T command;
	private final String[] preArgs;
	private final String[] args;
	
	private final boolean isNull;
	
	public T getCommand()
	{
		return command;
	}
	
	public String[] getPreArgs()
	{
		return preArgs;
	}
	
	public String[] getArgs()
	{
		return args;
	}
	
	public boolean isNull()
	{
		return isNull;
	}
}
