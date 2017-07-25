package edu.umb.cs.cs680.unittest;

import java.util.ArrayList;
import java.util.Date;

public class Directory extends FSElement {
	
	private ArrayList<FSElement> children = new ArrayList<FSElement>();

	public Directory(Directory parent,String name,String owner,int size){
		super(parent,name,owner,size);
	}
	
	public Directory(){}
	
	public ArrayList<FSElement> getChildren(){
		return this.children;
	}
	
	public void setChildren(ArrayList<FSElement> arFS){
		this.children=arFS;
		}
	
	public void appendChild(FSElement child){
		children.add(child);
		super.setIsFile(false);
		
	}
	
	public void addChild(FSElement child, int index){
		this.getChildren().add(index, child);
	}
	
	public int getSize(){
		int total=0;
		for (FSElement fElement: this.getChildren()){
			total = total + fElement.getSize();
		}
		return total;
	}
	
	public String getName() {
		return super.getName();
	}

	public Directory getParent() {
		return super.getParent();
	}
	
	public Date getCreated() {
		return super.getCreated();
	}
	
	public Date getModified() {
		return super.getModified();
	}
	
	
	
	
	public String getOwner() {
		return super.getOwner();
	}

	public void setOwner(String s) {
		 super.setOwner(s);
	}
	
	public Directory getDirectory(String dirName){
		Directory dirFound=null;

		for(FSElement fs:this.getChildren()){
		if(fs.getName().contentEquals(dirName) && fs instanceof Directory){
			//System.out.println("Found");
			dirFound=(Directory) fs;
	
			}

		}
		return dirFound;

	}
	
	public void removeDirectory(String name){
	//	System.out.println("remove the directory:"+this.getDirectory(name));
		if (this.getChildren().contains(this.getDirectory(name))){
		
		this.getChildren().remove(this.getDirectory(name));
		}
	}

	public void accept(FSVisitor v){

		v.visit(this);
	//	System.out.println("The size of children:"+this.children.size());
		for(FSElement e:children){
			e.accept(v);
		}
	}
	
	public int getDiskUtil(){
		return 0;
	}
	
	public void showAllElements(){
		int count=0;
		for(FSElement fsElement : getChildren()){
			
			if(!fsElement.getIsFile()){
				System.out.print(fsElement.getName()+"\t");							
			}
			
			else{
				System.out.print(fsElement.getName()+" ");	
			}
			count++;
			if(count==getChildren().size() && !fsElement.getIsFile()){
				System.out.println();
			}
	}
		
	  for(FSElement fs : getChildren()){
			if(!fs.getIsFile()){
				fs.showAllElements();		
				}
			
		}
	}
}
