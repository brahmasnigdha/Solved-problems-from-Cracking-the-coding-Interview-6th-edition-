/*Ex.2.4: Delete Middle Node (Cracking the Coding interview)*/

public class DeleteMiddleNode
{
	static class Node{
		
		int data;
		Node next;

		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	Node head;
	
	void printList()
	{
		Node n = head;
		
		
		while(n != null)	
		{
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	void deleteMiddleNode(int key)
	{
		Node n = head;
		Node prev = head;
		while(n != null && n.next != null)
		{
			
			if(n.data == key)
			{
				prev.next = n.next;
				n = n.next;
				return;
			}
			
			prev = n;
			n = n.next;
			
		}

		
	}
	
	public static void main(String[] args)
	{
		DeleteMiddleNode n = new DeleteMiddleNode();
		
		n.head = new Node(12);

		Node second = new Node(13);
		
		Node third = new Node(14);
		
		Node fourth =  new Node(18);

		n.head.next = second;
		second.next = third;
		third.next = fourth;
				
		System.out.println("\nLinked List:\n ");
		n.printList();
		
		System.out.println("\nList after deletion of 13\n");
		
		n.deleteMiddleNode(13);
		
		n.printList();

	}
}