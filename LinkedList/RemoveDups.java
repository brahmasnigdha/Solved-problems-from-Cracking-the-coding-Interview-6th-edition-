/*
*	2.1) Remove Dups: Write code to remove duplicates from an unsorted
*		linked list.
*	FOLLOW UP:
*		How would you solve this problem if a temporary buffer
*		is not allowed?
*/

import java.util.HashSet;

class Node{
	
	Node next = null;
	int data;
	
	public Node(int d)
	{
		this.data = d;	
	}

	public void appendToTail(int d)
	{
		Node newNode = new Node(d);
		Node n = this;

		while(n.next != null)
		{
			n = n.next;
		}
		n.next = newNode;
	}

	public void printList()
	{
		Node n = this;
		
		while(n.next != null)
		{
			n = n.next;
			
			System.out.print(n.data+" ");
		}
		
	}
}

public class RemoveDups{
	
	static void removeDups(Node n)
	{
		HashSet<Integer> hs = new HashSet<Integer>();
		
		while(n.next != null)	
		{
			n = n.next;
			hs.add(n.data);
		}
		
		System.out.println("Removed Duplicates: "+hs);		
		
	}

	public static void main(String[] args)
	{
		Node n = new Node(0);
		
		n.appendToTail(11);
		n.appendToTail(12);
		n.appendToTail(11);
		n.appendToTail(13);

		n.printList();
		System.out.println();

		removeDups(n);
		
	}
}
