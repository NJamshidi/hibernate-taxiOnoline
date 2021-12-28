package tamrintaxi.model.trip;

import lombok.Data;
import lombok.NoArgsConstructor;
import tamrintaxi.enumaration.Payment;
import tamrintaxi.enumaration.TripStatus;
import tamrintaxi.model.person.Driver;
import tamrintaxi.model.person.Passenger;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Driver driver;
    @OneToOne
    private Passenger passenger;
    private String origin;
    private String destination;
    private double cost;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;

    public Trip(Passenger passenger, String origin, String destination, double cost, Payment payment) {
        this.passenger = passenger;
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.payment = payment;
        this.tripStatus = TripStatus.ON_TRIP;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", driverId=" + passenger +
                ", passengerId=" + driver +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                ", payment=" + payment +
                ", tripStatus=" + tripStatus +
                '}';
    }
}
