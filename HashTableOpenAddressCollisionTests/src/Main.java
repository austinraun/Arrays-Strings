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
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class Main
{
	public static void main(String[] args){
		
		if (args.length != 1){
			System.out.println("Invalid # of arguments");
		}
		
		OpenAddressCollisionTests collisionTests = new OpenAddressCollisionTests();
		
		HashTable hashTable1 = new HashTable();
		HashTable hashTable2 = new HashTable();
		HashTable hashTable3 = new HashTable();
		HashTable hashTable4 = new HashTable();
		
		System.out.println("Before processing file:");
		System.out.println();
		hashTable1.print();
		hashTable1.printStats();
		hashTable1.processFile(args[0]);
		System.out.println();
		System.out.println("After processing file:");
		System.out.println("F1:");
		System.out.println();
		hashTable1.print();
		hashTable1.printStats();
		

		
		System.out.println();
		System.out.println();
		hashTable2.setHashFunction(2);
		hashTable2.processFile(args[0]);
		System.out.println();
		System.out.println("F2:");
		System.out.println();
		hashTable2.print();
		hashTable2.printStats();
		
	
		System.out.println();
		System.out.println();
		hashTable3.setHashFunction(3);
		hashTable3.processFile(args[0]);
		System.out.println();
		System.out.println("F3:");
		System.out.println();
		hashTable3.print();
		hashTable3.printStats();

		System.out.println();
		System.out.println();
		hashTable4.setHashFunction(4);
		hashTable4.processFile(args[0]);
		System.out.println();
		System.out.println("F4:");
		System.out.println();
		hashTable4.print();
		hashTable4.printStats();

		
		int i;
		for (i = 1; i <= 3; i++){
			int j;
			int collisions;
			double[] percent = new double[4];
			percent[0] = 0.25;
			percent[1] = 0.5;
			percent[2] = 0.75;
			percent[3] = 0.90;
			
			for (j = 0; j < 4; j++){
				
				collisions = collisionTests.testFunction(i, percent[j]);
				
				if (i == 1){
					System.out.println("Linear collisions at " + percent[j]*100 + "%: " + collisions);	
				}
				else if (i == 2){
					System.out.println("Quadratic collisions at " + percent[j]*100 + "%: " + collisions);	
				}
				else if (i == 3){
					System.out.println("Cubic collisions at " + percent[j]*100 + "%: " + collisions);					
					
				}
			}
			System.out.println();
			
		}
	}
}
