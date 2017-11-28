/*

1.2) Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.

*/

import java.util.Arrays;
import java.io.*;

public class CheckPermutation
{
	static boolean checkPermutation(String str1, String str2)
	{
		
		int m = str1.length();
		int n = str2.length();

		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		if(m != n)
		{
			return false;
		}
				
		Arrays.sort(ch1);		
		Arrays.sort(ch2);
		
		for(int i = 0; i < n; i++)
		{
			if(ch1[i] != ch2[i])
			{
				return false;
			}
		}
		
		return true;
		
	}

	public static void main(String[] args)
	{
		String str1 = "Dogg";
		String str2 = "God";
		
		System.out.println("Check Permutation of "+ str1 +" and "+ str2+"? "+ checkPermutation(str1.toLowerCase(), str2.toLowerCase()));
	}
}