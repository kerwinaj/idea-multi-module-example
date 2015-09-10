package testInstanceOf.entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yukai on 15-9-8.
 */
public class InstanceOfTest {

    public static void main(String[] args) {
        instanceofVSisAssignableFrom();
        testIsInstance();
    }

    /**
     * instanceof 针对实例(操作符)
     * 第一个参数是对象实例名,第二个参数是具体的类名或接口名.
     * 是用来判断一个对象实例是否是一个类或接口的或其子类子接口的实例.
     * 如果第一个参数是null值，则测试结果总是false,所以instance返回true表示绝对不是null，而且是第二个参数的实例
     */
    /**
     * isAssignableFrom(Class的方法)
     * 调用者和参数都是   java.lang.Class   类型.
     * 针对class对象,是用来判断一个类Class1和另一个类Class2是否相同或是另一个类的超类或接口.
     */
    /**
     * instanceof是子-->父
     * isAssignableFrom是父-->子
     */
    public static void instanceofVSisAssignableFrom(){
        List<String> list = new ArrayList<String>();
        System.out.println(list instanceof List); // true
        System.out.println(list instanceof ArrayList); // true
        System.out.println(list instanceof Object); // true

        System.out.println(list.getClass().isAssignableFrom(List.class));// false
        System.out.println(List.class.isAssignableFrom(list.getClass()));// true
    }

    /**
     * Class类的isInstance(Object obj)方法
     * obj是被测试的对象,
     * 这个方法是instanceof运算符的动态等价.
     */
    public static void testIsInstance(){
        List<String> list = new ArrayList<String>();
        System.out.println(List.class.isInstance(list));//true
        System.out.println(ArrayList.class.isInstance(list));//true
        System.out.println(Object.class.isInstance(list));//true
    }
}
