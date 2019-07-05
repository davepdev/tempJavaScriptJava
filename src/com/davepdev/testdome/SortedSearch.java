package com.davepdev.testdome;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 
 * @author davepdev
 * score: 50% - not very efficient
 * 
 * Implement function countNumbers that accepts a sorted array of unique integers and, 
 * efficiently with respect to time used, counts the number of array elements that are 
 * less than the parameter lessThan.
 * 
 * For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 
 * because there are two array elements less than 4.
 *
 */


public class SortedSearch {
	
	
    public static int countNumbers(int[] sortedArray, int lessThan) {
    	List<Integer> list = Arrays.stream(sortedArray).boxed().collect(Collectors.toList());
    	list.sort(Comparator.naturalOrder());
    	
    	/* this works but could be faster
    	 * https://stackoverflow.com/questions/30245166/find-the-nearest-closest-value-in-a-sorted-list
    	 */
    	int i;
    	for (i = 0 ; i < list.size(); i++ ) {
    		if (list.get(i) >= lessThan) {
    			System.out.println("-x----------");
    			return i;
    		}
    	}		
    	
    //	return undefined;
		System.out.println("------xxxx-----");
    	
		return i;
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}