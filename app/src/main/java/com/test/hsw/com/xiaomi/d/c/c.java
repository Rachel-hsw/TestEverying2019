package com.xiaomi.d.c;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.d.e.g;

public class c extends d
{
  private String a = null;
  private String d = null;
  private String e;
  private String f;
  private String g;
  private String h;
  private boolean i = false;
  private String j;
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  private boolean o = false;

  public c()
  {
  }

  public c(Bundle paramBundle)
  {
    super(paramBundle);
    this.a = paramBundle.getString("ext_msg_type");
    this.e = paramBundle.getString("ext_msg_lang");
    this.d = paramBundle.getString("ext_msg_thread");
    this.f = paramBundle.getString("ext_msg_sub");
    this.g = paramBundle.getString("ext_msg_body");
    this.h = paramBundle.getString("ext_body_encode");
    this.j = paramBundle.getString("ext_msg_appid");
    this.i = paramBundle.getBoolean("ext_msg_trans", false);
    this.o = paramBundle.getBoolean("ext_msg_encrypt", false);
    this.k = paramBundle.getString("ext_msg_seq");
    this.l = paramBundle.getString("ext_msg_mseq");
    this.m = paramBundle.getString("ext_msg_fseq");
    this.n = paramBundle.getString("ext_msg_status");
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<message");
    if (t() != null)
      localStringBuilder.append(" xmlns=\"").append(t()).append("\"");
    if (this.e != null)
      localStringBuilder.append(" xml:lang=\"").append(i()).append("\"");
    if (k() != null)
      localStringBuilder.append(" id=\"").append(k()).append("\"");
    if (m() != null)
      localStringBuilder.append(" to=\"").append(g.a(m())).append("\"");
    if (!TextUtils.isEmpty(e()))
      localStringBuilder.append(" seq=\"").append(e()).append("\"");
    if (!TextUtils.isEmpty(f()))
      localStringBuilder.append(" mseq=\"").append(f()).append("\"");
    if (!TextUtils.isEmpty(g()))
      localStringBuilder.append(" fseq=\"").append(g()).append("\"");
    if (!TextUtils.isEmpty(h()))
      localStringBuilder.append(" status=\"").append(h()).append("\"");
    if (n() != null)
      localStringBuilder.append(" from=\"").append(g.a(n())).append("\"");
    if (l() != null)
      localStringBuilder.append(" chid=\"").append(g.a(l())).append("\"");
    if (this.i)
      localStringBuilder.append(" transient=\"true\"");
    if (!TextUtils.isEmpty(this.j))
      localStringBuilder.append(" appid=\"").append(d()).append("\"");
    if (!TextUtils.isEmpty(this.a))
      localStringBuilder.append(" type=\"").append(this.a).append("\"");
    if (this.o)
      localStringBuilder.append(" s=\"1\"");
    localStringBuilder.append(">");
    if (this.f != null)
    {
      localStringBuilder.append("<subject>").append(g.a(this.f));
      localStringBuilder.append("</subject>");
    }
    if (this.g != null)
    {
      localStringBuilder.append("<body");
      if (!TextUtils.isEmpty(this.h))
        localStringBuilder.append(" encode=\"").append(this.h).append("\"");
      localStringBuilder.append(">").append(g.a(this.g)).append("</body>");
    }
    if (this.d != null)
      localStringBuilder.append("<thread>").append(this.d).append("</thread>");
    if ("error".equalsIgnoreCase(this.a))
    {
      h localh = p();
      if (localh != null)
        localStringBuilder.append(localh.d());
    }
    localStringBuilder.append(s());
    localStringBuilder.append("</message>");
    return localStringBuilder.toString();
  }

  public void a(String paramString)
  {
    this.j = paramString;
  }

