/*
Problem-22: Give an algorithm for finding the number of levels. The only change is, we need to keep track of the sums as well.
*/

import java.util.Queue;
import java.util.LinkedList;

public class FindLevels
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
//////////////////////////////////problem Solution//////////////////////////////////////
		
	int findLevelsMaxSum(Node node)
	{
		int max_sum = 0, current_sum=0;
		if(node == null)
		{
			return 0;
		}
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(node);
		
		while(!queue.isEmpty())
		{
			Node temp = queue.poll();
			if(temp != null)
			{
				
				if(temp.left != null)
				{
					queue.add(temp.left);
					current_sum = temp.left.data + temp.right.data;
					
				}
				if(temp.right != null)
				{
					queue.add(temp.right);
					current_sum = temp.left.data + temp.right.data;
				}
				

			}
			else
			{
				if(current_sum > max_sum)
				{
					max_sum = current_sum;
				}
				current_sum = 0;
				if(!queue.isEmpty())
				{
					queue.add(null);
				}
			}
		}
		return max_sum;
	}


//////////////////////////////////////////MAIN/////////////////////////////////////////////

	public static void main(String[] args)
	{
		FindLevels tree = new FindLevels();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);
		
		System.out.println("Level Max sum: "+tree.findLevelsMaxSum(tree.root));
	}
}