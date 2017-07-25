package edu.umb.cs.cs680.unittest;

import java.util.Date;

public class File extends FSElement {

	public File(Directory parent,String name,String owner, int size){
		super(parent,name,owner,size);
		
	}
    
	public Directory getParent() {
		return super.getParent();
	}

	public String getName() {
		return super.getName();
	}

	public String getOwner() {
		return super.getOwner();
	}

	public int getSize() {
		return super.getSize();
	}
	public Date getCreated() {
		return super.getCreated();
	}
	public Date getModified() {
		return super.getModified();
	}
	
	public void accept(FSVisitor v){
		v.visit(this);
	}
	
	public int getDiskUtil(){
		return this.getSize();
	}
}


