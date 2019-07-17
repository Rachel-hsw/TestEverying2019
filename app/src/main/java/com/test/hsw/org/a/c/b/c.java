package org.a.c.b;

public class c
{
  public final String a;
  public final byte b;
  public final short c;

  public c()
  {
    this("", 0, 0);
  }

  public c(String paramString, byte paramByte, short paramShort)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramShort;
  }

  public String toString()
  {
    return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.c.b.c
 * JD-Core Version:    0.6.0
 */