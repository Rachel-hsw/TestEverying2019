package org.a.a.a.f;

import java.io.Serializable;

public class b
  implements Serializable, Comparable<b>, a<Boolean>
{
  private static final long a = -4830728138360036487L;
  private boolean b;

  public b()
  {
  }

  public b(Boolean paramBoolean)
  {
    this.b = paramBoolean.booleanValue();
  }

  public b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public int a(b paramb)
  {
    boolean bool = paramb.b;
    if (this.b == bool)
      return 0;
    if (this.b)
      return 1;
    return -1;
  }

  public void a(Boolean paramBoolean)
  {
    this.b = paramBoolean.booleanValue();
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public Boolean b()
  {
    return Boolean.valueOf(this.b);
  }

  public boolean c()
  {
    return this.b == true;
  }

  public boolean d()
  {
    return !this.b;
  }

  public boolean e()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof b;
    int i = 0;
    if (bool1)
    {
      boolean bool2 = this.b;
      boolean bool3 = ((b)paramObject).e();
      i = 0;
      if (bool2 == bool3)
        i = 1;
    }
    return i;
  }

  public Boolean f()
  {
    return Boolean.valueOf(e());
  }

  public int hashCode()
  {
    if (this.b)
      return Boolean.TRUE.hashCode();
    return Boolean.FALSE.hashCode();
  }

  public String toString()
  {
    return String.valueOf(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.f.b
 * JD-Core Version:    0.6.0
 */