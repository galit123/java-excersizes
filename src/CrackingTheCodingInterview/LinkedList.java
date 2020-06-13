package CrackingTheCodingInterview;

public class LinkedList {
	Node head = null;

	public Node addNode(int data) {
		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
			newNode.prev = head;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}			
			n.next = newNode;
			newNode.prev = head;
		}
		return head;
	}
	

}
