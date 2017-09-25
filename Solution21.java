//Problem 21 - Project Euler

/*
GOAL:
AMICABLE # :
Consider a number A:
Let the sum of its divisors (all divisors below A) be B; where A != B
Then, if the sum of all divisors of B (divisors below B) = A, A & B are
an amicable pair.
LOGIC:
STEP1:
Iterate from 1 till 10000, find all divisors below a given #, and sum them up
STEP2:
Check if the sum of the divisors != the # itself, in that case check if the 
sum of the divisors is a amicable pair of the #, that is, find all the divisors 
of the sum of the divisors of the 1st #
STEP3:
Add all the #s obtained from STEP1 & STEP2
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution21 {
	
    public static void main(String[] args) {
        long sum = 0;
        long big_sum = 0;
        for (long i=1; i<10000; i++) {
            for (long j=1; j<10000; j++) {
                if(j>i){
                    break;
                }else{
                    if(i!=j){
                        if(i%j == 0){
                            sum+=j;
                        } 
                    }  
                } 
            }if (sum!=i) {
                if(check_amicability(i,sum)){
                    big_sum+=sum;
                }
            }
            sum = 0;
        }
        System.out.println("ANSWER: "+ big_sum);
    }

    public static boolean check_amicability(long num, long sum_num){
        long sum_store = 0;
        for (long i=1; i<10000 ;i++) {
            if(sum_num<i){
                    break;
            }else{
                if(i!=sum_num){
                    if(sum_num%i == 0){
                        sum_store+=i;
                    } 
                }  
            }
        }
        if(sum_store == num){
            System.out.println(sum_store);
            return true;
        }else{
            return false;
        }
    }
}


