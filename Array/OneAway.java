/*
	One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings write a function to check if they are one edit (or zero edits) away.

EXAMPLE:
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
*/

import java.util.Arrays;

public class OneAway
{
	static boolean isOneEditAway(String str1, String str2)
	{
		
		int count = 0;		

		//Append both the strings
		
		String newString =  str1 + str2;

		//convert string into character array
		
		char[] ch_String = newString.toCharArray();

		int[] table = new int[128];

		for(char ch : ch_String)
		{
			table[ch]++;
		}

		for(char ch : ch_String)
		{
			if(table[ch] == 1)
			{
				count++;
			}
		}

		if(count == 1 || count == 0)
		{
			return true;
		}

		return false;
	}

	public static void main(String[] args)
	{
		if(isOneEditAway("pales", "bake"))
		{
			System.out.println("Is one or zero edit away");
		}
		else
		{
			System.out.println("More than one edit away");
		}
	}
}