package ba.unsa.etf.rpr.domain;
import java.util.Objects;
import java.util.Date;

/**
 *
 */

public class Payment {
    private int id;
    private Date paymentDate;
    private int PassengerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPassengerId() {
        return PassengerId;
    }

    public void setPassengerId(int passengerId) {
        PassengerId = passengerId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentDate=" + paymentDate +
                ", PassengerId=" + PassengerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return getId() == payment.getId() && getPassengerId() == payment.getPassengerId() && getPaymentDate().equals(payment.getPaymentDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPaymentDate(), getPassengerId());
    }
}
