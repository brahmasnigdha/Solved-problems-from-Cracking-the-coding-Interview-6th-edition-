/*
	Problem 6: Give an algorithm for finding the size of binary tree
*/

public class BinaryTreeSize
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
	
	/////////////////////////Problem Solution//////////////////////////////////
	int size(Node node)
	{
		int leftCount = node.left == null? 0 : size(node.left);
		int rightCount = node.right == null? 0 : size(node.right);
		return 1 + leftCount +rightCount;
	}
	
///////////////////////////////////////////Traverse Tree////////////////////////////////////////
	
	void traverse(Node node)
	{
		if(node != null)
		{
			System.out.print(node.data+" ");
			traverse(node.left);
			traverse(node.right);
		}
	}
//////////////////////////////////////////////MAIN//////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		BinaryTreeSize tree = new BinaryTreeSize();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);
		
		System.out.println("Tree: ");
		
		tree.traverse(tree.root);
		
		System.out.println();
		System.out.println("Size of the tree: "+ tree.size(tree.root));
		

	}
}