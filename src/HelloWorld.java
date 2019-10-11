import java.util.*;

public class HelloWorld {
    public static void main(String args[]) {
        
        
        //var i = 1;
        double x = 1.0 / 10;
        double y = 9.0 / 10.0;
        
        String s = new String();
        String t = s;
        s = "nihao";
        System.out.println(t);
        System.out.println(s);
        
        
        int ns[] = new int[]{85};
        ns[0] = 45;
        System.out.println(ns[0]);
        
        System.out.println("input:");
        Scanner scanner = new Scanner(System.in);
       /* int n = scanner.nextInt();                //scanner类
        System.out.println(n);
        switch (n) {                                //switch
            case 1:
                System.out.println("56");
                break;
            case 2:
            default:
                System.out.println(n);
                break;
            
        }
        for(int no:ns){
            System.out.println(no);
        }
*/
        int[] a1 = {1, 2, 3, 4, 5};            //基本类型，可更改，非引用
        int[] a2;
        a2 = a1;
        System.out.println(a1[0]);
        a2[0] = 10;
        System.out.println(a1[0]);
        
        String s1 = "abc";                     //不可变字符串，。concat返回new String
        String s2 = s1;
        String s3 = s1.concat("ef");
        s1 = "dsf";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        
        String[] names = {"ABC", "XYZ", "zoo"};   //数组里面不是基本类型，是引用类型
        String s4 = names[1];
        names[1] = "cat";
        System.out.println(s4); // s是"XYZ"还是"cat"?
        System.out.println(names[1]); // s是"XYZ"还是"cat"?
        
        int[] array = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        // 排序前:
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {           //冒泡倒序
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        int[][] ns1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(Arrays.deepToString(ns1));
        
        Student p = new Student("ming", 18, 89);
        //p.setAge(15);
        System.out.println(p.getAge()); // 15
        System.out.println(a1[0]=14); // 15
        
        
    }
}

class Person {
    
    protected int age;
    protected String name;
     Person(){ }
    
    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
}

class Student extends Person {
    //
    protected int sore;
    
    public Student(String name, int age, int sore) {
        super(name, age);
        this.sore = sore;
    }
    
}


