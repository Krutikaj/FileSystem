package edu.umb.cs.cs680.unittest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PwdTest {
    
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
	
	public String execute() {
		int i=0;
		FileSystem fs=FileSystem.getFileSystem();
		fs.setCurrent(fs.getRootDir());
		Directory current=fs.getCurrent();
		Directory parent=new Directory();
		
		ArrayList<String> path=new ArrayList<String>();
		
	while(parent!=null){
			parent=current.getParent();
			path.add(current.getName());
			current=parent;
		}
		for(i=path.size()-1;i>=0;i--){
			//System.out.print("/"+path.get(i));
			return path.get(i);
		}
		return null;
	}
	
	
	@Test
	public void testpwd(){
		//Command co=new Pwd();
		String actual = this.execute();
		String actual1= actual;
		String expected="root";
		assertEquals(actual1,expected);
	}

}
