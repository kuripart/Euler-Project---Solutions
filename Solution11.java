//Problem 11 - Project Euler
/*
GOAL: FIND MAX PRODUCT OF 4 CONSECUTIVE #s : UP, DOWN, FORWARD DIAGONAL & BACKWARD DIAGONAL
STEP1:
Get the input as a string
STEP2:
Make the string mutable using a String Builder
STEP3:
Pass each character of string as an Integer in a list of Integers.
STEP4:
All are inputed as 2 digits, pass all digits from list into a 2D Array
STEP5:
Horizontal, Vertical, Diagonal searches for the max product
*/

import java.io.*;
import java.util.*;

public class Solution11 {
	
    public static void main(String[] args) {
    	//String digit_string = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48"
    	String digit_string = "08022297381500400075040507785212507791084949994017811857608717409843694804566200814931735579142993714067538830034913366552709523046011426924685601325671370236912231167151676389419236542240402866331380244732609903450244753353783684203517125032988128642367102638406759547066183864706726206802621220956394396308409166499421245558056673992697177878968314883489637221362309750076442045351400613397343133957817532822753167159403800462161409535692163905429635314755588824001754243629855786560048357189070544443744602158515417581980816805944769287392138652177704895540045208839735991607975732162626793327986688366887576220720346336746551232639353690442167338253911249472180846293240627636206936417230238834629969826759857404361620733529783190017431497148868116235705540170547183515469169233486143520189196748";
    	int size = digit_string.length();
    	StringBuilder string_mutate = new StringBuilder(digit_string);
    	List<Integer> digit_store = new ArrayList<Integer>();
    	int first = 0;
    	int second = 0;
    	int sum_digit = 0;
    	int[][] digit_array = new int[20][20];
    	for(int i=0; i<(size-1); i+=2){
    		first = Character.getNumericValue(string_mutate.charAt(i));
    		second = Character.getNumericValue(string_mutate.charAt(i+1));
    		first*=10;
    		sum_digit = first+second;
    		digit_store.add(sum_digit);
    		first = 0;
    		second = 0;
    		sum_digit = 0;
    	}
        //TEST
    	/*for(int i=0; i<digit_store.size(); i++){
    		System.out.println(digit_store.get(i));
    		System.out.println(" ");
    	}*/
    	int id = 0;
    	for(int i=0; i<20; i++){
    		for(int j=0; j<20; j++){
    			digit_array[i][j] = digit_store.get(id);
    			id++;
    		}
    	}
        //TEST
    	/*for(int i=0; i<20; i++){
    		for(int j=0; j<20; j++){
    			System.out.print(" " + digit_array[i][j] + " ");
    		}
    		System.out.println(" ");
    	}*/

        //HORIZONTAL CHECKS

    	long prdct = 1;
    	long max_prdct = Long.MIN_VALUE;
    	int total_id_count = 0;
    	int row = 0;
    	int column = 0;
        //variable to keep track of next column to start with
    	int in_col = 0;
    	int col_count = 0;
        //loop till final row
    	while(row!=20){ 
    		//System.out.println("big while");
    		in_col = column;
            //17 -> to cover 4 consecutive#s
            //check if end of row
    		while(total_id_count!=17){ 
    			//System.out.println("small while");
    			prdct*=digit_array[row][column];
    			column++;
    			col_count++; 
                //if 4 consecutive #s done with
    			if(col_count==4){ 
    				total_id_count++;
    				col_count = 0;
    				in_col ++;
    				column = in_col;
    				if(prdct>max_prdct){
    					max_prdct=prdct;
    				}
    				prdct = 1;
    			}
    		}
            //reset
    		total_id_count = 0;
    		column = 0;
    		prdct = 1;
            //go to next row
    		row++;
    	}

        //VERTICAL CHECKS

    	int row_count = 0;
        //variable to keep track of next row to start with
    	int in_row = 0; 
    	total_id_count = 0;
    	prdct = 1;
    	row = 0;
    	column = 0;
    	in_col = 0;
    	
        //loop till final column
    	while(column!=20){
    		//System.out.println("big while");
    		in_row = row;
            //check for end of column
    		while(total_id_count!=17){
    			//System.out.println("small while");
    			prdct*=digit_array[row][column];
    			row++;
    			row_count++; 
                //4 consecutive #s 
    			if(row_count==4){
    				total_id_count++;
    				row_count = 0;
    				in_row ++;
    				row = in_row;
    				if(prdct>max_prdct){
    					max_prdct=prdct;
    				}
    				prdct = 1;
    			}
    		}
            //reset
    		total_id_count = 0;
    		row = 0;
    		prdct = 1;
            //next column
    		column++;
    	}

        //RIGHT - DOWN DIAGONAL

        /*
        DIAGONALS ARE TRICKY!!!!!!

        LOGIC: 
        The longest diagonal has 20 elements, and a max of 16 checks can be done on that diagonal
        as we need to check 4 consecutive elements (16 + 4 = 20 for the final one duh.). So break
        the check at the 17th check.

        The next smaller diagonals have a breakpoint: (diagonal length - 4) + 1.
        Start with the longest diagonal, check element by element (upto 4), knowing that the next
        element is previous row + 1, previous column + 1.

        After a diagonal is done move to the next diagonal, in this case the starting row is 0, 
        hence keeing the row constant, move to the next column to iterate through the second
        largest diagonal.

        Keep repeating the same process, till you reach the diagonal that has less than 4 elemnts,
        no need to deal with that. how to find it? That's what the 1st loop takes care of. When the
        decrement value reaches 0, from initial value of 17 (the breakpoint), we know that it is the 
        end of 4 consecutive terms.

        Check for max product after getting each of the consecutive 4 terms.

        ALL THE DIAGONAL CHECKS FOLLOW THE SAME LOGIC, FORTUNATELY, HOWEVER HOW YOU ACCESS THE ELEMENTS
        DIFFER :)
        */
        int decrement = 17;
        //max diagonal length var
        int temp_diag = 20; 
        //var check if reached the end point of dialonal iteration
        int check_diag_count = 0;
        int count_consc_four = 0;
        int in_column_first = 0;
        row = 0;
        column = 0;
        //variable to keep track of next start row
        in_row = 0;
        //variable to keep track of next start column
        in_col = 0;
        prdct = 1;
        /*

        1   2   3   4   5   6

            2   3   4   5   6

                3   4   5   6

                    4   5   6

                        5   6

                            6

        */
        
        //while not the end of iterations
        //can start with 0 and end at 17 vice-versa
        while(decrement != 0){
            in_column_first = column;
            //temp_diag-3 beacuse breakpoint condition
            while(check_diag_count != (temp_diag-3)){
                prdct*=digit_array[row][column];
                row++;
                column++;
                count_consc_four++;
                //if 4 consecutive #s reached
                if(count_consc_four == 4){
                    count_consc_four = 0;
                    //next start row, just after the previous start
                    in_row++; 
                    //next start column, just after the previous start
                    in_col++;
                    check_diag_count++;
                    row = in_row; 
                    column = in_col;
                    if(prdct>max_prdct){
                        max_prdct = prdct;
                    }
                    prdct = 1; //reset product
                }
            }
            prdct = 1; //reset product
            check_diag_count = 0; //reset
            temp_diag--; //length of diagonal changes
            row = 0; //row - constant
            in_row = row; //assert it on next start row
            in_column_first++; //column change to next
            column = in_column_first; //apply to the column var to access element
            in_col = column; //assert it on next start column
            decrement--; //come closer to end loop
        }

        //LEFT - DOWN DIAGONAL

        int in_row_first = 0;
        decrement = 17;
        temp_diag = 20; 
        check_diag_count = 0;
        count_consc_four = 0;
        in_column_first = 0;
        row = 0;
        column = 0;
        in_row = 0;
        in_col = 0;
        prdct = 1;

        /*

        1   

        1   2    

        1   2    3    

        1   2    3    4   

        1   2    3    4    5  

        1   2    3    4    5   6

        */
        
        while(decrement != 0){
            in_row_first = row;
            while(check_diag_count != (temp_diag-3)){
                prdct*=digit_array[row][column];
                row++;
                column++;
                count_consc_four++;
                if(count_consc_four == 4){
                    count_consc_four = 0;
                    in_row++;
                    in_col++;
                    check_diag_count++;
                    row = in_row; 
                    column = in_col;
                    if(prdct>max_prdct){
                        max_prdct = prdct;
                    }
                    prdct = 1;
                }
            }
            prdct = 1;
            check_diag_count = 0;
            temp_diag--;
            column = 0;
            in_col = column;
            in_row_first++;
            row = in_row_first;
            in_row = row;
            decrement--;
        }

         //LEFT - UP DIAGONAL

        in_column_first = 19;
        decrement = 17;
        temp_diag = 20; 
        check_diag_count = 0;
        count_consc_four = 0;
        in_column_first = 0;
        row = 0;
        column = 19;
        in_row = 0;
        in_col = 19;
        prdct = 1;

        /*

        1   2    3    4    5    6

        1   2    3    4    5    

        1   2    3    4   

        1   2    3  

        1   2  

        1  

        */
       
        while(decrement != 0){
            in_column_first = column;
            while(check_diag_count != (temp_diag-3)){
                prdct*=digit_array[row][column];
                row++; //first row start
                column--; //last column start
                count_consc_four++;
                if(count_consc_four == 4){
                    count_consc_four = 0;
                    in_row++;
                    in_col--;
                    check_diag_count++;
                    row = in_row; 
                    column = in_col;
                    if(prdct>max_prdct){
                        max_prdct = prdct;
                    }
                    prdct = 1;
                }
            }
            prdct = 1;
            check_diag_count = 0;
            temp_diag--;
            row = 0;
            in_row = row;
            in_column_first--;
            column = in_column_first;
            in_col = column;
            decrement--;
        }





         /*

                                6

                           5    6 

                      4    5    6   

                 3    4    5    6  

            2    3    4    5    6

        1   2    3    4    5    6

        */

        //RIGHT - UP DIAGONAL

        in_row_first = 19;
        decrement = 17;
        temp_diag = 20; 
        check_diag_count = 0;
        count_consc_four = 0;
        in_column_first = 0;
        row = 19; //start with last row
        column = 0; //1st column start
        in_row = 19;
        in_col = 0;
        prdct = 1;


        
        while(decrement != 0){
            in_row_first = row;
            while(check_diag_count != (temp_diag-3)){
                prdct*=digit_array[row][column];
                row--;
                column++;
                count_consc_four++;
                if(count_consc_four == 4){
                    count_consc_four = 0;
                    in_row--;
                    in_col++;
                    check_diag_count++;
                    row = in_row; 
                    column = in_col;
                    if(prdct>max_prdct){
                        max_prdct = prdct;
                    }
                    prdct = 1;
                }
            }
            prdct = 1;
            check_diag_count = 0;
            temp_diag--;
            column = 0;
            in_col = column;
            in_row_first--;
            row = in_row_first;
            in_row = row;
            decrement--;
        }

    	System.out.println(max_prdct);
    }	
}


//ANSWER: 70600674