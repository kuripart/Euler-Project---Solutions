//Problem 14 - Project Euler

/*
GOAL:
(Collatz Problem)
Do the following with the numbers below 1,000,000:
n → n/2 (n is even)
n → 3n + 1 (n is odd)
Till you reach 1

LOGIC:
STEP1:
Initially start with 1, apply the rules till you reach 1, on each application of the rule have a counter
STEP2:
Move to the next number, repeat step 1.
STEP3:
Compare the counts, and get the number that gave the max count.
*/

import java.io.*;
import java.util.*;

public class Solution14 {
	
    public static void main(String[] args) {
    	long counter = 0;
    	long big_count = Long.MIN_VALUE;
    	long final_num = 0;
    	long test_num = 1;
    	long store = 0;
    	long intial_start = 1;
  		while(intial_start<1000000){
  			//do not touch the starting number
  			//test with a test number
  			test_num = intial_start;
  			//loop with rules
  			while(final_num!=1){
	    		if(test_num%2 == 0){
	    			test_num/=2;
	    			final_num = test_num;
	    			counter++;
	    		}else{
	    			test_num = 3*(test_num) + 1;
	    			final_num = test_num;
	    			counter++;
	    		}
    		}
    		if(counter>big_count){
    			big_count = counter;
    			//get the number with max count
    			store = intial_start;
    		}
    		//reset
    		final_num = 0;
    		counter = 0;
    		//go to next number
    		intial_start ++;
  		}
  		System.out.println("ANSWER: " + store);
    }
}


// ANSWER: 837799
