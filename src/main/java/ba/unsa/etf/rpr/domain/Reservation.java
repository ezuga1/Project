package ba.unsa.etf.rpr.domain;

import java.util.Objects;
import java.util.Date;

/**
 *
 */

public class Reservation {
    private int id;
     private int BusId;
     private String departTime;
     private String destination;
     private Date ReservationDate;
     private int PassengerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusId() {
        return BusId;
    }

    public void setBusId(int busId) {
        BusId = busId;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        ReservationDate = reservationDate;
    }

    public int getPassengerId() {
        return PassengerId;
    }

    public void setPassengerId(int passengerId) {
        PassengerId = passengerId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", BusId=" + BusId +
                ", departTime='" + departTime + '\'' +
                ", destination='" + destination + '\'' +
                ", ReservationDate=" + ReservationDate +
                ", PassengerId=" + PassengerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getId() == that.getId() && getBusId() == that.getBusId() && getPassengerId() == that.getPassengerId() && getDepartTime().equals(that.getDepartTime()) && getDestination().equals(that.getDestination()) && getReservationDate().equals(that.getReservationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBusId(), getDepartTime(), getDestination(), getReservationDate(), getPassengerId());
    }
}
