package edu.umb.cs.cs680.unittest;

public class CountingVisitor implements FSVisitor{

	private int dirNum=0;
	  private int fileNum=0;	
	  private int linkNum=0;	
	  
	  public CountingVisitor(){
		  super();
		  dirNum=0;
		  fileNum=0;
		  linkNum=0;
	  }
	  
	  public void visit(Link link){
		  linkNum++;
		}
	  
	  public void visit(Directory dir){
		  dirNum++;
		}
	  
	  public void visit(File file){
		  fileNum++;
		}
	
   public int getDirNum(){
  	 return this.dirNum;
   }
   
   public int getFileNum(){
  	 return this.fileNum;
   }
   
   public int getLinkNum(){
  	 return this.linkNum;
   }
}
