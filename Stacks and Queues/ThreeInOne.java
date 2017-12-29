//CTCI Solution

/*
	Three in One: Describe how you could use a single array to implement three stacks
*/


import java.util.*;

public class ThreeInOne
{
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public ThreeInOne(int stackSize)
	{
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	public void push(int stackNum, int value) 
	{
		if(isFull(stackNum))
		{
			System.out.println("Stack's full");
			return;
		}
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	public int pop(int stackNum)
	{
		if(isEmpty(stackNum))
		{
			throw new EmptyStackException();
		}
		
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0; 
		sizes[stackNum]--;
		return value;		
	}

	public boolean isEmpty(int stackNum)
	{
		return sizes[stackNum] == 0;
	}

	public boolean isFull(int stackNum)
	{
		return sizes[stackNum] == stackCapacity;
	}

	private int indexOfTop(int stackNum)
	{
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

	public static void main(String[] args)
	{
		int[] arr = {4,6,32,7,21,68,44,75,23,65,234};
		

		ThreeInOne stack1 = new ThreeInOne(12);
		//ThreeInOne stack2 = new ThreeInOne(arr2.length);
		//ThreeInOne stack3 = new ThreeInOne(arr3.length);
		
		for(int i = 0; i<arr.length; i++)
		{
			stack1.push(1,arr[i]);
		}
		for(int i = 0 ; i < arr.length; i++)
		{
			System.out.print(stack1.pop(1)+ " ");
		}
		
		
	}
}