package edu.umb.cs.cs680.unittest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Shell {

	public static void main(String[] args) {
		
    FileSystem fs=FileSystem.getFileSystem();
	fs.init();
	
	System.out.println("\nFileSystem has been initialized !");
		while(true){
			Scanner in =new Scanner(System.in);
		try {
		
			System.out.println();
			String command=readEntry(">",in);
			ArrayList<String> com=new ArrayList<String>(Arrays.asList(getTokens(command)));
//			System.out.println("kj:testing1");
			execute(com);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		}
	
}

public static void execute(ArrayList<String> c){
	CommandHistory ch=CommandHistory.getCommandHistory();
	
	if(c.get(0).contentEquals("cd") && c.size()==1){
		Command co=new Cd();
		
		co.execute();
		ch.push(co);
	}
	else if(c.get(0).contentEquals("cd") && c.size()>1){
		
		String s=c.get(1);
		for(int i=2;i<c.size();i++){
			s=s+" "+c.get(i);
		}
		Command co=new Cd(s);
		
		co.execute();
		ch.push(co);
	}
	
	else if(c.get(0).contentEquals("dir") && c.size()>1){
		
		String s=c.get(1);
		for(int i=2;i<c.size();i++){
			s=s+" "+c.get(i);
		}
		Command co=new Dir(s);
		co.execute();
		ch.push(co);
	}
	else if(c.get(0).contentEquals("dir")){
		Command co=new Dir();
		co.execute();
		ch.push(co);
		}
	
	else if(c.get(0).contentEquals("pwd")){
		Command co=new Pwd();
		co.execute();
		ch.push(co);
	}
	else if(c.get(0).contentEquals("ls")){
		Command co=new Ls();
//		System.out.println("kj:testing2-ls");
		co.execute();
		ch.push(co);
	}
	else if(c.get(0).contentEquals("mkdir") && c.size()>1){
		
		String s=c.get(1);
		Command co=new Mkdir(s);
		co.execute();
		ch.push(co);
		
	}
	
	else if(c.get(0).contentEquals("rmdir") && c.size()>1){
		
		String s=c.get(1);
//		for(int i=2;i<c.size();i++){
//			s=s+" "+c.get(i);
//		}
		Command co=new Rmdir(s);
		co.execute();
		ch.push(co);
	}
	
else if(c.get(0).contentEquals("ln") && c.size()>2){
		
		String s=c.get(1);
		String name="";
		 for(int i=2;i<c.size();i++){
				if(i!=c.size()-1){
				s=s+" "+c.get(i);
				}
				else{
					name=c.get(i);
				}
		 }
		Command co=new Ln(s,name);
		co.execute();
		ch.push(co);
	}
else if(c.get(0).contentEquals("ln") && c.size()>1){
		
		String s=c.get(1);
		String name=c.get(2);
		
		Command co=new Ln(s,name);
		co.execute();
		ch.push(co);
	}
	
	
else if(c.get(0).contentEquals("chown") && c.size()>1){

String s=c.get(1);
for(int i=2;i<c.size();i++){
	s=s+" "+c.get(i);
}


Command co=new Chown(s);
co.execute();
ch.push(co);
}

	else if(c.get(0).contentEquals("exit")){
		System.exit(0);
	}
	else if(c.get(0).contentEquals("redo")){
		Command co=new Redo();
		co.execute();
	}
	else if(c.get(0).contentEquals("history")){
		Command co=new History();
		co.execute();
		ch.push(co);
	}
	else if(c.get(0).contentEquals("sort") && c.size()>1){
		String s=c.get(1);
		for(int i=2;i<c.size();i++){
			s=s+" "+c.get(i);
		}
		Command co=new Sort(s);
		co.execute();
		ch.push(co);
	}
	else if(c.get(0).contentEquals("sort")){
		String s=new String();
		
		Command co=new Sort(s);
		co.execute();
		ch.push(co);
	}
	else if(c.get(0).contentEquals("visit")){
	//	String s=new String();
		
		Command co=new Visit();
		co.execute();
		ch.push(co);
	}
	else if(c.get(0).contentEquals("visitSizeCount")){
		//	String s=new String();
			
			Command co=new VisitSizeCount();
			co.execute();
			ch.push(co);
		}
else if(c.get(0).contentEquals("visitFileSearch") && c.size()>1){
	   String searchDir= c.get(1);
		String s=c.get(2);
		
		Command co=new VisitFileSearch(s,searchDir);
		co.execute();
		ch.push(co);
		
	}
/*	else if(c.get(0).contentEquals("visitFileSearch")){
			Directory dir=new Directory();
			String search = new String();
			
			Command co=new VisitFileSearch(dir,search);
			co.execute();
			ch.push(co);
		}*/
	else{
		System.out.println("Invalid Command");
	}
}



public String getNextCommand(Scanner in) throws IOException {
	String line = null;
	try {
		line = in.nextLine();
	} catch (NoSuchElementException e) { } 
	return (line != null) ? line.trim() : line;
}

public static String[] getTokens(String command) {
	return command.split("\\s+"); 
}

private int[] getIntTokens(String command) {
	String tokens[] = getTokens(command);
	int returnValue[] = new int[tokens.length];
	for (int i = 1; i < tokens.length; i++)
		returnValue[i] = Integer.parseInt(tokens[i]);
	return returnValue;
}

public static String readEntry(String prompt,Scanner in)
		throws IOException {
	System.out.print(prompt);
	String out=in.nextLine().trim();
	return out;
	
}
}
