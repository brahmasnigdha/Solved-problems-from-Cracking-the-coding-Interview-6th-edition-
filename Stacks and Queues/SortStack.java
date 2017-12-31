/*

3.5) Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as array). The stack supports the following operations: push, pop, peek, and is Empty.

*/

//ctci solution

import java.util.Stack;

public class SortStack
{

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	void sort_stack(Stack<Integer> s)
	{
		while(!s.isEmpty())
		{
			int tmp = s.pop();
			
			while(!stack2.isEmpty() && stack2.peek() > tmp)
			{
				s.push(stack2.pop());
			}
			stack2.push(tmp);
		}
		
		while(!stack2.isEmpty())
		{
			s.push(stack2.pop());
		}
		
		while(!s.isEmpty())
		{
			System.out.print(s.pop()+ " ");
		}
		System.out.println();
	}
	
		
	
	public static void main(String[] args)
	{
		SortStack s = new SortStack();

		s.stack1.push(65);
		s.stack1.push(12);
		s.stack1.push(76);
		s.stack1.push(32);		

		System.out.println("-----------------");
		
		s.sort_stack(s.stack1);
	}
}