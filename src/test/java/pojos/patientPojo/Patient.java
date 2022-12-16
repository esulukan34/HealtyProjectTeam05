package pojos.patientPojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {

    private String createdBy;
    private String createdDate;
    private int id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phone;
    private String gender;
    private String bloodGroup;
    private String adress;
    private String email;
    private String description;
    private User user;
    private Object appointments;
    private Object inPatients;
    private Country country;
    private Cstate cstate;

    public Patient(int id, String firstName, String lastName) { //US0015API de 3 parametreli cons kullandik.
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
