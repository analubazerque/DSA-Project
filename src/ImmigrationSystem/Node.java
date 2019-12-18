package ImmigrationSystem;

import java.util.Scanner;

public class Node <E> {

	// Attributes of a generic Node
	private Node next;
	private Node previous;
	private Person data;
	private Priority priorityLevel;

	// Constructor of a Node

	public Node (Person data, Priority priority) {
		this.priorityLevel = priority;
		this.data = data;
	}

	public Node (Node next, Node previous, Person data, Priority priority) {

		this.next = next;
		this.previous = previous;
		this.data = data;
		this.priorityLevel = priority;
	}

	//////////////////////////////GETTERS AND SETTERS/////////////////////////////////////

	public Priority getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(Priority priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node newNode) {
		this.next = newNode;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node last) {
		this.previous = last;
	}

	public Person getData() {
		return data;
	}

	public int getId() {
		return data.getId();
	}

	public void setData(Person data) {
		this.data = data;
	}
}
