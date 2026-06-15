package fst123;

import java.util.*;
public class Activity2 {

	public static void main(String[] args) {
		int [] number= {10,77,10,54,-11,10};
		System.out.println(Arrays.toString(number));
		TenCheck(number);
	}
    public static void TenCheck(int arr[]) {
    	int count = 0;
    	int sum =0;
    	int n=arr.length;
    	for(int i=0;i<n;i++) {
    		if(arr[i]==10) {
    			count++;
    			sum+=arr[i];
    		}
    	}
    	System.out.println("Count:"+count);
    	System.out.println("Sum of 10's in array :"+sum);
    }
}
