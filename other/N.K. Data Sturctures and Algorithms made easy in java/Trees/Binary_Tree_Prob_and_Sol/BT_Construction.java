/*
	Problem-29: Give an algorithm for constructing binary tree from given Inorder and Preorder traversals.

Solution: Let us consider the traversals below:
	Inorder sequence: D B E A F C
	Preorder sequence: A B D E C F
*/

public class BT_Construction
{

	static class Node
	{
		char data;
		Node left;
		Node right;
		
		Node(char d)
		{
			this.data = d;
			left = null;
			right = null;
		}
	}	

	Node root;
	static int preIndex = 0;

	/////////////////Method for adding left child///////////////////
	
	Node addLeftChild(char data, Node node)
	{
		Node new_node = new Node(data);
		node.left = new_node;
		return node.left;		
	}

	//////////////Method for adding right child////////////////////
	
	Node addRightChild(char data, Node node)
	{
		Node new_node = new Node(data);
		node.right = new_node;
		return node.right;
	}

	//////////////Problem Solution//////////////////////////////

	Node construction_of_BT(char[] inorder_seq, char[] preorder_seq, int inStart, int inEnd)
	{
		if(inStart > inEnd)
		{
			return null;
		}
		
		Node new_node = new Node(preorder_seq[preIndex++]);
		
		if(inStart == inEnd)
		{
			return new_node;
		}
		
		int inIndex = search_Inorder(inorder_seq, inStart, inEnd, new_node.data);
		
		new_node.left = construction_of_BT(inorder_seq, preorder_seq, inStart, inIndex - 1);
		
		new_node.right = construction_of_BT(inorder_seq, preorder_seq, inIndex + 1, inEnd);
		
		return new_node;
	}

	int search_Inorder(char[] inorder, int start, int end, char value)
	{
		for(int i = start; i <= end; i++)
		{
			if(inorder[i]==value)
			{
				return i;
			}
		}
		return -1;
	}

	///////////////////Traverse Tree///////////////////////////

	void traverse(Node node)
	{

		if(node != null)
		{
			System.out.print(node.data + " ");
			traverse(node.left);
			traverse(node.right);
		}
	}
	public static void main(String[] args)
	{
		char[] in = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};	
		char[] pre = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
		int len = in.length;
		
		BT_Construction tree = new BT_Construction();
		
		tree.root = tree.construction_of_BT(in, pre, 0, len - 1);	
		
		System.out.println("Tree: ");
		tree.traverse(tree.root);
	}
}