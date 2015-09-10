package dal.common;

/**
 * Created by yukai on 15-9-7.
 */
public enum DbType {
    Int,
    TinyInt,
    SmallInt,
    BigInt,
    Char,
    Varchar,
    Float,
    Double,
    Text,
    /**
     * <br>对应实体类型为 long/Long
     * <br>只适用mysql, ucdc不适用
     */
    DateTime,
    /**
     * <br>InputStream
     */
    Blob,
}
