public class Driver {
    public static void main(String[] args) {

        SingleLinkedList sll = new SingleLinkedList();

        for (int x = 0; x < 10; x++){
            sll.add(x+1);
        }

        System.out.println(sll.toString() + ", Size: " + sll.size());

        sll.add(0,10);

        System.out.println(sll.toString() + ", Size: " + sll.size());

        sll.add(sll.size()-1,100);

        System.out.println(sll.toString() + ", Size: " + sll.size());


    }
}
