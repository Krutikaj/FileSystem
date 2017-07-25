package edu.umb.cs.cs680.unittest;

public class Ls implements Command {
	
	public Ls(){;}
	
	@Override
	public void execute(){
		
		FileSystem fs=FileSystem.getFileSystem();
	Directory dir=fs.getCurrent();
//	System.out.println("In Ls dir value="+dir.getName());
	for(FSElement f:dir.getChildren()){
//		System.out.println("kj:testing3");
		System.out.println(f.getName());
	}
	}

	@Override
	public String getName() {
		return "ls";
	}

}
