public class Driver {
    public static void main(String[] args) {

        SingleLinkedList<String> sll = new SingleLinkedList<String>();
        sll.add(0, "Two");
        sll.add(0, "One");
        System.out.println(sll.toString());


    }
}
