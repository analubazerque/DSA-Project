package Views;

import ImmigrationSystem.*;

import java.util.Scanner;

public class Menu {

    private int selection;
    private Node node;
    private List list = ListCreator.getListInstance();
    private Scanner input = new Scanner(System.in);
    private int id;
    private Priority priority;
    private String level;

    public void mainMenu() {

        /***************************************************/

        System.out.println("-------------------------\n");
        System.out.println("");
        System.out.println("Please select an option from 1 to 5");
        System.out.println("1 - Search for a person by id number");
        System.out.println("2 - See all the people in the list");
        System.out.println("3 - Add a person to the list");
        System.out.println("4 - Delete a person from the list");
        System.out.println("5 - Update details of a person");
        System.out.println("6 - Exit program");
        System.out.println("");
        selection = input.nextInt();

        switch (selection){
            case 1:
                System.out.println("Please type in the id number");
                id = input.nextInt();
                System.out.println(list.searchById(id).getData());
                mainMenu();
                break;
            case 2:
                list.printList();
                mainMenu();
                break;
            case 3:
                createNodeMenu();
                break;
            case 4:
                list.delete(id);
                break;
            case 5:
                list.updatePerson();
                break;
            case 6:
                System.exit(0);
            default:
                throw new IllegalStateException("Unexpected value: " + selection);
        }
    }

    public void createNodeMenu(){
        //level = priority.getLevel();
        System.out.println("");
        System.out.println("Please type in the First Name");
        String name = input.nextLine();
        System.out.println("Please type in the Family Name");
        String surname = input.nextLine();
        System.out.println("Please type in the date of arrival");
        String date = input.next();
        System.out.println("Please type in the passport number");
        String passport = input.next();

        Person data = new Person(name, surname, date, passport);
        System.out.println((data));

        System.out.println("Please type in the priority level");
        level = input.nextLine();

        Node newNode = new Node(data, level);
        list.create(node);
        list.printList();

    }
}
