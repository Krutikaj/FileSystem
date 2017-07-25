package edu.umb.cs.cs680.unittest;

import java.util.ArrayList;
import java.util.Arrays;

public class Dir implements Command {
	
	private String parameter;

	public Dir(String s){
		this.parameter=s;
	}

	public Dir(){}
public void execute(){
		FileSystem fs=FileSystem.getFileSystem();
		Directory dir=fs.getCurrent();
		
      if(this.parameter==null){
			
			fs.setCurrent(dir);
			for(FSElement f:dir.getChildren()){
				
				if(f instanceof Directory){
				System.out.println(" Directory - Name-"+f.getName()+"\tSize:"+f.getSize()+"\tOwner"+f.getOwner());
				}
				
				if(f instanceof File){
					System.out.println(" File - Name-"+f.getName()+"\tSize:"+f.getSize()+"\tOwner"+f.getOwner());
					}
				if(f instanceof Link){
					System.out.println(" Link - Name-"+f.getName()+"\tSize:"+f.getSize()+"\tOwner"+f.getOwner());
					}
			}
		}
		else{
						
		if(this.parameter.contains("/")){
			ArrayList<String> path=new ArrayList<String>(Arrays.asList(this.parameter.split("/")));
			for(String n:path){
				if(n.contains("..")){
					Directory parent=dir.getParent();
					if(parent!=null){
					dir=parent;
					
						}
						else{
							System.out.println("Directory does not exists");
						}
				}
				else{
					Directory p=dir.getDirectory(n);
					if(p!=null){
					 dir=p;
						}
						else{
							System.out.println("Directory does not exists");
						}
				}
		
			}
			for(FSElement f:dir.getChildren()){
				
				if(f instanceof Directory){
					System.out.println(" Directory - Name-"+f.getName()+"Size:"+f.getSize()+"Owner"+f.getOwner());
					}
					
					if(f instanceof File){
						System.out.println(" File - Name-"+f.getName()+"Size:"+f.getSize()+"Owner"+f.getOwner());
						}
					if(f instanceof Link){
						System.out.println(" Link - Name-"+f.getName()+"Size:"+f.getSize()+"Owner"+f.getOwner());
						}
			}
			
			
}
		else{
			if(this.parameter.contains("..")){
				Directory p= dir.getParent();
				if(p!=null){
					dir=p;
					}
					else{
						System.out.println("No Such Directory Exists");
					}
			}
			else{
		Directory p=dir.getDirectory(this.parameter);
		if(p!=null){
		dir=p;
		}
		else{
			System.out.println("No Such Directory Exists");
		}
			}
for(FSElement f:dir.getChildren()){
				
	if(f instanceof Directory){
		System.out.println(" Directory - Name-"+f.getName()+"Size:"+f.getSize()+"Owner:"+f.getOwner());
		}
		
		if(f instanceof File){
			System.out.println(" File - Name-"+f.getName()+"Size:"+f.getSize()+"Owner:"+f.getOwner());
			}
		if(f instanceof Link){
			System.out.println(" Link - Name-"+f.getName()+"Size:"+f.getSize()+"Owner:"+f.getOwner());
			}
			}
	}	
		}		
	}

	@Override
	public String getName() {
		return "dir";
	}

}
