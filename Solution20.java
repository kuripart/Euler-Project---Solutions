//Problem 20 - Project Euler

/*
GOAL:
For the result of 100!, find the sum of the digits of the result.

LOGIC:
STEP1:
Create an array of BigInteger of size 100 and an array of Strings of size 100
STEP2:
Fill in the String array with 1,2....till 100
STEP3:
Intialize new BigInteger objects from each element of BigInteger Array:
i.e; BigIntegerArray[i] = new BigInteger(StringArray[i]);
STEP4:
Multiply each element of BigInteger Array, which are BigInteger themselves and
store them in a BigInteger
STEP5:
Convert the final product to a string, then to a mutable string using a String Builder
STEP6:
Access each character of the mutable string, convert it to a numneric value and obtain 
the SUM!!!!! 
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution20 {
	
    public static void main(String[] args) {
        BigInteger[] factorial = new BigInteger[100];
        BigInteger temp = BigInteger.ONE;
        int temp_;
        long sum = 0;
        String hold_prdct;
        String[] num_hold = new String[100];
        for(int i=0; i<100; i++){
            temp_ =  i+1;
            num_hold[i] = Integer.toString(temp_);
        }
        for (int i=0; i<100; i++) {
            factorial[i] = new BigInteger(num_hold[i]); //array of BigInteger objects
        }
        for (int i=0; i<100; i++ ) {
            temp = temp.multiply(factorial[i]);
        }
        //100!
        System.out.println(temp);
        hold_prdct = temp.toString();
        long size = hold_prdct.length();
        StringBuilder mutate_string = new StringBuilder(hold_prdct);
        for (int i=0; i<size; i++) {
            sum+=Character.getNumericValue(mutate_string.charAt(i));
        }
        System.out.println(sum);
    }
}