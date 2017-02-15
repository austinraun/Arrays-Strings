import java.util.Arrays;

public class Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Strings are anagrams? Ex) Dormitory - Dirty Room
		String s1 = "dormitory";
		String s2 = "dirty room";
		char[] cA1 = s1.toCharArray();
		char[] cA2 = s2.toCharArray();
		
		Arrays.sort(cA1);
		Arrays.sort(cA1);
		
		
		for(int i = 0; i<cA1.length; i++){
			System.out.println(cA1);
			System.out.println(cA2);
			if(!(cA1[i] == cA2[i])){
				System.out.println("Not Anagram");
			}
		}
		
		
	}

}
