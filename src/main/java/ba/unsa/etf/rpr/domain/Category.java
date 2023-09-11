package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Bean class for categories
 * @author Ernad Zuga
 */
public class Category implements Idable {
    private int categoryID;
    private String name;
    String status;

    public Category(String name) {
        this.name = name;
    }
    public Category(){

    }

    @Override
    public void setId(int categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public int getId() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return categoryID == category.categoryID && Objects.equals(getName(), category.getName()) && Objects.equals(getStatus(), category.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID, getName(), getStatus());
    }

    @Override
    public String toString() {
       return name;
    }
}
