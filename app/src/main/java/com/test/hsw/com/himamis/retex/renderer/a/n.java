package com.himamis.retex.renderer.a;

public class n extends q
{
  private final char a;
  private String b;

  public n(char paramChar, String paramString)
  {
    this.a = paramChar;
    this.b = paramString;
  }

  private m a(dq paramdq, int paramInt, boolean paramBoolean)
  {
    char c = this.a;
    if ((paramBoolean) && (Character.isLowerCase(this.a)))
      c = Character.toUpperCase(this.a);
    if (this.b == null)
      return paramdq.a(c, paramInt);
    return paramdq.a(c, this.b, paramInt);
  }

  public i a(dp paramdp)
  {
    if (this.b == null)
    {
      String str = paramdp.k();
      if (str != null)
        this.b = str;
    }
    boolean bool = paramdp.l();
    Object localObject = new o(a(paramdp.m(), paramdp.j(), bool));
    if ((bool) && (Character.isLowerCase(this.a)))
      localObject = new co((i)localObject, 0.800000011920929D, 0.800000011920929D);
    return (i)localObject;
  }

  public p a(dq paramdq)
  {
    return a(paramdq, 0, false).a();
  }

  public char d()
  {
    return this.a;
  }

  public String toString()
  {
    return "CharAtom: '" + this.a + "'";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.n
 * JD-Core Version:    0.6.0
 */