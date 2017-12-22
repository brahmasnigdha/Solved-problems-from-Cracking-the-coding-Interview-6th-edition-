import java.util.Stack;

public class Palindrome
{	
	//check of the given character array is a palindrome
	boolean isPalindrome(int[] str)
	{
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i = 0; i < str.length; i++)
		{
			st.push(str[i]);
		}
		
		for(int i = 0; i<str.length; i++)
		{	
			if(str[i] != (st.pop()))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		Palindrome p = new Palindrome();

		int[] str = {1,2,3,2,1};
		
		if(p.isPalindrome(str))
		{
			System.out.println("Is a palindrome");
		}
		else
		{
			System.out.println("Not a palindrome");
		}
	}
}