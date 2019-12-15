package ImmigrationSystem;

import java.util.Scanner;

public class List <L> {

	//Attributes of a generic List
	private Node first;
	private Node last;
	private int size;
	private Node lastHigh;
	private Node lastMedium;
	private Node current;
	Scanner scanner = new Scanner(System.in);

	// Constructor of a List
	public List() {
		this.size = 0;
		this.first = null;
		this.last = null;
	}

	public void create(Node newNode) {
		if (this.size == 0) {
			this.first = newNode;
			this.last = newNode;
		}

		if (newNode.getPriorityLevel() == Priority.HIGH) {
			createHigh(newNode);

		} else if (newNode.getPriorityLevel() == Priority.MEDIUM) {
			createMedium(newNode);

		} else {
			newNode.setPrevious(this.last);
			this.last.setNext(newNode);
			this.last = newNode;
		}
		size++;
	}

	private void createMedium(Node newNode) {

		if (this.lastMedium == null && this.lastHigh != null) {
			newNode.setNext(this.lastHigh.getNext());
			newNode.setPrevious(this.lastHigh);
			lastHigh.setNext(newNode);
			if (newNode.getNext() == null) {
				this.last = newNode;
			} else {
				newNode.getNext().setPrevious(newNode);
			}

		} else if (this.lastMedium == null && this.lastHigh == null) {
			this.first.setPrevious(newNode);
			newNode.setNext(this.first);
			this.first = newNode;

		} else {
			newNode.setNext(this.lastMedium.getNext());
			newNode.setPrevious(this.lastMedium);
			this.lastMedium.setNext(newNode);

			if (newNode.getNext() == null) {
				this.last = newNode;
			} else {
				newNode.getNext().setPrevious(newNode);
			}
		}
		this.lastMedium = newNode;
	}

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

	public Node searchById(int id) {
		if (this.getSize() == 0) {
			//System.out.println("booooooo");
			return null;
		}
		Node current = this.getFirst();
		while (current != null) {
			//System.out.println("ID do momento:"+current.getData().getId());
			if (current.getData().getId() == id)
				return current;
			else {
				current = current.getNext();
			}
		}
		return null;
	}

	//remove from the end
	public void deleteFromEnd(int amount) {

		if(size==0)
			return;
		Node currentNode = this.last;

		while(amount>0||size>0){
            System.out.println(currentNode);
			if(this.first == currentNode)
                this.first = null;
                this.last = currentNode.getPrevious();
                if(this.last!=null)
                    this.last.setNext(null);
                    currentNode.setPrevious(null);
                    currentNode = this.last;

			amount--;
			size--;
		}
		this.getLast().getPrevious().setNext(null);
		this.last = this.last.getPrevious();
		size--;
	}

	public boolean deleteById(int id) {

		Node current = searchById(id);
		if (current != null) {
			current.getNext().setPrevious(current.getPrevious());
			current.getPrevious().setNext(current.getNext());
			printList();
			return true;
		}
		return false;
	}

	///////GETTERS AND SETTERS///////

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

	public void printList() {

		if (size == 0) {
			System.out.println("Tem Ninguem");
			return;
		}
		int position = 1;
		Node current = first;
		while (current != null) {

			Person person = current.getData();
			System.out.println("Position:" + (position++) + " Arrival:" + person.getDateOfArrival() + " ID:" + person.getId() + " Name:" + person.getFirstName() + " " + person.getLastName() + " Passport:" + person.getPassportNumber() + " Priority:" + current.getPriorityLevel());
			current = current.getNext();
		}
	}

	public void updatePerson() {
	}
}