package edu.umb.cs.cs680.unittest;

public class Mkdir implements Command{
	private String param;

	public Mkdir(String s){
		this.param=s;
	}
	
	public String getParam() {
		return this.param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	public void execute(){
		FileSystem fs=FileSystem.getFileSystem();
		fs.setCurrent(fs.getRootDir());
		Directory dir=fs.getCurrent();
		Directory dir1 = new Directory(dir,this.param,dir.getOwner(),0);
		dir.appendChild(dir1);
		
		//fs.addChild(dir,new FSElement(dir,this.param,dir.getOwner(),0));
	//	FSElement fs1 = new FSElement(dir,this.param,dir.getOwner(),0);
	//	fs.addChild(dir,fs1);
	//	fs.setCurrent();
		System.out.println("Directory created");
	}
	
	@Override
	public String getName() {
		return "mkdir";
	}

}
