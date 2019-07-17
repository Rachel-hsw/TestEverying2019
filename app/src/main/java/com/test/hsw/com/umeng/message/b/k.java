package com.umeng.message.b;

import java.io.IOException;
import java.util.zip.Deflater;

public final class k
  implements aa
{
  private final h a;
  private final Deflater b;
  private boolean c;

  public k(aa paramaa, Deflater paramDeflater)
  {
    this(o.a(paramaa), paramDeflater);
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

  private void a(boolean paramBoolean)
    throws IOException
  {
    e locale = this.a.b();
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
        this.a.w();
        break;
      }
    }
    while (!this.b.needsInput());
  }

  void a()
    throws IOException
  {
    this.b.finish();
    a(false);
  }

  public void b(e parame, long paramLong)
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
        a();
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

  public void s()
    throws IOException
  {
    a(true);
    this.a.s();
  }

  public ac t()
  {
    return this.a.t();
  }

  public String toString()
  {
    return "DeflaterSink(" + this.a + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.k
 * JD-Core Version:    0.6.0
 */