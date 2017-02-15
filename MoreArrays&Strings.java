import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Prac {

	public static void main(String[] args) {
		
		
			Prac prac = new Prac();
				//Strings are anagrams? Ex) Dormitory - Dirty Room
				String s1 = "dormitory";
				String s2 = "dirty room";
				char[] cA1 = s1.replaceAll(" ", "").toCharArray();
				char[] cA2 = s2.replaceAll(" ", "").toCharArray();
				Arrays.sort(cA1);
				Arrays.sort(cA2);
				for(int i = 0; i<cA1.length; i++){
					if(!(cA1[i] == cA2[i])){
						System.out.println("Not Anagram");
					}
				}
				
				//Count number of matching prefixes in array of strings
				String[] sA1 = {"Hello", "Hell", "Man", "Heat"};
				String prefix1, prefix2;
				HashMap<String, Integer> hm = new HashMap<String, Integer>();
				HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
				for(int k = 0; k<sA1.length; k++){
					if(hm.containsKey(sA1[k].substring(0, 2))){
						hm.put(sA1[k].substring(0, 2), hm.get(sA1[k].substring(0, 2)) + 1);
					}else{
						hm.put(sA1[k].substring(0, 2), 1);
					}

				}
				//System.out.println(hm.toString());
				
				//Find the only 1 duplicate number in an array
				int[] intA = {1,2,3,4,5,6,7,8,9};
				HashSet<Integer> hs = new HashSet<Integer>();
				int c = 0, b = intA[0];
				Arrays.sort(intA);
				while(!(hs.contains(b)) || c == intA.length - 1){
					hs.add(b);
					c++;
					if(!(c == intA.length)){
						b = intA[c];
					}else{
						break;
					}
				}	
				if(c == intA.length){
					//System.out.println("No Repeat");
				}else{
					//System.out.println("Repeated number: " + b);
				}
		
				//Given array move all zeros to right side and keep order of others on left
				//ex) 2, 0 , 3, 1, 0, 4 --> 2, 3, 1, 4, 0, 0
				int[] arr = {2, 0 , 3, 1, 0, 4};
				int source = arr.length - 1;
				int dest = arr.length - 1;
				while (source >= 0) {
				  if (arr[source] != 0) {
				    arr[dest--] = arr[source];
				  }
				  source--;
				}
				while (dest >= 0) arr[dest--] = 0;
				//Array is now 0, 0, 2, 3, 1 , 4
				
				
				//Given 4x4 array, traverse it in a clockwise spiral pattern as shown below:
				/* 1 2 3 4
				 * 5 6 7 8
				 * 9 10 11 12
				 * 12 14 15 16
				 */
				/*
				int[][] arr2 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},  {13,14,15,16}};
				int rowLen = arr2.length;
				int directionIdx=0;
			    int curRow=0, curCol=0;
			    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
			    for(int i=0; i<rowLen*rowLen; i++){
			        System.out.print(arr2[curRow][curCol] +  " " );
			       // if(prac.shouldTurn(curRow, curCol, 4, 4)){
			       //     directionIdx = (directionIdx+1)%4;
			       // }
			        curRow += directions[directionIdx][0];
			        curCol += directions[directionIdx][1];
			    }
			    public boolean shouldTurn(int row, int col, int height, int width){
				    int same = 1;
				    if(row > height-1-row){
				    	row = height-1-row;
				    	same = 0; // Give precedence to top-left over bottom-left
				    }
				    if(col >= width-1-col){
				    	col = width-1-col;
				    	same = 0; // Give precedence to top-right over top-left
				    }
				    row -= same; // When the row and col doesn't change, this will reduce row by 1
				    if(row==col) return true;
				    return false;
				}
			    */
			    
				//Arrange an array backwards
				int[] intArry2 = {1,2,3,4,5};
				Stack<Integer> stack = new Stack<Integer>();
			    int temp = 0;
			    int last = intArry2.length -1 ;
			    int i =0;
				while(!(i==last)){
					temp = intArry2[i]; //get first first swap value
					intArry2[i] = intArry2[last];
					intArry2[last] = temp;
					i++;
					last--;
									
				}
			    for(int j=0; j< intArry2.length; j++){
			    	//System.out.print(intArry2[j] + " " );
			    }
			    
			    
			    
			    

	}
	
	


}
