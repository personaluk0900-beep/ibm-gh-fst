package fst123;
import java.util.*;
public class Activity10 {

	public static void main(String[] args) {
		HashSet<String> hs=new HashSet<String>();
		hs.add("M");
		hs.add("N");
		hs.add("A");
		hs.add("B");
		hs.add("D");
		hs.add("E");
		
		System.out.println("Original HashSet: "+hs);
		System.out.println("Size of HashSet: "+hs.size());
		System.out.println("Removing A from Hashset: "+hs.remove("A"));
		
		if(hs.remove("Z")) {
			System.out.println("Z is removed from the set");
		} else {
			System.out.println("Z is not present in the Set");
		}
		System.out.println("Checking if M is present: "+hs.contains("M"));
		System.out.println("Updated HashSet: "+hs);
	}

}
