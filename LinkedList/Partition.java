/*
	Partition: Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x. The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.

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
	
	void printList(Node head)
	{
		if(head == null)
		{
			System.out.println("List is empty");
		}

		Node n = head;
		
		while(n != null)
		{
			System.out.print(n.data+ " ");
			n = n.next;
		}
		System.out.println();

	}

	Node partition(Node node, int x)
	{
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		while(node != null)	
		{
			Node next = node.next;
			node.next = null;
			
			if(node.data < x)
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
	
	public static void main(String[] args)
	{
		Partition partition = new Partition();
		
		partition.head = new Node(3);
		
		Node second = new Node(5);
		
		Node third = new Node(8);
		
		Node fourth = new Node(5);
		
		Node fifth = new Node(10);

		Node sixth = new Node(2);
		
		Node seventh = new Node(1);

		partition.head.next = second;
		
		second.next = third;
			
		third.next = fourth;
		
		fourth.next = fifth;
		
		fifth.next = sixth;
		
		sixth.next = seventh;

		System.out.println("Given List:");
		
		partition.printList(partition.head);
		
		//System.out.println();
		//partition.partitionList(partition.head, 5);
		
		Node n = partition.partition(partition.head, 5);
		
		System.out.println("After partition: ");

		partition.printList(n);
		
		
	}
}