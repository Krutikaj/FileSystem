package edu.umb.cs.cs680.unittest;

public class VisitSizeCount implements Command {

	@Override
	public void execute(){
		
		FileSystem fs=FileSystem.getFileSystem();
		Directory dir=fs.getCurrent();
		SizeCountingVisitor scv= (SizeCountingVisitor)fs.createVisitor(dir,"SizeCountingVisitor",null); 
		fs.run(scv);
		}

	@Override
	public String getName() {
		return "visitSizeCount";
	}

}
