package c.a;

public final class dl
{
  public final String a;
  public final byte b;
  public final int c;

  public dl()
  {
    this("", 0, 0);
  }

  public dl(String paramString, byte paramByte, int paramInt)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramInt;
  }

  public boolean a(dl paramdl)
  {
    return (this.a.equals(paramdl.a)) && (this.b == paramdl.b) && (this.c == paramdl.c);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof dl))
      return a((dl)paramObject);
    return false;
  }

  public String toString()
  {
    return "<TMessage name:'" + this.a + "' type: " + this.b + " seqid:" + this.c + ">";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.dl
 * JD-Core Version:    0.6.0
 */