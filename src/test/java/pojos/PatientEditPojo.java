package pojos;

public class PatientEditPojo {
    private String id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String birthDateHour_Munite;
    private String email;
    private String phone;
    private String gender;
    private String bloodGroup;
    private String address;
    private String description;
    private String user;
    private String country;
    private String state_City;

    public PatientEditPojo() {

    }

    public PatientEditPojo(String id, String firstName, String lastName, String birthDate, String birthDateHour_Munite, String email, String phone, String gender, String bloodGroup, String address, String description, String user, String country, String state_City) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.description = description;
        this.user = user;
        this.country = country;
        this.state_City = state_City;
        this.birthDateHour_Munite = birthDateHour_Munite;
    }

    public String getBirthDateHour_Munite() {
        return birthDateHour_Munite;
    }

    public void setBirthDateHour_Munite(String birthDateHour_Munite) {
        this.birthDateHour_Munite = birthDateHour_Munite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState_City() {
        return state_City;
    }

    public void setState_City(String state_City) {
        this.state_City = state_City;
    }

    @Override
    public String toString() {
        return "PatientEditPojo{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", birthDateHour_Munite='" + birthDateHour_Munite + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", user='" + user + '\'' +
                ", country='" + country + '\'' +
                ", state_City='" + state_City + '\'' +
                '}';
    }
}
