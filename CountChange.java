import java.util.*;
import java.math.*;

public class CountChange {

	public static void main(String[] args){
		int amount = 17;
		int[] coins = {};
	    int ways = findCombinationsCount(amount,coins);

	    int largestPal = largestPalindrome(5);

	    System.out.println(largestPal);
	    System.out.println(2139999312%1337);

	}
	
	
	public static int largestPalindrome(int n) {
        
		int x1 = 0, x2 = 0;
        int largest_num = 0;
        int largest_int = 9;
        int previous = 0;
        int tens = 1;
        int[] returnPair = new int[2];
        for(int i = 0; i<n; i++){
            
            tens = (int) Math.pow(10,i);
            
            largest_num += largest_int * tens; // 9
                                                //9 + 9*10 = 99
                                                //99 + 9* 100 = 999
        }
      

        x1 = largest_num;
        x2 = largest_num;
        int product = x1 * x2;

        int biggestProduct = 0; 
        
        for(int a = x1; a>0; a--){
        	for(int b = x2; b>0; b--){
        		product = a*b;
        		if(isPalindrome(product)){
        			if(product > biggestProduct){
        				biggestProduct = product;
        				returnPair[0] = a;
        		        returnPair[1] = b;
        			}
        		}
        		if(biggestProduct > a*a && biggestProduct > a*b && biggestProduct > b*b){
        			break;
        		}
        	}
        }
        
        System.out.println(returnPair[0]);
        System.out.println(returnPair[1]);
		return biggestProduct % 1337;
        
    }
	
	public static int reverseNum(int n){
		int last_digit;
	    int reversedNum = 0;
        while (n != 0)
        {    
             last_digit = n % 10;
             reversedNum = reversedNum * 10 + last_digit;
             n = n / 10; 
             
        }
		    
	    return reversedNum;
		
	}
    
    public static boolean isPalindrome(int num){
        if(reverseNum(num) == num){
        	
        	return true;
        }else{
        	return false;
        }
    }

    
    //zz

	public static int findCombinationsCount(int sum, int vals[]) {
	        if (sum < 0) {
	            return 0;
	        }
	        if (vals == null || vals.length == 0) {
	            return 0;
	        }

	        int dp[] = new int[sum + 1];
	        System.out.println(Arrays.toString(vals));
	        System.out.println(Arrays.toString(dp));
	        dp[0] = 1;
	        int count; 
	        for (int i = 0; i < vals.length; i++) {
	            count = 0;
	            for (int j = vals[i]; j <= sum; j++) {
	                dp[j] += dp[j - vals[i]];
	                count++;
	            }
	            System.out.print("Ways to count with ");
	            for(int k = 0; k <= i ;k++){
	                System.out.print(vals[k] + " , ");
	            }
	            System.out.println("to "+sum+" : ways = " + dp[sum]);
	            System.out.println(Arrays.toString(dp));
	        }
	        return dp[sum];
	    }
}
