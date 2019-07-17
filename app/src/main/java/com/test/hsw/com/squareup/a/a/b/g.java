package com.squareup.a.a.b;

import b.ab;
import b.ac;
import b.h;
import b.i;
import b.j;
import com.squareup.a.v;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class g
  implements ad
{
  static final byte a = 0;
  static final byte b = 1;
  static final byte c = 2;
  static final byte d = 3;
  static final byte e = 4;
  static final byte f = 5;
  static final byte g = 6;
  static final byte h = 7;
  static final byte i = 8;
  static final byte j = 9;
  static final byte k = 10;
  static final byte l = 11;
  static final byte m = 0;
  static final byte n = 1;
  static final byte o = 1;
  static final byte p = 2;
  static final byte q = 4;
  static final byte r = 4;
  static final byte s = 8;
  static final byte t = 16;
  static final byte u = 32;
  static final byte v = 32;
  private static final Logger w = Logger.getLogger(g.class.getName());
  private static final j x = j.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

  private static short b(i parami, byte paramByte)
    throws IOException
  {
    if (((paramByte & 0x10) != 0) && ((paramByte & 0x8) == 0))
      throw d("PROTOCOL_ERROR FLAG_PAD_HIGH set without FLAG_PAD_LOW", new Object[0]);
    int i1;
    if ((paramByte & 0x10) != 0)
      i1 = 0xFFFF & parami.k();
    while (true)
    {
      if (i1 > 16383)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(i1);
        throw d("PROTOCOL_ERROR padding > 16383: %s", arrayOfObject);
        if ((paramByte & 0x8) != 0)
        {
          i1 = 0xFF & parami.j();
          continue;
        }
      }
      else
      {
        return (short)i1;
      }
      i1 = 0;
    }
  }

  private static short b(short paramShort1, byte paramByte, short paramShort2)
    throws IOException
  {
    if ((paramByte & 0x10) != 0)
      paramShort1 = (short)(paramShort1 - 2);
    while (paramShort2 > paramShort1)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Short.valueOf(paramShort2);
      arrayOfObject[1] = Short.valueOf(paramShort1);
      throw d("PROTOCOL_ERROR padding %s > remaining length %s", arrayOfObject);
      if ((paramByte & 0x8) == 0)
        continue;
      paramShort1 = (short)(paramShort1 - 1);
    }
    return (short)(paramShort1 - paramShort2);
  }

  private static IllegalArgumentException c(String paramString, Object[] paramArrayOfObject)
  {
    throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  private static IOException d(String paramString, Object[] paramArrayOfObject)
    throws IOException
  {
    throw new IOException(String.format(paramString, paramArrayOfObject));
  }

  public b a(i parami, boolean paramBoolean)
  {
    return new c(parami, 4096, paramBoolean);
  }

  public c a(h paramh, boolean paramBoolean)
  {
    return new d(paramh, paramBoolean);
  }

  public v a()
  {
    return v.d;
  }

  public int b()
  {
    return 16383;
  }

  static final class a
    implements ab
  {
    short a;
    byte b;
    int c;
    short d;
    short e;
    private final i f;

    public a(i parami)
    {
      this.f = parami;
    }

    private void b()
      throws IOException
    {
      int i = this.c;
      int j = this.f.l();
      int k = this.f.l();
      this.a = (short)((0x3FFF0000 & j) >> 16);
      byte b1 = (byte)((0xFF00 & j) >> 8);
      this.b = (byte)(j & 0xFF);
      if (g.d().isLoggable(Level.FINE))
        g.d().fine(g.b.a(true, this.c, this.a, b1, this.b));
      this.e = g.a(this.f, this.b);
      short s = g.a(this.a, this.b, this.e);
      this.d = s;
      this.a = s;
      this.c = (0x7FFFFFFF & k);
      if (b1 != 9)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(b1);
        throw g.a("%s != TYPE_CONTINUATION", arrayOfObject);
      }
      if (this.c != i)
        throw g.a("TYPE_CONTINUATION streamId changed", new Object[0]);
    }

    public ac a()
    {
      return this.f.a();
    }

    public long b(b.e parame, long paramLong)
      throws IOException
    {
      if (this.d == 0)
      {
        this.f.g(this.e);
        this.e = 0;
        if ((0x4 & this.b) == 0);
      }
      long l;
      do
      {
        return -1L;
        b();
        break;
        l = this.f.b(parame, Math.min(paramLong, this.d));
      }
      while (l == -1L);
      this.d = (short)(int)(this.d - l);
      return l;
    }

    public void close()
      throws IOException
    {
    }
  }

  static final class b
  {
    private static final String[] a = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION", "ALTSVC", "BLOCKED" };
    private static final String[] b = new String[64];
    private static final String[] c = new String[256];

    static
    {
      for (int i = 0; i < c.length; i++)
      {
        String[] arrayOfString = c;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.toBinaryString(i);
        arrayOfString[i] = String.format("%8s", arrayOfObject).replace(' ', '0');
      }
      b[0] = "";
      b[1] = "END_STREAM";
      b[2] = "END_SEGMENT";
      b[3] = "END_STREAM|END_SEGMENT";
      int[] arrayOfInt1 = { 1, 2, 3 };
      b[8] = "PAD_LOW";
      b[24] = "PAD_LOW|PAD_HIGH";
      int[] arrayOfInt2 = { 8, 24 };
      int j = arrayOfInt1.length;
      for (int k = 0; k < j; k++)
      {
        int i9 = arrayOfInt1[k];
        int i10 = arrayOfInt2.length;
        for (int i11 = 0; i11 < i10; i11++)
        {
          int i12 = arrayOfInt2[i11];
          b[(i9 | i12)] = (b[i9] + '|' + b[i12]);
        }
      }
      b[4] = "END_HEADERS";
      b[32] = "PRIORITY";
      b[36] = "END_HEADERS|PRIORITY";
      for (int i2 : new int[] { 4, 32, 36 })
      {
        int i3 = arrayOfInt1.length;
        for (int i4 = 0; i4 < i3; i4++)
        {
          int i5 = arrayOfInt1[i4];
          b[(i5 | i2)] = (b[i5] + '|' + b[i2]);
          int i6 = arrayOfInt2.length;
          for (int i7 = 0; i7 < i6; i7++)
          {
            int i8 = arrayOfInt2[i7];
            b[(i8 | (i5 | i2))] = (b[i5] + '|' + b[i2] + '|' + b[i8]);
          }
        }
      }
      for (int i1 = 0; i1 < b.length; i1++)
      {
        if (b[i1] != null)
          continue;
        b[i1] = c[i1];
      }
    }

    static String a(byte paramByte1, byte paramByte2)
    {
      String str;
      if (paramByte2 == 0)
        str = "";
      do
      {
        return str;
        switch (paramByte1)
        {
        case 5:
        case 9:
        default:
          if (paramByte2 >= b.length)
            break;
        case 4:
        case 6:
        case 2:
        case 3:
        case 7:
        case 8:
        case 10:
        case 11:
        }
        for (str = b[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = c[paramByte2])
        {
          return str.replace("HEADERS", "PUSH_PROMISE");
          if (paramByte2 == 1)
            return "ACK";
          return c[paramByte2];
          return c[paramByte2];
        }
      }
      while ((paramByte1 != 0) || ((paramByte2 & 0x20) == 0));
      return str.replace("PRIORITY", "COMPRESSED");
    }

    static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    {
      String str1;
      String str2;
      Object[] arrayOfObject2;
      if (paramByte1 < a.length)
      {
        str1 = a[paramByte1];
        str2 = a(paramByte1, paramByte2);
        arrayOfObject2 = new Object[5];
        if (!paramBoolean)
          break label105;
      }
      label105: for (String str3 = "<<"; ; str3 = ">>")
      {
        arrayOfObject2[0] = str3;
        arrayOfObject2[1] = Integer.valueOf(paramInt1);
        arrayOfObject2[2] = Integer.valueOf(paramInt2);
        arrayOfObject2[3] = str1;
        arrayOfObject2[4] = str2;
        return String.format("%s 0x%08x %5d %-13s %s", arrayOfObject2);
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Byte.valueOf(paramByte1);
        str1 = String.format("0x%02x", arrayOfObject1);
        break;
      }
    }
  }

  static final class c
    implements b
  {
    final f.a a;
    private final i b;
    private final g.a c;
    private final boolean d;

    c(i parami, int paramInt, boolean paramBoolean)
    {
      this.b = parami;
      this.d = paramBoolean;
      this.c = new g.a(this.b);
      this.a = new f.a(paramInt, this.c);
    }

    private List<d> a(short paramShort1, short paramShort2, byte paramByte, int paramInt)
      throws IOException
    {
      g.a locala = this.c;
      this.c.d = paramShort1;
      locala.a = paramShort1;
      this.c.e = paramShort2;
      this.c.b = paramByte;
      this.c.c = paramInt;
      this.a.b();
      this.a.c();
      return this.a.d();
    }

    private void a(b.a parama, int paramInt)
      throws IOException
    {
      int i = this.b.l();
      if ((0x80000000 & i) != 0);
      for (boolean bool = true; ; bool = false)
      {
        parama.a(paramInt, i & 0x7FFFFFFF, 1 + (0xFF & this.b.j()), bool);
        return;
      }
    }

    private void a(b.a parama, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramInt == 0)
        throw g.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
      if ((paramByte & 0x1) != 0);
      for (boolean bool = true; ; bool = false)
      {
        short s = g.a(this.b, paramByte);
        if ((paramByte & 0x20) != 0)
        {
          a(parama, paramInt);
          paramShort = (short)(paramShort - 5);
        }
        parama.a(false, bool, paramInt, -1, a(g.a(paramShort, paramByte, s), s, paramByte, paramInt), e.d);
        return;
      }
    }

    private void b(b.a parama, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      boolean bool1 = true;
      boolean bool2;
      if ((paramByte & 0x1) != 0)
      {
        bool2 = bool1;
        if ((paramByte & 0x20) == 0)
          break label41;
      }
      while (true)
      {
        if (!bool1)
          break label47;
        throw g.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        bool2 = false;
        break;
        label41: bool1 = false;
      }
      label47: int i = g.a(this.b, paramByte);
      int j = g.a(paramShort, paramByte, i);
      parama.a(bool2, paramInt, this.b, j);
      this.b.g(i);
    }

    private void c(b.a parama, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort != 5)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Short.valueOf(paramShort);
        throw g.a("TYPE_PRIORITY length: %d != 5", arrayOfObject);
      }
      if (paramInt == 0)
        throw g.a("TYPE_PRIORITY streamId == 0", new Object[0]);
      a(parama, paramInt);
    }

    private void d(b.a parama, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort != 4)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Short.valueOf(paramShort);
        throw g.a("TYPE_RST_STREAM length: %d != 4", arrayOfObject2);
      }
      if (paramInt == 0)
        throw g.a("TYPE_RST_STREAM streamId == 0", new Object[0]);
      int i = this.b.l();
      a locala = a.b(i);
      if (locala == null)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(i);
        throw g.a("TYPE_RST_STREAM unexpected error code: %d", arrayOfObject1);
      }
      parama.a(paramInt, locala);
    }

    private void e(b.a parama, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramInt != 0)
        throw g.a("TYPE_SETTINGS streamId != 0", new Object[0]);
      if ((paramByte & 0x1) != 0)
      {
        if (paramShort != 0)
          throw g.a("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        parama.a();
      }
      q localq;
      do
      {
        return;
        if (paramShort % 5 != 0)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Short.valueOf(paramShort);
          throw g.a("TYPE_SETTINGS length %% 5 != 0: %s", arrayOfObject2);
        }
        localq = new q();
        short s = 0;
        if (s < paramShort)
        {
          int i = this.b.j();
          int j = this.b.l();
          switch (i)
          {
          default:
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = Integer.valueOf(i);
            throw g.a("PROTOCOL_ERROR invalid settings id: %s", arrayOfObject1);
          case 2:
            if ((j == 0) || (j == 1))
              break;
            throw g.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
          case 3:
            i = 4;
          case 1:
          case 5:
          case 4:
          }
          do
          {
            localq.a(i, 0, j);
            s += 5;
            break;
            i = 7;
          }
          while (j >= 0);
          throw g.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
        }
        parama.a(false, localq);
      }
      while (localq.c() < 0);
      this.a.a(localq.c());
    }

    private void f(b.a parama, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramInt == 0)
        throw g.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
      short s = g.a(this.b, paramByte);
      parama.a(paramInt, 0x7FFFFFFF & this.b.l(), a((short)(paramShort - 4), s, paramByte, paramInt));
    }

    private void g(b.a parama, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      boolean bool = true;
      if (paramShort != 8)
      {
        Object[] arrayOfObject = new Object[bool];
        arrayOfObject[0] = Short.valueOf(paramShort);
        throw g.a("TYPE_PING length != 8: %s", arrayOfObject);
      }
      if (paramInt != 0)
        throw g.a("TYPE_PING streamId != 0", new Object[0]);
      int i = this.b.l();
      int j = this.b.l();
      if ((paramByte & 0x1) != 0);
      while (true)
      {
        parama.a(bool, i, j);
        return;
        bool = false;
      }
    }

    private void h(b.a parama, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort < 8)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Short.valueOf(paramShort);
        throw g.a("TYPE_GOAWAY length < 8: %s", arrayOfObject2);
      }
      if (paramInt != 0)
        throw g.a("TYPE_GOAWAY streamId != 0", new Object[0]);
      int i = this.b.l();
      int j = this.b.l();
      int k = paramShort - 8;
      a locala = a.b(j);
      if (locala == null)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(j);
        throw g.a("TYPE_GOAWAY unexpected error code: %d", arrayOfObject1);
      }
      j localj = j.a;
      if (k > 0)
        localj = this.b.c(k);
      parama.a(i, locala, localj);
    }

    private void i(b.a parama, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort != 4)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Short.valueOf(paramShort);
        throw g.a("TYPE_WINDOW_UPDATE length !=4: %s", arrayOfObject2);
      }
      long l = 0x7FFFFFFF & this.b.l();
      if (l == 0L)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Long.valueOf(l);
        throw g.a("windowSizeIncrement was 0", arrayOfObject1);
      }
      parama.a(paramInt, l);
    }

    private void j(b.a parama, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      long l = 0xFFFFFFFF & this.b.l();
      int i = 0xFFFF & this.b.k();
      this.b.j();
      int j = 0xFF & this.b.j();
      j localj = this.b.c(j);
      int k = 0xFF & this.b.j();
      String str = this.b.d(k);
      int m = paramShort - 9 - j - k;
      parama.a(paramInt, this.b.d(m), localj, str, i, l);
    }

    public void a()
      throws IOException
    {
      if (this.d);
      j localj;
      do
      {
        return;
        localj = this.b.c(g.c().f());
        if (!g.d().isLoggable(Level.FINE))
          continue;
        Logger localLogger = g.d();
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localj.c();
        localLogger.fine(String.format("<< CONNECTION %s", arrayOfObject2));
      }
      while (g.c().equals(localj));
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = localj.a();
      throw g.a("Expected a connection header but was %s", arrayOfObject1);
    }

    public boolean a(b.a parama)
      throws IOException
    {
      boolean bool = true;
      short s;
      do
      {
        byte b2;
        int k;
        try
        {
          int i = this.b.l();
          int j = this.b.l();
          s = (short)((0x3FFF0000 & i) >> 16);
          byte b1 = (byte)((0xFF00 & i) >> 8);
          b2 = (byte)(i & 0xFF);
          k = j & 0x7FFFFFFF;
          if (g.d().isLoggable(Level.FINE))
            g.d().fine(g.b.a(bool, k, s, b1, b2));
          switch (b1)
          {
          case 9:
          default:
            Object[] arrayOfObject2 = new Object[bool];
            arrayOfObject2[0] = Byte.valueOf(b1);
            throw g.a("PROTOCOL_ERROR: unknown frame type %s", arrayOfObject2);
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 10:
          case 11:
          }
        }
        catch (IOException localIOException)
        {
          bool = false;
          return bool;
        }
        b(parama, s, b2, k);
        return bool;
        a(parama, s, b2, k);
        return bool;
        c(parama, s, b2, k);
        return bool;
        d(parama, s, b2, k);
        return bool;
        e(parama, s, b2, k);
        return bool;
        f(parama, s, b2, k);
        return bool;
        g(parama, s, b2, k);
        return bool;
        h(parama, s, b2, k);
        return bool;
        i(parama, s, b2, k);
        return bool;
        j(parama, s, b2, k);
        return bool;
      }
      while (s == 0);
      Object[] arrayOfObject1 = new Object[bool];
      arrayOfObject1[0] = Short.valueOf(s);
      throw g.a("TYPE_BLOCKED length != 0: %s", arrayOfObject1);
    }

    public void close()
      throws IOException
    {
      this.b.close();
    }
  }

  static final class d
    implements c
  {
    private final h a;
    private final boolean b;
    private final b.e c;
    private final f.b d;
    private boolean e;

    d(h paramh, boolean paramBoolean)
    {
      this.a = paramh;
      this.b = paramBoolean;
      this.c = new b.e();
      this.d = new f.b(this.c);
    }

    private void b(boolean paramBoolean, int paramInt, List<d> paramList)
      throws IOException
    {
      if (this.e)
        throw new IOException("closed");
      if (this.c.c() != 0L)
        throw new IllegalStateException();
      this.d.a(paramList);
      int i = (int)this.c.c();
      byte b1 = 4;
      if (paramBoolean)
        b1 = 5;
      a(paramInt, i, 1, b1);
      this.a.a(this.c);
    }

    public void a()
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
      boolean bool = this.b;
      if (!bool);
      while (true)
      {
        monitorexit;
        return;
        if (g.d().isLoggable(Level.FINE))
        {
          Logger localLogger = g.d();
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = g.c().c();
          localLogger.fine(String.format(">> CONNECTION %s", arrayOfObject));
        }
        this.a.b(g.c().g());
        this.a.b();
      }
    }

    void a(int paramInt1, byte paramByte, b.e parame, int paramInt2)
      throws IOException
    {
      a(paramInt1, paramInt2, 0, paramByte);
      if (paramInt2 > 0)
        this.a.a(parame, paramInt2);
    }

    void a(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
      throws IOException
    {
      if (g.d().isLoggable(Level.FINE))
        g.d().fine(g.b.a(false, paramInt1, paramInt2, paramByte1, paramByte2));
      if (paramInt2 > 16383)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt2);
        throw g.b("FRAME_SIZE_ERROR length > 16383: %s", arrayOfObject2);
      }
      if ((0x80000000 & paramInt1) != 0)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(paramInt1);
        throw g.b("reserved bit set: %s", arrayOfObject1);
      }
      this.a.h((paramInt2 & 0x3FFF) << 16 | (paramByte1 & 0xFF) << 8 | paramByte2 & 0xFF);
      this.a.h(0x7FFFFFFF & paramInt1);
    }

    public void a(int paramInt1, int paramInt2, List<d> paramList)
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
      if (this.c.c() != 0L)
        throw new IllegalStateException();
      this.d.a(paramList);
      a(paramInt1, (int)(4L + this.c.c()), 5, 4);
      this.a.h(0x7FFFFFFF & paramInt2);
      this.a.a(this.c);
      monitorexit;
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
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Long.valueOf(paramLong);
        throw g.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", arrayOfObject);
      }
      a(paramInt, 4, 8, 0);
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
      a(paramInt, 4, 3, 0);
      this.a.h(parama.r);
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
      if (parama.r == -1)
        throw g.b("errorCode.httpCode == -1", new Object[0]);
      a(0, 8 + paramArrayOfByte.length, 7, 0);
      this.a.h(paramInt);
      this.a.h(parama.r);
      if (paramArrayOfByte.length > 0)
        this.a.b(paramArrayOfByte);
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
      b(false, paramInt, paramList);
      monitorexit;
    }

    public void a(q paramq)
      throws IOException
    {
      int i = 0;
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
      a(0, 5 * paramq.b(), 4, 0);
      if (i < 10)
        if (paramq.a(i))
          break label110;
      while (true)
      {
        label56: this.a.k(j);
        this.a.h(paramq.b(i));
        break label104;
        this.a.b();
        monitorexit;
        return;
        label104: label110: 
        do
        {
          j = i;
          break label56;
          i++;
          break;
          if (i != 4)
            continue;
          j = 3;
          break label56;
        }
        while (i != 7);
        int j = 4;
      }
    }

    public void a(boolean paramBoolean, int paramInt1, int paramInt2)
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
      byte b1 = 0;
      if (paramBoolean)
        b1 = 1;
      a(0, 8, 6, b1);
      this.a.h(paramInt1);
      this.a.h(paramInt2);
      this.a.b();
      monitorexit;
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
      try
      {
        if (this.e)
          throw new IOException("closed");
      }
      finally
      {
        monitorexit;
      }
      byte b1 = 0;
      if (paramBoolean)
        b1 = (byte)1;
      a(paramInt1, b1, parame, paramInt2);
      monitorexit;
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
      b(paramBoolean, paramInt, paramList);
      monitorexit;
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<d> paramList)
      throws IOException
    {
      monitorenter;
      if (paramBoolean2)
        try
        {
          throw new UnsupportedOperationException();
        }
        finally
        {
          monitorexit;
        }
      if (this.e)
        throw new IOException("closed");
      b(paramBoolean1, paramInt1, paramList);
      monitorexit;
    }

    public void b()
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
      a(0, 0, 4, 1);
      this.a.b();
      monitorexit;
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
        this.a.close();
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
 * Qualified Name:     com.squareup.a.a.b.g
 * JD-Core Version:    0.6.0
 */