import java.util.ArrayList;
import java.util.List;

class Node1{
	int data;
	Node1 left;
	Node1 right;
		
}
class BinTree{
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	public Node1 newNode1(int data){
		Node1 temp = new Node1();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}

	public void printCommonNode1sBST(Node1 root1, Node1 root2){

		if(root1 != null && root2 != null){
			getInorderArray(root1, list1); 
			getInorderArray(root2, list2);
			int i =0;int j=0;
			while(i < list1.size() && j < list2.size()){
				
				if(list1.get(i) < list2.get(j))
					i++;
				else if(list1.get(i) > list2.get(j))
					j++;
				else if(list1.get(i) == list2.get(j)){
					System.out.println(list1.get(i));
					i++;
					j++;
				}
				else
					System.out.println("No common Node1s");
			}
		}		
	}
	
	public void getInorderArray(Node1 root, List<Integer> list){
		
		List<Integer> list1 = list;
		if(root != null){
			getInorderArray(root.left, list1);
		    list.add(root.data);
		    getInorderArray(root.right, list1);
		}		
	}

}
public class CommonNodesBST {
	
	public static void main(String[] args) {
		
		BinTree binTree = new BinTree();
		Node1 root1 = binTree.newNode1(5);
		root1.left = binTree.newNode1(1);
		root1.left.left = binTree.newNode1(0);
		root1.left.right = binTree.newNode1(4);
		root1.right = binTree.newNode1(10);
		root1.right.left = binTree.newNode1(7);
		root1.right.left.right = binTree.newNode1(9);
		
		Node1 root2 = binTree.newNode1(10);
		root2.left = binTree.newNode1(7);
		root2.left.left = binTree.newNode1(4);
		root2.left.right = binTree.newNode1(9);
		root2.right = binTree.newNode1(20);
		
		binTree.printCommonNode1sBST(root1,root2);


	}

}
