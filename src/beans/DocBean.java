package beans;

public class DocBean {
    private int id;
    private String docname;
    private String email;
    private String password;
    private String specialty;
    private String contact;
    private int fees;
    private String doctorTime;
    private String amPm;
    private String status;  // Add this field

    // Constructors, getters, and setters
    public DocBean() {
    }

    public DocBean(String docname, String email, String password, String specialty, String contact, int fees, String doctorTime, String amPm) {
        this.docname = docname;
        this.email = email;
        this.password = password;
        this.specialty = specialty;
        this.contact = contact;
        this.fees = fees;
        this.doctorTime = doctorTime;
        this.amPm = amPm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public String getDoctorTime() {
        return doctorTime;
    }

    public void setDoctorTime(String doctorTime) {
        this.doctorTime = doctorTime;
    }

    public String getAmPm() {
        return amPm;
    }

    public void setAmPm(String amPm) {
        this.amPm = amPm;
    }

    public String getStatus() {
        return status;  
    }

    public void setStatus(String status) {
        this.status = status;  
    }
}
