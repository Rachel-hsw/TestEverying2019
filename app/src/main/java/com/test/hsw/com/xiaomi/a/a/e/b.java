package com.xiaomi.a.a.e;

import java.util.HashMap;
import java.util.Map;

public class b
{
  public int a;
  public Map<String, String> b = new HashMap();
  public String c;

  public String a()
  {
    return this.c;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = this.b.toString();
    arrayOfObject[2] = this.c;
    return String.format("resCode = %1$d, headers = %2$s, response = %3$s", arrayOfObject);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.a.a.e.b
 * JD-Core Version:    0.6.0
 */