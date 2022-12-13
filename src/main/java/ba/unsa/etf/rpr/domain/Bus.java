package ba.unsa.etf.rpr.domain;
import java.util.Objects;

/**
 *  Bus informations
 *
 * @author Ernad Zuga
 */

public class Bus {
    private int id;
    private int busNum;
    private String busStatus;
    private int busSeats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusNum() {
        return busNum;
    }

    public void setBusNum(int busNum) {
        this.busNum = busNum;
    }

    public String getBusStatus() {
        return busStatus;
    }

    public void setBusStatus(String busStatus) {
        this.busStatus = busStatus;
    }

    public int getBusSeats() {
        return busSeats;
    }

    public void setBusSeats(int busSeats) {
        this.busSeats = busSeats;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", busNum=" + busNum +
                ", busStatus='" + busStatus + '\'' +
                ", busSeats=" + busSeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        Bus bus = (Bus) o;
        return getId() == bus.getId() && getBusNum() == bus.getBusNum() && getBusSeats() == bus.getBusSeats() && getBusStatus().equals(bus.getBusStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBusNum(), getBusStatus(), getBusSeats());
    }
}
