package edu.umb.cs.cs680.unittest;

public class Visit implements Command {

public Visit(){;}
	
	@Override
	public void execute(){
		
		FileSystem fs=FileSystem.getFileSystem();
		Directory dir=fs.getCurrent();
		CountingVisitor cv= (CountingVisitor)fs.createVisitor(dir,"CountingVisitor",null); 
		fs.run(cv);
		}

	@Override
	public String getName() {
		return "visit";
	}

}
