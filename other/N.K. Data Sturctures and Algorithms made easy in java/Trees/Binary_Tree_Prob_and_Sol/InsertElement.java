/*
	Problem-5: Given an algorithm for inserting element into binary tree
*/

public class InsertElement
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
	
	void insertElement(Node node, int data)
	{
		if(node == null)
		{
			Node newNode = new Node(data);
		}
		else
		{
			insertElement2(node, data);
		}
	}

	void insertElement2(Node node, int data)
	{
		if(node.data >= data)	
		{
			if(node.left == null)
			{	
				node.left = new Node(data);
			}
			else
			{
				insertElement2(node.left, data);
			}
		}
		else
		{
			if(node.right == null)
			{
				node.right = new Node(data);
			}
			else
			{
				insertElement2(node.right, data);
			}
		}
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
		InsertElement tree = new InsertElement();

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

		int element_insert = 11;
		
		System.out.println("Insert element "+ element_insert+": ");

		tree.insertElement(tree.root, element_insert);
		
		tree.traverse(tree.root);
		
		System.out.println();
	}
}

