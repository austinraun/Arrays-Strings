
public class ReplaceSpace {

	public static void main(String[] args) {
		
		String str = "abc d e f ";
		String newString = "";
		int length = str.length();
		char[] charArray = new char[str.length()];
		
		
		for (int i = 0; i < length; i++) {
			if(str.charAt(i) == ' '){
				newString = newString + "%20";
			}else{
				newString = newString + str.charAt(i);
			}
		}
		System.out.print(newString);

	}	
}
