package com.umeng.message.b;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e
  implements h, i, Cloneable
{
  y a;
  long b;

  private void a(InputStream paramInputStream, long paramLong, boolean paramBoolean)
    throws IOException
  {
    while (true)
    {
      y localy;
      int j;
      if ((paramLong > 0L) || (paramBoolean))
      {
        localy = f(1);
        int i = (int)Math.min(paramLong, 2048 - localy.d);
        j = paramInputStream.read(localy.b, localy.d, i);
        if (j != -1)
          break label73;
        if (!paramBoolean);
      }
      else
      {
        return;
      }
      throw new EOFException();
      label73: localy.d = (j + localy.d);
      this.b += j;
      paramLong -= j;
    }
  }

  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    y localy = this.a;
    int i;
    if (localy == null)
      i = -1;
    do
    {
      return i;
      i = Math.min(paramInt2, localy.d - localy.c);
      System.arraycopy(localy.b, localy.c, paramArrayOfByte, paramInt1, i);
      localy.c = (i + localy.c);
      this.b -= i;
    }
    while (localy.c != localy.d);
    this.a = localy.a();
    z.a.a(localy);
    return i;
  }

  public long a()
  {
    return this.b;
  }

  public long a(byte paramByte)
  {
    return a(paramByte, 0L);
  }

  public long a(byte paramByte, long paramLong)
  {
    y localy = this.a;
    if (localy == null)
      return -1L;
    long l1 = 0L;
    int i = localy.d - localy.c;
    if (paramLong >= i)
      paramLong -= i;
    while (true)
    {
      l1 += i;
      localy = localy.e;
      if (localy != this.a)
        break;
      return -1L;
      byte[] arrayOfByte = localy.b;
      long l2 = paramLong + localy.c;
      long l3 = localy.d;
      while (l2 < l3)
      {
        if (arrayOfByte[(int)l2] == paramByte)
          return l1 + l2 - localy.c;
        l2 += 1L;
      }
      paramLong = 0L;
    }
  }

  public long a(aa paramaa)
    throws IOException
  {
    long l = a();
    paramaa.b(this, l);
    return l;
  }

  public long a(ab paramab)
    throws IOException
  {
    long l1 = 0L;
    while (true)
    {
      long l2 = paramab.c(this, 2048L);
      if (l2 == -1L)
        break;
      l1 += l2;
    }
    return l1;
  }

  public e a(int paramInt)
  {
    y localy = f(1);
    byte[] arrayOfByte = localy.b;
    int i = localy.d;
    localy.d = (i + 1);
    arrayOfByte[i] = (byte)paramInt;
    this.b = (1L + this.b);
    return this;
  }

  public e a(j paramj)
  {
    return b(paramj.b, 0, paramj.b.length);
  }

  public e a(InputStream paramInputStream)
    throws IOException
  {
    a(paramInputStream, 9223372036854775807L, true);
    return this;
  }

  public e a(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    a(paramInputStream, paramLong, false);
    return this;
  }

  public e a(OutputStream paramOutputStream)
    throws IOException
  {
    return a(paramOutputStream, 0L, this.b);
  }

  public e a(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    ae.a(this.b, 0L, paramLong);
    Object localObject1 = this.a;
    Object localObject2;
    if (paramLong > 0L)
    {
      int i = (int)Math.min(paramLong, ((y)localObject1).d - ((y)localObject1).c);
      paramOutputStream.write(((y)localObject1).b, ((y)localObject1).c, i);
      ((y)localObject1).c = (i + ((y)localObject1).c);
      this.b -= i;
      paramLong -= i;
      if (((y)localObject1).c != ((y)localObject1).d)
        break label130;
      localObject2 = ((y)localObject1).a();
      this.a = ((y)localObject2);
      z.a.a((y)localObject1);
    }
    while (true)
    {
      localObject1 = localObject2;
      break;
      return this;
      label130: localObject2 = localObject1;
    }
  }

  public e a(OutputStream paramOutputStream, long paramLong1, long paramLong2)
    throws IOException
  {
    ae.a(this.b, paramLong1, paramLong2);
    if (paramLong2 == 0L);
    while (true)
    {
      return this;
      for (y localy = this.a; paramLong1 >= localy.d - localy.c; localy = localy.e)
        paramLong1 -= localy.d - localy.c;
      while (paramLong2 > 0L)
      {
        int i = (int)(paramLong1 + localy.c);
        int j = (int)Math.min(localy.d - i, paramLong2);
        paramOutputStream.write(localy.b, i, j);
        paramLong2 -= j;
        localy = localy.e;
        paramLong1 = 0L;
      }
    }
  }

  public e a(String paramString)
  {
    return a(paramString, ae.a);
  }

  public e a(String paramString, Charset paramCharset)
  {
    byte[] arrayOfByte = paramString.getBytes(paramCharset);
    return b(arrayOfByte, 0, arrayOfByte.length);
  }

  public e a(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public String a(long paramLong, Charset paramCharset)
  {
    ae.a(this.b, 0L, paramLong);
    if (paramLong > 2147483647L)
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    String str;
    if (paramLong == 0L)
      str = "";
    y localy;
    do
    {
      return str;
      localy = this.a;
      if (paramLong + localy.c > localy.d)
        return new String(f(paramLong), paramCharset);
      str = new String(localy.b, localy.c, (int)paramLong, paramCharset);
      localy.c = (int)(paramLong + localy.c);
      this.b -= paramLong;
    }
    while (localy.c != localy.d);
    this.a = localy.a();
    z.a.a(localy);
    return str;
  }

  public String a(Charset paramCharset)
    throws IOException
  {
    return a(this.b, paramCharset);
  }

  public void a(long paramLong)
    throws EOFException
  {
    if (this.b < paramLong)
      throw new EOFException();
  }

  public void a(e parame, long paramLong)
    throws IOException
  {
    parame.b(this, paramLong);
  }

  public byte b(long paramLong)
  {
    ae.a(this.b, paramLong, 1L);
    for (y localy = this.a; ; localy = localy.e)
    {
      int i = localy.d - localy.c;
      if (paramLong < i)
        return localy.b[(localy.c + (int)paramLong)];
      paramLong -= i;
    }
  }

  public e b()
  {
    return this;
  }

  public e b(int paramInt)
  {
    y localy = f(2);
    byte[] arrayOfByte = localy.b;
    int i = localy.d;
    int j = i + 1;
    arrayOfByte[i] = (byte)(0xFF & paramInt >>> 8);
    int k = j + 1;
    arrayOfByte[j] = (byte)(paramInt & 0xFF);
    localy.d = k;
    this.b = (2L + this.b);
    return this;
  }

  public e b(OutputStream paramOutputStream)
    throws IOException
  {
    return a(paramOutputStream, this.b);
  }

  public e b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      y localy = f(1);
      int j = Math.min(i - paramInt1, 2048 - localy.d);
      System.arraycopy(paramArrayOfByte, paramInt1, localy.b, localy.d, j);
      paramInt1 += j;
      localy.d = (j + localy.d);
    }
    this.b += paramInt2;
    return this;
  }

  public void b(e parame, long paramLong)
  {
    if (parame == this)
      throw new IllegalArgumentException("source == this");
    ae.a(parame.b, 0L, paramLong);
    y localy5;
    label67: y localy1;
    long l;
    if (paramLong > 0L)
      if (paramLong < parame.a.d - parame.a.c)
      {
        if (this.a != null)
        {
          localy5 = this.a.f;
          if ((localy5 != null) && (paramLong + (localy5.d - localy5.c) <= 2048L))
            break label216;
          parame.a = parame.a.a((int)paramLong);
        }
      }
      else
      {
        localy1 = parame.a;
        l = localy1.d - localy1.c;
        parame.a = localy1.a();
        if (this.a != null)
          break label248;
        this.a = localy1;
        y localy2 = this.a;
        y localy3 = this.a;
        y localy4 = this.a;
        localy3.f = localy4;
        localy2.e = localy4;
      }
    while (true)
    {
      parame.b -= l;
      this.b = (l + this.b);
      paramLong -= l;
      break;
      localy5 = null;
      break label67;
      label216: parame.a.a(localy5, (int)paramLong);
      parame.b -= paramLong;
      this.b = (paramLong + this.b);
      return;
      label248: this.a.f.a(localy1).b();
    }
  }

  public long c(e parame, long paramLong)
  {
    if (this.b == 0L)
      return -1L;
    if (paramLong > this.b)
      paramLong = this.b;
    parame.b(this, paramLong);
    return paramLong;
  }

  public e c(int paramInt)
  {
    return b(ae.a((short)paramInt));
  }

  public j c(long paramLong)
  {
    return new j(f(paramLong));
  }

  public OutputStream c()
  {
    return new f(this);
  }

  public void close()
  {
  }

  public e d()
  {
    return this;
  }

  public e d(int paramInt)
  {
    y localy = f(4);
    byte[] arrayOfByte = localy.b;
    int i = localy.d;
    int j = i + 1;
    arrayOfByte[i] = (byte)(0xFF & paramInt >>> 24);
    int k = j + 1;
    arrayOfByte[j] = (byte)(0xFF & paramInt >>> 16);
    int m = k + 1;
    arrayOfByte[k] = (byte)(0xFF & paramInt >>> 8);
    int n = m + 1;
    arrayOfByte[m] = (byte)(paramInt & 0xFF);
    localy.d = n;
    this.b = (4L + this.b);
    return this;
  }

  public String d(long paramLong)
  {
    return a(paramLong, ae.a);
  }

  public e e(int paramInt)
  {
    return d(ae.a(paramInt));
  }

  String e(long paramLong)
  {
    if ((paramLong > 0L) && (b(paramLong - 1L) == 13))
    {
      String str2 = d(paramLong - 1L);
      g(2L);
      return str2;
    }
    String str1 = d(paramLong);
    g(1L);
    return str1;
  }

  public boolean e()
  {
    return this.b == 0L;
  }

  public boolean equals(Object paramObject)
  {
    long l1 = 0L;
    if (!(paramObject instanceof e))
      return false;
    e locale = (e)paramObject;
    if (this.b != locale.b)
      return false;
    if (this.b == l1)
      return true;
    y localy1 = this.a;
    y localy2 = locale.a;
    int i = localy1.c;
    int j = localy2.c;
    while (l1 < this.b)
    {
      long l2 = Math.min(localy1.d - i, localy2.d - j);
      int k = 0;
      while (k < l2)
      {
        byte[] arrayOfByte1 = localy1.b;
        int m = i + 1;
        int n = arrayOfByte1[i];
        byte[] arrayOfByte2 = localy2.b;
        int i1 = j + 1;
        if (n != arrayOfByte2[j])
          return false;
        k++;
        j = i1;
        i = m;
      }
      if (i == localy1.d)
      {
        localy1 = localy1.e;
        i = localy1.c;
      }
      if (j == localy2.d)
      {
        localy2 = localy2.e;
        j = localy2.c;
      }
      l1 += l2;
    }
    return true;
  }

  y f(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 2048))
      throw new IllegalArgumentException();
    y localy1;
    if (this.a == null)
    {
      this.a = z.a.a();
      y localy2 = this.a;
      y localy3 = this.a;
      localy1 = this.a;
      localy3.f = localy1;
      localy2.e = localy1;
    }
    do
    {
      return localy1;
      localy1 = this.a.f;
    }
    while (paramInt + localy1.d <= 2048);
    return localy1.a(z.a.a());
  }

  public InputStream f()
  {
    return new g(this);
  }

  public byte[] f(long paramLong)
  {
    ae.a(this.b, 0L, paramLong);
    if (paramLong > 2147483647L)
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    int i = 0;
    byte[] arrayOfByte = new byte[(int)paramLong];
    while (i < paramLong)
    {
      int j = (int)Math.min(paramLong - i, this.a.d - this.a.c);
      System.arraycopy(this.a.b, this.a.c, arrayOfByte, i, j);
      i += j;
      y localy1 = this.a;
      localy1.c = (j + localy1.c);
      if (this.a.c != this.a.d)
        continue;
      y localy2 = this.a;
      this.a = localy2.a();
      z.a.a(localy2);
    }
    this.b -= paramLong;
    return arrayOfByte;
  }

  public long g()
  {
    long l = this.b;
    if (l == 0L)
      l = 0L;
    y localy;
    do
    {
      return l;
      localy = this.a.f;
    }
    while (localy.d >= 2048);
    return l - (localy.d - localy.c);
  }

  public void g(long paramLong)
  {
    ae.a(this.b, 0L, paramLong);
    this.b -= paramLong;
    while (paramLong > 0L)
    {
      int i = (int)Math.min(paramLong, this.a.d - this.a.c);
      paramLong -= i;
      y localy1 = this.a;
      localy1.c = (i + localy1.c);
      if (this.a.c != this.a.d)
        continue;
      y localy2 = this.a;
      this.a = localy2.a();
      z.a.a(localy2);
    }
  }

  public byte h()
  {
    if (this.b == 0L)
      throw new IllegalStateException("size == 0");
    y localy = this.a;
    int i = localy.c;
    int j = localy.d;
    byte[] arrayOfByte = localy.b;
    int k = i + 1;
    int m = arrayOfByte[i];
    this.b -= 1L;
    if (k == j)
    {
      this.a = localy.a();
      z.a.a(localy);
      return m;
    }
    localy.c = k;
    return m;
  }

  public e h(long paramLong)
  {
    y localy = f(8);
    byte[] arrayOfByte = localy.b;
    int i = localy.d;
    int j = i + 1;
    arrayOfByte[i] = (byte)(int)(0xFF & paramLong >>> 56);
    int k = j + 1;
    arrayOfByte[j] = (byte)(int)(0xFF & paramLong >>> 48);
    int m = k + 1;
    arrayOfByte[k] = (byte)(int)(0xFF & paramLong >>> 40);
    int n = m + 1;
    arrayOfByte[m] = (byte)(int)(0xFF & paramLong >>> 32);
    int i1 = n + 1;
    arrayOfByte[n] = (byte)(int)(0xFF & paramLong >>> 24);
    int i2 = i1 + 1;
    arrayOfByte[i1] = (byte)(int)(0xFF & paramLong >>> 16);
    int i3 = i2 + 1;
    arrayOfByte[i2] = (byte)(int)(0xFF & paramLong >>> 8);
    int i4 = i3 + 1;
    arrayOfByte[i3] = (byte)(int)(paramLong & 0xFF);
    localy.d = i4;
    this.b = (8L + this.b);
    return this;
  }

  public int hashCode()
  {
    y localy = this.a;
    if (localy == null)
      return 0;
    int i = 1;
    do
    {
      int j = localy.c;
      int k = localy.d;
      while (j < k)
      {
        int m = i * 31 + localy.b[j];
        j++;
        i = m;
      }
      localy = localy.e;
    }
    while (localy != this.a);
    return i;
  }

  public e i(long paramLong)
  {
    return h(ae.a(paramLong));
  }

  public short i()
  {
    if (this.b < 2L)
      throw new IllegalStateException("size < 2: " + this.b);
    y localy = this.a;
    int i = localy.c;
    int j = localy.d;
    if (j - i < 2)
      return (short)((0xFF & h()) << 8 | 0xFF & h());
    byte[] arrayOfByte = localy.b;
    int k = i + 1;
    int m = (0xFF & arrayOfByte[i]) << 8;
    int n = k + 1;
    int i1 = m | 0xFF & arrayOfByte[k];
    this.b -= 2L;
    if (n == j)
    {
      this.a = localy.a();
      z.a.a(localy);
    }
    while (true)
    {
      return (short)i1;
      localy.c = n;
    }
  }

  public int j()
  {
    if (this.b < 4L)
      throw new IllegalStateException("size < 4: " + this.b);
    y localy = this.a;
    int i = localy.c;
    int j = localy.d;
    if (j - i < 4)
      return (0xFF & h()) << 24 | (0xFF & h()) << 16 | (0xFF & h()) << 8 | 0xFF & h();
    byte[] arrayOfByte = localy.b;
    int k = i + 1;
    int m = (0xFF & arrayOfByte[i]) << 24;
    int n = k + 1;
    int i1 = m | (0xFF & arrayOfByte[k]) << 16;
    int i2 = n + 1;
    int i3 = i1 | (0xFF & arrayOfByte[n]) << 8;
    int i4 = i2 + 1;
    int i5 = i3 | 0xFF & arrayOfByte[i2];
    this.b -= 4L;
    if (i4 == j)
    {
      this.a = localy.a();
      z.a.a(localy);
      return i5;
    }
    localy.c = i4;
    return i5;
  }

  public long k()
  {
    if (this.b < 8L)
      throw new IllegalStateException("size < 8: " + this.b);
    y localy = this.a;
    int i = localy.c;
    int j = localy.d;
    if (j - i < 8)
      return (0xFFFFFFFF & j()) << 32 | 0xFFFFFFFF & j();
    byte[] arrayOfByte = localy.b;
    int k = i + 1;
    long l1 = (0xFF & arrayOfByte[i]) << 56;
    int m = k + 1;
    long l2 = l1 | (0xFF & arrayOfByte[k]) << 48;
    int n = m + 1;
    long l3 = l2 | (0xFF & arrayOfByte[m]) << 40;
    int i1 = n + 1;
    long l4 = l3 | (0xFF & arrayOfByte[n]) << 32;
    int i2 = i1 + 1;
    long l5 = l4 | (0xFF & arrayOfByte[i1]) << 24;
    int i3 = i2 + 1;
    long l6 = l5 | (0xFF & arrayOfByte[i2]) << 16;
    int i4 = i3 + 1;
    long l7 = l6 | (0xFF & arrayOfByte[i3]) << 8;
    int i5 = i4 + 1;
    long l8 = l7 | 0xFF & arrayOfByte[i4];
    this.b -= 8L;
    if (i5 == j)
    {
      this.a = localy.a();
      z.a.a(localy);
      return l8;
    }
    localy.c = i5;
    return l8;
  }

  public short l()
  {
    return ae.a(i());
  }

  public int m()
  {
    return ae.a(j());
  }

  public long n()
  {
    return ae.a(k());
  }

  public String o()
    throws IOException
  {
    return a(this.b, ae.a);
  }

  public String p()
    throws IOException
  {
    long l = a(10);
    if (l == -1L)
    {
      if (this.b != 0L)
        return d(this.b);
      return null;
    }
    return e(l);
  }

  public String q()
    throws IOException
  {
    long l = a(10);
    if (l == -1L)
      throw new EOFException();
    return e(l);
  }

  public void r()
  {
    g(this.b);
  }

  public void s()
  {
  }

  public ac t()
  {
    return ac.b;
  }

  public String toString()
  {
    if (this.b == 0L)
      return "Buffer[size=0]";
    if (this.b <= 16L)
    {
      j localj = v().c(this.b);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Long.valueOf(this.b);
      arrayOfObject2[1] = localj.c();
      return String.format("Buffer[size=%s data=%s]", arrayOfObject2);
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(this.a.b, this.a.c, this.a.d - this.a.c);
      for (y localy = this.a.e; localy != this.a; localy = localy.e)
        localMessageDigest.update(localy.b, localy.c, localy.d - localy.c);
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Long.valueOf(this.b);
      arrayOfObject1[1] = j.a(localMessageDigest.digest()).c();
      String str = String.format("Buffer[size=%s md5=%s]", arrayOfObject1);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    throw new AssertionError();
  }

  List<Integer> u()
  {
    if (this.a == null)
      return Collections.emptyList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(this.a.d - this.a.c));
    for (y localy = this.a.e; localy != this.a; localy = localy.e)
      localArrayList.add(Integer.valueOf(localy.d - localy.c));
    return localArrayList;
  }

  public e v()
  {
    e locale = new e();
    if (this.b == 0L)
      return locale;
    locale.b(this.a.b, this.a.c, this.a.d - this.a.c);
    for (y localy = this.a.e; localy != this.a; localy = localy.e)
      locale.b(localy.b, localy.c, localy.d - localy.c);
    return locale;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.e
 * JD-Core Version:    0.6.0
 */