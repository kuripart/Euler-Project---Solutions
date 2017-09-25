//Problem 12 - Project Euler


/*
GOAL:
FIND 1STTRIANGLE NUMBER MORE THAN 500 DIVISORS

LOGIC:
STEP1:
Use formula to find sum of n numbers: n(n+1)/2
STEP2:
FInd # of divisors of sum n
STEP3:
Sum whose divisors are more than 500, that is thw answer.
*/

import java.io.*;
import java.util.*;

public class Solution12 {
	
    public static void main(String[] args) {
        long summed = 1;
        long start = 1;//29021;
        boolean done = false;
        while(!done){
            summed = (start*(1+start))/2;
            //System.out.println(summed);
            if(check_divisor_count(summed)){
                done = true;
                System.out.println("UPTO: "+start);
            }else{
                start++;
            }

        }
        System.out.println("ANSWER: " + summed);

    	
    }	

    /*

Let's say m = sqrt(n) then m × m = n. Now if n is not a prime then n can be written as n = a × b, so m × m = a × b. 
Notice that m is a real number whereas n, a and b are natural numbers.
Now there can be 3 cases:

a > m ⇒ b < m
a = m ⇒ b = m
a < m ⇒ b > m

In all 3 cases, min(a, b) ≤ m. Hence if we search till m, we are bound to find at least one factor of n, 
which is enough to show that n is not prime.

    */

    //CHECK DIVISIBILITY
    public static boolean check_divisor_count(long summed_num){
        int divisor_count = 0;
        for(int i=1; i*i<=summed_num; i++){
            if(summed_num%i == 0){
                //NOT SURE HOW THE MATH WORKS HERE??
                if(i*i<summed_num){
                    divisor_count+=2;
                }else{
                  divisor_count++;  
                }                
            }
        }
        if(divisor_count > 500){
            return true;
        }else{
            return false;
        }
    }
}


// ANSWER: 76576500
