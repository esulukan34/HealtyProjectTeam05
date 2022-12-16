package pojos;

public class US009DataPojo {
    private String createdBy;
    private String createdDate;
    private Integer id;
    private String firstName;
    private String lastName;
    private Object birthDate;
    private String phone;
    private Object gender;
    private Object bloodGroup;
    private Object adress;
    private String email;
    private Object description;
    private US009UserPojo user;
    private Object appointments;
    private Object inPatients;
    private Object country;
    private Object cstate;

    public US009DataPojo() {
    }

    public US009DataPojo(String createdBy, String createdDate, Integer id, String firstName, String lastName, Object birthDate, String phone, Object gender, Object bloodGroup, Object adress, String email, Object description, US009UserPojo user, Object appointments, Object inPatients, Object country, Object cstate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.adress = adress;
        this.email = email;
        this.description = description;
        this.user = user;
        this.appointments = appointments;
        this.inPatients = inPatients;
        this.country = country;
        this.cstate = cstate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Object birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(Object bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Object getAdress() {
        return adress;
    }

    public void setAdress(Object adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public US009UserPojo getUser() {
        return user;
    }

    public void setUser(US009UserPojo user) {
        this.user = user;
    }

    public Object getAppointments() {
        return appointments;
    }

    public void setAppointments(Object appointments) {
        this.appointments = appointments;
    }

    public Object getInPatients() {
        return inPatients;
    }

    public void setInPatients(Object inPatients) {
        this.inPatients = inPatients;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getCstate() {
        return cstate;
    }

    public void setCstate(Object cstate) {
        this.cstate = cstate;
    }

    @Override
    public String toString() {
        return "US009DataPojo{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", bloodGroup=" + bloodGroup +
                ", adress=" + adress +
                ", email='" + email + '\'' +
                ", description=" + description +
                ", user=" + user +
                ", appointments=" + appointments +
                ", inPatients=" + inPatients +
                ", country=" + country +
                ", cstate=" + cstate +
                '}';
    }
    /*
    {
    "createdBy": "anonymousUser",
    "createdDate": "2022-04-07T14:00:00.206137Z",
    "id": 55902,
    "firstName": "Eli",
    "lastName": "Wuckert",
    "birthDate": null,
    "phone": "455-455-5555",
    "gender": null,
    "bloodGroup": null,
    "adress": null,
    "email": "teodoro.olson@yahoo.com",
    "description": null,
    "user": {
        "createdBy": "anonymousUser",
        "createdDate": "2022-04-07T14:00:05.828549Z",
        "id": 55224,
        "login": "barb.gaylord",
        "firstName": "Eli",
        "lastName": "Wuckert",
        "email": "vaughn.donnelly@yahoo.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null,
        "ssn": "699-50-3044"
    },
    "appointments": null,
    "inPatients": null,
    "country": null,
    "cstate": null
}
*/
}
