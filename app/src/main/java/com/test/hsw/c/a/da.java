package c.a;

import java.io.Serializable;

public class da
  implements Serializable
{
  private final boolean a;
  public final byte b;
  private final String c;
  private final boolean d;

  public da(byte paramByte)
  {
    this(paramByte, false);
  }

  public da(byte paramByte, String paramString)
  {
    this.b = paramByte;
    this.a = true;
    this.c = paramString;
    this.d = false;
  }

  public da(byte paramByte, boolean paramBoolean)
  {
    this.b = paramByte;
    this.a = false;
    this.c = null;
    this.d = paramBoolean;
  }

  public boolean a()
  {
    return this.a;
  }

  public String b()
  {
    return this.c;
  }

  public boolean c()
  {
    return this.b == 12;
  }

  public boolean d()
  {
    return (this.b == 15) || (this.b == 13) || (this.b == 14);
  }

  public boolean e()
  {
    return this.d;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.da
 * JD-Core Version:    0.6.0
 */