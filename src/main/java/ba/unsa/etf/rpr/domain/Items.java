package ba.unsa.etf.rpr.domain;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.Objects;

/**
 * Bean class for items
 * @author Ernad Zuga
 */
public class Items implements Idable{
    private int id;
    private String itemName;
    private String price;
    private String description;
   // private int categoryID;
    private Category categoryid;

    public Category getCategoryid()  {
        return categoryid;
    }

    /*public void setCategory(Category category) {
        this.category = category;
    }*/

    private int userID;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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
    public void setCategoryID(Category categoryID){
        this.categoryid = categoryID;
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
    public Category getCategoryID(){
        return categoryid;
    }




    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Name: "+ itemName + "\nPrice: " + price + "\nDescription: " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Items)) return false;
        Items items = (Items) o;
        return getId() == items.getId() && getCategoryID() == items.getCategoryID() && getUserID() == items.getUserID() && getItemName().equals(items.getItemName()) && getPrice().equals(items.getPrice()) && getDescription().equals(items.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getItemName(), getPrice(), getDescription(), getCategoryID(), getUserID());
    }
}
