package ImmigrationSystem;

import java.io.IOException;

public class ListCreator {
    static List list = new List<Node>();
    Node node;
    public static List getListInstance(){
        feedList(list);
        return list;
    }
    public static void feedList(List list){

        Person person1 = new Person("Ana", "Bazerque", "29/11/2014", "84376287462");
        Node node1 = new Node(person1, Priority.MEDIUM);

        Person person2 = new Person("Lucas", "Bazerque", "29/12/2014", "364276477");
        Node node2 = new Node( person2, Priority.LOW);

        Person person3 = new Person("Luiz", "Bazerque", "29/12/2015", "36428887");
        Node node3 = new Node( person3, Priority.HIGH);

        Person person4 = new Person("Maria", "Bazerque", "29/12/2017", "36477777");
        Node node4 = new Node( person4, Priority.LOW);

        Person person5 = new Person("Jucivaldo", "Bazerque", "29/12/2017", "36477777");
        Node node5 = new Node( person5, Priority.MEDIUM);

        Person person6 = new Person("Cleidevania", "Bazerque", "29/12/2017", "36477777");
        Node node6 = new Node( person6, Priority.HIGH);

        try {
            list.create(node1);

        list.create(node2);
        list.create(node3);
        list.create(node4);
        list.create(node5);
        list.create(node6);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
