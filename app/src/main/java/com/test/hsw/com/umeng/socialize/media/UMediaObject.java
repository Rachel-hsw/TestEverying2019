package com.umeng.socialize.media;

import android.os.Parcelable;
import com.umeng.socialize.bean.p;
import java.util.Map;

public abstract interface UMediaObject extends Parcelable, Cloneable
{
  public abstract String a();

  public abstract void a(FetchMediaDataListener paramFetchMediaDataListener);

  public abstract boolean b();

  public abstract Map<String, Object> c_();

  public abstract byte[] d_();

  public abstract p f();

  public abstract a g();

  public abstract boolean h();

  public static abstract interface FetchMediaDataListener
  {
    public abstract void a();

    public abstract void a(byte[] paramArrayOfByte);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      g = arrayOfa;
    }

    public static a a(String paramString)
    {
      for (a locala : values())
        if (locala.toString().equals(paramString))
          return locala;
      return null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.UMediaObject
 * JD-Core Version:    0.6.0
 */