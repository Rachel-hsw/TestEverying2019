package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

public final class o extends t
{
  private String b;
  private byte[] c;
  private String d;
  private ArrayList<Header> e;
  private Map<String, String> f;
  private boolean g;

  public o(String paramString)
  {
    this.b = paramString;
    this.e = new ArrayList();
    this.f = new HashMap();
    this.d = "application/x-www-form-urlencoded";
  }

  public final String a()
  {
    return this.b;
  }

  public final void a(String paramString)
  {
    this.d = paramString;
  }

  public final void a(String paramString1, String paramString2)
  {
    if (this.f == null)
      this.f = new HashMap();
    this.f.put(paramString1, paramString2);
  }

  public final void a(Header paramHeader)
  {
    this.e.add(paramHeader);
  }

  public final void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public final void a(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }

  public final String b(String paramString)
  {
    if (this.f == null)
      return null;
    return (String)this.f.get(paramString);
  }

  public final byte[] b()
  {
    return this.c;
  }

  public final String c()
  {
    return this.d;
  }

  public final ArrayList<Header> d()
  {
    return this.e;
  }

  public final boolean e()
  {
    return this.g;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    o localo;
    do
      while (true)
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localo = (o)paramObject;
        if (this.c == null)
        {
          if (localo.c != null)
            return false;
        }
        else if (!this.c.equals(localo.c))
          return false;
        if (this.b != null)
          break;
        if (localo.b != null)
          return false;
      }
    while (this.b.equals(localo.b));
    return false;
  }

  public final int hashCode()
  {
    int i = 1;
    if ((this.f != null) && (this.f.containsKey("id")))
      i = 31 + ((String)this.f.get("id")).hashCode();
    int j = i * 31;
    if (this.b == null);
    for (int k = 0; ; k = this.b.hashCode())
      return k + j;
  }

  public final String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = this.e;
    return String.format("Url : %s,HttpHeader: %s", arrayOfObject);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.android.phone.mrpc.core.o
 * JD-Core Version:    0.6.0
 */