//Problem 8 - Project Euler

/*
GOAL: 
FIND THE HIGHEST PRODUCT OF 13 CONSECUTIVE DIGITS IN THE PROVIDED LONG DIGIT

LOGIC:
STEP1:
Assign a string the big number
STEP2:
Make the string mutable using a String Builder
STEP3:
Convert each character of the string into an Integer and store in a List
STEP4:
Loop through 13 elements and find product of them
STEP5:
Compare products to find answer



*/



import java.io.*;
import java.util.*;

public class Solution8 {
	
    public static void main(String[] args) {
    	
	    String big_digit = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";	
		int string_size = big_digit.length();
		StringBuilder digit_mutate = new StringBuilder(big_digit);
		int initial = 0;
		long product = 1;
		long max_product = Long.MIN_VALUE;
		Character char_digit;
		int get_digit = 0;
		List<Integer> store_digits = new ArrayList<Integer>();
		for(int i=0; i<string_size; i++){
			char_digit = digit_mutate.charAt(i);
			get_digit = Character.getNumericValue(char_digit);
			store_digits.add(get_digit);
		}
		for(int i=0; i<(store_digits.size() - 13); i++){
			initial = i;
			//iterate through 13 elements
			for(int j=initial; j<(initial+13); j++){
				product*=(long)store_digits.get(j);
				//System.out.println(product);
			}
			if(product>max_product){
				max_product = product;
			}
			//reset product
			product = 1;
		}
		System.out.println(max_product);
	}
		
}

//ANSWER: 23514624000


    	


