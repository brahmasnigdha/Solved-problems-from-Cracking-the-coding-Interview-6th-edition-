/*
Intersection: 
	Given two (singly) linked lists, determine if the two lists intersect. Retrurn the intersecting node. Note that the intersection is defined based on reference, not value. That is if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
*/

public class Intersection
{
	static class Node
	{	
		private int data;
		private Node next;
	
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	Node head1; //head node for list 1
	Node head2; //head node for list 2

	void append(int d, Node n)
	{
		if(n == null)
		{
			n = new Node(d);
		}
		else
		{
			while(n.next != null)
			{
				n = n.next;
			}
			n.next = new Node(d);
		}
	}

	boolean search(int data, int position, Node n)
	{
		int pos = 0;
		
		while(n != null)	
		{
			pos++;
			if(n.data == data && pos == position)
			{
				return true;
			}
			n = n.next;
		}
		return false;
	}

	boolean intersection(Node l1, Node l2)	
	{
		int position = 0;
		
		while(l1 != null)
		{
			position++;
			if(search(l1.data, position, l2))
			{
				return true;
			}
			l1 = l1.next;
		}
		return false;
	}
	
	
	public static void main(String[] args)
	{
		Intersection n = new Intersection();
		
		n.head1 = new Node(9);
		n.head2 = new Node(3);
		
		n.append(1, n.head1);
		n.append(5, n.head1);
		n.append(2, n.head1);
		
		n.append(6, n.head2);
		n.append(5, n.head2);
		n.append(8, n.head2);
		
		if(n.intersection(n.head1, n.head2))
		{
			System.out.println("Lists intersect");
		}
		else
		{
			System.out.println("Lists don't intersect");
		}
	}
}