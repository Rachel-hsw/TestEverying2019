package b;

import java.io.IOException;

public abstract class m
  implements ab
{
  private final ab a;

  public m(ab paramab)
  {
    if (paramab == null)
      throw new IllegalArgumentException("delegate == null");
    this.a = paramab;
  }

  public ac a()
  {
    return this.a.a();
  }

  public long b(e parame, long paramLong)
    throws IOException
  {
    return this.a.b(parame, paramLong);
  }

  public final ab b()
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
 * Qualified Name:     b.m
 * JD-Core Version:    0.6.0
 */