public class Return_Kth_to_Last
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

	void return_Kth_to_Last(int k)
	{
		if(head == null)
		{
			return;
		}

		Node temp =  head;
		
		if(k == 0)
		{
			while(temp != null)
			{
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			return;
		}

		else
		{
			for(int i = 0; temp != null && i<(k-1); i++)
			{
				temp= temp.next;
			}
			
			if(temp == null || temp.next == null)
			{
				return;
			}
			else
			{
				while(temp != null)
				{
					System.out.print(temp.data+" ");
					temp = temp.next;
				}	
			}
			
		}
		
		System.out.println();
	}

	public static void main(String[] args)
	{
		Return_Kth_to_Last llist = new Return_Kth_to_Last();
		
		llist.head = new Node(12);

		Node second = new Node(14);		
		Node third = new Node(15);
		
		Node fourth = new Node(18);
		
		llist.head.next = second;
		
		second.next = third;

		third.next = fourth;	
		
		llist.return_Kth_to_Last(2);	
		
	}
}
