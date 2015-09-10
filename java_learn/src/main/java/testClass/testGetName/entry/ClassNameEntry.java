package testClass.testGetName.entry;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by yukai on 15-9-8.
 */
public class ClassNameEntry {

    public static void main(String[] args){
        classNameDifference();
    }

    /**
     * <pre>
     int
     int
     int

     java.lang.String
     java.lang.String
     String

     java.util.AbstractMap$SimpleEntry
     java.util.AbstractMap.SimpleEntry
     SimpleEntry

     testClass.testGetName.entry.ClassNameEntry$1
     null

     * </pre>
     */
    public static void classNameDifference(){
        //primitive
        System.out.println(int.class.getName());
        System.out.println(int.class.getCanonicalName());
        System.out.println(int.class.getSimpleName());

        System.out.println();

        //class
        System.out.println(String.class.getName());
        System.out.println(String.class.getCanonicalName());
        System.out.println(String.class.getSimpleName());

        System.out.println();

        //inner class
        System.out.println(HashMap.SimpleEntry.class.getName());
        System.out.println(HashMap.SimpleEntry.class.getCanonicalName());
        System.out.println(HashMap.SimpleEntry.class.getSimpleName());

        System.out.println();

        //anonymous inner class
        System.out.println(new Serializable(){}.getClass().getName());
        System.out.println(new Serializable(){}.getClass().getCanonicalName());
        System.out.println(new Serializable(){}.getClass().getSimpleName());//empty string
    }
}
