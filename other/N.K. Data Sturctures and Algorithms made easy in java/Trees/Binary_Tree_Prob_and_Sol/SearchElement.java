/*
	Problem-3: Give an algorithm for searching an element in binary tree
*/

public class SearchElement
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
	
	boolean searchElement(int data, Node node)
	{
		if(node == null)
		{
			return false;
		}
		
		if(node.data == data)
		{
			return true;
		}
		
		return searchElement(data, node.left) || searchElement(data, node.right);
	}
//////////////////////////////////////////////MAIN//////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		SearchElement tree = new SearchElement();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);

		int searchValue = 5;
		
		if(tree.searchElement(searchValue, tree.root))
		{
			System.out.println(searchValue + " exist");
		}
		else
		{
			System.out.println(searchValue +" does not exist");
		}
	}
}