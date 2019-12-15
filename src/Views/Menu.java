package Views;

import ImmigrationSystem.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

    private int selection;
    private Node node;
    private List list = ListCreator.getListInstance();
    private Scanner inputsc = new Scanner(System.in);
    private int id;
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public void mainMenu() throws IOException {

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
        selection = inputsc.nextInt();

        switch (selection){
            case 1:
                System.out.println("Please type in the id number");
                id = inputsc.nextInt();
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
                deleteMenu();
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

    public void deleteMenu() throws IOException {
        System.out.println("Want to delete a specific id? 'Y' or 'N'");
        String answer = input.readLine().toLowerCase();
        switch (answer){
            case "y":
                System.out.println("Type in the id number of the person to be deleted");
                int id = inputsc.nextInt();
                list.deleteById(id);
                mainMenu();
                break;
            case "n":
                System.out.println("Type in the number of people you want to delete from the end of the list");
                int amount = inputsc.nextInt();
                list.deleteFromEnd(amount);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + answer);
        }
    }

    public Priority getEnumFromString(String string){
        String compare = string.toLowerCase();
        switch (compare){
            case "low":
                return Priority.LOW;
            case "medium":
                return Priority.MEDIUM;
            case "high":
                return Priority.HIGH;
            default: return null;
        }
    }

    public void createNodeMenu() throws IOException {
        System.out.println("");
        System.out.println("Please type in the First Name");
        String name = input.readLine();
        System.out.println("Please type in the Family Name");
        String surname = input.readLine();
        System.out.println("Please type in the date of arrival");
        String date = input.readLine();
        System.out.println("Please type in the passport number");
        String passport = input.readLine();

        Person data = new Person(name, surname, date, passport);
        System.out.println((data));

        System.out.println("Please type in the priority level");
        String level = input.readLine();
        Priority priority = getEnumFromString(level);
        System.out.println(priority);

        Node newNode = new Node(data, priority);
        list.create(newNode);
        list.printList();
        mainMenu();
        }

    }

