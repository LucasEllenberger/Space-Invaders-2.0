package tp1.control.commands;

import java.util.Arrays;
import java.util.List;

public class CommandGenerator {

	private static final List<Command> availableCommands = Arrays.asList(
		new MoveCommand(),
		new ShootCommand(),
		new ShockwaveCommand(),
		new ListCommand(),
		new ResetCommand(),
		new HelpCommand(),
		new ExitCommand(),
		new NoneCommand()
		//TODO Add more commands if needed
	);

	public static Command parse(String[] commandWords) {		
		Command command = null;
		for (Command c: availableCommands) {
			//TODO TEST!
			if (c.matchCommandName(commandWords[0])) {
				return c.parse(commandWords);
			}
		}
		return command;
	}
		
	public static String commandHelp() {
		StringBuilder commands = new StringBuilder();	
		for (Command c: availableCommands) {
			//TODO TEST!
			commands.append(c.helpText());
		}
		return commands.toString();
	}

}
