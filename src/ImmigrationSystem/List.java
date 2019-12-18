package ImmigrationSystem;

import Views.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class List <L> {

	//Attributes of a generic List

	private Node first;
	private Node last;
	private int size;
	private Node lastHigh;
	private Node lastMedium;
	private int position = 1;
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private Menu menu;


	// Constructor of a List
	public List() {
		this.size = 0;
		this.first = null;
		this.last = null;
		this.position = position++;
	}

	///////////////////////////////////////////////////////////////////////////////////
	//entry method to place que new node in the right position in the queue
	public void create(Node newNode) throws IOException {
		if (this.size == 0) {     //checks if the list is empty
			this.first = newNode; // new node will be the first
			this.last = newNode;  // and the last in the list
		}

		if (newNode.getPriorityLevel() == Priority.HIGH) { //if the new node is a high priority, calls the correspondent method
			createHigh(newNode);

		} else if (newNode.getPriorityLevel() == Priority.MEDIUM) { //if the new node is a medium priority, calls the correspondent method
			createMedium(newNode);

		} else {                             // if none of the previous, add the new node to the end of the list
			newNode.setPrevious(this.last);  // and sets the next and previous nodes with the right references
			this.last.setNext(newNode);
			this.last = newNode;
		}
		size++; // increases the size of the list


	}

	///////////////////////////////////////////////////////////////////////////////////
	//method to create a node in the medium priority position in the list
	private void createMedium(Node newNode) {

		if (this.lastMedium == null && this.lastHigh != null) { //if the list only contains high priority nodes
			newNode.setNext(this.lastHigh.getNext());           // and sets the new node after the last high priority node
			newNode.setPrevious(this.lastHigh);
			lastHigh.setNext(newNode);
			if (newNode.getNext() == null) { // checks if the new node is the last, set is as last
				this.last = newNode; // new node becomes the last node on the list
			} else {
				newNode.getNext().setPrevious(newNode);
			}

		} else if (this.lastMedium == null && this.lastHigh == null) { //if the list only contains low priority nodes
			this.first.setPrevious(newNode);                           // sets the new node before all the existing nodes
			newNode.setNext(this.first);
			this.first = newNode; //new node becomes the first on the list

		} else {                                        // sets new node after the las medium on the list
			newNode.setNext(this.lastMedium.getNext()); // and sets the corresponding references for the links
			newNode.setPrevious(this.lastMedium);
			this.lastMedium.setNext(newNode);

			if (newNode.getNext() == null) { // checks if the new node is the last on the list
				this.last = newNode;         //sets new node as the last
			} else {
				newNode.getNext().setPrevious(newNode); //
			}
		}
		this.lastMedium = newNode; // the new node with a medium priority will always be set as the last medium on the list
	}

	///////////////////////////////////////////////////////////////////////////////////
	//method to create a now node which has the "high" priority in the list
	public void createHigh(Node newNode) {
		if (this.lastHigh == null) {
			this.first.setPrevious(newNode);
			newNode.setNext(this.first);
			this.first = newNode;
		} else {
			newNode.setNext(this.lastHigh.getNext());
			newNode.setPrevious(this.lastHigh);
			this.lastHigh.setNext(newNode);
			//if there are only high priority nodes on the list the node is added to the end of the list)

			if (this.lastHigh == this.last) {
				this.last = newNode;
				//if there are nodes with other priority
			} else {
				((Node) this.lastHigh.getNext()).setPrevious(newNode);
			}
		}
		this.lastHigh = newNode;
	}

	//////////////////////////////////////////////////////////////////////////////////
	//method to search a node by the id contained in the data inside the node
	public Node searchById(int id) {
		if (this.getSize() == 0) {
			return null;
		}
		Node current = this.getFirst();
		while (current != null) {
			if (current.getData().getId() == id)
				return current;
			else {
				current = current.getNext();
			}
		}
		return null;
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// method to update the data of a person inside a node
	// the method takes an integer that will be taken by the search method
	//the returned node will have its data updated field by field with user input
	public void updatePersonData(int id) throws IOException {
		Node current = searchById(id);
		System.out.println("");
		System.out.println("Please type in the First Name");
		String name = input.readLine();
		current.getData().setFirstName(name);
		System.out.println("Please type in the Family Name");
		String surname = input.readLine();
		current.getData().setLastName(surname);
		System.out.println("Please type in the date of arrival");
		String date = input.readLine();
		current.getData().setDateOfArrival(date);
		System.out.println("Please type in the passport number");
		String passport = input.readLine();
		current.getData().setPassportNumber(passport);
		System.out.println(current);
		printList();

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	//method to remove node from the end
	//the method takes an int amount that is the number of nodes that will be deleted from the end of the list
	public void deleteFromEnd(int amount) {

		if(size==0)
			return;
		Node currentNode = this.last;

		while(amount>0&&size>0){ // as long as the amount to be delete and the size of the list are bigger than zero
			System.out.println(currentNode);
			if(this.first == currentNode) //checks if the current node is the first on the list deletes the first node
				this.first = null;
			this.last = currentNode.getPrevious();
			if(this.last!=null) //checks if the las is not null and sets the node's links
				this.last.setNext(null);
			currentNode.setPrevious(null);
			currentNode = this.last;

			amount--; // it decreases the amount to be deleted and the size of the list
			size--;
		}
		this.getLast().getPrevious().setNext(null); // is size or amount reaches zero, stop and
													// sets all the links with the new arrangement
		this.last = this.last.getPrevious();
		size--;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////
	//method to remove node by id
	//the method takes an id from user input and returns the node which has the person with that id
	public boolean deleteById(int id) {

		Node current = searchById(id);
		if (current != null) {       // if the id exists on the list, reset the links and deletes the entry
			current.getNext().setPrevious(current.getPrevious());
			current.getPrevious().setNext(current.getNext());
			printList();
			return true;
		}
		return false;
	}

	///////////////////////////////////GETTERS AND SETTERS/////////////////////////////////////

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setLastHigh(Node lastHigh) {
		this.lastHigh = lastHigh;
	}

	public int getPosition(int id) {
		return position;
	}
	public void setPosition(int position) {
		this.position = position++;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	//method to print the list populated by its nodes
	public void printList() {

		if (size == 0) {
			System.out.println("The list is empty");
			return;
		}
		Node current = first;
		while (current != null) {

			Person person = current.getData();
			System.out.println("Position:" + (position++) + " Arrival:" + person.getDateOfArrival() + " ID:" + person.getId() + " Name:" + person.getFirstName() + " " + person.getLastName() + " Passport:" + person.getPassportNumber() + " Priority:" + current.getPriorityLevel());
			current = current.getNext();
		}
	}
}