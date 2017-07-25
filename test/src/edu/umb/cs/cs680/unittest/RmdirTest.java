package edu.umb.cs.cs680.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class RmdirTest {

	@Test
	public void testinit(){
	FileSystem fs=FileSystem.getFileSystem();
	Directory system=new Directory(fs.getRootDir(),"system",fs.getRootDir().getOwner(),0);
	Directory home=new Directory(fs.getRootDir(),"home",fs.getRootDir().getOwner(),0);
	fs.setCurrent(fs.getRootDir());
	
	system.appendChild(new File(system,"a.exe",system.getOwner(),1));
	system.appendChild(new File(system,"b.bat",system.getOwner(),1));
	system.appendChild(new File(system,"c.exe",system.getOwner(),1));
	home.appendChild(new File(system, "d.bash",home.getOwner(),1));
	Directory pictures = new Directory(home, "pictures",home.getOwner(),0);
	File e=new File(pictures, "e.exe",home.getOwner(),1);
	pictures.appendChild(e);
	
	pictures.appendChild(new File(pictures, "f.bat",home.getOwner(),1));
	home.appendChild(pictures);
	Link x =new Link(home,"x.lnk",home.getOwner(),0);
	x.addLink(system);
	home.appendChild(x);
	Link y =new Link(pictures,"y.lnk",pictures.getOwner(),0);
    y.addLink(e);
    pictures.appendChild(y);
	}
	
	public String execute(){
		String param="home";
		FileSystem fs=FileSystem.getFileSystem();
		fs.setCurrent(fs.getRootDir());
		Directory directory=fs.getCurrent();
	//	System.out.println("The set directory:"+ directory.getName()+"the directory to remove:"+this.parameter+"\n");
	   directory.removeDirectory(param);
    	String remdir=param;
		return remdir;
			
	}
	
	@Test
	public void testrmdir(){
		//Command co=new Pwd();
		String actual = this.execute();
		String actual1= actual;
		String expected="home";
		assertEquals(actual1,expected);
	}

}
