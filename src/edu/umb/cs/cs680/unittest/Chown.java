package edu.umb.cs.cs680.unittest;

import java.util.ArrayList;
import java.util.Arrays;

public class Chown implements Command {
	
	private String parameter;
	
	public Chown(String newOwner){
		this.parameter=newOwner;
	}

	@Override
	public void execute() {
	FileSystem fs=FileSystem.getFileSystem();
		if(this.parameter==null){
			System.out.println("Invalid chown command");
		}
		else{
			ArrayList<String> ownfile=new ArrayList<String>(Arrays.asList(this.parameter.split("\\s+")));
			String owner=ownfile.get(0);
			for(int i=1;i<ownfile.size();i++){
				fs.getCurrent().getDirectory(ownfile.get(i)).setOwner(owner);
			}
			
		}

}
	@Override
	public String getName() {
		return "chown";
	}

}
