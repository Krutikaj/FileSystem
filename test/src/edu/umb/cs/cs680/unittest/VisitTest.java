package edu.umb.cs.cs680.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class VisitTest {
	
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

	public int runDir(CountingVisitor v){
		
		//	CountingVisitor visitor2 = createVisitor(home),"CountingVisitor");
			int d=v.getDirNum();
			return d;
	  //  	System.out.println("Number of files:"+v.getFileNum());
	  //  	System.out.println("Number of links:"+v.getLinkNum());
			
		}
	
public int runFile(CountingVisitor v){
		
		//	CountingVisitor visitor2 = createVisitor(home),"CountingVisitor");
			int f=v.getFileNum();
			return f;
	  //  	System.out.println("Number of files:"+v.getFileNum());
	  //  	System.out.println("Number of links:"+v.getLinkNum());
			
		}
public int executetest(){
		
		FileSystem fs=FileSystem.getFileSystem();
		Directory dir=fs.getRootDir();
		CountingVisitor cv= (CountingVisitor)fs.createVisitor(dir,"CountingVisitor",null); 
		int dnum=this.runDir(cv);
	//	fs.runDir(cv);
		return dnum;
		}

public int executefile(){
	
	FileSystem fs=FileSystem.getFileSystem();
	Directory dir=fs.getCurrent();
	CountingVisitor cv= (CountingVisitor)fs.createVisitor(dir,"CountingVisitor",null); 
	int fnum=this.runFile(cv);
	return fnum;
	}

@Test
public void visittest(){
	
//	Visit v = new Visit();
	int actual=this.executetest();
	assertEquals(1,actual);
	
}
@Test
public void visitfile(){
	
//	Visit v = new Visit();
	int actual=this.executefile();
	assertEquals(0,actual);
	
}

}
