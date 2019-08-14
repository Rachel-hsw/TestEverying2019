package b;

import java.io.IOException;

public abstract class l
  implements aa
{
  private final aa a;

  public l(aa paramaa)
  {
    if (paramaa == null)
      throw new IllegalArgumentException("delegate == null");
    this.a = paramaa;
  }

  public ac a()
  {
    return this.a.a();
  }

  public void a(e parame, long paramLong)
    throws IOException
  {
    this.a.a(parame, paramLong);
  }

  public void b()
    throws IOException
  {
    this.a.b();
  }

  public final aa c()
  {
    return this.a;
  }

  public void close()
    throws IOException
  {
    this.a.close();
  }

  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.a.toString() + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.l
 * JD-Core Version:    0.6.0
 */