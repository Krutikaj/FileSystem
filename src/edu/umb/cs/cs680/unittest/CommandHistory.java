package edu.umb.cs.cs680.unittest;

import java.util.ArrayList;

public class CommandHistory {

	private ArrayList<Command> command;
	private static CommandHistory instance;
	
	private CommandHistory(){
		this.command=new ArrayList<Command>();
	};

	
	
	public static CommandHistory getCommandHistory(){
		if(instance == null){
			instance = new CommandHistory();
		}
		return instance;
	}

	public void push(Command c){
		this.command.add(c);
	}

	public Command pop(){
		return this.command.get(this.command.size()-1);
	}
	
	public void displayAllCommands(){
		
		for(Command c:this.command){
			System.out.println();
		System.out.print(c.getName());
//		if(c.getParam()!=null){
//			System.out.print(" "+s.getParam());
//		}
		
		}
	}
}
