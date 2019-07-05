package com.davepdev.testdome;


import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author davepdev
 * score: 100%
 *
 * Using JUnit Assert class, write tests for the Account class that cover the following cases:
 * - The deposit and withdraw methods will not accept negative numbers.
 * - Account cannot overstep its overdraft limit.
 * - The deposit and withdraw methods will deposit or withdraw the correct amount, respectively.
 * - The withdraw and deposit methods return the correct results.
 */
public class AccountTest {
    private double epsilon = 1e-6;

    @Test 
    public void depositCannotAcceptNegativeNumber() {
    	Account account = new Account(20);
    	Assert.assertFalse(account.deposit(-20));
    }
    
    @Test 
    public void withdrawlCannotAcceptNegativeNumber() {
    	Account account = new Account(20);
    	Assert.assertFalse(account.withdraw(-20));
    }

    @Test
    public void accountCannotOverstepOverdraft() {
    	Account account = new Account(10);
    	// new empty account should be empty
    	Assert.assertTrue(0d == account.getBalance());

    	// should be able to withdraw overdraft limit
    	Assert.assertTrue(account.withdraw(account.getOverdraftLimit()));
    	
    	// ...but that's it.
    	Assert.assertFalse(account.withdraw(1));
    	
    }
    
    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        System.out.println(account.getBalance());
        System.out.println(account.getOverdraftLimit());
        Assert.assertTrue(account.getOverdraftLimit() == 0);
    }
    
    @Test
    public void withdrawWorks() {
    	Account account = new Account(20);
    	account.deposit(10);
    	final boolean result = account.withdraw(5);
    	Assert.assertEquals(5d,  account.getBalance(), epsilon);
    			
    	Assert.assertTrue(result);
    }

    @Test 
    public void depositWorks() {
    	Account account = new Account(10);
    	account.deposit(10);

    	final boolean result = account.deposit(5);
    	Assert.assertTrue((double)15 == account.getBalance());
    	Assert.assertTrue(result);
    }

}