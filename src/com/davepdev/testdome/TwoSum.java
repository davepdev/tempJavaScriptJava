package com.davepdev.testdome;

/**
 * 
 * @author davepdev
 * score: 75% - performance test failed w/large list of numbers
 * hint suggests avoiding nested loops. 
 *
 ** Write a function that, when passed a list and a target sum, returns, 
 * efficiently with respect to time used, two distinct zero-based indices of any two 
 * of the numbers, whose sum is equal to the target sum. If there are no two numbers, 
 * the function should return null.
 * 
 * For example, findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10) should return a 
 * single dimensional array with two elements and contain any of the following pairs of indices:
 * 0 and 3 (or 3 and 0) as 3 + 7 = 10
 * 1 and 5 (or 5 and 1) as 1 + 9 = 10
 * 2 and 4 (or 4 and 2) as 5 + 5 = 10
*/
public class TwoSum {
	
	public static int[] loopWork(int sum, int i, int[] list ) {
		for (int x = 0; x < list.length; x++) {
			if (i != x) {
				if (sum == (list[i] + list[x])) {
					System.out.println( "did it!");
					System.out.println( list[i] + ":" + list[x]);
					System.out.println( i + ":" + x);

					return new int[] { i, x };
					
				}
				System.out.println(i + ":" + x);
			}
		}
		return null;

	}
	
	public static int[] findTwoSum(int[] list, int sum) {
		int[] retVal = null;
		for (int i = 0; i < list.length; i++) {
			retVal = loopWork(sum, i, list);
			if (retVal != null ) return retVal;
			System.out.println(list[i]);
		}
		
		
		return null;
		
		
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}