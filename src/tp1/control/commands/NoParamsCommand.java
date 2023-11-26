package tp1.control.commands;

import tp1.control.ExecutionResult;
import tp1.logic.Game;

public abstract class NoParamsCommand extends Command {

	@Override
	public Command parse(String[] commandWords) {
		if (this.matchCommandName(commandWords[0]) && commandWords.length == 1) {
			return this;
		}
		return null;
	}

//	public ExecutionResult execute(Game game) {
//		// TODO Auto-generated method stub
//		return null;
//	}	
}
