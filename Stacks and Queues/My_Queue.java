/*
3.4) Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
*/


//Cracking the coding interview solution
import java.util.Stack;

public class My_Queue
{
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	My_Queue()
	{
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}	
		
	public int size()
	{
		return stack1.size() + stack2.size();
	}

	public void add(int value)
	{
		stack1.push(value);
	}
	
	private void shiftStacks()
	{
		if(stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
		}
	}
	
	public int peek()
	{
		shiftStacks();
		return stack2.peek();
	}
	
	public int remove()
	{
		shiftStacks();
		return stack2.pop();
	}
	
	public static void main(String[] args)
	{
		My_Queue queue = new My_Queue();
		
		queue.add(45);
		queue.add(2);
		queue.add(34);
		queue.add(4);
		queue.add(7);

		for(int i = 0; i < 5; i++)
		{
			System.out.println(queue.remove());
		}
	}
		
}