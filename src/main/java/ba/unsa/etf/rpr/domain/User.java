package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class User {
    int userID;
    String username;
    String surname;
    String emailAddress;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
                ", surname='" + surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserID() == user.getUserID() && getUsername().equals(user.getUsername()) && getSurname().equals(user.getSurname()) && getEmailAddress().equals(user.getEmailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getUsername(), getSurname(), getEmailAddress());
    }
}
