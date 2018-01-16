/*
	Problem 28: Given two trees, give an algorithm for checking whether they are mirrors of each other.
*/

public class CheckMirror
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
		
	Node root1;
	Node root2;	
	
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
	
	static boolean checkMirrorTree(Node n1, Node n2)
	{
		if(n1 == null && n2 == null)
		{
			return false;
		}
		
		if(n1 == null || n2 == null)
		{
			return false;
		}
		
		if(n1.data != n2.data)
		{
			return false;
		}
		
		else return (checkMirrorTree(n1.left, n2.right) && checkMirrorTree(n1.right, n2.left));
	}
	////////////////////////////////MAIN/////////////////////////////////
	public static void main(String[] args)
	{
		CheckMirror tree = new CheckMirror();

		tree.root1 = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root1);
		
		Node root_right = tree.addRightChild(3, tree.root1);
		
		
		CheckMirror tree1 = new CheckMirror();

		tree1.root2 = new Node(1);	
		
		Node root_left1 = tree1.addLeftChild(3, tree1.root2);
		
		Node root_right1 = tree1.addRightChild(2, tree1.root2);
		
		if(checkMirrorTree(tree.root1, tree1.root2))
		{
			System.out.println("Mirror");
		}
		else
		{
			System.out.println("Not mirror");
		}
				
	}
}