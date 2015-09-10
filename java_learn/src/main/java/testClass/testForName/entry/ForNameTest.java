package testClass.testForName.entry;

import testClass.testForName.entity.EntityObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yukai on 15-9-8.
 */
public class ForNameTest {

    public static void main(String[] args) {
        testForName();
        testObjectToString();
    }

    /**
     * 注意: Class的toString()方法输出
     */
    public static void testForName(){
        List<String> list = new ArrayList<String>();

        System.out.println(List.class);

        // 以下3种方法返回的是同一个Class实例
        System.out.println(list.getClass());
        System.out.println(list.getClass().hashCode());
        System.out.println(ArrayList.class);
        System.out.println(ArrayList.class.hashCode());
        try {
            System.out.println(Class.forName("java.util.ArrayList"));
            System.out.println(Class.forName("java.util.ArrayList").hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     Object 中定义的toString()的源代码如下：
     public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
     }
     也就是说，如果一个类没有重写 Object.toString() 方法，那么打印语句得到的都将是：类名+"@"+十六进制表示的对象的哈希值
     */
    public static void testObjectToString(){
        Object b = new Object();
        System.out.println(b);
        System.out.println(b.getClass().getName());
        System.out.println(b.hashCode());
        System.out.println(Integer.toHexString(b.hashCode()));

        EntityObject eo = new EntityObject();
        System.out.println(eo);
        System.out.println(eo.getClass().getName());
        System.out.println(eo.hashCode());
        System.out.println(Integer.toHexString(eo.hashCode()));
    }
}
