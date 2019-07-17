package com.umeng.socialize.b.b;

import java.util.Map;
import org.json.JSONObject;

public abstract class g
{
  protected static String g = "POST";
  protected static String h = "GET";
  protected String i;

  public g(String paramString)
  {
    this.i = paramString;
  }

  public Map<String, Object> b()
  {
    return null;
  }

  public void b(String paramString)
  {
    this.i = paramString;
  }

  public Map<String, a> c()
  {
    return null;
  }

  public abstract JSONObject d();

  public abstract String e();

  protected String f()
  {
    return g;
  }

  public String i()
  {
    return this.i;
  }

  public static class a
  {
    String a;
    byte[] b;

    public a(String paramString, byte[] paramArrayOfByte)
    {
      this.a = paramString;
      this.b = paramArrayOfByte;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.b.g
 * JD-Core Version:    0.6.0
 */