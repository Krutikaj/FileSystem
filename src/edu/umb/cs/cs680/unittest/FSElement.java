package edu.umb.cs.cs680.unittest;

import java.util.*;


public class FSElement {

	private String name;
	private String owner;
	private Date created;
	private Date lastModified;
	private int size;
	private Directory parent;
	private boolean isFile;
	
	public FSElement(Directory parent, String name, String owner, int size){
		this.parent=parent;
		this.name=name;
		this.owner=owner;
		this.size=size;
		this.created=new Date();
		this.lastModified=new Date();
		this.isFile=true;
	}
	
   public FSElement(){
		
	}
			
	public Directory getParent(){
		return parent;
	}
	
	public String getName(){
		return name;
	}
	
	public String getOwner(){
		return owner;
	}
	
	public void setOwner(String n) {
		this.owner=n;
		}
	
	public boolean getIsFile(){
		return isFile;
	}
	
	public void setIsFile(Boolean child){
		this.isFile=child;
		
	}
	
	

	
	
	public int getSize(){
		return size;
			}
	public Date getCreated() {
		return new Date(created.getTime());
	}
	public Date getModified() {
		return new Date(lastModified.getTime());
	}	
	
public void accept(FSVisitor v){
		
	}
	
	public void showAllElements(){}
	
/*	public static void main(String[] args){
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
		System.out.println("Size of file pointed to by x:"+x.getTargetSize());
		Link y =new Link(pictures,"y",pictures.getOwner(),0);
	    y.addLink(e);
	    pictures.appendChild(y);
	    System.out.println("Size of file pointed to by y:"+y.getTargetSize());
	    
	/*    Link z =new Link(pictures,"z",pictures.getOwner(),0);
	    z.addLink(y);
	    System.out.println("Size of file pointed to by z:"+z.getTargetSize());
	    
	    Link dl =new Link(pictures,"dl",pictures.getOwner(),0);
	    dl.addLink(x);
	    System.out.println("Size of file pointed to by dl:"+dl.getTargetSize());*/
	    
	/*	fs.getRootDir().appendChild(system);
		fs.getRootDir().appendChild(home);
		System.out.println("Size of Root:"+fs.getRootDir().getSize());
		fs.showAllElements();
		}*/	
		
	}



