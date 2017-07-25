package edu.umb.cs.cs680.unittest;

public class VisitFileSearch implements Command {

	private Directory dir;
	private String search;
	private String searchDirectory;

	public VisitFileSearch(String s, String searchDir){
		this.search=s;
		this.searchDirectory = searchDir;
	}
	
	@Override
	public void execute(){
		
		FileSystem fs=FileSystem.getFileSystem();
		//fs.setCurrent(dir);
		
    	Directory d=fs.getRootDir().getDirectory(this.searchDirectory);
    	System.out.println("The returned directory:"+ d.getName()+"File Search:" + this.search);
	//	Directory dir=fs.getCurrent();
	    
		FileSearchVisitor cv= (FileSearchVisitor)fs.createVisitor(d,"FileSearchVisitor",this.search); 
		fs.run(cv,d);
		}

	@Override
	public String getName() {
		return "visitFileSearch";
	}

}
