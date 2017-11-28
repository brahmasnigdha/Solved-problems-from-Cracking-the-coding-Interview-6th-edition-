/*

1.3) URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: if implementing in Java, please use character array so that you can perform this operation in place.)

EXAMPLE:

Input: "Mr John Smith ", 13
Output: "Mr%20John%20Smith"

*/

import java.util.Arrays;

public class URLify
{
	static char[] urlify(char[] ch_str, int n_size)
	{
		int count_space = 0;
		int total_size = 0;
		
		for(int i = 0; i < n_size; i++)	
		{
			if(ch_str[i] == ' ')	
			{
				count_space++;
			}
		}

		total_size = n_size + (count_space*2);
		char[] result = new char[total_size];
				
		if(n_size < ch_str.length) ch_str[n_size] = '\0';

		for(int i = n_size-1 ; i >= 0 ; i--)
		{
			if(ch_str[i]==' ')
			{
				result[total_size-1] = '0';
				result[total_size-2] = '2';
				result[total_size-3] = '%';
				total_size = total_size - 3;
			}
			else
			{
				result[total_size-1] = ch_str[i];
				total_size--;
			}
						
		}

		return result;
	}

	public static void main(String[] args)
	{
		String str = "Mr John Smith";
		int n_size = str.length();
		
		char[] ch_str = str.toCharArray();
		System.out.println("Input String: "+str);
		System.out.print("Output String: ");
		
		char[] ch = urlify(ch_str, n_size);

		for(int i = 0; i<ch.length;i++)
		{
			System.out.print(ch[i]);
		}
		
		System.out.println();
	}
}