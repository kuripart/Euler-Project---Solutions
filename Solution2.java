//Problem 2 - Project Euler

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
    	int sum = 0;
    	int total = 0;
    	int i = 0;
    	int first, second;
    	first = 0;
    	second = 0;
        while(sum<=4000000){
        	if(i==0){
        		first = i+1;
        		second = first+1;
        		total+=second;
        	}
        	else{
        		sum = first + second;
        		if(sum % 2 == 0){
        			total+=sum;
        		}
        		first = second;
        		second = sum;
        	}
        	i++;
        }
        System.out.println(total);  
    }
}