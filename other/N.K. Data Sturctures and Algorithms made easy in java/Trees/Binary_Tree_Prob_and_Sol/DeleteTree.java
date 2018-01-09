/*
	Problem 8: Give an algorithm for deleting the tree
*/

import java.util.LinkedList;
import java.util.Stack;

public class DeleteTree
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
	
	Node deleteTree(Node node)
	{
		node = null;
		
		return node;
	}
	
///////////////////////////////////////////Traverse Tree////////////////////////////////////////
	LinkedList<Integer> traverse(Node node)
	{
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		Stack<Node> stack = new Stack<Node>();
		
		Node currentNode = node;
		
		boolean done = false;

		if(node == null)		
		{
			return result;
		}

		while(!done)	
		{
			if(currentNode != null)
			{
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			else
			{
				if(stack.isEmpty())
				{
					done = true;
				}
				else
				{
					currentNode = stack.pop();	
					result.add(currentNode.data);
					currentNode = currentNode.right;
				}

			}
		
		}
		
		return result;
	}
	
//////////////////////////////////////////////MAIN//////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		DeleteTree tree = new DeleteTree();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);
		
		System.out.println("Tree: "+tree.traverse(tree.root));
		
		System.out.println();
		
		tree.root = tree.deleteTree(tree.root);
		
		System.out.println("Tree after deletion : "+tree.traverse(tree.root));
	}
}
