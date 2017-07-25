package edu.umb.cs.cs680.unittest;

public class Rmdir implements Command{

	private String parameter;
	
  public Rmdir(String dir){
	  this.parameter= dir;
  }
  
  public void execute(){
			FileSystem fs=FileSystem.getFileSystem();
			fs.setCurrent(fs.getRootDir());
			Directory directory=fs.getCurrent();
		//	System.out.println("The set directory:"+ directory.getName()+"the directory to remove:"+this.parameter+"\n");
		   directory.removeDirectory(this.parameter);
			fs.setCurrent(directory);
				
		}
  @Override
	public String getName() {
		return "rmdir";
	}
  }

