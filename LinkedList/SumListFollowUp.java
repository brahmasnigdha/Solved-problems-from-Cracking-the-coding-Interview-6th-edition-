/*

Problem 2.5: Follow up: Suppose the digits are stored in forward order. Repeat of the Sum Lists problem.

Example: 

Input: (6->1->7)+(2->9->5). That is, 617 + 295
Output: 9->1->2. That is, 912
*/

public class SumListFollowUp
{
	static class Node
	{
		private int data;
		private Node next;
		
		Node(int d)		
		{
			this.data = d;
			this.next = null;
		}
	}
	
	static class PartialSum		//cracking the coding interview
	{
		public Node sum = null;
		public int carry = 0;
	}

	Node head1;
	Node head2;	
	Node head;

	Node addLists(Node l1, Node l2)	     //cracking the coding interview
	{
		int len1 = length(l1);
		int len2 = length(l2);
		
		//Pad the shorter list with zeros 
		if(len1 < len2)
		{
			l1 = padList(l1, len2 - len1);
		}
		else
		{
			l2 = padList(l2, len1 - len2);
		}

		//Add lists
		PartialSum sum = addListHelper(l1, l2);
		
		// If there was a carry value left over, insert this at the
		// front of the list. Otherwise, just return the linked
		// list.

		if(sum.carry == 0)			
		{
			return sum.sum;
		}
		else
		{
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
		
	}
	
	int length(Node n)
	{
		int count = 0;
		while(n != null)
		{
			count++;
			n = n.next;
		}
		return count;
	}

	PartialSum addListHelper(Node l1, Node l2)	//cracking the coding interview
	{
		if(l1 == null && l2 == null)
		{
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		//Add smaller digits recursively
		PartialSum sum = addListHelper(l1.next, l2.next);
		
		//Add carry to current data
		int val = sum.carry + l1.data + l2.data;

		//Insert sum of current digits
		Node full_result = insertBefore(sum.sum, val % 10);
		
		//Return sum so far, and the carry value
		sum.sum = full_result;
		sum.carry = val/10;
		return sum;
	}	

	void append(Node n, int d)
	{
		Node newNode = new Node(d);
		
		if(n == null)
		{
			n = newNode;
		}
		else
		{
			while(n.next != null)
			{
				n = n.next;
			}
			n.next = newNode;
		}
	}
	
	
	
	Node padList(Node l, int padding) //cracking the coding interview
	{
		Node n = l;
		for(int i = 0; i < padding; i++)
		{
			n = insertBefore(n,0);
		}
		return n;
	}

	Node insertBefore(Node list, int data) //cracking the coding interview
	{
		Node node = new Node(data);
		if(list != null)
		{
			node.next = list;
		}
		return node;
	}
	
	void printList(Node n)
	{
		while(n != null)
		{
			System.out.print(n.data+ " ");
			n = n.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		SumListFollowUp s = new SumListFollowUp();
		
		s.head1 = new Node(6);
		s.head2 = new Node(2);
		s.append(s.head1, 1);
		s.append(s.head1, 7);
		s.append(s.head2, 9);		
		s.append(s.head2, 5);
		
		System.out.println("Input: ");
		s.printList(s.head1);
		s.printList(s.head2);
		

/////////////////////////////Add Two Lists//////////////////////////////////
		
		s.head = s.addLists(s.head1, s.head2);
		System.out.println("Output:");
		s.printList(s.head);
	}
}