import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class BinaryTree
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
	/////////////////////////////TRAVERSAL METHODS/////////////////////////
	/////////////////////////preorder traversal
	void preorderTraversal(Node node)
	{
		if(node != null)
		{
			System.out.print(node.data+" ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}	
	
	//Iterative preorder traversal
	LinkedList<Integer> iterativePreorderTraversal(Node node)
	{
		Stack<Node> stack = new Stack<Node>();
		LinkedList<Integer> output = new LinkedList<Integer>();
		if(node == null)
		{
			return output;
		}
		stack.push(node);
		
		while(!stack.isEmpty())
		{
			Node tmp = stack.pop();
			output.add(tmp.data);
			
			if(tmp.right != null)
			{
				stack.push(tmp.right);
			}
			if(tmp.left != null)
			{
				stack.push(tmp.left);
			}
		}
		
		return output;
	}
	
	//////////////////////////inorder traversal
	void inorderTraversal(Node node)
	{
		if(node != null)
		{
			inorderTraversal(node.left);
			System.out.print(node.data+" ");
			inorderTraversal(node.right);
		}
	}

	//non-recursive inorder traversal
	LinkedList<Integer> non_recurse_inorderTraversal(Node node)
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
	
	///////////////////////////postorder traversal
	void postorderTraversal(Node node)
	{
		if(node != null)
		{
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(node.data+" ");
		}
	}

	//////////////////////////Level Order traversal
	/*
		Level order traversal is defined as follows:
		
		-> Visit the root.
		-> While traversing level 1, keep all the elements at level l+1 in queue.
		-> Go to the next level and visit all the nodes at that level.
		-> Repeat the steps until all the levels are completed
	*/
	
	// Method to find the height of the tree
	
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
	
	
	//Level order traversal method
	//
	
	void printLevelOrder(Node node) // geeks for geeks
	{
		int h = height(node);
		
		for(int i = 1; i <= h ; i++)
		{
			levelOrderTraversal(node, i);
		}
	}
	
	void levelOrderTraversal(Node node, int level) //Geeks for geeks
	{
		if(node == null)
		{
			return;
		}
		
		if(level == 1)
		{
			System.out.print(node.data+" ");
		}
		
		else if(level > 1)
		{
			levelOrderTraversal(node.left, level - 1);
			levelOrderTraversal(node.right, level - 1);
		}
	}

	// Levelorder traversal using queue
	ArrayList<Integer> levelOrderTraversal2(Node node, int height)		
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<Node>();
		
		if(node == null)
		{
			return result;
		}
		
		int level = height;
		
		q.add(node);
		
		while(!q.isEmpty())
		{
			Node temp = q.poll();
			
			result.add(temp.data);			
			
			if(temp.left != null && level >=1)
			{
				q.add(temp.left);
			}
			
			if(temp.right != null && level >=1)
			{
				q.add(temp.right);
			}
			level--;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();

		//////////////////////////////TREE//////////////////////////////
		
		tree.root = new Node(1);	
		
		Node root_left = tree.addLeftChild(2, tree.root);
		
		Node root_right = tree.addRightChild(3, tree.root);
		
		Node root_left_left = tree.addLeftChild(4, root_left);
		
		Node root_left_right = tree.addRightChild(5, root_left); 

		Node root_right_left = tree.addLeftChild(6, root_right);
		
		Node root_right_right = tree.addRightChild(7, root_right);

		///////////////////////////////TRAVERSALS/////////////////////////
		System.out.print("Preorder Traversal: ");
		tree.preorderTraversal(tree.root);
		System.out.println();
		
		System.out.print("Inorder Traversal: ");
		tree.inorderTraversal(tree.root);
		
		System.out.print("\nPostorder Traversal: ");
		tree.postorderTraversal(tree.root);
		
		System.out.println("\nIterative Preorder Traversal: "+tree.iterativePreorderTraversal(tree.root));
		
		System.out.println("Non-Recursive Inorder Traversl: "+tree.non_recurse_inorderTraversal(tree.root));
		
		System.out.print("Level Order Traversal: ");
		tree.printLevelOrder(tree.root);
		System.out.println();
		
		System.out.println("Level Order traversal using queue: "+ tree.levelOrderTraversal2(tree.root, tree.height(tree.root)));
	}
	
		
	
	
}