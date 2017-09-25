//Problem 16 - Project Euler

/*
GOAL:
Find the sum of the digits of 2^1000

LOGIC:
Use BigInteger
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution16 {
	
    public static void main(String[] args) {
        BigInteger two = new BigInteger("2");
        BigInteger num;
        num = two.pow(1000);
        String to_string = num.toString();
        long sum = 0;
    	StringBuilder mutate_string = new StringBuilder(to_string);
    	int size = to_string.length();
    	for(int i=0; i<size; i++){
    		sum+=Character.getNumericValue(mutate_string.charAt(i));
    	}
    	System.out.println("ANSWER: "+ sum);
        //2^1000
        System.out.println(num);
    }
}

