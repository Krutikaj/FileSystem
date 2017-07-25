package edu.umb.cs.cs680.unittest;

public class History implements Command{

	public void execute(){
		CommandHistory ch= CommandHistory.getCommandHistory();
		ch.displayAllCommands();
	}

	
	@Override
	public String getName() {
		return "history";
	}

}
