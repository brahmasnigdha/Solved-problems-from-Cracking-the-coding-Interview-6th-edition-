/*

	String Rotation: Assume you have a method isSubstring which checks if one word is a substring of another. Given two string s1 and s2, write a code to check if s2 is a rotation of s1 using only one call to isSubstring(e.g., "waterbottle" is a rotation of "erbottlewat").

*/

public class StringRotation
{
	static boolean isRotation(String s1, String s2)
	{

		int len = s1.length();
		
		if(len == s2.length() && len > 0)				
		{
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}

	static boolean isSubstring(String s1s1, String s2)
	{
		return s1s1.contains(s2);
	}

	public static void main(String[] args)
	{
		if(isRotation("waterbottle", "erbottlewat"))
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
	}
}