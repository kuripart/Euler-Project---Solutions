//Problem 7 - Project Euler

/*
GOAL: FIND THE 10001th PRIME #

LOGIC:
STEP1:
Make a list for holding primes
STEP2:
Check if a number is a prime #. Start with 2, since it is the first #, and the list to which
you add the primes is initially empty, add 2 to it.
STEP3:
Increment the prime # count whenvever a prime is added to the list
STEP4:
Keep incrementing number by number(+1), and check if it is a prime
NOTE: A # is prime if it is not divisible by any of the elements of the list.
STEP5:
When the prime count reaches 10001, stop the search. The final element of the list is your
1000th PRIME NUMBER!!!!
*/

import java.io.*;
import java.util.*;

public class Solution7 {
	
    public static void main(String[] args) {
    	int prime_count = 0;
    	int num_count;
    	List<Long> num_list = new ArrayList<Long>();
    	long prime_num = 2;
    	//search till its not the 10001th prime
    	while(prime_count!=10001){
    		if(check_prime(prime_num, num_list)){//prime check
    			//add to list if prime
    			num_list.add(prime_num);
    			prime_count++;
    			//DEBUG
    			//System.out.println(prime_num);
    		}
    		//not 10001 keep moving ahead
    		if(prime_count!=10001){
    			prime_num++;
    		}
    	}
    	System.out.println(" ");
    	System.out.println("ANSWER: " + num_list.get(10000));
    }

    //CHECK FOR PRIME
	public static boolean check_prime(long factor, List prime_list){
		boolean set = true;
		if(prime_list.isEmpty()){
			return true; //empty list, add 2 to it.
		}else{
			for(int i=0; i<prime_list.size(); i++){
				//check divisibility by other elemets in list
				if(factor%(long)prime_list.get(i) == 0){
					set = false;
					break;
				}else{
					set = true;
				}
			}
		}
		if(set){
			return true;
		}else{
			return false;
		}
	}
		
}

//ANSWER: 104743

    	


