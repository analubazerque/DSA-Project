package ImmigrationSystem;

import java.util.Scanner;

public class Node <E> {
	
	// Attributes of a generic Node
	private Node next;
	private Node previous;
	private Person data;
	private Priority priorityLevel;
	private String level;


	// Constructor of a Node
	public Node (Node next, Node previous, Person data, Priority priority) {

		this.next = next;
		this.previous = previous;
		this.data = data;
		this.priorityLevel = priority;
	}

	public Node (Person data, String priority) {
		level = priorityLevel.getLevel(priority);
		priorityLevel = level;
		this.data = data;

	}
	
	///////GETTERS AND SETTERS///////
	
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
}
