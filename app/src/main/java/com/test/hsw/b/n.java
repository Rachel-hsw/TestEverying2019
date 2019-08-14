package b;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class n
  implements aa
{
  private final h a;
  private final Deflater b;
  private final k c;
  private boolean d;
  private final CRC32 e = new CRC32();

  public n(aa paramaa)
  {
    if (paramaa == null)
      throw new IllegalArgumentException("sink == null");
    this.b = new Deflater(-1, true);
    this.a = q.a(paramaa);
    this.c = new k(this.a, this.b);
    c();
  }

  private void b(e parame, long paramLong)
  {
    for (y localy = parame.a; paramLong > 0L; localy = localy.e)
    {
      int i = (int)Math.min(paramLong, localy.d - localy.c);
      this.e.update(localy.b, localy.c, i);
      paramLong -= i;
    }
  }

  private void c()
  {
    e locale = this.a.d();
    locale.b(8075);
    locale.a(8);
    locale.a(0);
    locale.d(0);
    locale.a(0);
    locale.a(0);
  }

  private void d()
    throws IOException
  {
    this.a.g((int)this.e.getValue());
    this.a.g(this.b.getTotalIn());
  }

  public ac a()
  {
    return this.a.a();
  }

  public void a(e parame, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (paramLong == 0L)
      return;
    b(parame, paramLong);
    this.c.a(parame, paramLong);
  }

  public void b()
    throws IOException
  {
    this.c.b();
  }

  public void close()
    throws IOException
  {
    if (this.d);
    while (true)
    {
      return;
      Object localObject1 = null;
      try
      {
        this.c.c();
        d();
      }
      catch (Throwable localObject3)
      {
        try
        {
          this.b.end();
          localObject2 = localObject1;
        }
        catch (Throwable localObject3)
        {
          try
          {
            while (true)
            {
              Object localObject2;
              this.a.close();
              this.d = true;
              if (localObject2 == null)
                break;
              ae.a(localObject2);
              return;
              localThrowable1 = localThrowable1;
              localObject1 = localThrowable1;
              continue;
              localThrowable2 = localThrowable2;
              if (localObject1 == null)
                continue;
              localObject3 = localObject1;
            }
          }
          catch (Throwable localThrowable3)
          {
            while (true)
            {
              if (localObject3 != null)
                continue;
              Object localObject3 = localThrowable3;
            }
          }
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.n
 * JD-Core Version:    0.6.0
 */