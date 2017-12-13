/*
	Partition: Write code to partition a linked list aroung a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x. The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.

Example:

Input: 3, 5, 8, 5, 10, 2, 1 [partition = 5]
Output: 3, 1, 2, 10, 5, 5, 8
*/

public class Partition
{
	static class Node
	{
		int data;
		Node next;
		
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	Node head;

	void appendToTail(Node head, int d)
	{
		Node n = head;
		Node insert = new Node(d);
		
		while(n.next != null)
		{
			n = n.next;
		}
		n.next = insert;
	}
	
	boolean search(Node head, int value)
	{
		Node n = head;

		while(n != null)
		{
			if(n.data == value)
			{
				return true;
			}
			n = n.next;
		}
		return false;
	}
	
	Node partition(Node node, int p_Value)	//p_Value: partition value
	{
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		while(node != null)
		{
			Node next = node.next;
			node.next = null;

			if(node.data < p_Value)
			{
				if(beforeStart == null)
				{
					beforeStart = node;
					beforeEnd = beforeStart;
				}
				else
				{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}
			else
			{
				if(afterStart == null)
				{
					afterStart = node;
					afterEnd = afterStart;
				}
				else
				{
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}

		if(beforeStart == null)
		{
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	void printList(Node head)
	{
		Node n = head;
		
		while(n != null)
		{
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Partition p = new Partition();
		
		p.head = new Node(3);
		
		p.appendToTail(p.head, 5);
		p.appendToTail(p.head, 8);
		p.appendToTail(p.head, 5);
		p.appendToTail(p.head, 10);
		p.appendToTail(p.head, 2);
		p.appendToTail(p.head, 1);
		
		System.out.println("Input: ");
		p.printList(p.head);
		
		int partition_Value = 8;
		
		if(p.search(p.head, partition_Value))
		{
			Node new_head_node = p.partition(p.head, partition_Value);
			System.out.println("Output: ");
			p.printList(new_head_node);	
		}
		
		else
		{
			System.out.println("Element does not exist");
		}
		
		
	}
	
}