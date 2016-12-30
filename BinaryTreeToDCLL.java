import java.util.LinkedList;
import java.util.Queue;

/*
 * 
Convert a Binary Tree to a Circular Doubly Link List

Given a Binary Tree, convert it to a Circular Doubly Linked List (In-Place).

    The left and right pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
    The order of nodes in List must be same as Inorder of the given Binary Tree.
    The first node of Inorder traversal must be head node of the Circular List.
    
Algo :

 The idea can be described using below steps.
1) Write a general purpose function that concatenates two given circular doubly lists (This function is explained below).
2) Now traverse the given tree
….a) Recursively convert left subtree to a circular DLL. Let the converted list be leftList.
….a) Recursively convert right subtree to a circular DLL. Let the converted list be rightList.
….c) Make a circular linked list of root of the tree, make left and right of root to point to itself.
….d) Concatenate leftList with list of single root node.
….e) Concatenate the list produced in step above (d) with rightList.

Note that the above code traverses tree in Postorder fashion. We can traverse in inorder fashion also. We can first concatenate left subtree and root, then recur for right subtree and concatenate the result with left-root concatenation.

How to Concatenate two circular DLLs?

    Get the last node of the left list. Retrieving the last node is an O(1) operation, since the prev pointer of the head points to the last node of the list.
    Connect it with the first node of the right list
    Get the last node of the second list
    Connect it with the head of the list.

 */
public class BinaryTreeToDCLL {
	
	class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	Node root;

	public void insertNodeBST(int data) {

		Node node = new Node(data);
		if (root == null) {
			root = node;
			return ;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		
		while(true) {
	        Node n = queue.remove();
	        if(n.left == null) {
	            n.left = node;
	            break;
	        } else {
	            queue.offer(n.left);
	        }           

	        if(n.right == null) {
	            n.right = node;
	            break;
	        } else {
	            queue.offer(n.right);
	        }
	    }
	}
	
	public Node concatenateLists(Node leftList, Node rightList){
		
		if(leftList == null)
			return rightList;
		if(rightList == null)
			return leftList;
		
		Node lastLeft = leftList.left;
		Node rightLast = rightList.left;
		
		lastLeft.right = rightList;
		rightList.left = lastLeft;
		
		leftList.left = rightLast;
		rightLast.right = leftList;
		
		return leftList;
				
	}
	
	public Node convertBTreeToDCLL(Node root){
		
		if(root == null)
			return null;
		
		Node left = convertBTreeToDCLL(root.left);
		Node right = convertBTreeToDCLL(root.right);
		
		root.left = root.right = root;
		
		return concatenateLists(concatenateLists(left, root), right);
	}
	
	public void printList(Node head) {

		Node current = head;
		while (current.right != head) {

			System.out.print(current.data + "  ");
			current = current.right;
		}
		System.out.println(current.data);
	}

	public void insertNode(int data) {
		insertNodeBST(data);
	}

	public static void main(String[] args) {
		
		BinaryTreeToDCLL dll = new BinaryTreeToDCLL();
		dll.insertNode(10);
		dll.insertNode(12);
		dll.insertNode(15);
		dll.insertNode(25);
		dll.insertNode(30);
		dll.insertNode(36);

		BinaryTreeToDCLL.Node head = dll.convertBTreeToDCLL(dll.root);
		dll.printList(head);
	}

}
