package edu.umb.cs.cs680.unittest;

import java.util.ArrayList;
import java.util.Arrays;

public class Cd implements Command {
	
	private String parameter;

	public Cd(String s){
		this.parameter=s;
	}
	
	public Cd(){}

	@Override
	public void execute() {
		FileSystem fs=FileSystem.getFileSystem();
		if(this.parameter==null){
			
			Directory dir=fs.getRootDir();
			fs.setCurrent(dir);		
		}
		else{
		if(this.parameter.contains("/")){
			ArrayList<String> path=new ArrayList<String>(Arrays.asList(this.parameter.split("/")));
			for(String n:path){
				if(n.contains("..")){
					Directory d=fs.getCurrent().getParent();
					if(d!=null){
						fs.setCurrent(d);
						}
						else{
							System.out.println("No Such File or Directory");
						}
				}
				else{
					Directory d=fs.getCurrent().getDirectory(n);
				
					if(d!=null){
						fs.setCurrent(d);
						}
						else{
							System.out.println("No Such File or Directory");
						}
				}
			}
			
			
}
		else{
			if(this.parameter.contains("..")){
				Directory d=fs.getCurrent().getParent();
				if(d!=null){
					fs.setCurrent(d);
					}
					else{
						System.out.println("No Such File or Directory");
					}
			}
			else{
		Directory d=fs.getCurrent().getDirectory(this.parameter);
		if(d!=null){
		fs.setCurrent(d);
		}
		else{
			System.out.println("No Such File or Directory Exists");
		}
			}
	}	
		}
	}

	
	@Override
	public String getName() {
		return "cd";
	}
	

}
