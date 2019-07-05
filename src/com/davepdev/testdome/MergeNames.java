package com.davepdev.testdome;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * @author davepdev
 * score: 100%
 *
 *
 * Implement the uniqueNames method. When passed two arrays of names, 
 * it will return an array containing the names that appear in either or both arrays. 
 * The returned array should have no duplicates.
 * 
 * For example, calling MergeNames.uniqueNames(new String[]{'Ava', 'Emma', 'Olivia'}, new String[]{'Olivia', 'Sophia', 'Emma'}) should return an array containing Ava, Emma, Olivia, and Sophia in any order.
 *
 */
public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
    	List<String> temp1 = Arrays.asList(names1);
    	List<String> temp2 = Arrays.asList(names2);
    	
    	ArrayList<String> updatableList = new ArrayList<String>();
    	updatableList.addAll(temp1);
    	updatableList.addAll(temp2);
    	
    	List<String> newList = new ArrayList<String>(new HashSet<String>(updatableList));
    	newList.sort(String::compareToIgnoreCase);
    	
    	String[] arr = new String[newList.size()];
		arr = newList.toArray(arr);
		return arr;

        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}