package testClass.testGetFields.entity;

/**
 * Created by yukai on 15-9-7.
 */
public class Parent extends GrandParent{

    private Long parentPrivateAttr;

    Long parentDefaultAttr;

    protected Long parentProtectedAttr;

    public String parentPublicAttr;

    /**
     * -------------------
     */
    private Long getParentPrivateAttr() {
        return parentPrivateAttr;
    }

    Long getParentDefaultAttr() {
        return parentDefaultAttr;
    }

    protected Long getParentProtectedAttr() {
        return parentProtectedAttr;
    }

    public String getParentPublicAttr() {
        return parentPublicAttr;
    }
}
