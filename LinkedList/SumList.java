/*
Sum List: You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

EXAMPLE: 

Input:(7->1->6) + (5->9->2). That is, 617 + 295
Output: 2->1->9. That is, 912.
*/

public class SumList
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

	Node head1;
	Node head2;
	Node result;

	void printList(Node n)
	{
		while(n != null)
		{
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println();
	}

	void addLists(Node n1, Node n2)
	{
		int carry = 0;
		int sum = 0;		
			
		if(n1 == null && n2 == null)
		{
			System.out.println("Empty list");
		}
		
		else
		{
			while(n1 != null && n2 != null)
			{
				sum = (n1.data + n2.data + carry) % 10;
				carry = (n1.data + n2.data + carry)/10;
				append(sum);
				n1 = n1.next;
				n2 = n2.next;
			}
		}
		
	}
	
	void append(int data)
	{
		Node new_Node = new Node(data);
		
		if(result == null)
		{
			result = new Node(data);
			return;
		}
		Node n = result;
		
		while(n.next != null)
		{
			n = n.next;
		}
		
		n.next = new_Node;
		return;
	}

	
	public static void main(String[] args)
	{
		SumList s = new SumList();
		
		s.head1 = new Node(7);
		s.head2 = new Node(5);
		Node second1 = new Node(1);
		Node third1 = new Node(6);
		Node second2 = new Node(9);
		Node third2 = new Node(2);
		
		s.head1.next = second1;
		second1.next = third1;
		
		s.head2.next = second2;
		second2.next = third2;
		
		System.out.println("Input:");
		System.out.println("------------");
		s.printList(s.head1);
		s.printList(s.head2);
		
		s.addLists(s.head1, s.head2);
		System.out.println("------------");
		System.out.println("Output:");
		System.out.println("-------------");
		s.printList(s.result);
	}
}