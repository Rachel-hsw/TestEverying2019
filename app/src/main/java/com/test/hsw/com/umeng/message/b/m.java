package com.umeng.message.b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class m
  implements ab
{
  private static final byte a = 1;
  private static final byte b = 2;
  private static final byte c = 3;
  private static final byte d = 4;
  private static final byte e = 0;
  private static final byte f = 1;
  private static final byte g = 2;
  private static final byte h = 3;
  private int i = 0;
  private final i j;
  private final Inflater k;
  private final n l;
  private final CRC32 m = new CRC32();

  public m(ab paramab)
  {
    if (paramab == null)
      throw new IllegalArgumentException("source == null");
    this.k = new Inflater(true);
    this.j = o.a(paramab);
    this.l = new n(this.j, this.k);
  }

  private void a()
    throws IOException
  {
    this.j.a(10L);
    int n = this.j.b().b(3L);
    int i1;
    if ((0x1 & n >> 1) == 1)
      i1 = 1;
    while (true)
    {
      if (i1 != 0)
        a(this.j.b(), 0L, 10L);
      a("ID1ID2", 8075, this.j.i());
      this.j.g(8L);
      if ((0x1 & n >> 2) == 1)
      {
        this.j.a(2L);
        if (i1 != 0)
          a(this.j.b(), 0L, 2L);
        int i2 = this.j.b().l();
        this.j.a(i2);
        if (i1 != 0)
          a(this.j.b(), 0L, i2);
        this.j.g(i2);
      }
      if ((0x1 & n >> 3) != 1)
        break;
      long l2 = this.j.a(0);
      if (l2 == -1L)
      {
        throw new EOFException();
        i1 = 0;
        continue;
      }
      if (i1 != 0)
        a(this.j.b(), 0L, 1L + l2);
      this.j.g(1L + l2);
    }
    if ((0x1 & n >> 4) == 1)
    {
      long l1 = this.j.a(0);
      if (l1 == -1L)
        throw new EOFException();
      if (i1 != 0)
        a(this.j.b(), 0L, 1L + l1);
      this.j.g(1L + l1);
    }
    if (i1 != 0)
    {
      a("FHCRC", this.j.l(), (short)(int)this.m.getValue());
      this.m.reset();
    }
  }

  private void a(e parame, long paramLong1, long paramLong2)
  {
    for (y localy = parame.a; paramLong1 >= localy.d - localy.c; localy = localy.e)
      paramLong1 -= localy.d - localy.c;
    while (paramLong2 > 0L)
    {
      int n = (int)(paramLong1 + localy.c);
      int i1 = (int)Math.min(localy.d - n, paramLong2);
      this.m.update(localy.b, n, i1);
      paramLong2 -= i1;
      localy = localy.e;
      paramLong1 = 0L;
    }
  }

  private void a(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 != paramInt1)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      arrayOfObject[2] = Integer.valueOf(paramInt1);
      throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", arrayOfObject));
    }
  }

  private void b()
    throws IOException
  {
    a("CRC", this.j.m(), (int)this.m.getValue());
    a("ISIZE", this.j.m(), this.k.getTotalOut());
  }

  public long c(e parame, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (paramLong == 0L)
      return 0L;
    if (this.i == 0)
    {
      a();
      this.i = 1;
    }
    if (this.i == 1)
    {
      long l1 = parame.b;
      long l2 = this.l.c(parame, paramLong);
      if (l2 != -1L)
      {
        a(parame, l1, l2);
        return l2;
      }
      this.i = 2;
    }
    if (this.i == 2)
    {
      b();
      this.i = 3;
      if (!this.j.e())
        throw new IOException("gzip finished without exhausting source");
    }
    return -1L;
  }

  public void close()
    throws IOException
  {
    this.l.close();
  }

  public ac t()
  {
    return this.j.t();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.m
 * JD-Core Version:    0.6.0
 */