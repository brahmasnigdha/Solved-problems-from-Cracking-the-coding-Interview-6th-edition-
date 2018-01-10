/*
	Problem-9: Give an algorithm for printing the level order data in reverse order. For example, the output for the below tree should be: 4 5 6 7 2 3 1
	
			          1
			    /  		\
			   2            3
			/     \        /   \    
		       4       5      6     7
*/

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class ReverseLevelOrder
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
		
		if(node == null)
		{
			return 0;
		}
		else
		{
			int left_height = height(node.left);
			int right_height = height(node.right);
			
			if(left_height > right_height)
			{
				return (left_height+1);
			}
			else
			{
				return (right_height+1);
			}
		}
	}
	
	void reverseLevelOrder(Node node, int height)
	{
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		
		
		queue.add(node);
		
		while(!queue.isEmpty())		
		{
			Node temp = queue.poll();
			
			
			if(temp.right != null)
			{
				queue.offer(temp.right);
			}
			if(temp.left != null)
			{
				queue.offer(temp.left);
			}
			stack.push(temp);
		}
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop().data+" ");
		}
		
	
		
	}

//////////////////////////////////////////MAIN/////////////////////////////////////////////

	public static void main(String[] args)
	{
		ReverseLevelOrder tree = new ReverseLevelOrder();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);
		
		System.out.print("Reverse Level Order: ");
		tree.reverseLevelOrder(tree.root, tree.height(tree.root));
		System.out.println();
	}
}