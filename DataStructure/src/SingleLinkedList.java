import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E> {

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

    public void addLast(E e){
        Node<E> n = new Node<>(e);
        if(first == null){
            first = n;
        }else{
            Node<E> current = first;
            while (current.next != null){
                current = current.next;
            }
            current.next = n;
        }
    }

    public E removeLast(){
        if(first == null){
            throw new NoSuchElementException();
        }
        if(first.next == null){
            Node<E> tem = first;
            first = null;
            return tem.element;
        }
        Node<E> current = first;
        Node<E> pre = null;
        while (current.next != null){
            pre = current;
            current = current.next;
        }
        pre.next = null;
        return current.element;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = first;
        while (current!=null){
            sb.append(current.element + ",");
            current = current.next;
            if(current == null){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public Iterator<E> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>{
        private Node<E> pos;
        private ListIterator(){
            pos = first;
        }
        public boolean hasNext(){
            return pos != null;
        }
        public E next(){
            if(hasNext()){
                Node<E> tem = pos;
                pos = pos.next;
                return tem.element;
            }else{
                throw new NoSuchElementException();
            }
        }
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
