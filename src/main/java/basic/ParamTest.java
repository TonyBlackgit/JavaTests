package basic;

public class ParamTest<T> {
    private static final String  NAME = "HELLO";
    private static final Person P = new Person(1);
    public void swap(T a, T b){
        T tmp = a;
        a = b;
        b = tmp;
    }
    public static void main(String[] args) {
        Integer a = new Integer(1111);
        Integer b = new Integer(2111);
//        StringBuilder a = new StringBuilder("1111");
//        StringBuilder b = new StringBuilder("2222");
        System.out.println("Before swap: "+ "a="+ a + " b=" + b);
        ParamTest p = new ParamTest();
        p.swap(a, b);
        System.out.println("After swap: "+ "a="+ a + " b=" + b);
        System.out.println(7 & (5-1));
    }
}
class Person{
    int age;
    public Person(int age){
        this.age = age;
    }
}