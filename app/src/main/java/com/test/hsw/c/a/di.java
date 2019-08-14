package c.a;

public class di
{
  public final String a;
  public final byte b;
  public final short c;

  public di()
  {
    this("", 0, 0);
  }

  public di(String paramString, byte paramByte, short paramShort)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramShort;
  }

  public boolean a(di paramdi)
  {
    return (this.b == paramdi.b) && (this.c == paramdi.c);
  }

  public String toString()
  {
    return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.di
 * JD-Core Version:    0.6.0
 */