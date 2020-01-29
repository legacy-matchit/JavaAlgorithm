import java.util.NoSuchElementException;

public class SingleLinkedStack<E> {

    private Node<E> first;

    public void addFirst(E e){
        Node<E> n = new Node<>(e);
        n.next = first;
        first = n;
    }
    public E removeFirst(){
        if(first == null){
            throw new NoSuchElementException();
        }
        Node<E> tem = first;
        first = first.next;
        return tem.element;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> n = first;
        while (n!=null){
            sb.append(n.element + ",");
            n = n.next;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E>{
        private E element;
        private Node<E> next;

        private Node(E e){
            element = e;
            next = null;
        }
    }
}
