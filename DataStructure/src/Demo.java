import java.util.Iterator;

public class Demo {
    public static void main(String[] args){
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst("A");
        singleLinkedList.addFirst("B");
        singleLinkedList.addFirst("C");
        System.out.println(singleLinkedList);
        //System.out.println(singleLinkedList.removeFirst());
        //System.out.println(singleLinkedList.removeFirst());
        //System.out.println(singleLinkedList.removeFirst());

        System.out.println(singleLinkedList.removeLast());
        System.out.println(singleLinkedList.removeLast());
        System.out.println(singleLinkedList.removeLast());

        System.out.println(singleLinkedList);


        /*
        singleLinkedList.addLast("A");
        singleLinkedList.addLast("B");
        singleLinkedList.addLast("C");

        Iterator<String> i = singleLinkedList.iterator();

        while (i.hasNext()){
            System.out.println(i.next());
        }
        for (String s :
                singleLinkedList) {
            System.out.println(s);
        }*/

    }
}
