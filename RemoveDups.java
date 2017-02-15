
public class RemoveDups {
	public static void main(String[] args) {
		String string = "abcdefebiwdijdabcad";
		String holder = "";
		for(int i = 0; i <string.length(); i++){
			if (!holder.contains("" + string.charAt(i))) {
				holder = holder + "" + string.charAt(i);
	        }
	    }
		System.out.print(holder);
		
	}
}
