/*
	Problem 16: Give an algorithm for finding the number of leaves in the binary tree without using recursion
*/

import java.util.LinkedList;
import java.util.Queue;

public class findLeaves
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
	
	/////////////////////////////////////Problem Solution///////////////////////////////

	int countLeaves(Node node)
	{
		Queue<Node> queue = new LinkedList<Node>();

		int count = 0;
		
		if(node == null)				
		{
			return 0;
		}
		
		queue.add(node);
		
		while(!queue.isEmpty())
		{
			Node temp = queue.poll();
			
			if(temp.left == null && temp.right == null)
			{
				count++;
			}
			
			if(temp.left != null)
			{
				queue.add(temp.left);
			}
			
			if(temp.right != null)
			{
				queue.add(temp.right);
			}
		}
		
		return count;		
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
		findLeaves tree = new findLeaves();

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
		System.out.print("Number of leaves: "+tree.countLeaves(tree.root));
		System.out.println();
	}
	
}