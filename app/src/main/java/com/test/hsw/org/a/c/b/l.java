package org.a.c.b;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class l extends a
{
  private static int f = 10000;
  private static int g = 10000;
  private static int h = 10000;
  private static int i = 10485760;
  private static int j = 104857600;

  public l(org.a.c.c.d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramd, paramBoolean1, paramBoolean2);
  }

  public e k()
  {
    byte b1 = r();
    byte b2 = r();
    int k = t();
    if (k > f)
      throw new g(3, "Thrift map size " + k + " out of range!");
    return new e(b1, b2, k);
  }

  public d m()
  {
    byte b = r();
    int k = t();
    if (k > g)
      throw new g(3, "Thrift list size " + k + " out of range!");
    return new d(b, k);
  }

  public j o()
  {
    byte b = r();
    int k = t();
    if (k > h)
      throw new g(3, "Thrift set size " + k + " out of range!");
    return new j(b, k);
  }

  public String w()
  {
    int k = t();
    if (k > i)
      throw new g(3, "Thrift string size " + k + " out of range!");
    if (this.e.c() >= k)
      try
      {
        String str = new String(this.e.a(), this.e.b(), k, "UTF-8");
        this.e.a(k);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new org.a.c.f("JVM DOES NOT SUPPORT UTF-8");
      }
    return b(k);
  }

  public ByteBuffer x()
  {
    int k = t();
    if (k > j)
      throw new g(3, "Thrift binary size " + k + " out of range!");
    d(k);
    if (this.e.c() >= k)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(this.e.a(), this.e.b(), k);
      this.e.a(k);
      return localByteBuffer;
    }
    byte[] arrayOfByte = new byte[k];
    this.e.d(arrayOfByte, 0, k);
    return ByteBuffer.wrap(arrayOfByte);
  }

  public static class a extends a.a
  {
    public a()
    {
      super(true);
    }

    public a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      super(paramBoolean2, paramInt);
    }

    public f a(org.a.c.c.d paramd)
    {
      l locall = new l(paramd, this.a, this.b);
      if (this.c != 0)
        locall.c(this.c);
      return locall;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.c.b.l
 * JD-Core Version:    0.6.0
 */