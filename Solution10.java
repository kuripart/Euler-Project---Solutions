//Problem 10 - Project Euler
/*
GOAL:
SUM OF ALL PRIMES BELOW 2,000,000

LOGIC:
STEP1:
Start with prime 2. Check if a # is prime, and add to list
STEP2:
Keep adding primes till # 2,000,000 reached
*/


import java.io.*;
import java.util.*;

public class Solution10 {
	
    public static void main(String[] args) {

        long big = 2000000L;
        List<Long> prime_list = new ArrayList<Long>();
        long prime_num = 2;
        long big_sum = 0;
        while(prime_num!=big){
            if(check_prime(prime_list, prime_num)){
                prime_list.add(prime_num);
                System.out.println(prime_num);
                big_sum += prime_num;
            }
            prime_num++;
        }
        System.out.println("ANSWER: "+big_sum);
    	
    }

    //CHECL PRIME
    public static boolean check_prime(List primes_list, long prime){
        boolean done = true;
        if(primes_list.isEmpty()){
            return true;
        }else{
            for(int i=0; i<primes_list.size(); i++){
                if(prime%(long)primes_list.get(i) == 0){
                    done = false;
                    break;
                }else{
                    done = true;
                }
            }
        }
        if(done){
            return true;
        }else{
            return false;
        }
    }
		
}

//ANSWER: 142913828922




    	


