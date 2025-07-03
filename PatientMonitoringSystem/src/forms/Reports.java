package forms;

public class Reports {
    private int id;
    private String patientName;
    private String date;
    private String hospitalName;
    private String reportName;
    private String filename;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getPatientName() {
        return patientName;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    public String getHospitalName() {
        return hospitalName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
    public String getReportName() {
        return reportName;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getFilename() {
        return filename;
    }
}

