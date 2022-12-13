package pojos.patientPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cstate {

    private int id;
    private String name;
    private CountryInState country;
}
