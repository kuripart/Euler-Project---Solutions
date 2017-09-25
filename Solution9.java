//Problem 9 - Project Euler
/*
GOAL: Find Pythagorean triplets (a,b,c) such that a+b+c = 1000 (Given: a<b<c)

LOGIC:
Have 2 equations:
1) a+b+c = 1000
2) a^2 + b^2 = c^2
Solve 1) and 2) to obtain: a*b = 5*10^5 - c(10^3)
=> c<=500
We know a<b<c, hence b<=499 and a<=498
Also a>=1, b>=2 and c>=3

STEP1:
Iterate through a(s), b(s) and c(s) within the solved limits
STEP2:
Check if a+b+c = 1000
STEP3:
Then check if a^2 + b^2 = c^2
STEP4:
If both conditions match, get product
*/

import java.io.*;
import java.util.*;

public class Solution9 {
	
    public static void main(String[] args) {
    	int c_high_limit = 500;
    	int c_low_limit = 3;
    	int b_high_limit = 499;
    	int b_low_limit = 2;
    	int a_high_limit = 498;
    	int a_low_limit = 1;
    	int a_b_c_sum = 0;
    	long a_sqr = 0;
    	long b_sqr = 0;
    	long c_sqr = 0;
    	long a = 0;
    	long b = 0;
    	long c = 0;
    	long product = 0;
    	boolean done = false;

    	for(int i=c_high_limit; i>=c_low_limit; i--){
    		for(int j=a_low_limit; j<=a_high_limit; j++){
    			for(int k=b_high_limit; k>=b_low_limit; k--){
    				a_b_c_sum = i + j + k;
    				if(a_b_c_sum == 1000){ //CHECK 1
    					//System.out.println("hi");
    					a_sqr = (long)Math.pow((double)j,2);
    					b_sqr = (long)Math.pow((double)k,2);
    					c_sqr = (long)Math.pow((double)i,2);
    					if((a_sqr+b_sqr) == c_sqr){ //CHECK 2
    						a = j;
    						b = k;
    						c = i;
    						System.out.println("a:  " + a);
    						System.out.println("b:  " + b);
    						System.out.println("c:  " + c);
    						done = true;
    					}
    				}
    				if(done){
    					break;
    				}
    			}
    			if(done){
					break;
				}
    		}
    		if(done){
				break;
			}
    	}

    	product = a*b*c;
    	System.out.println(product);
    }
		
}

/*
a:  200
b:  375
c:  425
ANSWER: 31875000
*/



    	


