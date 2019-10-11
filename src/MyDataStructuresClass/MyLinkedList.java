package MyDataStructuresClass;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    

    
    private static class Node<AnyType> {
    
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;
        
        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }
        
       
    }
    
    private int theSize;
    private int modCount;
    private Node<AnyType> beginMaker;
    private Node<AnyType> endMaker;
    
    public MyLinkedList() {
        doClear();
    }
    
    public void clear() {
        doClear();
    }
    
    private void doClear() {
        beginMaker = new Node<AnyType>(null, null, null);
        endMaker = new Node<AnyType>(null, beginMaker, null);
        beginMaker.next = endMaker;
        theSize = 0;
        modCount++;
    }
    
    public int size() {
        return theSize;
    }
    
    public boolean isEmpty() {
        return theSize == 0;
    }
    
    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }
    
    public void add(int index, AnyType x) {
        aadBefore(getNode(index, 0, size()), x);
    }
    
    public AnyType get(int index) {
        return getNode(index).data;
    }
    
    public AnyType set(int index, AnyType newVal) {
        Node<AnyType> p = getNode(index);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }
    
    public AnyType remove(int index) {
        return remove(getNode(index));
    }
    
    private void aadBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
        p.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }
    
    private AnyType remove(Node<AnyType> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize--;
        modCount++;
        return p.data;
    }
    
    private Node<AnyType> getNode(int index) {
        return getNode(index, 0, size() - 1);
    }
    
    private Node<AnyType> getNode(int index, int lower, int upper) {
        Node<AnyType> p;
        if (index < lower || index > upper)
            throw new IndexOutOfBoundsException();
        if (index < size() / 2) {
            p = beginMaker;
            for (int i = 0; i < index; i++)
                p = p.next;
        } else {
            p = endMaker;
            for (int i = size(); i > index; i--)
                p = p.prev;
        }
        return p;
    }
    
    
    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator{
        private Node<AnyType> currrent=beginMaker.next;
        private int expectedModcount=modCount;
        private boolean okToRemove=false;
        
        public boolean hasNext(){
            return currrent!=endMaker;
        }
        
        public AnyType next(){
            if(modCount!=expectedModcount)
                throw new ConcurrentModificationException();
            if(!hasNext())
                throw new NoSuchElementException();
            AnyType nextItem=currrent.data;
            currrent=currrent.next;
            okToRemove=true;
            return nextItem;
        }
        
        public void remove(){
            if(modCount!=expectedModcount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            MyLinkedList.this.remove(currrent.prev);
            expectedModcount++;
            okToRemove=false;
        }
    }
    
}
