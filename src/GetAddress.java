
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;


public class GetAddress {                  //获取变量地址
    static final Unsafe unsafe = getUnsafe();
    static final boolean is64bit = true;
    
    public static void main(String... args) {
        //    Double[] ascending = new Double[16];
        //    for (int i = 0; i < ascending.length; i++)
        //       ascending[i] = (double) i;
        
       /* String s0="sdf";
        String s1;
        s1=s0;
        //s0="hhh";
        //System.out.println("Before GC");
        System.out.println("s0:"+s0);
        System.out.println("s1:"+s1);
        printAddresses("s0 address:", s0);
        printAddresses("s1 address:", s1);
    
    
        int q0,q1;
        q0=10;
        q1=q0;
       // q0=20;
        System.out.println("q0:"+q0);
        System.out.println("q0:"+q1);
        printAddresses("q0 address:", q0);
        printAddresses("q1 address:", q1);
        
       // System.gc();
       // System.out.println("\nAfter GC");
       // printAddresses("ascending", s0);
       // printAddresses("ascending", s1);
        */
       
       /*
        Human human = new Human("小明");
        printAddresses("address:", human);
        update(human);
        printAddresses("address:", human.getName());
        System.out.println("执行方法后的name" + human.getName());
        */
       
       Human[] human =new Human[2];
       Human human1=new Human(26,"aaa");
       Human human2=new Human(27,"bbb");
       human[0]=human1;
       human[1]=human2;
       human[0].setName("ccc");
       System.out.println(human1.getName());
        printAddresses("address:", human1);
        printAddresses("address:", human2);
        printAddresses("address:", human[0]);
        printAddresses("address:", human[1]);
    
    }
    
    public static void printAddresses(String label, Object... objects) {
        System.out.print(label + ": 0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    else
                        System.out.print(", -" + Long.toHexString(last - i2));
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        System.out.println();
    }
    
    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
    
    
    public static void update(Human human) {
        System.out.println("传入的name:" + human.getName());
        human = new Human("哈 哈哈");
        human.setName("小红");
        System.out.println("方法内改后的name" + human.getName());
    }
    
}

class Human {
    private int age;
    private String name;
    
    public Human() {
    
    }
    
    public Human(String name) {
        this.name = name;
    }
    
    public Human(int age) {
        this.age = age;
    }
    
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}

