package pojos.apiPojos;

public class US010AnaPojo {
    private String createdBy;
    private String createdDate;
    private int id;
    private String startDate;
    private String endDate;
    private String status;
    private Object anamnesis;
    private Object treatment;
    private Object diagnosis;
    private Object prescription;
    private Object description;
    private US010PhysicianPojo physician;
    private US010PatientPojo patient;
    private Object ctests;

    public US010AnaPojo() {
    }

    public US010AnaPojo(String createdBy, String createdDate, int id, String startDate, String endDate, String status, Object anamnesis, Object treatment, Object diagnosis, Object prescription, Object description, US010PhysicianPojo physician, US010PatientPojo patient, Object ctests) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.anamnesis = anamnesis;
        this.treatment = treatment;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.description = description;
        this.physician = physician;
        this.patient = patient;
        this.ctests = ctests;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(Object anamnesis) {
        this.anamnesis = anamnesis;
    }

    public Object getTreatment() {
        return treatment;
    }

    public void setTreatment(Object treatment) {
        this.treatment = treatment;
    }

    public Object getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Object diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Object getPrescription() {
        return prescription;
    }

    public void setPrescription(Object prescription) {
        this.prescription = prescription;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public US010PhysicianPojo getPhysician() {
        return physician;
    }

    public void setPhysician(US010PhysicianPojo physician) {
        this.physician = physician;
    }

    public US010PatientPojo getPatient() {
        return patient;
    }

    public void setPatient(US010PatientPojo patient) {
        this.patient = patient;
    }

    public Object getCtests() {
        return ctests;
    }

    public void setCtests(Object ctests) {
        this.ctests = ctests;
    }

    @Override
    public String toString() {
        return "US010AnaPojo{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", anamnesis=" + anamnesis +
                ", treatment=" + treatment +
                ", diagnosis=" + diagnosis +
                ", prescription=" + prescription +
                ", description=" + description +
                ", physician=" + physician +
                ", patient=" + patient +
                ", ctests=" + ctests +
                '}';
    }
}
