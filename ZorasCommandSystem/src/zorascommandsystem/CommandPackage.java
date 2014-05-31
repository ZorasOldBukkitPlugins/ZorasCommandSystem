package zorascommandsystem;

public class CommandPackage<T>
{
	private final T command;
	private final String cmdName;
	private final String[] preArgs;
	private final String[] args;

	private final boolean isNull;
	
	CommandPackage()
	{
		this.command = null;
		this.preArgs = null;
		this.args = null;
		this.cmdName = null;
		
		this.isNull = true;
	}
	
	CommandPackage(T command, String cmdName, String[] preArgs, String[] args)
	{
		this.command = command;
		this.preArgs = preArgs;
		this.args = args;
		this.cmdName = cmdName;
		
		this.isNull = false;
	}
	
	public T getCommand()
	{
		return command;
	}
	
	public String getCmdName()
	{
		return cmdName;
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
