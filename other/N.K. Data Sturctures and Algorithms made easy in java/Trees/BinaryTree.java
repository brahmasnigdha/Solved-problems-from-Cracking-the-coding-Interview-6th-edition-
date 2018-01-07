import java.util.Stack;
import java.util.LinkedList;

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
	}
	
		
	
	
}