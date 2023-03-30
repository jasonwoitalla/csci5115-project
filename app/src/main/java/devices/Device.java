package devices;

public class Device {

    private String deviceName;
    private int image;

    public Device(String deviceName, int image) {
        this.deviceName = deviceName;
        this.image = image;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getImage(){
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
