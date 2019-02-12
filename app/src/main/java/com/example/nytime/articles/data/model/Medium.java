
package com.example.nytime.articles.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Medium implements Parcelable {

    @SerializedName("approved_for_syndication")
    private Long mApprovedForSyndication;
    @SerializedName("caption")
    private String mCaption;
    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("media-metadata")
    private List<MediaMetadatum> mMediaMetadata;
    @SerializedName("subtype")
    private String mSubtype;
    @SerializedName("type")
    private String mType;

    protected Medium(Parcel in) {
        if (in.readByte() == 0) {
            mApprovedForSyndication = null;
        } else {
            mApprovedForSyndication = in.readLong();
        }
        mCaption = in.readString();
        mCopyright = in.readString();
        mMediaMetadata = in.createTypedArrayList(MediaMetadatum.CREATOR);
        mSubtype = in.readString();
        mType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mApprovedForSyndication == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mApprovedForSyndication);
        }
        dest.writeString(mCaption);
        dest.writeString(mCopyright);
        dest.writeTypedList(mMediaMetadata);
        dest.writeString(mSubtype);
        dest.writeString(mType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Medium> CREATOR = new Creator<Medium>() {
        @Override
        public Medium createFromParcel(Parcel in) {
            return new Medium(in);
        }

        @Override
        public Medium[] newArray(int size) {
            return new Medium[size];
        }
    };

    public Long getApprovedForSyndication() {
        return mApprovedForSyndication;
    }

    public void setApprovedForSyndication(Long approvedForSyndication) {
        mApprovedForSyndication = approvedForSyndication;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public String getCopyright() {
        return mCopyright;
    }

    public void setCopyright(String copyright) {
        mCopyright = copyright;
    }

    public List<MediaMetadatum> getMediaMetadata() {
        return mMediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
        mMediaMetadata = mediaMetadata;
    }

    public String getSubtype() {
        return mSubtype;
    }

    public void setSubtype(String subtype) {
        mSubtype = subtype;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
