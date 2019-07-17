package com.himamis.retex.editor.a.e;

public class f extends e
{
  private final int[] a;
  private int b;
  private int c;
  private i[] d;
  private String e;
  private String f;

  f(String paramString1, String paramString2, String paramString3, char paramChar, i[] paramArrayOfi)
  {
    super(paramString1, paramString2, paramString3, paramChar, paramChar);
    i[] arrayOfi;
    int j;
    if (paramArrayOfi != null)
    {
      arrayOfi = paramArrayOfi;
      this.d = arrayOfi;
      this.b = 0;
      this.c = 0;
      if (paramArrayOfi == null)
        break label144;
      j = paramArrayOfi.length;
      label49: this.a = new int[j];
    }
    StringBuffer localStringBuffer;
    for (int k = 0; ; k++)
    {
      if (k >= this.a.length)
      {
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(b() + "(");
        if (i < this.a.length)
          break label173;
        localStringBuffer.append(")");
        this.f = localStringBuffer.toString();
        return;
        arrayOfi = new i[0];
        break;
        label144: j = 0;
        break label49;
      }
      this.a[this.d[k].d()] = k;
    }
    label173: StringBuilder localStringBuilder = new StringBuilder(String.valueOf(this.d[i].a()));
    if (i + 1 < this.a.length);
    for (String str = ", "; ; str = "")
    {
      localStringBuffer.append(str);
      i++;
      break;
    }
  }

  public i a(int paramInt)
  {
    return this.d[paramInt];
  }

  public String a()
  {
    return this.e;
  }

  public void a(String paramString)
  {
    this.e = paramString;
  }

  void b(int paramInt)
  {
    this.b = paramInt;
  }

  void c(int paramInt)
  {
    this.c = paramInt;
  }

  public int d(int paramInt)
  {
    return this.d[paramInt].e();
  }

  public int e(int paramInt)
  {
    return this.d[paramInt].f();
  }

  public String g()
  {
    return this.f;
  }

  public int h()
  {
    return this.d.length;
  }

  public int i()
  {
    return this.b;
  }

  public int j()
  {
    return this.c;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.e.f
 * JD-Core Version:    0.6.0
 */