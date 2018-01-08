/*
	Problem 4: Searching an algorithm for searching an element in binary tree without recursion
*/
	
import java.util.Stack;

public class SearchElement2
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
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		
		while(!stack.isEmpty())
		{
			Node temp = stack.pop();
			
			if(temp.data == data)
			{
				return true;
			}
			
			if(temp.right != null)
			{
				stack.push(temp.right);
			}
				
			if(temp.left != null)
			{
				stack.push(temp.left);
			}
			
		}
		return false;
		
	}
//////////////////////////////////////////////MAIN//////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		SearchElement2 tree = new SearchElement2();

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

