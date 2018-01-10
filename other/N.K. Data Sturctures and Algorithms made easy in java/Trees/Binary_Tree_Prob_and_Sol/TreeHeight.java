/*
	Problem 10: Give an algorithm for finding the height (or depth) of the binary tree.
*/

public class TreeHeight
{
	static class Node
	{
		int data;
		Node left;
		Node right;
		
		Node(int d)
		{
			this.data = d;
			left = null;
			right = null;
		}
	}
	
	Node root;	
	
	///////////////////////////Method for Adding Left Child////////////////////////
	Node addLeftChild(int data, Node node)
	{
		Node newChild = new Node(data);
		node.left = newChild;
		return node.left;	
	}
	
	///////////////////////////Method for Adding Right Child///////////////////////
	Node addRightChild(int data, Node node)
	{
		Node newChild = new Node(data);
		node.right = newChild;
		return node.right;
	}
//////////////////////////////////REVERSE LEVEL ORDER//////////////////////////////////////

	int height(Node node)
	{
		
		if(node == null)
		{
			return 0;
		}
		else
		{
			int left_height = height(node.left);
			int right_height = height(node.right);
			
			/*if(left_height > right_height)
			{
				return (left_height+1);
			}
			else
			{
				return (right_height+1);
			}*/
			return (left_height > right_height) ? (left_height + 1):(right_height+1);
		}
	}

//////////////////////////////////////////MAIN/////////////////////////////////////////////

	public static void main(String[] args)
	{
		TreeHeight tree = new TreeHeight();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);
		
		System.out.println("Height of the tree: "+ tree.height(tree.root));
	}
}