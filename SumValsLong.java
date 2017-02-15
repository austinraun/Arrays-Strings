

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumValsLong {

    public static void main(String[] args) {
        
    	Scanner in = new Scanner(System.in);
    	 String n1 = in.nextLine();
         int n = Integer.parseInt(n1.trim());
        int n = in.nextInt();
        String line;
        int sum1 = 0;
        int sum2 = 0; 
        int start = 0;
        int end = n - 1;
        while(in.hasNextLine()){
            line = in.nextLine();
            
            sum1+= Integer.parseInt((" " + line.charAt(start)).trim());
            System.out.println(sum1);
            
            System.out.println(line);
            
        }
        int arr[] = new int[n];
        long result = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            
        }
    	int n = 5;
    	long[] vals = {1000000001,1000000002,1000000003,1000000004,1000000005};
    	
    	
        System.out.println(sumVals(vals));
    }
    public static long sumVals(long[] arr){
        long total = 0;
        for(int i = 0; i < arr.length; i++){
            total+= arr[i];
            System.out.println(total);
        }
        return total;
    }
        
        
        /*        
                
                
        
        String[]numArray = sc.nextLine().split(" ");
        
        long sum = 0;
        for(String num:numArray){
            if(!num.equals("")){
                sum+=Long.parseLong(num);
            }
        }
        System.out.println(sum);
        */
                
   // }
}