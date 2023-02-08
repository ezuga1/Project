package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Bean class for users
 * @author Ernad Zuga
 */
public class User implements Idable{
   private int userID;
    private String username;
    private String emailAddress;

    private String password;

    public User(String name){
        username = name;
    }

    public User() {}

    public int getId(){
        return userID;
    }
    public void setId(int id){
        this.userID = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && getUsername().equals(user.getUsername()) && getEmailAddress().equals(user.getEmailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getEmailAddress());
    }
}
