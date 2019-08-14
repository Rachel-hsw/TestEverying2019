package com.umeng.a.b;

import android.text.TextUtils;

public class a
{
  private b a;
  private String b = "";
  private String c = "";
  private String d;
  private a e;

  public a(b paramb, String paramString)
  {
    if ((paramb == null) || (TextUtils.isEmpty(paramString)))
    {
      o.b("MobclickAgent", "parameter is not valid");
      return;
    }
    this.a = paramb;
    this.b = paramString;
  }

  public String a()
  {
    return this.c;
  }

  public void a(a parama)
  {
    this.e = parama;
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public b b()
  {
    return this.a;
  }

  public void b(String paramString)
  {
    this.d = paramString;
  }

  public String c()
  {
    return this.b;
  }

  public String d()
  {
    return this.d;
  }

  public a e()
  {
    return this.e;
  }

  public boolean f()
  {
    return (this.a != null) && (!TextUtils.isEmpty(this.b));
  }

  public String toString()
  {
    return "UMPlatformData [meida=" + this.a + ", usid=" + this.b + ", weiboId=" + this.c + ", name=" + this.d + ", gender=" + this.e + "]";
  }

  public static enum a
  {
    public int c;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      d = arrayOfa;
    }

    private a(int paramInt)
    {
      this.c = paramInt;
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
 * Qualified Name:     com.umeng.a.b.a
 * JD-Core Version:    0.6.0
 */