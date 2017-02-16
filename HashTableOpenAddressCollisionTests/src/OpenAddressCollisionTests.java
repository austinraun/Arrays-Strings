/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Austin
 * Last Name: Raun
 * Lab Section: 3A
 * email address: araun@uci.edu
 * ph
 *
 * Assignment: lab6
 * Filename : OpenAddressCollisionTests.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

import java.util.Vector;
import java.util.Random;


public class OpenAddressCollisionTests
{
	int TABLESIZE = 9000;
	Vector<String> myTable;

	public OpenAddressCollisionTests(){
		myTable = new Vector<String>();
		myTable.setSize(TABLESIZE);
	}
	
	int hashFunction(){
		//Randomly generate an input sequence of integer keys
		Random rand = new Random();
		return rand.nextInt(TABLESIZE);
	}

	int testFunction(int probeNum, double num){
		int i = 0;
		int collisionCount = 0;
		int probe;
		int size = (int)(TABLESIZE * num);
		
		for (i = 0; i < TABLESIZE; i++){
			myTable.set(i, null);
		}
		
		for (i = 0; i < size; i++){
			int counter = 0;
			int hash = hashFunction();
			int newHash = hash;
			
			while (myTable.get(newHash) != null){
				probe = 1;
				counter++;
				collisionCount++;
				
				switch(probeNum){
					case 1: probe = counter;
					case 2: probe = counter*counter;
					case 3: probe = counter*counter*counter;
				}
				newHash = ((hash + probe) % TABLESIZE);
			}
			myTable.set(newHash, "");
		}
		return collisionCount;
	}
}