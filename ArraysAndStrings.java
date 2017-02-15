import java.util.Arrays;
import java.util.HashMap;

public class ArraysAndStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Need to call class to make dynamic method calls
		ArraysAndStrings ss = new ArraysAndStrings();
		
		String s1 = "wow";
		char[] cA1 = s1.toCharArray();
		String s2 = "oww";
		char[] cA2 = s2.toCharArray();
		
		
		
	}
	
	
}



//1.1 Determine if a String has all unique characters
String string = "Hellomynmeisaustinrun!";
char[] ss = string.toCharArray();
Arrays.sort(ss);
System.out.println(ss);
for(int i = 0; i< ss.length; i++){
	char temp = ss[i];
	int j = i + 1;
	if(temp == ss[j]){
		System.out.println("Match: '" + temp + "'");
		break;
	}
	j++;
}

//1.2 Determine if 2 strings are "Permutations" of one another - aka same size + values
String s1 = "world";
String s2 = "rlwod";
char[] cA1 = s1.toCharArray();
char[] cA2 = s2.toCharArray();
Arrays.sort(cA1);
Arrays.sort(cA2);
if(cA1.length == cA2.length){
	for(int i = 0; i< cA1.length; i++){
		if(cA1[i] != cA2[i]){
			System.out.println("Fail");
			break;
		}
	}
	System.out.println("Pass");
}else{
	System.out.println("Fail");
}


	//1.3Replace all spaces in char sequence with '%20'
	public char[] replaceSpaces(char[] s){
		int spaceCount = 0;
		for(int i = 0; i < s.length; i++){
			if(s[i] == ' '){
				spaceCount++;
			}
		}
		int newLen = s.length + spaceCount * 2;
		char[] newCharArray = new char[newLen];
		int k = 0;
		for(int j = 0; j < s.length; j++){
			if(s[j] == ' '){
				newCharArray[k] = '%';
				newCharArray[k+1] = '2';
				newCharArray[k+2] = '0';
				k+=3;
			}else{
				newCharArray[k] = s[j];
				k++;
			}
		}
		return newCharArray;
	}

	//1.4 Function to check if string is a Palindrome (same fwd and bkwrds)
	public boolean palindrome(char[] cA1){
		int j = cA1.length - 1; //KEY: if j = 3 then we want cA[2]
		for(int i=0; i< cA1.length /2; i++){
			if(cA1[i] != cA1[j]){
				return false;
			}
			j--;
		}
		return true;
	}
	
	//1.5 Given 2 strings see if they are 1 edit away (Ex: pale, pal --> true | pale, bale --> true | pale, bake --> false
	public boolean compare(char[] cA1, char[] cA2){
		int count = 0;
		int i1 = 0, i2 =0;
		while(i1 < cA1.length && i2 <cA2.length){
			if(cA1[i1] == cA2[i2]){
				i1++;
				i2++;
			}else{
				count++;
				i1++;
			}
			if(count > 1){
				return false;
			}
		}
		return true;
	}
	public boolean oneEditAway(char[] cA1, char[] cA2){
		if(cA1.length == cA2.length){
			return compare(cA1, cA2);
		}else if (cA2.length + 1 == cA1.length){
			return compare(cA1, cA2);
		}else if(cA1.length + 1 == cA2.length){
			return compare(cA2, cA1);
		}else{
			return false;
		}
	}
	
	
	//1.6 String compression (Ex: aaabbbcc returns a3b3c2) or returns original string if compressed string contains more characters
	public String compressString(String s1){
		StringBuilder sb = new StringBuilder();
		char[] cA1 = s1.toCharArray();
		Arrays.sort(cA1);
		System.out.println(cA1);
		int i = 0;
		char temp = cA1[i];
		int count = 1;
		for(i=1; i< cA1.length;i++){
			if(temp == cA1[i])
				count++;	
			else{
				sb.append(temp);
				sb.append(count);
				temp = cA1[i];
				count = 1;
			}
		}
		sb.append(temp);
		sb.append(count);
		if(s1.length() > sb.length())
			return sb.toString();
		else
			return s1;
	}
	
	//1.7 Rotate Matrix: Gven an image rep by an NxN matrix, where each pixel in the image is 4 bytes, write a method to 
	//rotate the image by 90 degrees. Can you do this in place?
	//ex) int[][] matrix = new int[][] {{1,2,3,4}, {5,6,7,8} ,{9,10,11,12}, {13,14,15,16}};
	// |x|y|z|x2|
	// | | | |y2|
	// | | | |z2|
	// | | | |  |
	public int[][] rotateMatrix(int[][] matrix){
		int[][] matrixRot = new int[matrix.length][matrix.length];
		
		int n = matrix.length;
		for(int layer =0 ; layer< n/2; layer++){//Starting from outtermost layer we work inwards
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i< last; i++){
				int offset = i - first; // = 0, 1, 2 
				int top = matrix[first][i]; //save top for last update     = [0][0], [0][1], [0][2], 
				//left -> top
				matrix[first][i] = matrix[last-offset][first];   // matrix[0][0] = matrix[3-0][0], [0][1] = [2][0], [0][2] = [1][0]
				//bottom -> left
				matrix[last-offset][first] = matrix[last][last-offset]; //matrix[3-0][0] = matrix[3][3], [2][0] = [3][2], [1][0] = [3][1]
				//right -> bottom
				matrix[last][last-offset] = matrix[i][last]; // matrix[3][3-0] = [0][3], [3][2] = [1][3], [3][1] = [2][3]
				//top -> right
				matrix[i][last] = top; //matrix[0][3] = [0][0], [1][3] =[0][1], [2][3] = [0][2]
				
			}
		}
		return matrix;
	}
	
	//1.8 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
	//ex) int[][] matrix = new int[][] {{1,2,3}, {0,6,7} ,{9,10,11}, {13,14,15}};
	// |1|2|3| --> |0|2|3|
	// |0|5|6| --> |0|0|0|
	// |7|8|9| --> |0|8|9|
	// |1|1|1| --> |0|1|1|
	public int[][] zeroMatrix(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		for(int i = 0; i< matrix.length; i++){ //first find all rows & columns that will be made null
			for(int j = 0; j< matrix[0].length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int k = 0; k< row.length;k++){//null rows
			if(row[k])
				nullRow(matrix, k);
		}
		for(int m = 0; m< column.length;m++){//null columns
			if(column[m])
				nullColumn(matrix, m);
		}
		return matrix;
	}
	public void nullRow(int[][] matrix, int row){
		for(int i = 0; i< matrix[0].length; i++) //for each column_space in a row set = 0
			matrix[row][i] = 0;
	}
	public void nullColumn(int[][] matrix, int column){
		for(int i = 0; i< matrix.length; i++)//for each row_space in a column set = 0
			matrix[i][column] = 0;
	}
	
	//1.9 Check if one word is substring of another, we have isSubString function. Check if s1 is rotation of s2 
	//ex) waterbottle is a rotation of terbottlewa
	public boolean isRotatedSubString(String s1, String s2){
		if(s1.length() == s2.length() && s1.length() >0){ //if same length && s1 != 0
			String s1s1 = s1+s1;
			isSubString(s1s1, s2);
		}
		return false;
	}	
		
	
