/*

1.1) Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

*/

public class IsUnique
{
	static boolean isUnique(String str)
	{
		//convert given string to character array
		
		char[] ch_arr = str.toCharArray();
		int[] value = new int[128];

		for(char ch : ch_arr)
		{
			value[ch]++;	
			if(value[ch] > 1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		String str = "Snigdha";
		
		System.out.println("Does \""+str +"\" has all unique characters? "+isUnique(str));
	}
}