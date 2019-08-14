package c.a;

import org.json.JSONObject;

public abstract class ca
{
  protected static String b = "POST";
  protected static String c = "GET";
  protected String d;

  public ca(String paramString)
  {
    this.d = paramString;
  }

  public abstract JSONObject a();

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public abstract String b();

  protected String c()
  {
    return b;
  }

  public String d()
  {
    return this.d;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ca
 * JD-Core Version:    0.6.0
 */