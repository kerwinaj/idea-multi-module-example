package dal.annotation;

import dal.common.DbType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yukai on 15-9-7.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    /** name,  字段名  */
    public String name();

    /** type,  字段类型  */
    public DbType type();
}
