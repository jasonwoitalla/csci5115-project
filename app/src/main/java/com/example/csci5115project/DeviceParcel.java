package com.example.csci5115project;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DeviceParcel implements Parcelable {
    String deviceName;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(deviceName);
    }

    public static final Parcelable.Creator<DeviceParcel> CREATOR = new Parcelable.Creator<DeviceParcel>() {
        public DeviceParcel createFromParcel(Parcel in) {
            return new DeviceParcel(in);
        }

        public DeviceParcel[] newArray(int size) {
            return new DeviceParcel[size];
        }
    };

    private DeviceParcel(Parcel in) {
        deviceName = in.readString();
    }
}
