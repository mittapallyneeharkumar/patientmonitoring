package forms;

public class Medicine {
    private int mid;
    private String name;
    private String fromDate;
    private String toDate;
    private boolean morning;
    private boolean afternoon;
    private boolean night;
    private String doctorName;

    public void setMid(int mid) {
        this.mid = mid;
    }
    public int getMid() {
        return mid;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
    public String getFromDate() {
        return fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
    public String getToDate() {
        return toDate;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
    }
    public boolean isMorning() {
        return morning;
    }

    public void setAfternoon(boolean afternoon) {
        this.afternoon = afternoon;
    }
    public boolean isAfternoon() {
        return afternoon;
    }

    public void setNight(boolean night) {
        this.night = night;
    }
    public boolean isNight() {
        return night;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public String getDoctorName() {
        return doctorName;
    }
}
