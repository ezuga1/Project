package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Category {
    int categoryID;
    String name;
    String status;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return getCategoryID() == category.getCategoryID() && getName().equals(category.getName()) && getStatus().equals(category.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryID(), getName(), getStatus());
    }
}
