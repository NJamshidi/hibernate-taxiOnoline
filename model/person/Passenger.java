package tamrintaxi.model.person;

import lombok.Data;
import lombok.NoArgsConstructor;
import tamrintaxi.enumaration.Gender;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Passenger extends User {
    @Id

    private double accountBalance;
    private Long id;

    public Passenger(String personalId, String firstName, String lastName, Gender gender, String phoneNumber, int birthYear, double accountBalance) {
        super(personalId, firstName, lastName, gender, phoneNumber, birthYear);
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double increaseAccountBalance(double amount) {
        return accountBalance += amount;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                super.toString() + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }




}
