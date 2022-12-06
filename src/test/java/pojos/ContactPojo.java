package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactPojo {

    private Integer id;
    private String email;
    private String message;
    private String name;
    private String subject;

    public ContactPojo(String email, String message, String name, String subject) {
        this.id = id;
        this.email = email;
        this.message = message;
        this.name = name;
        this.subject = subject;
    }

    /*
    "id": 364775,
    "name": "testNG22",
    "email": "deneme2@deneme.com",
    "subject": "Hangi framework222",
    "message": "TestNG daha stabil calisiyor222"
     */

    public ContactPojo(Integer id, String name, String email, String subject, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;


    }

    public ContactPojo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "ContactPojo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    /*
    "email": "deneme2@deneme.com",
"message": "TestNG daha stabil calisiyor2",
"name": "testNG22",
"subject": "Hangi framework2"
     */
}
