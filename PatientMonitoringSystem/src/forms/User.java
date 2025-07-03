package forms;

public class User {
    private long uid;
    private String email;
    private String mobile;
    private String name;
    private String dob;
    private String address;
    private String gender;
    private String bp;
    private int height;
    private int weight;
    private float bmi;
    private boolean currentStatus;

    public void setUid(long uid) {
        this.uid = uid;
    }
    public long getUid() {
        return uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getMobile() {
        return mobile;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getDob() {
        return dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }
    public String getBp() {
        return bp;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }
    public float getBmi() {
        return bmi;
    }

    public void setCurrentStatus(boolean currentStatus) {
        this.currentStatus = currentStatus;
    }
    public boolean getCurrentStatus() {
        return currentStatus;
    }

}

