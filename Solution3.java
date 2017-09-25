//Problem 3 - Project Euler

//NUMBER THEORY
//Any integer greater than 1 is either a prime number, 
//or can be written as a unique product of prime numbers (ignoring the order).

import java.io.*;
import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
    	long big = 600851475143L;
        long start = 2;
        long count = 2;
        /*LOGIC:
        *
        *
        *
        Since every number can be expressed as a product of primes, divide the number incrementaly
        ie, e.g: 30, start by dividing with 2, keep dividing by 2, until you cant, increment to  next
        divisor i.e; 3; divide the previously obtained result; that couldn't be divided by 2; with 3
        continue the process; eventually you will reach the largest divisor; which should be a prime;
        result = 1, end is reached. 
        *
        *
        */
        while(big!=1){
            if(big%count == 0){
                big = big/count;
            }else{ //if not divisible
                count++;
            }
        }
        System.out.print(count);
    }
}

//tests!!


//12
//12/2
//6
//6/2
//3
//3/3
//1


//30
//30/2
//15
//15/3
//5
//5/5
//1
