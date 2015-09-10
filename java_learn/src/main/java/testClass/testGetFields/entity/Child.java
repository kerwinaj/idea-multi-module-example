package testClass.testGetFields.entity;

/**
 * Created by yukai on 15-9-7.
 */
public class Child extends Parent{

    private Long childPrivateAttr;

    Long childDefaultAttr;

    protected Long childProtectedAttr;

    public String childPublicAttr;

    /**
     * -------------------
     */
    private Long getChildPrivateAttr() {
        return childPrivateAttr;
    }

    Long getChildDefaultAttr() {
        return childDefaultAttr;
    }

    protected Long getChildProtectedAttr() {
        return childProtectedAttr;
    }

    public String getChildPublicAttr() {
        return childPublicAttr;
    }
}
