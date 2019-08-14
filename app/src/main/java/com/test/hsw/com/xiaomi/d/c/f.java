package com.xiaomi.d.c;

import android.os.Bundle;
import com.xiaomi.d.e.g;

public class f extends d
{
  private b a = b.a;
  private String d = null;
  private int e = -2147483648;
  private a f = null;

  public f(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.containsKey("ext_pres_type"))
      this.a = b.valueOf(paramBundle.getString("ext_pres_type"));
    if (paramBundle.containsKey("ext_pres_status"))
      this.d = paramBundle.getString("ext_pres_status");
    if (paramBundle.containsKey("ext_pres_prio"))
      this.e = paramBundle.getInt("ext_pres_prio");
    if (paramBundle.containsKey("ext_pres_mode"))
      this.f = a.valueOf(paramBundle.getString("ext_pres_mode"));
  }

  public f(b paramb)
  {
    a(paramb);
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<presence");
    if (t() != null)
      localStringBuilder.append(" xmlns=\"").append(t()).append("\"");
    if (k() != null)
      localStringBuilder.append(" id=\"").append(k()).append("\"");
    if (m() != null)
      localStringBuilder.append(" to=\"").append(g.a(m())).append("\"");
    if (n() != null)
      localStringBuilder.append(" from=\"").append(g.a(n())).append("\"");
    if (l() != null)
      localStringBuilder.append(" chid=\"").append(g.a(l())).append("\"");
    if (this.a != null)
      localStringBuilder.append(" type=\"").append(this.a).append("\"");
    localStringBuilder.append(">");
    if (this.d != null)
      localStringBuilder.append("<status>").append(g.a(this.d)).append("</status>");
    if (this.e != -2147483648)
      localStringBuilder.append("<priority>").append(this.e).append("</priority>");
    if ((this.f != null) && (this.f != a.b))
      localStringBuilder.append("<show>").append(this.f).append("</show>");
    localStringBuilder.append(s());
    h localh = p();
    if (localh != null)
      localStringBuilder.append(localh.d());
    localStringBuilder.append("</presence>");
    return localStringBuilder.toString();
  }

  public void a(int paramInt)
  {
    if ((paramInt < -128) || (paramInt > 128))
      throw new IllegalArgumentException("Priority value " + paramInt + " is not valid. Valid range is -128 through 128.");
    this.e = paramInt;
  }

  public void a(a parama)
  {
    this.f = parama;
  }

  public void a(b paramb)
  {
    if (paramb == null)
      throw new NullPointerException("Type cannot be null");
    this.a = paramb;
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public Bundle c()
  {
    Bundle localBundle = super.c();
    if (this.a != null)
      localBundle.putString("ext_pres_type", this.a.toString());
    if (this.d != null)
      localBundle.putString("ext_pres_status", this.d);
    if (this.e != -2147483648)
      localBundle.putInt("ext_pres_prio", this.e);
    if ((this.f != null) && (this.f != a.b))
      localBundle.putString("ext_pres_mode", this.f.toString());
    return localBundle;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      f = arrayOfa;
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[8];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
      arrayOfb[7] = h;
      i = arrayOfb;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.c.f
 * JD-Core Version:    0.6.0
 */