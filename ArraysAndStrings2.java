import java.util.HashSet;
import java.util.Set;

public class ArraysAndStrings2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "AustinRow";
		
		Set<Character> hs = new HashSet<Character>();
		for(int i = 0; i< str.length(); i++){
			
			if(hs.contains(str.charAt(i))){
				System.out.println("false"); 
			}else{
				hs.add(str.charAt(i));
			}
			
		}
		
		
		
	}
	
	public boolean allUnique(String str){
		
		Set<Character> hs = new HashSet<Character>();
		for(int i = 0; i< str.length(); i++){
			
			if(hs.contains(str.charAt(i))){
				return false;
			}else{
				hs.add(str.charAt(i));
			}
			
		}
		return true;
		
	}

}
