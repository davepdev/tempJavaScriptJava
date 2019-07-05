package com.davepdev.testdome;

import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * 
 * @author davepdev
 * score: 100%
 *
 *
 * User interface contains two types of user input controls: 
 * TextInput, which accepts all characters and NumericInput, which accepts only digits.
 * 
 * Implement the class TextInput that contains:
 * - Public method void add(char c) - adds the given character to the current value
 * - Public method String getValue() - returns the current value
 * 
 * Implement the class NumericInput that:
 * - Inherits from TextInput
 * - Overrides the add method so that each non-numeric character is ignored
 * 
 */
public class UserInput {
	public static boolean isNumeric(String str) {
		  NumberFormat formatter = NumberFormat.getInstance();
		  ParsePosition pos = new ParsePosition(0);
		  if (pos == null || str == null) return false;
		  formatter.parse(str, pos);
		  return str.length() == pos.getIndex();
		}
	
	
    public static class TextInput {
    	private char c;
    	protected String value;
    	
    	TextInput() {
    		this.value = "";
    	}
    	
    	public void add(char c) {
    		StringBuilder sb = new StringBuilder();
    		sb.append(this.value);
    		sb.append(c);
    		this.value = sb.toString();
    	}
    	
    	public String getValue() {
    		return value;
    	}
    }
    

    public static class NumericInput extends TextInput {
    	private String str;
    	public void add(char c) {
    		String charAsString = Character.toString(c);
    		if (isNumeric(charAsString)) {
    			StringBuilder sb = new StringBuilder();
        		sb.append(this.value);
        		sb.append(charAsString);
        		System.out.println(charAsString);
        		this.value = sb.toString();
    		}
			System.out.println(this.value);

    	}
    	
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
