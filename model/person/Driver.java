package tamrintaxi.model.person;

import lombok.Data;
import lombok.NoArgsConstructor;
import tamrintaxi.enumaration.Gender;
import tamrintaxi.enumaration.TypeOfVehicle;
import tamrintaxi.model.vehicle.Vehicle;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Driver extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @OneToOne
    private Vehicle vehicle;
    @Enumerated(value = EnumType.STRING)
    private TypeOfVehicle typeOfVehicle;
    private String location;

    public Driver(String personalId, String firstName, String lastName, Gender gender, String phoneNumber, int birthYear, TypeOfVehicle typeOfVehicle, Vehicle vehicle, String location) {
        super(personalId, firstName, lastName, gender, phoneNumber, birthYear);
        this.vehicle = vehicle;
        this.typeOfVehicle = typeOfVehicle;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                super.toString() + '\'' +
                ", vehicleId=" + vehicle +
                ", typeOfVehicle=" + typeOfVehicle.toString().toLowerCase() +
                ", location=" + location +
                '}';
    }


}
