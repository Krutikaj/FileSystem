package edu.umb.cs.cs680.unittest;

import java.util.ArrayList;
import java.util.Collections;

public class Sort implements Command {

private String parameter;

	public Sort(String s){
		this.parameter=s;
	}
@Override
public void execute() {
	FileSystem fs=FileSystem.getFileSystem();
	ArrayList<FSElement> f=fs.getCurrent().getChildren();
	if(this.parameter.contentEquals("")){
		Collections.sort(f,new AlphabeticalComparator());
		fs.getCurrent().setChildren(f);
	}
	else if(this.parameter.contentEquals("reversealphabetical")){
		Collections.sort(f,new ReverseAlphabeticalComparator());
		fs.getCurrent().setChildren(f);
	}
	else if(this.parameter.contentEquals("timestamp")){
		Collections.sort(f,new TimeStampComparator());
		fs.getCurrent().setChildren(f);
	}	
	else{
		System.out.println("Invalid Sorting Strategy");
	}
}



@Override
public String getName() {
	return "sort";
}

}
