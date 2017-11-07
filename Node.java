// Singly linked list 

class Node{

	Node next = null;
	int data;
	
	Node(int d)
	{
		this.data = d;
	}
	
	//insert into the linked list
	void insert(int d)
	{
		Node newNode = new Node(d);
		Node node = this;
		
		while(node.next != null)
		{
			node = node.next;
		}
		node.next = newNode;
	}
	
	//delete
	void delete(Node head, int d)
	{
		//runner technique
		Node n = head;
		while(n.next != null)
		{
			if(n.next.data == d)
			{
				n.next = n.next.next;	
				
			}
			n = n.next;
		}
		
	}

	void printList()
	{
		Node node = this;
		
		System.out.print(node.data+" ");
		while(node.next != null)	
		{
			node = node.next;	
			System.out.print(node.data+" ");
		}
	}

	public static void main(String[] args)
	{
		Node n = new Node(0);
		
		n.insert(12);
		n.insert(13);
		n.insert(17);
		n.insert(19);
		System.out.println("List:");
		n.printList();
		System.out.println();
		System.out.println();
		n.delete(n, 17);
		System.out.println("After deleting 17 from the list:");
		
		n.printList();
		
		
	}
}