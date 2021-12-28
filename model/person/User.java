package tamrintaxi.model.person;

import lombok.Data;
import tamrintaxi.enumaration.UserStatus;

import javax.persistence.*;

@Data
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String userName;
    protected String name;
    protected String family;
    protected String nationalCode;
    protected String phoneNumber;
    protected int age;
    protected UserStatus userStatus;

}
