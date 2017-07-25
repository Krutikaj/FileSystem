package edu.umb.cs.cs680.unittest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileSystem {

	private Directory directory;
	private Directory current;
	private Directory root;
	private static FileSystem fs = null;
	
	private FileSystem(){
		this.directory = new Directory(null, "root","XYZ",0);
		
	};
	
	
	
	public static FileSystem getFileSystem(){
		if(fs == null){
			fs = new FileSystem();
		}
		return fs;
	}
	
	public void setRoot(Directory root){
		this.root=root;
	}

///checkthis	
	public Directory getRootDir(){
		return this.directory;
	}
	
	public void setCurrent(Directory dir){
		this.current=dir;
	}
	
	
	public Directory getCurrent(){
		return this.current;
	}
	public ArrayList<FSElement> sort(Directory dir, Comparator<FSElement> c){
		
		ArrayList<FSElement> ar = this.getChildren(dir);
		
		Collections.sort(ar,c);
		
		return ar;
		
		
	}
	public int getInsertionLocation(Directory dir, FSElement element){
		
	ArrayList<FSElement> fsList =	this.sort(dir, new AlphabeticalComparator());	
	
	int index=0;
	int size=fsList.size();
	System.out.println(size);
	for(FSElement f1:fsList){
	AlphabeticalComparator ac=new AlphabeticalComparator();
	int res=ac.compare(f1, element);

	if(res>0){	

	return index;
	}

	index++;
	//System.out.println(i);
	}
	if(index==size){
//		this.getCurrent().appendChild(f);
		return size;
	}
	return 0;
}
	
	
	public void addChild(Directory parent,FSElement child){
		parent.addChild(child, getInsertionLocation(parent,child));
		
	}
	
	public ArrayList<FSElement> getChildren(Directory current){
		return current.getChildren();
	}
	public void showAllElements(){
		System.out.println(directory.getName());
		directory.showAllElements();
	}
	
	public FSVisitor createVisitor(Directory dir,String s, String arg){
		if (s=="CountingVisitor"){ 
			CountingVisitor visitor2 = new CountingVisitor();
	    	dir.accept(visitor2);
	    	return visitor2;
		}
		else if (s=="FileSearchVisitor" && arg!=null){ 
			FileSearchVisitor fsv = new FileSearchVisitor(arg);
			dir.accept(fsv);
			return fsv;
		}
		else 
		{
			SizeCountingVisitor visitor = new SizeCountingVisitor();
	    	dir.accept(visitor);
	    	return visitor;
		}
	}
	
	public void run(CountingVisitor v){
		
	//	CountingVisitor visitor2 = createVisitor(home),"CountingVisitor");
		System.out.println("Number of directories:"+v.getDirNum());
    	System.out.println("Number of files:"+v.getFileNum());
    	System.out.println("Number of links:"+v.getLinkNum());
		
	}
	
	public void run(FileSearchVisitor fsv,Directory dir){
		fsv.visit(dir);
	    ArrayList<File> afs=fsv.getFoundFiles();
	//    System.out.println("afs values found are:"+afs.size());
	    
	    System.out.println("The names of Files found are:");
	    	for(File f:afs){
	    	//	System.out.println("kj:entered for loop");
	    		System.out.println(f.getName());
	    	}
	}
	
	public void run(SizeCountingVisitor visitor){
		int tsize=visitor.getTotalSize();
    	System.out.println("\nSize Counting Visitor="+tsize+"\n");
	}
	
	public void init(){
	//	FileSystem fs=FileSystem.getFileSystem();
		//FSVisitor visit= new CountingVisitor();
		Directory system=new Directory(this.getRootDir(),"system",this.getRootDir().getOwner(),0);
		Directory home=new Directory(this.getRootDir(),"home",this.getRootDir().getOwner(),0);
		this.setCurrent(this.getRootDir());
		
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

		
		this.getRootDir().appendChild(system);
		this.getRootDir().appendChild(home);
		
		this.showAllElements();
		
		

	}
	
}


