package edu.umb.cs.cs680.unittest;

import java.util.ArrayList;

public class Pwd implements Command{

	@Override
	public void execute() {
		FileSystem fs=FileSystem.getFileSystem();
		Directory current=fs.getCurrent();
		Directory parent=new Directory();
		ArrayList<String> path=new ArrayList<String>();
		
		while(parent!=null){
			parent=current.getParent();
			path.add(current.getName());
			current=parent;
		}
		for(int i=path.size()-1;i>=0;i--){
			System.out.print("/"+path.get(i));
		}
	}
	
	@Override
	public String getName() {
		return "pwd";
	}


}
