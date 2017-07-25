package edu.umb.cs.cs680.unittest;

public class SizeCountingVisitor implements FSVisitor{

	private int totalSize=0; 
	
	public SizeCountingVisitor(){
		super();
		this.totalSize=0;
	}	
  
  public void visit (Link link){
	  this.totalSize=this.totalSize + link.getDiskUtil();
//	  System.out.println("The total size of visitor:"+totalSize);
  }
  
  public void visit (Directory dir){
	/*  for (FSElement fElement: dir.getChildren()){
			this.visit((File)fElement);
	  }*/
	  
	  this.totalSize=this.totalSize + dir.getDiskUtil();
//	  System.out.println("The total size of visitor:"+totalSize);
	  
  }
  
  public void visit (File file){
/*	  if(file.getName().contains(this.extension)){
		  this.foundFiles.add(file);
	  }*/
	  this.totalSize = this.totalSize+file.getDiskUtil();
	 // System.out.println("The total size of visitor:"+totalSize);
  }
  
  public int getTotalSize(){
	     return this.totalSize;
	  
  }

}
