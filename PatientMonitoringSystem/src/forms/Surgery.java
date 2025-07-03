package forms;

public class Surgery {
    private int surgeryId;
    private String patientName;
    private String hospitalName;
    private String doctorName;
    private String surgeryType;
    private String surgeryDate;
    private String startTime;
    private String endTime;
    private String status;
    private String notes;
    private double cost;

    public void setSurgeryId(int surgeryId) {
        this.surgeryId = surgeryId;
    }
    public int getSurgeryId() {
        return surgeryId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getPatientName() {
        return patientName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    public String getHospitalName() {
        return hospitalName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public String getDoctorName() {
        return doctorName;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }
    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryDate(String surgeryDate) {
        this.surgeryDate = surgeryDate;
    }
    public String getSurgeryDate() {
        return surgeryDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getEndTime() {
        return endTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getNotes() {
        return notes;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getCost() {
        return cost;
    }
}
