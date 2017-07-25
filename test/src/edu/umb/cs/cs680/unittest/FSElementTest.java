package edu.umb.cs.cs680.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class FSElementTest {

	@Test
	public void testFSElement() {
		Directory parent=null;
		String name= "a";
		String owner= "ABC";
		int size= 5;
		
		FSElement fs = new FSElement(parent,name,owner,size);
		assertEquals(parent,fs.getParent());
		assertEquals(name,fs.getName());
		assertEquals(owner,fs.getOwner());
		assertEquals(size,fs.getSize());
	}
	
	@Test
	public void testmain(){
		FileSystem fs=FileSystem.getFileSystem();
		Directory system=new Directory(fs.getRootDir(),"system",fs.getRootDir().getOwner(),0);
		//Directory home=new Directory(fs.getRootDir(),"home",fs.getRootDir().getOwner(),0);
		
		system.appendChild(new File(system,"a",system.getOwner(),1));
		system.appendChild(new File(system,"b",system.getOwner(),1));
		system.appendChild(new File(system,"c",system.getOwner(),1));
		
		assertEquals(3,system.getSize());
	}


}
