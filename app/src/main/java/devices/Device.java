package devices;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Device implements Parcelable {

    private String deviceName;
    private int image;
    private Bitmap bitmap;

    public Device(String deviceName, int image) {
        this.deviceName = deviceName;
        this.image = image;
    }

    public Device(String deviceName, Bitmap bitmap) {
        this.deviceName = deviceName;
        this.bitmap = bitmap;
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

    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeString(deviceName);
        parcel.writeParcelable(bitmap, flags);
    }

    public static final Parcelable.Creator<Device> CREATOR = new Parcelable.Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel parcel) {
            return new Device(parcel);
        }

        @Override
        public Device[] newArray(int i) {
            return new Device[i];
        }
    };

    private Device(Parcel in) {
        deviceName = in.readString();
        bitmap = in.readParcelable(Bitmap.class.getClassLoader());
    }
}
