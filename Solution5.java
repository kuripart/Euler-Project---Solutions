//Problem 5 - Project Euler

/*
GOAL:
Find LCM (Least Common Multiple) of numbers 1 to 20. Techniques used: PRIME FACTORISATION

LOGIC:

STEP 1:
Create a List containing elements 1 to 20
STEP 2:
Start of by checking element by element if each one is divisible by 2 (call it factor).
If it is, divide the element by 2 and replace the old element with the result of division 
by factor (that is now 2).
STEP3:
When done checkimg all 20 elements, it is now important to check if any of the elements are
still divisible by 2 (the current factor). To do so, find the product of all the elements
in the active List. If the product is still divisible by the current factor, keep the current
factor without incrementing. In the next few iteraions check if the current factor is divisible
by the previous factors.
NOTE: In LCM Method, a prime factor can be multiplied many times, till the elemets turn 1.
check_divisibility(long factor_, List divs) take care of it. Take a look for extra notes.
STEP4:
Mulitply the current factor to a new variable that will hold the final answer (Remember 
PRIME FACTORISATION). If the product is not divisible by the current factor, check if the 
currentis divisible by any of the past factors, if so, it is not a prime, hence increment 
to the next factor.
STEP4:
Check if all the elements of the list have turned 1. If so you have arrived at your final 
product, i.e; the LCM!!!!!	
*/



import java.io.*;
import java.util.*;

public class Solution5 {
	
    public static void main(String[] args) {
    	boolean all_ones = false; 
    	long product_result;
		long start = 1;
		long factor = 2;
		long factor_product = 1;
		List<Long> num = new ArrayList<Long>();
		List<Long> divs = new ArrayList<Long>();
		int size_ = 20;
		int size_check = 0;
		int count_check = 0;
		long result = 0;
		//make the list of 1 to 20
    	for(int i=0; i<size_; i++){
    		num.add(start);
    		start++;
    	}
    	//while not all elements 1
    	while(!all_ones){
    		//if factor evenly divides list's element
    		if(num.get(size_check)%factor == 0){
    			result = num.get(size_check)/factor;
    			//change element as per the result
    			num.set(size_check,result);
    		}
    		//move on to next element in the list
    		size_check++;
    		//if reached end of list
    		if(size_check == size_){
    			size_check = 0; //reset
    			//print_num(num); //DEBUG
    			//getting product of elements
    			product_result = find_product(num);
    			//if product is still divisible by current factor
    			if(product_result%factor == 0){
    				//keep the factor same;
    				if(check_divisibility(factor, divs)){
						//ignore number;
					}else{
						//mulitply to reach LCM
						factor_product*=factor;
					}
    			}else{
					if(check_divisibility(factor, divs)){
						//ignore number;
					}else{
						factor_product*=factor;
						//DEBUG
						//System.out.println(factor);
						//System.out.println(" ");
						//add factor to a separate list
						divs.add(factor); 
					}
					//next factor
    				factor++;
    				//DEBUG
    				//System.out.println(factor);
    			}
    			//check if all elements are 1
    			if(find_ones(num)){
    				all_ones = true;
    			}
    		}
    	}
    	System.out.println(factor_product); //LCM!!!!!!
    }

    //METHOD TO CHECK IF ALL ELEMENTS (1 T0 20) HAVE BECOME 1
    public static boolean find_ones(List num){
    	int count = 0;
    	long check = 0;
    	for(int i=0; i<num.size(); i++){
    		check = (long)num.get(i);
    		if(check == 1){
    			count++; //increment if element 1
    		}
    	}
    	//System.out.println(count);
    	if(count == 20){ //if all 20 elemets 1
    		return true;
    	}else{
    		return false;
    	}
    }

    //GET THE PRODUCT OF ELEMENTS IN LIST (1 TO 20)
    public static long find_product(List num){
    	long product = 1;
    	for(int i=0; i<num.size(); i++){
    			product*=(long)num.get(i);
    		}
    	return product;
	}

	//PRINTING LIST -> DEBUGING PURPOSES
	public static void print_num(List num){
		for(int i=0; i<num.size(); i++){
    		System.out.println(num.get(i));
    	}
    	System.out.println(" ");
	}

	//CHECK VIABILITY OF FACTOR
	public static boolean check_divisibility(long factor_, List divs){
		//Get current factor and the list of factors
		boolean set = false;
		boolean ok = false;
		int count = 0;
		//if the 1st factor is 2 and occurred only once
		if(factor_ == 2 && count == 0){
			set = false;
			count++;
			//System.out.println("ok");
		}else{ //for a different factor
			for(int i=0; i<divs.size(); i++){
				//if the factor is different from the other factors
				//GO AHEAD to next check!!!!
				if(factor_ != (long)divs.get(i)){
					ok = true; 
				}else{//or else no need
					ok = false;
				}
			}
			if(ok){
				//check if the number is not a prime
				//i.e; if it is divisible by other factors
				for(int i=0; i<divs.size(); i++){
					if(factor_%(long)divs.get(i) == 0){
						set = true;
					}
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

//ANS: 232792560

    	


