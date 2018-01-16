/*
	Problem-15: Give and algorithm for deleting an element (assuming data is given) from binary tree.
*/

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class deleteElementTree
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
	
	Node deepestNode(Node node)
	{
		Queue<Node> queue = new LinkedList<Node>();
		Node temp = null;
		
		if(node == null)
		{
			return null;
		}
				
		queue.add(node);
		
		while(!queue.isEmpty())
		{
			temp = queue.poll();
			if(temp.left != null)
			{
				queue.add(temp.left);
			}
			if(temp.right != null)
			{
				queue.add(temp.right);
			}
		}
		return temp;
	}
	
	Node searchElement(int data, Node node)
	{
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		
		while(!stack.isEmpty())
		{
			Node temp = stack.pop();
			
			if(temp.data == data)
			{
				return temp;
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
		return null;
		
	}
	
	void deleteNode(Node node1, Node node_search)
	{
		
		/*Node searchNode = searchElement(node_search.data, node1);
		Node deepestNode = deepestNode(node1);
		
		Node temp = deepestNode;
		deepestNode = searchNode;
		searchNode = temp;
		
		deepestNode = null;*/
		
		node_search = null;
		
		//return node;
		
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
		deleteElementTree tree = new deleteElementTree();

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
		
		tree.deleteNode(tree.root,root_right);
		
		//tree.traverse(tree.root);
		
		System.out.println();		

	}
}