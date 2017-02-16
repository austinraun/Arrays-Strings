/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Austin
 * Last Name: Raun
 * Lab Section: 3A
 * email address: araun@uci.edu
 *
 *
 * Assignment: lab6
 * Filename : HashTable.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

import java.io.*;
import java.util.*;

public class HashTable{
	int collisionCount;
	int hashFunctionNum;
	int TABLESIZE = 9000;
	Vector<List<String>> myTable;

	public HashTable(){
		collisionCount = 0;
		myTable = new Vector<List<String>>();
		myTable.setSize(TABLESIZE);
		hashFunctionNum = 1;
		for (int i = 0; i < TABLESIZE; i++){
			myTable.set(i, new ArrayList<String>());
		}
	}
	
	/* 
	 * Print the hash table in the following format. 
	 * Each array location will be printed on a separate line. 
	 * The line will start with the number of the array location 
	 * followed by a : and followed by one tab. You will then print
	 *  each word stored at that hash array location separated by a , 
	 *  and a single space. After all words at that hash array 
	 *  location are printed, you will output a return. 
	 *  Here is a sample of what your output should look like
	 * 
	 */
	
	void print(){
		for( int i = 0; i < TABLESIZE; i++  ){
			System.out.print(i + ":\t");
			List<String> list = myTable.get(i);
			
			for( int w = 0; w < list.size(); w++  ){
				System.out.print(list.get(w));
				System.out.print(", ");
			}
			System.out.println();	
		}
	}
	

	/*
	 * Add all of the words in the file specified as 
	 * "filename" to the hash table. Here is a sample 
	 * input file. Use push back to insert each of the
	 *  words into the list at the hash location that 
	 *  the words hashes to.
	 */
	
	void processFile(String filename){
		try{
			FileReader reader = new FileReader(new File(filename)); 
			Scanner in = new Scanner(reader);
			while (in.hasNextLine()){
	              String line = in.nextLine();
	              List<String> list = myTable.get(hash(line));
	              list.add(line);
	              if(list.size() != 1){
	            	  collisionCount ++;
	              }
	        }
		}
		catch (ArrayIndexOutOfBoundsException e){	
			
			System.out.println("Index out of bounds");
		}
		catch (FileNotFoundException e){	
			
			System.out.println("File not found");
		}
		
	}
	

	/*
	 * Print the hash statistics: total number of 
	 * collisions (keep track of this during insertions) 
	 * the length of the longest list, and the average 
	 * length of all lists.
	 */
	
	void printStats(){
		int len = 0;
		System.out.println();
		System.out.println("Total number of collisions:  " + collisionCount );
		for( int i = 0; i < TABLESIZE; i++  ){
			int size = myTable.get(i).size();
			if(size > len){
				len = size;
			}	
		}
		System.out.println("The length of the longest list: " + len);
		int j;
		double avg = 0;
		for (j=0; j < TABLESIZE; j++){
			avg += myTable.get(j).size();
		}		
		System.out.println("The average length of all lists: " + avg/TABLESIZE);
		System.out.println();
	}
	
	
	void setHashFunction(int i){
		hashFunctionNum = i;
	}
	
	int hash(String string){
		switch(hashFunctionNum){
			case 1: return hashFunction1(string);
			case 2: return hashFunction2(string);
			case 3: return hashFunction3(string);
			case 4: return hashFunction4(string);
			default: return 0;
		}
	}
	
	/*
	 * Hash Function 1:
	 * This hash function adds up the ASCII 
	 * values of the characters in the key.
	 */
	
	int hashFunction1(String string){
		int values = 0;
		int i;
		int ascii;
		int len = string.length();
		for(i = 0; i < len; i++){
			ascii = (int) string.charAt(i);
			values += ascii;
		}
		return values % TABLESIZE;
		
	}
	
	/*
	 * Hash Function 2:
	 * This hash function uses the first three characters 
	 * of the key, therefore all keys are assumed to be at 
	 * least three characters long. The value for a key k 
	 * is calculated as: k[0] + 27 * k[1] + 729 * k[2] where 
	 * 27 represents the number of letters in the English 
	 * alphabet, plus the blank, and 729 is 27^2.
	 * 
	 */
	int hashFunction2(String string){
		int values = 0;
		int ascii;
		
		ascii = (int) string.charAt(0);
		values += ascii;
		ascii = 27 * (int) string.charAt(1);
		values += ascii;
		ascii = 729 * (int) string.charAt(2);
		values += ascii;	
		return values % TABLESIZE;
	}
	
	
	/*
	 * Hash Function 3:
	 * This hash function uses all characters in the key and calculates 
	 * k[keysize - i - 1] * 37 i.
	 * You can compute this polynomial function (of 37) by using Horner's rule, for example: 
	 * h = k0 + (37 * k1) + (37^2 * k2)
	 * 
	 */
	int hashFunction3(String string)
	{
		int values = 0;
		int len = string.length();
		
		for (int i = 0; i < len; i++){
			values = values * 37 + (int)string.charAt(i);
		}
		return values % TABLESIZE;
	}
	
	/*
	 * Hash Function 4: 
	 * My own hash function that takes a String as a key
	 * My function processes the string 4 bytes at a time, 
	 * adding the 4 byte pieces together and uses modulus
	 * operator to hash to a specific spot in the table.  
	 */
	
	int hashFunction4(String string){
		int len = string.length()/4;
		long values = 0;
		long multiplier = 1;
		int i;
		int j;
		for (i = 0; i < len; i++){
			char c[] = string.substring(i * 4, (i * 4) + 4).toCharArray();
			for(j = 0; j < c.length; j++){
				values = values + c[j] * multiplier;
				multiplier = multiplier * 256;
			}
		}
		char c[] = string.substring(len * 4).toCharArray();
		multiplier = 1;
		for (int k = 0; k < c.length; k++) {
			values = values + c[k] * multiplier;
			multiplier = multiplier * 256;
		}
		return (int)values % TABLESIZE;		
	}
}
