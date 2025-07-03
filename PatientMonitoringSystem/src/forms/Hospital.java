package forms;

public class Hospital {
    private int hid;
    private String name;
    private String address;
    private String phoneNumber;
    private long uid;

    public void setHid(int hid) {
        this.hid = hid;
    }
    public int getHid() {
        return hid;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String  getPhoneNumber() {
        return phoneNumber;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
    public long getUid() {
        return uid;
    }
}

