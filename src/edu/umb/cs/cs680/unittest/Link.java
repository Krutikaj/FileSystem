package edu.umb.cs.cs680.unittest;

import java.util.Date;

public class Link extends FSElement{

    private FSElement fsElem;

		public Link(Directory parent,String name,String owner,int size){
		super(parent,name,owner,size);
		this.fsElem=new FSElement();
	}

	public Link(FSElement fs){
		this.fsElem=fs;
		
	}
	public void addLink(FSElement fs){
		this.fsElem=fs;
	}

	public void getLnkTo(){
		System.out.println(this.fsElem.getName());
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
		
	public int getSize(){
		return 0;
	}
	
	public void accept(FSVisitor v){
		v.visit(this);
	}
	
	public int getDiskUtil(){
		return 0;
	}
   
	public int getTargetSize(){
		if (this.fsElem.getSize() == 0) {
			Link link= (Link)this.fsElem;
			return link.getTargetSize();
		}
		else 
			return this.fsElem.getSize();
		
	}


		
	}
