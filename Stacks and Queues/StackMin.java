/*
	3.2) Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop, and min should all operated in O(1) time.
*/

import java.util.EmptyStackException;

public class StackMin
{
	static class Stack{
		int data;
		Stack next;
		
		Stack(int d)
		{
			data = d;	
		}
	}

	
		
	Stack top;
	int min_value;

	public void push(int item)
	{	
		int value = item;	
		
		if(isEmpty())
		{
			min_value = item;
		}
		else
		{
			int new_min_value = min_value<item? min_value : item;
			min_value = new_min_value;
		}
		Stack t = new Stack(item);	
		t.next =top;
		top = t;	
	}
	
	public int pop()
	{
		if(top == null)
		{
			System.out.println();
		}
		
		int item = top.data;
		top = top.next;
		return item;
	}
	
	public int peek()
	{
		if(top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty()
	{
		return top == null;
	}	

	public static void main(String[] args)	
	{
		StackMin stack = new StackMin();
		 
		int[] arr = {11,67,345, 78,23,70};
		
		System.out.println("Stack Input:");

		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		for(int i = 0 ; i < arr.length; i++)
		{
			stack.push(arr[i]);
		}
		
		System.out.println("Pop operation: ");
		for(int i = 0; i<arr.length; i++)
		{
			System.out.print(stack.pop()+" ");
		}
		
		
		System.out.println("\nMinimum value: "+stack.min_value);
		
	}
}