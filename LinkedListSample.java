package test;

public class LinkedListSample {

	static class Node {

		int data;
		Node next;

		Node(int data) {

			this.data = data;
			next = null;

		}

	}

	static Node head;

	public static void insertFirst(int data) {

		Node new_node = new Node(data);
		new_node.next = head;

		head = new_node;
	}

	public static void insertLast(int data) {

		Node current = head;

		while (current.next != null) {
			current = current.next;

		}
		Node newNode = new Node(data);

		current.next = newNode;

	}

	public static void delete() {

		Node temp = head;

		temp = null;
	}


}
