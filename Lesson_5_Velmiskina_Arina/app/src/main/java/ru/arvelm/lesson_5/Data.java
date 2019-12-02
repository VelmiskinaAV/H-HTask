package ru.arvelm.lesson_5;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    String value = "";
    private Data info;

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(value);
        out.writeParcelable(info, flags);
    }


    private Data(Parcel in) {
        value = in.readString();
        info = in.readParcelable(Data.class.getClassLoader());
    }

    public Data() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {

        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}


