package edu.umb.cs.cs680.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkTest {

	@Test
	public void testLink() {
		Directory parent=null;
		String name= "a";
		String owner= "ABC";
		int size= 0;
		
		Link lk = new Link(parent,name,owner,size);
		assertEquals(parent,lk.getParent());
		assertEquals(name,lk.getName());
		assertEquals(owner,lk.getOwner());
		assertEquals(size,lk.getSize());
	}
	
	@Test
	public void testTargetSize(){
		FileSystem fs=FileSystem.getFileSystem();
		Directory system=new Directory(fs.getRootDir(),"system",fs.getRootDir().getOwner(),0);
		Directory home=new Directory(fs.getRootDir(),"home",fs.getRootDir().getOwner(),0);
		
		system.appendChild(new File(system,"a",system.getOwner(),1));
		system.appendChild(new File(system,"b",system.getOwner(),1));
		system.appendChild(new File(system,"c",system.getOwner(),1));
		home.appendChild(new File(home, "d",home.getOwner(),1));
		Directory pictures = new Directory(home, "pictures",home.getOwner(),0);
		home.appendChild(pictures);
		pictures.appendChild(new File(pictures, "e",home.getOwner(),1));
		pictures.appendChild(new File(pictures, "f",home.getOwner(),1));
		File e=new File(pictures, "e",home.getOwner(),1);
		pictures.appendChild(e);
		Link x =new Link(home,"x",home.getOwner(),0);
		x.addLink(system);
		home.appendChild(x);
		
		Link y =new Link(pictures,"y",pictures.getOwner(),0);
	    y.addLink(e);
	    pictures.appendChild(y);

	    assertEquals(3,x.getTargetSize());
	    assertEquals(1,y.getTargetSize());
	}

}
