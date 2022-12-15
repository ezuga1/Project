package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Items {
    int itemID;
    String itemName;
    String price;
    String description;
    int categoryID;
    int userID;

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", categoryID=" + categoryID +
                ", userID=" + userID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Items)) return false;
        Items items = (Items) o;
        return getItemID() == items.getItemID() && getCategoryID() == items.getCategoryID() && getUserID() == items.getUserID() && getItemName().equals(items.getItemName()) && getPrice().equals(items.getPrice()) && getDescription().equals(items.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemID(), getItemName(), getPrice(), getDescription(), getCategoryID(), getUserID());
    }
}
