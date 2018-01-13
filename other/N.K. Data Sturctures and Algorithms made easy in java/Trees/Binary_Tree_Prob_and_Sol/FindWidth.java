/*
	Problem-21: Give an algorithm for finding the width of the binary tree. The diameter of a tree is the maximum number of nodes at any level (or depth) in the tree.
*/

import java.util.Queue;
import java.util.LinkedList;

public class FindWidth
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
//////////////////////////////////Problem Solution//////////////////////////////////////

	int maxDepthRecursive(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		
		int left = maxDepthRecursive(node.left);
		int right = maxDepthRecursive(node.right);
		int diameter = 0;
		
		if(left + right > diameter)
		{
			diameter = left + right;
		}
		
		return Math.max(left, right)+1;
	}
	
	public int width(Node node)
	{
		int max = 0;
		int height = maxDepthRecursive(node);
		
		for(int k = 0; k <= height; k++)
		{
			int tmp = width(node, k);
			if(tmp > max)
			{
				max = tmp;
			}
		}
		return max;
	}
	
	public int width(Node node, int depth)
	{
		if(node == null)
		{
			return 0;
		}
		else
		{
			if(depth == 0)
			{
				return 1;
			}
			else
			{
				return width(node.left, depth-1)+width(node.right, depth-1);
			}
		}
	}
//////////////////////////////////////////MAIN/////////////////////////////////////////////

	public static void main(String[] args)
	{
		FindWidth tree = new FindWidth();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);
		
		System.out.println("Width of the tree: "+ tree.width(tree.root));
		
	}
}