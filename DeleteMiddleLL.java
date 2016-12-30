

class LinkedList1 {
	
	class Node {
		
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		    next = null;
		}
	}
	
	Node head;
	
	public void addNode(int data){
		
		if(head == null){
			head = new Node(data);
			head.next = null;
		} else {
			Node currentNode = head;
			Node newNode = new Node(data);
			newNode.next = currentNode;
			head = newNode;
		}
	}
		
	public void displayList(Node head) {
		
		Node curr = head;
		while(curr.next != null){
			System.out.print(curr.data + "--->");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}
	
	public Node deleteMid(Node head){
		
		if(head == null){
			return null;
		} else if (head.next == null){
			head = null;
		} else {
			Node slowPtr = head;
			Node fastPtr = head;
			
			Node prev = null;
			while (fastPtr != null && fastPtr.next != null){
				fastPtr=fastPtr.next.next;
				prev = slowPtr;
				slowPtr = slowPtr.next;
			}
			
			prev.next = slowPtr.next;
			slowPtr = null;
			
		}
		return head;
	}
	
	public void deleteMidUtil(){
		this.head = deleteMid(head);
	}
}


public class DeleteMiddleLL {

	public static void main(String[] args) {
		LinkedList1 list = new LinkedList1();
		list.addNode(10);
		list.addNode(13);
		list.addNode(21);
		list.addNode(33);
		list.addNode(56);
		
		list.displayList(list.head);
		list.deleteMidUtil();
		list.displayList(list.head);

	}

}
