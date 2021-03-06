package tamrintaxi.model.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;
import tamrintaxi.enumaration.TypeOfVehicle;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    protected String color;
    protected String plaque;
    @Enumerated(EnumType.STRING)
    protected TypeOfVehicle typeOfVehicle;

    public Vehicle(String name, String color, String plaque, TypeOfVehicle typeOfVehicle) {
        this.name = name;
        this.color = color;
        this.plaque = plaque;
        this.typeOfVehicle = typeOfVehicle;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", plaque='" + plaque + '\'' +
                '}';
    }
}
