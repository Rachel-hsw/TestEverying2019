package org.a.c;

import org.a.c.b.a.a;
import org.a.c.b.f;
import org.a.c.b.h;
import org.a.c.c.c;

public class e
{
  private final f a;
  private final c b = new c();

  public e()
  {
    this(new a.a());
  }

  public e(h paramh)
  {
    this.a = paramh.a(this.b);
  }

  public void a(b paramb, byte[] paramArrayOfByte)
  {
    try
    {
      this.b.a(paramArrayOfByte);
      paramb.a(this.a);
      return;
    }
    finally
    {
      this.a.y();
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.c.e
 * JD-Core Version:    0.6.0
 */