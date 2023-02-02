package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Category implements Idable {
    int categoryID;
    String name;
    String status;
    public int getId(){
        return categoryID;
    }
    public void setId(int id){
        this.categoryID = id;
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
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return getId() == category.getId() && getName().equals(category.getName()) && getStatus().equals(category.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStatus());
    }


}
