package com.umeng.socialize.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.umeng.socialize.b.b.e;
import org.json.JSONException;
import org.json.JSONObject;

public class UMComment extends BaseMsg
  implements Parcelable
{
  public static final Parcelable.Creator<UMComment> CREATOR = new bb();
  public String d;
  public String e;
  public String f;
  public String g;
  public long h;
  public c i;

  public UMComment()
  {
  }

  private UMComment(Parcel paramParcel)
  {
    super(paramParcel);
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readLong();
  }

  public static UMComment a(JSONObject paramJSONObject)
  {
    UMComment localUMComment;
    if (paramJSONObject == null)
      localUMComment = null;
    while (true)
    {
      return localUMComment;
      localUMComment = new UMComment();
      try
      {
        if (paramJSONObject.has("uname"))
          localUMComment.f = paramJSONObject.getString("uname");
        if (paramJSONObject.has("ic"))
          localUMComment.d = paramJSONObject.getString("ic");
        if (paramJSONObject.has("uid"))
          localUMComment.e = paramJSONObject.getString("uid");
        if (paramJSONObject.has(e.s))
          localUMComment.a = paramJSONObject.getString(e.s);
        if (paramJSONObject.has("dt"))
          localUMComment.h = paramJSONObject.getLong("dt");
        if (paramJSONObject.has("gender"))
        {
          int j = paramJSONObject.optInt("gender", 0);
          localUMComment.i = c.a("" + j);
        }
        if (!paramJSONObject.has(e.t))
          continue;
        localUMComment.b = UMLocation.a(paramJSONObject.getString(e.t));
        return localUMComment;
      }
      catch (JSONException localJSONException)
      {
      }
    }
    return localUMComment;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "UMComment [mUserIcon=" + this.d + ", mUid=" + this.e + ", mUname=" + this.f + ", mSignature=" + this.g + ", mDt=" + this.h + ", mGender=" + this.i + ", mText=" + this.a + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.h);
    if (this.i == null);
    for (String str = ""; ; str = this.i.toString())
    {
      paramParcel.writeString(str);
      return;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.UMComment
 * JD-Core Version:    0.6.0
 */