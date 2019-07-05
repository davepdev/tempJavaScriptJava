package com.davepdev.testdome;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author davepdev
 * score: 75% - test reports issue selecting parent directories. Seems to work.
 * 
 * Write a function that provides change directory (cd) function for an abstract file system.
 * 
 */
public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void cd(String newPath) {
    	
    	if (Character.toString(newPath.charAt(0)).equals("/")   ) {
    		// root path
    		this.path = newPath;
    		return;
    	} 
    	
    	// ./ or just characters...
    	// add to current path
    	if (newPath.startsWith("./") || Character.isAlphabetic(newPath.charAt(0) )) {
    		this.path = path + "/" + newPath;
    		return;
    	}

    	if (newPath.startsWith("..")) {
    		// relative path 
	    	String[] arrPath = newPath.split("/");
	    	List<String> alp = Arrays.asList(arrPath);

	    	String[] arrWorkingDir = path.split("/");
	    	List<String> workingDir = new ArrayList<>(Arrays.asList(arrWorkingDir));
	    	
	    	for (int i = 0; i < alp.size(); i++) {
	    		System.out.println(i);
	    		System.out.println(alp.get(i));
	    		if (alp.get(i).equals("..")) {
	    			workingDir.remove(workingDir.size()-1);
	    		} else {
	    			workingDir.add(alp.get(i));
	    		}
	    		System.out.println("workingDir" + workingDir.toString());
	    		System.out.println(workingDir);
	    		
	    	}
	    	
    		this.path = workingDir.stream().collect(Collectors.joining("/"));
    		System.out.println(this.path);
    		return;
    	} 
    	
    	return;
    	//throw new UnsupportedOperationException("Input string invalid.");
    	
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
        
        path.cd("y/bird");
        System.out.println(path.getPath());

        path.cd("../../fishsnack/../dogfood");        
        System.out.println(path.getPath());
        
        System.out.println(path.getPath());

    }
}