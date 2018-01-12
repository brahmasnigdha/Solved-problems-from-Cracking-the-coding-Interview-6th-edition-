/*
	Problem-19: Given two binary trees, return true if they are structurally identical
*/

public class TreeStructureIdentity
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
	
	/////////////////////////////////////Problem Solution///////////////////////////////

	/*
		1) If both the trees are null then return true
		2) If both the tree are not null compare subtrees of both the trees and if the subtrees are identical then return true.
	*/
	static boolean checkIdentical(Node tree1, Node tree2)
	{
		if(tree1 == null && tree2 == null)
		{
			return true;
		}
		
		if(tree1 == null || tree2 == null)
		{
			return false;
		}
		
		return (checkIdentical(tree1.left, tree2.left) && checkIdentical(tree1.right, tree2.right));
	}
	
///////////////////////////////////////////Traverse Tree////////////////////////////////////////
	
	static void traverse(Node node)
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
		TreeStructureIdentity tree1 = new TreeStructureIdentity();
			
		TreeStructureIdentity tree2 = new TreeStructureIdentity();

		tree1.root = new Node(1);	
		
		Node root_left = tree1.addLeftChild(2, tree1.root);
		
		Node root_right = tree1.addRightChild(3, tree1.root);
		
		Node root_left_left = tree1.addLeftChild(4, root_left);
		
		Node root_left_right = tree1.addRightChild(5, root_left); 

		Node root_right_left = tree1.addLeftChild(6, root_right);
		
		Node root_right_right = tree1.addRightChild(7, root_right);


		tree2.root = new Node(1);	
		
		Node root_left1 = tree2.addLeftChild(2, tree2.root);
		
		Node root_right1 = tree2.addRightChild(6, tree2.root);
		
		Node root_left_left1 = tree2.addLeftChild(4, root_left1);
		
		Node root_left_right1 = tree2.addRightChild(5, root_left1); 

		System.out.print("Tree1: ");
		traverse(tree1.root);
		System.out.println();
		
		System.out.print("Tree2: ");
		traverse(tree2.root);
				
		System.out.print("\nAre the trees identical? "+checkIdentical(tree1.root, tree2.root));
		
		
	}
}