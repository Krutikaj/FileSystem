package edu.umb.cs.cs680.unittest;

import java.util.ArrayList;

public class FileSearchVisitor implements FSVisitor{

	private String extension;
	private ArrayList<File> foundFiles;
	
  public FileSearchVisitor (String extension){
	  this.extension=extension;
	  this.foundFiles= new ArrayList<File>();
  }
  
  

  public void visit (Link link){
	  return;
  }
  
  public void visit (Directory dir){
	  for (FSElement fElement: dir.getChildren()){
		  this.visit((File)fElement);
	  }
//		  if(fElement.getIsFile() && fElement.getSize() > 0){
		
//		  }else{
//			  continue;
//		  }
//		}
	  return;
  }
  
  public void visit (File file){
	  if(file.getName().contains(this.extension)){
		  this.foundFiles.add(file);
	  }
  }
  
  public ArrayList<File> getFoundFiles(){
	     return this.foundFiles;
	  
  }

}
