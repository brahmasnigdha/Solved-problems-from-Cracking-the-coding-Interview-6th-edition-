/*
	Problem-25: Give an algorithm for finding the sum of all elements in binary tree.

Solution: Recursively, call left subtree sum, right subtree sum and added their values to current nodes data

*/

import java.util.Queue;
import java.util.LinkedList;

public class SumBinaryTreeElement
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

	///////////////////////Problem Solution//////////////////////////

	int sumTree(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		
		int sum = 0;
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(node);
		
		while(!queue.isEmpty())
		{
			Node tmp = queue.poll();
			sum += tmp.data;
			
			if(tmp.left != null)
			{
				queue.add(tmp.left);
			}
			if(tmp.right != null)
			{
				queue.add(tmp.right);
			}
		}	
		return sum;		
	}

	////////////////////////////////MAIN/////////////////////////////////
	public static void main(String[] args)
	{
		SumBinaryTreeElement tree = new SumBinaryTreeElement();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);	

		System.out.println("Sum of elements in the Tree: "+tree.sumTree(tree.root));	
	}
}