/*
	Problem-23: Given a binary tree, print out all its root-to-leaf paths.
*/

public class Root_To_Leaf
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


	//////////////////////////Problem Solution/////////////////////////////////////
	
	public void printPaths(Node node)	
	{
		int[] path = new int[256];
		printPaths(node, path, 0);
	}
	
	private void printPaths(Node node, int[] path, int pathLen)
	{
		if(node == null)
		{
			return;
		}
		path[pathLen] = node.data;
		pathLen++;
		
		if(node.left == null && node.right == null)
		{
			printArray(path, pathLen);
		}
		else
		{
			printPaths(node.left, path, pathLen);
			printPaths(node.right, path, pathLen);
		}
	}
	
	private void printArray(int[] path, int len)
	{
		System.out.print("Path: ");
		for(int i = 0 ; i < len; i++)
		{
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}
	//////////////////////////////////////////MAIN/////////////////////////////////////////////

	public static void main(String[] args)
	{
		Root_To_Leaf tree = new Root_To_Leaf();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);
		
		tree.printPaths(tree.root);
	
	}
}