/*

	String Compression: Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a-z)

*/

import java.lang.StringBuffer;

public class StringCompression
{

	static StringBuffer compressString(String str)
	{
		StringBuffer newString = new StringBuffer();

		int count = 0;		

		for(int i = 0; i<str.length(); i++)
		{
			count++;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1))
			{
				newString.append(str.charAt(i));
				newString.append(count);
				count = 0;
			}
			
		}
		
		return newString;
	}

	public static void main(String[] args)
	{
		System.out.println("Compression: "+compressString("aabcccccaaa"));		
	}

}