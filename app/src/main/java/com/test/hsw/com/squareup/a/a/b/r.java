package com.squareup.a.a.b;

import b.h;
import b.i;
import b.j;
import com.squareup.a.a.l;
import com.squareup.a.v;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.Deflater;

public final class r
  implements ad
{
  static final int a = 0;
  static final int b = 1;
  static final int c = 2;
  static final int d = 3;
  static final int e = 4;
  static final int f = 6;
  static final int g = 7;
  static final int h = 8;
  static final int i = 9;
  static final int j = 1;
  static final int k = 2;
  static final int l = 3;
  static final byte[] m;

  static
  {
    try
    {
      m = "".getBytes(l.d.name());
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new AssertionError();
  }

  public b a(i parami, boolean paramBoolean)
  {
    return new a(parami, paramBoolean);
  }

  public c a(h paramh, boolean paramBoolean)
  {
    return new b(paramh, paramBoolean);
  }

  public v a()
  {
    return v.c;
  }

  public int b()
  {
    return 16383;
  }

  static final class a
    implements b
  {
    private final i a;
    private final boolean b;
    private final k c;

    a(i parami, boolean paramBoolean)
    {
      this.a = parami;
      this.c = new k(this.a);
      this.b = paramBoolean;
    }

    private static IOException a(String paramString, Object[] paramArrayOfObject)
      throws IOException
    {
      throw new IOException(String.format(paramString, paramArrayOfObject));
    }

    private void a(b.a parama, int paramInt1, int paramInt2)
      throws IOException
    {
      boolean bool1 = true;
      int i = this.a.l();
      int j = this.a.l();
      int k = i & 0x7FFFFFFF;
      int m = j & 0x7FFFFFFF;
      this.a.k();
      List localList = this.c.a(paramInt2 - 10);
      boolean bool2;
      if ((paramInt1 & 0x1) != 0)
      {
        bool2 = bool1;
        if ((paramInt1 & 0x2) == 0)
          break label104;
      }
      while (true)
      {
        parama.a(bool1, bool2, k, m, localList, e.a);
        return;
        bool2 = false;
        break;
        label104: bool1 = false;
      }
    }

    private void b(b.a parama, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = 0x7FFFFFFF & this.a.l();
      List localList = this.c.a(paramInt2 - 4);
      if ((paramInt1 & 0x1) != 0);
      for (boolean bool = true; ; bool = false)
      {
        parama.a(false, bool, i, -1, localList, e.b);
        return;
      }
    }

    private void c(b.a parama, int paramInt1, int paramInt2)
      throws IOException
    {
      if (paramInt2 != 8)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt2);
        throw a("TYPE_RST_STREAM length: %d != 8", arrayOfObject2);
      }
      int i = 0x7FFFFFFF & this.a.l();
      int j = this.a.l();
      a locala = a.a(j);
      if (locala == null)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(j);
        throw a("TYPE_RST_STREAM unexpected error code: %d", arrayOfObject1);
      }
      parama.a(i, locala);
    }

    private void d(b.a parama, int paramInt1, int paramInt2)
      throws IOException
    {
      parama.a(false, false, 0x7FFFFFFF & this.a.l(), -1, this.c.a(paramInt2 - 4), e.c);
    }

    private void e(b.a parama, int paramInt1, int paramInt2)
      throws IOException
    {
      if (paramInt2 != 8)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt2);
        throw a("TYPE_WINDOW_UPDATE length: %d != 8", arrayOfObject2);
      }
      int i = this.a.l();
      int j = this.a.l();
      int k = i & 0x7FFFFFFF;
      long l = j & 0x7FFFFFFF;
      if (l == 0L)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Long.valueOf(l);
        throw a("windowSizeIncrement was 0", arrayOfObject1);
      }
      parama.a(k, l);
    }

    private void f(b.a parama, int paramInt1, int paramInt2)
      throws IOException
    {
      boolean bool1 = true;
      if (paramInt2 != 4)
      {
        Object[] arrayOfObject = new Object[bool1];
        arrayOfObject[0] = Integer.valueOf(paramInt2);
        throw a("TYPE_PING length: %d != 4", arrayOfObject);
      }
      int i = this.a.l();
      boolean bool2 = this.b;
      boolean bool3;
      if ((i & 0x1) == bool1)
      {
        bool3 = bool1;
        if (bool2 != bool3)
          break label86;
      }
      while (true)
      {
        parama.a(bool1, i, 0);
        return;
        bool3 = false;
        break;
        label86: bool1 = false;
      }
    }

    private void g(b.a parama, int paramInt1, int paramInt2)
      throws IOException
    {
      if (paramInt2 != 8)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt2);
        throw a("TYPE_GOAWAY length: %d != 8", arrayOfObject2);
      }
      int i = 0x7FFFFFFF & this.a.l();
      int j = this.a.l();
      a locala = a.c(j);
      if (locala == null)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(j);
        throw a("TYPE_GOAWAY unexpected error code: %d", arrayOfObject1);
      }
      parama.a(i, locala, j.a);
    }

    private void h(b.a parama, int paramInt1, int paramInt2)
      throws IOException
    {
      boolean bool = true;
      int i = this.a.l();
      if (paramInt2 != 4 + i * 8)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramInt2);
        arrayOfObject[bool] = Integer.valueOf(i);
        throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", arrayOfObject);
      }
      q localq = new q();
      for (int j = 0; j < i; j++)
      {
        int k = this.a.l();
        int m = this.a.l();
        int n = (0xFF000000 & k) >>> 24;
        localq.a(k & 0xFFFFFF, n, m);
      }
      if ((paramInt1 & 0x1) != 0);
      while (true)
      {
        parama.a(bool, localq);
        return;
        bool = false;
      }
    }

    public void a()
    {
    }

    public boolean a(b.a parama)
      throws IOException
    {
      int i;
      int m;
      int n;
      while (true)
      {
        int i4;
        try
        {
          i = this.a.l();
          int j = this.a.l();
          if ((0x80000000 & i) != 0)
          {
            k = 1;
            m = (0xFF000000 & j) >>> 24;
            n = j & 0xFFFFFF;
            if (k == 0)
              break;
            int i3 = (0x7FFF0000 & i) >>> 16;
            i4 = 0xFFFF & i;
            if (i3 == 3)
              break label111;
            throw new ProtocolException("version != 3: " + i3);
          }
        }
        catch (IOException localIOException)
        {
          return false;
        }
        int k = 0;
        continue;
        switch (i4)
        {
        case 5:
        default:
          this.a.g(n);
          return true;
        case 1:
          a(parama, m, n);
          return true;
        case 2:
          b(parama, m, n);
          return true;
        case 3:
          c(parama, m, n);
          return true;
        case 4:
          h(parama, m, n);
          return true;
        case 6:
          f(parama, m, n);
          return true;
        case 7:
          g(parama, m, n);
          return true;
        case 8:
          label111: d(parama, m, n);
          return true;
        case 9:
        }
        e(parama, m, n);
        return true;
      }
      int i1 = 0x7FFFFFFF & i;
      int i2 = m & 0x1;
      boolean bool = false;
      if (i2 != 0)
        bool = true;
      parama.a(bool, i1, this.a, n);
      return true;
    }

    public void close()
      throws IOException
    {
      this.c.a();
    }
  }

  static final class b
    implements c
  {
    private final h a;
    private final b.e b;
    private final h c;
    private final boolean d;
    private boolean e;

    b(h paramh, boolean paramBoolean)
    {
      this.a = paramh;
      this.d = paramBoolean;
      Deflater localDeflater = new Deflater();
      localDeflater.setDictionary(r.m);
      this.b = new b.e();
      this.c = b.q.a(new b.k(this.b, localDeflater));
    }

    private void a(List<d> paramList)
      throws IOException
    {
      if (this.b.c() != 0L)
        throw new IllegalStateException();
      this.c.h(paramList.size());
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        j localj1 = ((d)paramList.get(j)).h;
        this.c.h(localj1.f());
        this.c.b(localj1);
        j localj2 = ((d)paramList.get(j)).i;
        this.c.h(localj2.f());
        this.c.b(localj2);
      }
      this.c.b();
    }

    public void a()
    {
      monitorenter;
      monitorexit;
    }

    void a(int paramInt1, int paramInt2, b.e parame, int paramInt3)
      throws IOException
    {
      if (this.e)
        throw new IOException("closed");
      if (paramInt3 > 16777215L)
        throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + paramInt3);
      this.a.h(0x7FFFFFFF & paramInt1);
      this.a.h((paramInt2 & 0xFF) << 24 | 0xFFFFFF & paramInt3);
      if (paramInt3 > 0)
        this.a.a(parame, paramInt3);
    }

    public void a(int paramInt1, int paramInt2, List<d> paramList)
      throws IOException
    {
    }

    public void a(int paramInt, long paramLong)
      throws IOException
    {
      monitorenter;
      try
      {
        if (this.e)
          throw new IOException("closed");
      }
      finally
      {
        monitorexit;
      }
      if ((paramLong == 0L) || (paramLong > 2147483647L))
        throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + paramLong);
      this.a.h(-2147287031);
      this.a.h(8);
      this.a.h(paramInt);
      this.a.h((int)paramLong);
      this.a.b();
      monitorexit;
    }

    public void a(int paramInt, a parama)
      throws IOException
    {
      monitorenter;
      try
      {
        if (this.e)
          throw new IOException("closed");
      }
      finally
      {
        monitorexit;
      }
      if (parama.s == -1)
        throw new IllegalArgumentException();
      this.a.h(-2147287037);
      this.a.h(8);
      this.a.h(0x7FFFFFFF & paramInt);
      this.a.h(parama.s);
      this.a.b();
      monitorexit;
    }

    public void a(int paramInt, a parama, byte[] paramArrayOfByte)
      throws IOException
    {
      monitorenter;
      try
      {
        if (this.e)
          throw new IOException("closed");
      }
      finally
      {
        monitorexit;
      }
      if (parama.t == -1)
        throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
      this.a.h(-2147287033);
      this.a.h(8);
      this.a.h(paramInt);
      this.a.h(parama.t);
      this.a.b();
      monitorexit;
    }

    public void a(int paramInt, List<d> paramList)
      throws IOException
    {
      monitorenter;
      try
      {
        if (this.e)
          throw new IOException("closed");
      }
      finally
      {
        monitorexit;
      }
      a(paramList);
      int i = (int)(4L + this.b.c());
      this.a.h(-2147287032);
      this.a.h(0x0 | i & 0xFFFFFF);
      this.a.h(0x7FFFFFFF & paramInt);
      this.a.a(this.b);
      monitorexit;
    }

    public void a(q paramq)
      throws IOException
    {
      monitorenter;
      try
      {
        if (this.e)
          throw new IOException("closed");
      }
      finally
      {
        monitorexit;
      }
      int i = paramq.b();
      int j = 4 + i * 8;
      this.a.h(-2147287036);
      this.a.h(0x0 | j & 0xFFFFFF);
      this.a.h(i);
      for (int k = 0; ; k++)
        if (k <= 10)
        {
          if (!paramq.a(k))
            continue;
          int m = paramq.c(k);
          this.a.h((m & 0xFF) << 24 | k & 0xFFFFFF);
          this.a.h(paramq.b(k));
        }
        else
        {
          this.a.b();
          monitorexit;
          return;
        }
    }

    public void a(boolean paramBoolean, int paramInt1, int paramInt2)
      throws IOException
    {
      boolean bool1 = true;
      monitorenter;
      try
      {
        if (this.e)
          throw new IOException("closed");
      }
      finally
      {
        monitorexit;
      }
      boolean bool2 = this.d;
      boolean bool3;
      if ((paramInt1 & 0x1) == bool1)
        bool3 = bool1;
      while (true)
      {
        if (paramBoolean != bool1)
          throw new IllegalArgumentException("payload != reply");
        this.a.h(-2147287034);
        this.a.h(4);
        this.a.h(paramInt1);
        this.a.b();
        monitorexit;
        return;
        while (true)
        {
          if (bool2 == bool3)
            break label128;
          break;
          bool3 = false;
        }
        label128: bool1 = false;
      }
    }

    public void a(boolean paramBoolean, int paramInt, b.e parame)
      throws IOException
    {
      monitorenter;
      try
      {
        a(paramBoolean, paramInt, parame, (int)parame.c());
        monitorexit;
        return;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public void a(boolean paramBoolean, int paramInt1, b.e parame, int paramInt2)
      throws IOException
    {
      monitorenter;
      int i;
      if (paramBoolean)
        i = 1;
      try
      {
        a(paramInt1, i, parame, paramInt2);
        return;
        i = 0;
      }
      finally
      {
        monitorexit;
      }
    }

    public void a(boolean paramBoolean, int paramInt, List<d> paramList)
      throws IOException
    {
      monitorenter;
      try
      {
        if (this.e)
          throw new IOException("closed");
      }
      finally
      {
        monitorexit;
      }
      a(paramList);
      if (paramBoolean);
      for (int i = 1; ; i = 0)
      {
        int j = (int)(4L + this.b.c());
        this.a.h(-2147287038);
        this.a.h((i & 0xFF) << 24 | j & 0xFFFFFF);
        this.a.h(0x7FFFFFFF & paramInt);
        this.a.a(this.b);
        this.a.b();
        monitorexit;
        return;
      }
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<d> paramList)
      throws IOException
    {
      monitorenter;
      try
      {
        if (this.e)
          throw new IOException("closed");
      }
      finally
      {
        monitorexit;
      }
      a(paramList);
      int i = (int)(10L + this.b.c());
      int j;
      if (paramBoolean1)
        j = 1;
      while (true)
      {
        int m = k | j;
        this.a.h(-2147287039);
        this.a.h((m & 0xFF) << 24 | i & 0xFFFFFF);
        this.a.h(paramInt1 & 0x7FFFFFFF);
        this.a.h(paramInt2 & 0x7FFFFFFF);
        this.a.j(0);
        this.a.a(this.b);
        this.a.b();
        monitorexit;
        return;
        j = 0;
        int k = 0;
        if (!paramBoolean2)
          continue;
        k = 2;
      }
    }

    public void b()
    {
    }

    public void c()
      throws IOException
    {
      monitorenter;
      try
      {
        if (this.e)
          throw new IOException("closed");
      }
      finally
      {
        monitorexit;
      }
      this.a.b();
      monitorexit;
    }

    public void close()
      throws IOException
    {
      monitorenter;
      try
      {
        this.e = true;
        l.a(this.a, this.c);
        monitorexit;
        return;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.r
 * JD-Core Version:    0.6.0
 */