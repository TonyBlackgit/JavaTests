package concurrency;

public class InterfaceTest implements MyInter{
    @Override
    public void existsDefault() {
        System.out.println("default method in class");
    }

    @Override
    public void newMethod() {
        System.out.println("new method");
    }
//    @Override
//    public static void existsStatic(){
//        System.out.println("static method in class");
//    }

    public static void main(String[] args) {
        //验证接口可以声明对象类型
        MyInter m = new InterfaceTest();
        m.existsDefault();
        m.newMethod();
        MyInter.existsStatic();
    }

}
interface MyInter {
    //验证default方法可以被override
    default void existsDefault(){
        System.out.println("default method in interface");
    }
    //验证static方法不可以被override
    static void existsStatic(){
        System.out.println("static method in interface");
    }

    void newMethod();
}
