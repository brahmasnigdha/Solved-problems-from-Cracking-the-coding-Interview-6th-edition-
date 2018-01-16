/*
	Problem-27: Give an algorithm for converting a tree to its mirror. Mirror of a tree is another tree with left and right children of all non-leaf nodes interchanged. The trees below are mirrors to each other.


	1				1
    2	    3			     3      2
4      5                                  5     4

*/

public class MirrorTree
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

	///////////////////////Problem Solution//////////////////////////
	
	Node mirror_BinaryTree(Node node)
	{
		if(node != null)
		{
			mirror_BinaryTree(node.left);
			mirror_BinaryTree(node.right);
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;			
		}
		return node;	
	}
	
	void traverse(Node node)
	{
		if(node != null)
		{
			System.out.print(node.data+" ");
			traverse(node.left);
			traverse(node.right);
		}
		//System.out.println();
	}

	////////////////////////////////MAIN/////////////////////////////////
	public static void main(String[] args)
	{
		MirrorTree tree = new MirrorTree();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);
		
		System.out.print("Tree: ");
		
		tree.traverse(tree.root);
		
		System.out.println();
		
		Node new_tree = tree.mirror_BinaryTree(tree.root);
		
		System.out.print("Mirror Tree: ");
		
		tree.traverse(tree.root);		
	}
}