package MyDataStructuresClass;

//import java.util.Iterator;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
    
    
    
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private AnyType[] theItems;
    
    public MyArrayList() {
        doClear();
    }
    
    public void clear() {
        doClear();
    }
    
    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }
    
    public int size() {
        return theSize;
    }
    
    public int length() {
        return theItems.length;
    }
    
    public boolean isEmpty() {
        return theSize == 0;
    }
    
    public void trimToSize() {
        ensureCapacity(size());
    }
    
    public AnyType get(int index) {
        if (index < 0 || index > size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[index];
    }
    
    public AnyType set(int index, AnyType newVal) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[index];
        theItems[index] = newVal;
        return old;
    }
    
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize)
            return;
        AnyType[] temp = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < theSize; i++) {
            temp[i] = theItems[i];
        }
        theItems = temp;
       /*AnyType[] old=theItems;
       theItems=(AnyType [])new Object[newCapacity];
       for(int i=0;i<size();i++)
           theItems[i]=old[i];*/
    }
    
    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }
    
    public boolean add(AnyType...x) {
        for(AnyType i : x)
            add(size(), i);
        return true;
    }
    
    public void print(){
        for(int  i=0;i<theSize;i++ )
        System.out.println(theItems[i]);
    }
    
    public void add(int index, AnyType x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        if(index<0||index>theItems.length){
            throw new ArrayIndexOutOfBoundsException();
        }
            for (int i = theSize; i > index; i--)
            theItems[i] = theItems[i - 1];
        theItems[index] = x;
        theSize++;
    }
    public AnyType remove(int index){
        check(index);
        AnyType removedItem=theItems[index];
        for(int i=index;i<size()-1;i++){
            theItems[i]=theItems[i+1];
        }
        theSize--;
        return removedItem;
    }
    
    private void check(int index){
        if (index < 0 || index > size())
            throw new ArrayIndexOutOfBoundsException();
    }
    
    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayLisrIterator();
    }
    
    private class ArrayLisrIterator implements Iterator<AnyType>{
        private int current=0;
        public boolean hasNext(){
            return current<size();
        }
        
        public AnyType next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return theItems[current++];
        }
        public void remove(){
            MyArrayList.this.remove(--current);
        }
    }
}


























