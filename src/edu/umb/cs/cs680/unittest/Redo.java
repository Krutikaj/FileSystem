package edu.umb.cs.cs680.unittest;

public class Redo implements Command {
	
	@Override
	public void execute() {
		CommandHistory ch=CommandHistory.getCommandHistory();
		Command comm=ch.pop();
		
		comm.execute();
	}

	@Override
	public String getName() {
		return "Redo";
	}

}
