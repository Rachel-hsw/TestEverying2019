package c.a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class cv
{
  private final ByteArrayOutputStream a = new ByteArrayOutputStream();
  private final dz b = new dz(this.a);
  private dn c;

  public cv()
  {
    this(new dh.a());
  }

  public cv(dp paramdp)
  {
    this.c = paramdp.a(this.b);
  }

  public String a(cl paramcl, String paramString)
    throws cs
  {
    try
    {
      String str = new String(a(paramcl), paramString);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new cs("JVM DOES NOT SUPPORT ENCODING: " + paramString);
  }

  public byte[] a(cl paramcl)
    throws cs
  {
    this.a.reset();
    paramcl.b(this.c);
    return this.a.toByteArray();
  }

  public String b(cl paramcl)
    throws cs
  {
    return new String(a(paramcl));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.cv
 * JD-Core Version:    0.6.0
 */