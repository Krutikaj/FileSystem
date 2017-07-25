package edu.umb.cs.cs680.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MkdirTest {

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
	
	@Test
	public void Mkdirtest(){
		String param="krut";
		Mkdir mk = new Mkdir(param);
		assertEquals(param,mk.getParam());
	}
	
	
	public String executetest(){
		 String param="krut";
		FileSystem fs=FileSystem.getFileSystem();
		fs.setCurrent(fs.getRootDir());
		Directory dir=fs.getCurrent();
		Directory dir1 = new Directory(dir,param,dir.getOwner(),0);
		dir.appendChild(dir1);
		
		return dir1.getName();
		//fs.addChild(dir,new FSElement(dir,this.param,dir.getOwner(),0));
	//	FSElement fs1 = new FSElement(dir,this.param,dir.getOwner(),0);
	//	fs.addChild(dir,fs1);
	//	fs.setCurrent();
	//	System.out.println("Directory created");
	}

	@Test
	public void testmkdir(){
		//Command co=new Pwd();
		String actual = this.executetest();
		String actual1= actual;
		String expected="krut";
		assertEquals(actual1,expected);
	}
	
}
