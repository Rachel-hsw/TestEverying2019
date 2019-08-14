package com.umeng.socialize.bean;

import android.text.TextUtils;

public enum p
{
  private String E;

  static
  {
    A = new y("LINE", 26, "line");
    B = new z("FLICKR", 27, "flickr");
    C = new aa("TUMBLR", 28, "tumblr");
    D = new ac("KAKAO", 29, "kakao");
    p[] arrayOfp = new p[30];
    arrayOfp[0] = a;
    arrayOfp[1] = b;
    arrayOfp[2] = c;
    arrayOfp[3] = d;
    arrayOfp[4] = e;
    arrayOfp[5] = f;
    arrayOfp[6] = g;
    arrayOfp[7] = h;
    arrayOfp[8] = i;
    arrayOfp[9] = j;
    arrayOfp[10] = k;
    arrayOfp[11] = l;
    arrayOfp[12] = m;
    arrayOfp[13] = n;
    arrayOfp[14] = o;
    arrayOfp[15] = p;
    arrayOfp[16] = q;
    arrayOfp[17] = r;
    arrayOfp[18] = s;
    arrayOfp[19] = t;
    arrayOfp[20] = u;
    arrayOfp[21] = v;
    arrayOfp[22] = w;
    arrayOfp[23] = x;
    arrayOfp[24] = y;
    arrayOfp[25] = z;
    arrayOfp[26] = A;
    arrayOfp[27] = B;
    arrayOfp[28] = C;
    arrayOfp[29] = D;
    F = arrayOfp;
  }

  private p(String paramString)
  {
    this.E = paramString;
  }

  public static p a(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return null;
      if (paramString.equals("wxtimeline"))
        return j;
      if (paramString.equals("wxsession"))
        return i;
      for (p localp : values())
        if (localp.toString().trim().equals(paramString))
          return localp;
    }
  }

  public static p[] d()
  {
    p[] arrayOfp = new p[8];
    arrayOfp[0] = e;
    arrayOfp[1] = l;
    arrayOfp[2] = f;
    arrayOfp[3] = k;
    arrayOfp[4] = h;
    arrayOfp[5] = c;
    arrayOfp[6] = d;
    arrayOfp[7] = i;
    return arrayOfp;
  }

  public static p[] e()
  {
    p[] arrayOfp = new p[4];
    arrayOfp[0] = e;
    arrayOfp[1] = l;
    arrayOfp[2] = k;
    arrayOfp[3] = h;
    return arrayOfp;
  }

  public boolean a()
  {
    return true;
  }

  public boolean b()
  {
    return false;
  }

  public int c()
  {
    return 0;
  }

  public String toString()
  {
    return this.E;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.p
 * JD-Core Version:    0.6.0
 */