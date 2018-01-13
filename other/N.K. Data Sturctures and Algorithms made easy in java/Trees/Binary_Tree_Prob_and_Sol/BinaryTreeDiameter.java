/*
	Problem-20: Give an algorithm for finding the diameter of the binary tree. The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree.
*/

public class BinaryTreeDiameter
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

// Solution: N.K. Data Structures and Algorithms
	public int diameter(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		
		int len1 = height(node.left)+height(node.right)+3;
		
		int len2 = Math.max(diameter(node.left), diameter(node.right));

		return Math.max(len1, len2);
	}
	
	public int height(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		
		int leftDepth = height(node.left);
		int rightDepth = height(node.right);

		return (leftDepth > rightDepth)?leftDepth :rightDepth;
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
/////////////////////////////////////////////MAIN//////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		BinaryTreeDiameter tree = new BinaryTreeDiameter();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		//Node root_right_right = tree.addRightChild(7, root_right);

		System.out.print("Tree: ");
		tree.traverse(tree.root);
		System.out.println();
		
		System.out.println("Diameter of the tree: "+ tree.diameter(tree.root));	
		
	}
}