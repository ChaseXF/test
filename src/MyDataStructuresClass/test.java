package MyDataStructuresClass;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Iterator;

public class test<T> {
    private T a;
    //@org.jetbrains.annotations.Contract(pure = true)
    test(T a){
        this.a=a;
    }
    T get(){
        return this.a;
    }
    
    public static void main(String[] args){
         MyArrayList array= new MyArrayList();
         array.add("adwf");
         //array.add(15,"adwf");
         array.add(1,2,3,4,5,6,7,8,9,10,11,12);
         array.print();
         System.out.println(array.size()+" "+array.length());
    
        Iterator itr=array.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        ArrayList a=new ArrayList();
        a.ensureCapacity( 5);
        
        test<Integer> b=new test<Integer>(65);
        System.out.println(b.get());
    }
}
