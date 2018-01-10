/*
	Problem 11: Solving problem 10 with stack
*/
import java.util.Stack;

public class TreeHeight2
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
//////////////////////////////////REVERSE LEVEL ORDER//////////////////////////////////////

	int height(Node node)
	{
		Stack<Node> stack = new Stack<Node>();
		int left_height = 0;
		int right_height = 0;
		
		if(node == null)
		{
			return 0;
		}
		
		stack.push(node);
		
		while(!stack.isEmpty())
		{
			Node temp = stack.pop();
			if(temp.right != null)
			{
				stack.push(temp.right);
				right_height = right_height+1;
			}
			if(temp.left!=null)
			{
				stack.push(temp.left);
				left_height = left_height+1;
			}
			
		}
		return (left_height >= right_height)? left_height:right_height;
		
	}

//////////////////////////////////////////MAIN/////////////////////////////////////////////

	public static void main(String[] args)
	{
		TreeHeight2 tree = new TreeHeight2();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);
		
		System.out.println("Height of the tree: "+ tree.height(tree.root));
	}
}