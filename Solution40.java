//Problem 40 - Project Euler
//Champernowne's constant

/*
GOAL:
For
x = 0.1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21....
FIND:
d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
where dn stands for each digit after 0. in x

LOGIC:
"Takes a little more than a minute"
Iterate till a max #, by trial and error found 185500, such that you can add each digit
as a string to a string to obtain a larger STRING! Get the length of string, if it is 
1000000 or more than it, you are done. Get the 1st, 10th, 100th,.....,1000000th character
of the string and multiply them to get your ANSWER!!!
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

//0.1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 
//d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

public class Solution40 {
	
    public static void main(String[] args) {
        long elements_num = 1;
        long elements = 1;
        String temp_string;
        String store_string = "";
        long prdct = 1;

        while(elements!=185500){
            if(elements == 1){
                store_string = Long.toString(elements);
            }else{
                temp_string = Long.toString(elements);
                store_string+=temp_string;
            }
            elements++;
        }
        //System.out.println(store_string);
        System.out.println("LEHGTH: " + store_string.length());

        StringBuilder mutate_string = new StringBuilder(store_string);

        for(int i=0; i<7; i++){
            prdct*=Character.getNumericValue(mutate_string.charAt((int)elements_num - 1));
            elements_num*=10;
        }
        System.out.println("ANSWER: " + prdct);

    }
}

//LEHGTH: 1001889
//ANSWER: 

