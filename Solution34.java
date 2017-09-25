//Problem 34 - Project Euler

/*
GOAL:
Find sum of the #s, whose factorial digits sum up to be the number itself

LOGIC:
STEP1:
Get an upper bound (found it with the help of Wikipedia: Factorian)
EXPLANATION:
If n is a natural number of d digits that is a factorion, then 10d − 1 ≤ n ≤ 9!d. 
This fails to hold for d ≥ 8 thus n has at most 7 digits, and the first upper bound is 9,999,999. 
But the maximum sum of factorials of digits for a 7 digit number is 9!*7 = 2,540,160 establishing 
the second upper bound. Going further, since no number bigger than 2540160 is possible, 
the first digit of a 7 digit number can be at most 2. Thus, only 6 positions can range up until 9 and 2!+6*9!= 2177282 
becomes a third upper bound. This implies, if n is a 7 digit number, either the second digit 
is 0 or 1 or the first digit is 1. If the first digit is 2 and thus the second digit is 0 or 1, 
the numbers are limited by 2!+1!+5*9! = 1814403 - a contradiction to the first digit being 2. 
Thus, a 7-digit number can be at most 1999999, establishing our fourth upper bound.
STEP2:
Iterate till 3, find out which number is a factorian, by find factorail of 
each digit and then summing up the factorials.
STEP3:
Sum up the factorians
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution34 {
    public static void main(String[] args) {
        //CREDITS TO WIKIPEDIA FOR UPPER BOUND
    	long upper_bound = 1999999;
        long mega_factorial_sum = 0;
        for(long i=upper_bound; i>144; i--){
            //System.out.println(i);
            //numbers are: 40585 and 145
            if(find_factorian(i)){
                //System.out.println(i);
                mega_factorial_sum+=i;
            }
        }
        System.out.println("ANSWER: " + mega_factorial_sum);
    }

    public static boolean find_factorian(long num){
        long factorial_sum = 0;
        String num_string = Long.toString(num);
        int size = num_string.length();
        StringBuilder mutate_string = new StringBuilder(num_string);
        //String test = mutate_string.toString();
        //System.out.println(test);
        for(int i=0; i<size; i++){
            factorial_sum+=find_factorial(Character.getNumericValue(mutate_string.charAt(i)));
        }
        if(factorial_sum == num){
            return true;
        }else{
            return false;
        }
    }

    public static long find_factorial(int fact_num){
        long factorial = 1;
        if(fact_num == 0){
            return factorial;
        }else{
            for (int i=fact_num; i>0 ;i--) {
                factorial*=(long)i;
                //System.out.println(factorial);
            } 
        }
        return factorial;    
    }
}

//ANSWER: 40730