/*
	Problem-24: Give an algorithm for checking the existence of path with given sum. That means, given a sum check whether there exists a path from root to any of the nodes.

Solution: For this problem, the strategy is: subtract the node value from the sum before calling its children recursively, and check to see if the sum is 0 we run out of tree.
*/

public class HasPathSum
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

	/////////////////////////Problem Solution////////////////////

	/*
		Solution: For this problem, the strategy is: subtract the node value from the sum before calling its children recursively, and check to see if the sum is 0 we run out of tree.
	*/
	boolean hasPathSum(Node node, int sum)
	{
		if(node == null)
		{
			return false;
		}
		
		if(node.left == null && node.right == null && node.data == sum)
		{
			return true;
		}
		
		return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);			
	}	

////////////////////////////////MAIN/////////////////////////////////
	public static void main(String[] args)
	{
		HasPathSum tree = new HasPathSum();

		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);		
		
		System.out.println("Has path sum ? "+tree.hasPathSum(tree.root, 0));
	}
}