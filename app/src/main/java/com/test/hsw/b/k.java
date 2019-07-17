package b;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class k
  implements aa
{
  private final h a;
  private final Deflater b;
  private boolean c;

  public k(aa paramaa, Deflater paramDeflater)
  {
    this(q.a(paramaa), paramDeflater);
  }

  k(h paramh, Deflater paramDeflater)
  {
    if (paramh == null)
      throw new IllegalArgumentException("source == null");
    if (paramDeflater == null)
      throw new IllegalArgumentException("inflater == null");
    this.a = paramh;
    this.b = paramDeflater;
  }

  @IgnoreJRERequirement
  private void a(boolean paramBoolean)
    throws IOException
  {
    e locale = this.a.d();
    label115: 
    do
    {
      y localy = locale.f(1);
      if (paramBoolean);
      for (int i = this.b.deflate(localy.b, localy.d, 2048 - localy.d, 2); ; i = this.b.deflate(localy.b, localy.d, 2048 - localy.d))
      {
        if (i <= 0)
          break label115;
        localy.d = (i + localy.d);
        locale.b += i;
        this.a.y();
        break;
      }
    }
    while (!this.b.needsInput());
  }

  public ac a()
  {
    return this.a.a();
  }

  public void a(e parame, long paramLong)
    throws IOException
  {
    ae.a(parame.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      y localy = parame.a;
      int i = (int)Math.min(paramLong, localy.d - localy.c);
      this.b.setInput(localy.b, localy.c, i);
      a(false);
      parame.b -= i;
      localy.c = (i + localy.c);
      if (localy.c == localy.d)
      {
        parame.a = localy.a();
        z.a.a(localy);
      }
      paramLong -= i;
    }
  }

  public void b()
    throws IOException
  {
    a(true);
    this.a.b();
  }

  void c()
    throws IOException
  {
    this.b.finish();
    a(false);
  }

  public void close()
    throws IOException
  {
    if (this.c);
    while (true)
    {
      return;
      Object localObject1 = null;
      try
      {
        c();
        try
        {
          label14: this.b.end();
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
              this.c = true;
              if (localObject2 == null)
                break;
              ae.a(localObject2);
              return;
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
      catch (Throwable localThrowable1)
      {
        break label14;
      }
    }
  }

  public String toString()
  {
    return "DeflaterSink(" + this.a + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.k
 * JD-Core Version:    0.6.0
 */