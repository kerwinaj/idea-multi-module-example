package testClass.testGetFields.entry;

import com.google.common.collect.Lists;
import testClass.testGetFields.entity.Child;
import testClass.testGetFields.entity.GrandParent;
import testClass.testGetFields.entity.Parent;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yukai on 15-9-7.
 */

public class GetFieldsEntry {

    public static void main(String[] args){
        getFieldsVsgetDeclaredFields();
        System.out.println("==================");
        getAllFields();
    }

    /**
     * 测试class的getFields和getDeclaredFields的不同<br/>
     * <a href="http://stackoverflow.com/questions/16966629/what-is-the-difference-between-getfields-and-getdeclaredfields-in-java-reflectio">stackoverflow question</a>
     * <br/>
     * <br/>
     * testGetFields()<br/>
     * All the public fields up the entire class hierarchy.<br/>
     * <br/>
     * getDeclaredFields()
     * All the fields, regardless of their accessibility but only for the current class, not any base classes that the current class might be inheriting from.
     * <br/>
     * <br/>
     * run result start:<br/>
     <pre>
     Child.class.testGetFields():
     childPublicAttr
     parentPublicAttr
     grandParentPublicAttr
     Child.class.getDeclaredFields():
     childPrivateAttr
     childDefaultAttr
     childProtectedAttr
     childPublicAttr
     </pre>
     * run result end:<br/>
     */
    public static void getFieldsVsgetDeclaredFields(){
        System.out.println("Child.class.testGetFields():");
        for(Field field : Child.class.getFields()){
            System.out.println(field.getName());
        }
        System.out.println("Child.class.getDeclaredFields():");
        for(Field field : Child.class.getDeclaredFields()){
            System.out.println(field.getName());
        }
    }

    /**
     * <pre>
     getAllFields1():
     childPrivateAttr
     childDefaultAttr
     childProtectedAttr
     childPublicAttr
     parentPrivateAttr
     parentDefaultAttr
     parentProtectedAttr
     parentPublicAttr
     grandParentPrivateAttr
     grandParentDefaultAttr
     grandParentProtectedAttr
     grandParentPublicAttr
     getAllFields2():
     childPrivateAttr
     childDefaultAttr
     childProtectedAttr
     childPublicAttr
     getAllFields3():
     childPrivateAttr
     childDefaultAttr
     childProtectedAttr
     childPublicAttr
     parentPrivateAttr
     parentDefaultAttr
     parentProtectedAttr
     parentPublicAttr
     </pre>
     */
    public static void getAllFields(){
        System.out.println("getAllFields1():");
        Iterable<Field> fieldIterable1 = getFieldsUpTo(Child.class, null);
        print(fieldIterable1);

        System.out.println("getAllFields2():");
        Iterable<Field> fieldIterable2 = getFieldsUpTo(Child.class, Parent.class);
        print(fieldIterable2);

        System.out.println("getAllFields3():");
        Iterable<Field> fieldIterable3 = getFieldsUpTo(Child.class, GrandParent.class);
        print(fieldIterable3);
    }


    public static Iterable<Field> getFieldsUpTo(Class<?> startClass, Class<?> exclusiveParent) {
        List<Field> currentClassFields = Lists.newArrayList(startClass.getDeclaredFields());
        Class<?> parentClass = startClass.getSuperclass();

        if (parentClass != null &&
                (exclusiveParent == null || !(parentClass.equals(exclusiveParent)))) {
            List<Field> parentClassFields = (List<Field>) getFieldsUpTo(parentClass, exclusiveParent);
            currentClassFields.addAll(parentClassFields);
        }

        return currentClassFields;
    }

    public static void print(Iterable<Field> iterableField){
        Iterator<Field> fieldIterator = iterableField.iterator();
        while (fieldIterator.hasNext()){
            Field field = fieldIterator.next();
            System.out.println(field.getName());
        }
        System.out.println("---");
    }



}
