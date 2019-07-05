package com.davepdev.testdome;


/**
 * 
 * @author davepdev
 * score 100%
 *
 * A palindrome is a word that reads the same backward or forward.
 * 
 * Write a function that checks if a given word is a palindrome. Character case should be ignored.
 * 
 * For example, isPalindrome("Deleveled") should return true as character case should be ignored, 
 * resulting in "deleveled", which is a palindrome since it reads the same backward and forward.
 *
 */
public class Palindrome {
	
    public static boolean isPalindrome(String word) {
    	String forward = word.toLowerCase();
        String backward = new StringBuilder(forward).reverse().toString();
                
        if (forward.equals(backward)) {
            return true;
        }
        return false;
        // throw new UnsupportedOperationException("Waiting to be implemented.");
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}