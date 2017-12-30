/*
3.3) Stack of Plates:

Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 

Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.

Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.

SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).

FOLLOW UP:

Implement function popAt(int index) which performs a pop operation on a specific sub-stack.
*/

public class SetOfStacks
{
	int number_of_stacks = 3;
	
	int stack_capacity = 5;

	int[] top = new int[number_of_stacks];
	
	int[][] stack = new int[number_of_stacks][stack_capacity];
	
	SetOfStacks()
	{
		for(int i = 0; i < number_of_stacks; i++)
		{
			top[i] = -1;
		}	
	}
	
	//push into selected stack

	void push(int selected_stack, int value)
	{
		//System.out.println(top[selected_stack]);
		//System.out.println(stack_capacity);
		/*if(top[selected_stack] == stack_capacity)
		{
			System.out.println("-----------"+top[selected_stack]);
			System.out.println("Stack Overflow");
			//return false;
			//push(selected_stack++, value);
			System.out.println(selected_stack++);
			System.exit(0);
			
		}*/
		
		//else
		//{	
			stack[selected_stack][++top[selected_stack]] = value;
			//return true;
		//}
	}
	
	int pop(int index)	
	{
		if(top[index] < 0)
		{
			System.out.println("Stack Underflow");	
			return 0;
		}
		
		else
		{
			int x = stack[index][top[index]--];
			return x;
		}
	}

	public static void main(String[] args)
	{
		System.out.println("Stack of Plates");
		System.out.println("=======================");
		
		SetOfStacks s = new SetOfStacks();

		s.push(0,1);
		s.push(0,2);
		s.push(0,3);
		s.push(0,4);
		s.push(0,5);

		s.push(1,4);
		s.push(1,24);
		s.push(1,5);
		s.push(1,43);		
		s.push(1,76);

		s.push(2,2);
		s.push(2,9);
		s.push(2,34);
		s.push(2,45);
		s.push(2,35);
		
		for(int i=0; i<s.number_of_stacks; i++)
		{
			System.out.println("Stack "+i+": ");
			for(int j = 0; j < s.stack_capacity; j++)
			{
				System.out.println(s.pop(i));
			}
		}
		

	}
	
	
}