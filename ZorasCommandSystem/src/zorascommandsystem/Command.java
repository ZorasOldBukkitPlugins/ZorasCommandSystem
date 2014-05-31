package zorascommandsystem;

public interface Command
{
	public boolean onCommand(final String[] preArgs, final String[] args);
}
