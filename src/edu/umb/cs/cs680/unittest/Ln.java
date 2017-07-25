package edu.umb.cs.cs680.unittest;

import java.util.ArrayList;
import java.util.Arrays;

public class Ln implements Command {
    
	  private String source;
	    private String dest;
	    
	    
	    public Ln(String source,String dest){
	    	this.source=source;
	    	this.dest=dest;
	    }
		@Override
		public void execute() {
			
	//		System.out.println(this.getParam()+"  "+name);
	//		System.out.println(name);
			FileSystem fs=FileSystem.getFileSystem();
			Link l=null;
			Directory dir=fs.getCurrent();
			
			if(this.source==null){
				
				System.out.println("Invalid ln command");
				return;
			}
			else{
			
			
			if(this.source.contains("/")){
				ArrayList<String> path=new ArrayList<String>(Arrays.asList(this.source.split("/")));		
				System.out.println(path.get(0)+" -- "+path.get(1));
				for(String n:path){
				
					if(n.contains("..")){
						Directory d=dir.getParent();
						if(d!=null){
							dir=d;
							}
							else{
								System.out.println("No Such File or Directory");
							}
					}
					else{
						Directory d=dir.getDirectory(n);
						
				    	if(d!=null){
							dir=d;
							}
							else{
								System.out.println("No Such File or Directory");
							}
					}
					
				}
				l=new Link(fs.getCurrent(),".lnk",fs.getCurrent().getOwner(),0);
				System.out.println(dir.getName());
				
				l.addLink(dir);
				l.getLnkTo();
				fs.addChild(dir,l);
				return;			
	}
			else{
				if(this.source.contains("..")){
					Directory d=fs.getCurrent().getParent();
					if(d!=null){
						dir=d;
						}
						else{
							System.out.println("No Such File or Directory");
						}
				}
				else{
			
					System.out.println("Invalid ln Command");
					return;
				}
				l=new Link(fs.getCurrent(),".lnk",fs.getCurrent().getOwner(),0);
				l.addLink(dir);
				l.getLnkTo();
				fs.addChild(dir,l);
		}	
			}
		}

		
		

		@Override
		public String getName() {
			return "ln";
		}
	
}
