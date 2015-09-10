package testClass.testGetFields.entity;

/**
 * Created by yukai on 15-9-7.
 */
public class GrandParent {
    private Long grandParentPrivateAttr;

    Long grandParentDefaultAttr;

    protected Long grandParentProtectedAttr;

    public String grandParentPublicAttr;

    /**
     * -------------------
     */
    private Long getGrandParentPrivateAttr() {
        return grandParentPrivateAttr;
    }

    Long getGrandParentDefaultAttr() {
        return grandParentDefaultAttr;
    }

    protected Long getGrandParentProtectedAttr() {
        return grandParentProtectedAttr;
    }

    public String getGrandParentPublicAttr() {
        return grandParentPublicAttr;
    }
}