  public void a(String paramString1, String paramString2)
  {
    this.g = paramString1;
    this.h = paramString2;
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public String b()
  {
    return this.a;
  }

  public void b(String paramString)
  {
    this.k = paramString;
  }

  public void b(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public Bundle c()
  {
    Bundle localBundle = super.c();
    if (!TextUtils.isEmpty(this.a))
      localBundle.putString("ext_msg_type", this.a);
    if (this.e != null)
      localBundle.putString("ext_msg_lang", this.e);
    if (this.f != null)
      localBundle.putString("ext_msg_sub", this.f);
    if (this.g != null)
      localBundle.putString("ext_msg_body", this.g);
    if (!TextUtils.isEmpty(this.h))
      localBundle.putString("ext_body_encode", this.h);
    if (this.d != null)
      localBundle.putString("ext_msg_thread", this.d);
    if (this.j != null)
      localBundle.putString("ext_msg_appid", this.j);
    if (this.i)
      localBundle.putBoolean("ext_msg_trans", true);
    if (!TextUtils.isEmpty(this.k))
      localBundle.putString("ext_msg_seq", this.k);
    if (!TextUtils.isEmpty(this.l))
      localBundle.putString("ext_msg_mseq", this.l);
    if (!TextUtils.isEmpty(this.m))
      localBundle.putString("ext_msg_fseq", this.m);
    if (this.o)
      localBundle.putBoolean("ext_msg_encrypt", true);
    if (!TextUtils.isEmpty(this.n))
      localBundle.putString("ext_msg_status", this.n);
    return localBundle;
  }

  public void c(String paramString)
  {
    this.l = paramString;
  }

  public String d()
  {
    return this.j;
  }

  public void d(String paramString)
  {
    this.m = paramString;
  }

  public String e()
  {
    return this.k;
  }

  public void e(String paramString)
  {
    this.n = paramString;
  }

  public boolean equals(Object paramObject)
  {
    int i1 = 1;
    int i2;
    if (this == paramObject)
      i2 = i1;
    c localc;
    while (true)
    {
      return i2;
      i2 = 0;
      if (paramObject == null)
        continue;
      Class localClass1 = getClass();
      Class localClass2 = paramObject.getClass();
      i2 = 0;
      if (localClass1 != localClass2)
        continue;
      localc = (c)paramObject;
      boolean bool1 = super.equals(localc);
      i2 = 0;
      if (!bool1)
        continue;
      if (this.g == null)
        break;
      boolean bool5 = this.g.equals(localc.g);
      i2 = 0;
      if (!bool5)
        continue;
      if (this.e == null)
        break label195;
      boolean bool4 = this.e.equals(localc.e);
      i2 = 0;
      if (!bool4)
        continue;
      label115: if (this.f == null)
        break label205;
      boolean bool3 = this.f.equals(localc.f);
      i2 = 0;
      if (!bool3)
        continue;
      label143: if (this.d == null)
        break label215;
      boolean bool2 = this.d.equals(localc.d);
      i2 = 0;
      if (!bool2)
        continue;
      label171: if (this.a != localc.a)
        break label225;
    }
    while (true)
    {
      return i1;
      if (localc.g == null)
        break;
      return false;
      label195: if (localc.e == null)
        break label115;
      return false;
      label205: if (localc.f == null)
        break label143;
      return false;
      label215: if (localc.d == null)
        break label171;
      return false;
      label225: i1 = 0;
    }
  }

  public String f()
  {
    return this.l;
  }

  public void f(String paramString)
  {
    this.a = paramString;
  }

  public String g()
  {
    return this.m;
  }

  public void g(String paramString)
  {
    this.f = paramString;
  }

  public String h()
  {
    return this.n;
  }

  public void h(String paramString)
  {
    this.g = paramString;
  }

  public int hashCode()
  {
    int i1;
    int i3;
    label35: int i5;
    label59: int i6;
    if (this.a != null)
    {
      i1 = this.a.hashCode();
      int i2 = i1 * 31;
      if (this.g == null)
        break label129;
      i3 = this.g.hashCode();
      int i4 = 31 * (i3 + i2);
      if (this.d == null)
        break label134;
      i5 = this.d.hashCode();
      i6 = 31 * (i5 + i4);
      if (this.e == null)
        break label140;
    }
    label129: label134: label140: for (int i7 = this.e.hashCode(); ; i7 = 0)
    {
      int i8 = 31 * (i7 + i6);
      String str = this.f;
      int i9 = 0;
      if (str != null)
        i9 = this.f.hashCode();
      return i8 + i9;
      i1 = 0;
      break;
      i3 = 0;
      break label35;
      i5 = 0;
      break label59;
    }
  }

  public String i()
  {
    return this.e;
  }

  public void i(String paramString)
  {
    this.d = paramString;
  }

  public void j(String paramString)
  {
    this.e = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.c.c
 * JD-Core Version:    0.6.0
 */