package dal.annotation;

import dal.common.DbType;

/**
 * Created by yukai on 15-9-7.
 */
public @interface Column {
    /** name,  字段名  */
    public String name();

    /** type,  字段类型  */
    public DbType type();
}
