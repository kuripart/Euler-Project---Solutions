//Problem 4 - Project Euler

import java.io.*;
import java.util.*;

//999 * 999 = 998001
//950 * 950 = 902500
//995 * 995 = 990025
//997 * 997 = 994099
//998 * 998 = 996004 

/*
*
*
GOAL:
Have to find the the largest palindrome # from the product of two 3 digit numbers
The largest 3 digit # is 999. Its product with itself is the largest product for any two
3 digit #, therefore, the largest palindrome cannot exceed -> 999 * 999 = 998001

LOGIC: 

STEP 1:
I know the upper limit: 998001, hence I check from this upper limit whether it and the numbers 
below it are palindromes, to do this I get their reverse form. 
STEP2:
If a palindrome is obtained, that is, if the number and its reverse form match, a second check
is done. In this check, I check if numbers between 100 and 999 (3 digit #s) are factors of the 
reversed #/ palindrome. 
STEP3:
In doing the check for step 2 it is important to remeber that not only the numbers between 
100 and 999 be factors of the palindrome but also the product of the 2 obtained #s between 100
and 999 give the palindrome. 
STEP4:
Have a counter to check if 2 #s are obtained, if so, then check if their products result in the
PALINDROME!!
*
*
*/

public class Solution4 {
    public static void main(String[] args) {
    	long biggie = 0;
		long num = 999;
		biggie = (long)Math.pow(999,2);
		boolean reversed_ = false;
		long check_reverse = 0;
    	while(!reversed_){
    		//System.out.println("biggie: " + biggie);
    		check_reverse = reverse(biggie); //get the reverse of this #
    		//System.out.println("reverse: " + check_reverse);
    		if(check_reverse == biggie){ //if palindrome true
    			//System.out.println(check_reverse);
    			if(check_div(check_reverse)){ //check if 3dig #s product constraint satisied
    				reversed_ = true; //got it!!
    			}else{
    				biggie--; //keep decrementing to the next # if no satisfaction
    			}
    		}else{
    			biggie--; //if no palindrome keep decrementing 
    			//System.out.println(biggie);
    		}
    	}
    	System.out.println("Answer: " + biggie);
    }

    //check if the palindrome divisible by #s between 100 and 999.
    public static boolean check_div(long num){
    	long big = 999; //start with the highest
    	int count = 0; //need 2 #s for product
    	boolean found = false;
    	long first = 0; //1st#
    	long second = 0; //2nd#
    	while(!found && big>=100){ //the lowest # should be greater or = 100 and if !found yet
    		//System.out.println(big);
    		if(num == (long)Math.pow(big,2)){ //if squared #, then hooray!! found both the #s 
    			count = 2;
    		}else{
    			if(num%big == 0){
    				count++;
    				if(count == 1){
    					first = big; //store the 1st #
    				}
    				else if(count == 2){ //store the 2nd #
    					second = big;
    					if(first*second != num){ //check if the product give the palindrome
    					count = 0; //if not -> reset count to 0
    				}
    				}
  					//Debug statements!!
    				//big--;
    				//System.out.println("num: " + num);
    				//System.out.println("Count: " + count);
    				//System.out.println("3dig: " + big);
    			}
    		}
    		if(count == 2){
    			found = true; //got it!! break loop!!!!!
    		}
    		big--; //decremet to the next factor
    	}
    	if(found){
    		return true;
    	}else{
    		return false;
    	}
    	
    }

    //FIND THE REVERSE OF A NUMBER
    public static long reverse(long num){
    	long reversed = 0;
    	long store = 0;
    	while(num!=0){
	    	store = num%10;
	    	reversed += store;
	    	reversed *= 10;
	    	num/=10;
	    	//System.out.println(num); //debug
    	}
    	//System.out.println(reversed/10); //debug
    	return reversed/10;
    }
}

/*Count: 1
3dig: 993
num: 906609
Count: 2
3dig: 913
Answer: 906609*/

