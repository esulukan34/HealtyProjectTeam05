package pojos.patientPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private int id;
    private String name;
}
