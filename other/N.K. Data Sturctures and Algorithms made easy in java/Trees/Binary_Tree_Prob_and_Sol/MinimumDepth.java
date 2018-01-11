/*
	Problem-13: Give an algorithm for finding the minimum depth of the binary tree
*/

import java.util.Queue;
import java.util.LinkedList;

public class MinimumDepth
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

///////////////////////////ADD CHILD////////////////////////////////////
	
	Node addLeftChild(int data, Node node)
	{
		Node newChild = new Node(data);
		node.left = newChild;
		return node.left;
	}
	
	Node addRightChild(int data, Node node)
	{
		Node newChild = new Node(data);
		node.right = newChild;
		return node.right;
	}

////////////////////////////////////SOLUTION//////////////////////////////////////////////
	
	int minDepth(Node node) // Data Structures and Algorithms solution
	{
		if(node == null)
		{
			return 0;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(node);
		
		int count = 1;
		
		while(!queue.isEmpty())
		{
			Node currentNode = queue.poll();
			if(currentNode != null)
			{
				if(currentNode.left == null && currentNode.right == null)
				{
					return count;
				}
				if(currentNode.left != null)
				{
					queue.add(currentNode.left);
				}
				if(currentNode.right != null)
				{
					queue.add(currentNode.right);
				}
			}
			else
			{
				if(!queue.isEmpty())	
				{
					count++;
					queue.add(null);
				}
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
		MinimumDepth tree = new MinimumDepth();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		//Node root_right_right = tree.addRightChild(7, root_right);
		
		System.out.println("Tree: ");
		
		tree.traverse(tree.root);
		
		System.out.println("\nMinimumu Depth of the tree: "+ tree.minDepth(tree.root));
	}
	
}