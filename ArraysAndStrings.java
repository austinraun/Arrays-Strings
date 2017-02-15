import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraysAndStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Need to call class to make dynamic method calls
		ArraysAndStrings ss = new ArraysAndStrings();

		String s1 = "abce";
		char[] cA1 = s1.toCharArray();
		String s2 = "abcde";
		char[] cA2 = s2.toCharArray();
		String palindomePermutation = "tact coa";
		
		char[] aa = cA2.clone();
		
		System.out.println(ss.oneAway(s1, s2));
		
		
	}

	boolean oneAway( String s1, String s2){
		
		boolean foundDifference = false;
		if(s1.length() == s2.length()){
			foundDifference = oneEditAway(s1, s2);
		}else if(s1.length() == s2.length() + 1){
			foundDifference = oneInsertAway(s1, s2);
		}else if(s1.length() + 1 == s2.length()){
			foundDifference = oneInsertAway(s2, s1);
		}else{
			return false;
		}
		return foundDifference; 
	
	}
	
	boolean oneEditAway(String s1, String s2){
		boolean foundDifference = false;
		for(int i = 0; i< s1.length(); i++){
			if(!(s1.charAt(i) == s2.charAt(i))){
				if(foundDifference){
					return false;
				}else{
					foundDifference = true;
				}
			}
		}
		return true;
	}

	boolean oneInsertAway(String s1, String s2){
		boolean foundDifference = false;
		int x = 0;
		int y = 0;
		System.out.println(s1.length());
		System.out.println(s2.length());
		while(x < s1.length() && y < s2.length()){
			System.out.println(s1.charAt(x) + " , " + s2.charAt(y));
			if(!(s1.charAt(x) == s2.charAt(y))){
				if(!(x==y)){
					return false;
				}
				
				y++;
			}else{
				x++; 
				y++;
			}
		}
		return true;
	}
	
	
	
	
	
}


/*
//1.1 - All unique chars in a string
		String str = "mxNAustinRow";
		
		Set<Character> hs = new HashSet<Character>();
		for(int i = 0; i< str.length(); i++){
			
			if(hs.contains(str.charAt(i))){
				System.out.println("false"); 
			}else{
				hs.add(str.charAt(i));
			}
			
		}

//1.2 - Check permutation of string - use same characters & same length 
		String str1 = "dog";
		String str2  ="gdo";
		char[] cA1 = str1.toCharArray();
		char[] cA2 = str2.toCharArray();
		Arrays.sort(cA1);
		Arrays.sort(cA2);
		String s1 = new String(cA1);
		String s2 = new String(cA2);
		System.out.println(s1.equals(s2));

//1.3 - URLify %20 %20 for spaces
 String ss = "dogs are fun    ";
		char[] s = ss.toCharArray();
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
		System.out.println( newCharArray);
 
 
 //1.4 perm palindrome
  boolean isPermutationOfPalindrome(String phrase){
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	public int getCharNumber(char ch){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(ch);
		
		if( a<=  val && val <= z){
			return val - a;
		}
		return -1; 
		
	}
	
	public int[] buildCharFrequencyTable(String str){
	
		char[] cA1 = str.toCharArray();
		Arrays.sort(cA1);

	
		
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for( char ch: str.toCharArray()){
			int x = getCharNumber(ch);
			if(x != -1){
				table[x]++;
			}
		}
		return table;
}
	public boolean checkMaxOneOdd(int[] table){
		boolean foundOdd = false;
		for(int count : table){
			if (count %2 == 1){ // checking all values (but one) are even
				if (foundOdd){
					return true;
				}else{
					foundOdd = true;
				}
			}
		}
		return true;
	}
	
	
//1.5 One away
 	
 
 
	
  
  
  
  
  
  
  
 

*/