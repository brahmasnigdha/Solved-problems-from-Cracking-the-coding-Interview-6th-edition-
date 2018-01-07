/*
	Problem 2: Given an algorithm for finding maximum element in binary tree without recursion
*/
	
import java.util.Stack;

public class MaxBinaryTree2
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
	//Using Iterative method
	int maxElement(Node node)
	{
		int max_value = Integer.MIN_VALUE;

		Stack<Node> stack = new Stack<Node>();
		
		stack.push(node);
		
		while(!stack.isEmpty())
		{
			Node tmp = stack.pop();
			
			if(tmp.data > max_value)
			{
				max_value = tmp.data;
			}
		
			if(tmp.right != null)
			{
				stack.push(tmp.right);
			}
			
			if(tmp.left != null)
			{
				stack.push(tmp.left);
			}
		}
		return max_value;
	}


	Node root;	

//////////////////////////////////////////////MAIN//////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		MaxBinaryTree2 tree = new MaxBinaryTree2();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);
		
		int max_value = tree.maxElement(tree.root);
		
		System.out.println("Maximum value: "+max_value);
	}
}