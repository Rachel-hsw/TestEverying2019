package com.umeng.message.b;

import java.io.InputStream;

class g extends InputStream
{
  g(e parame)
  {
  }

  public int available()
  {
    return (int)Math.min(this.a.b, 2147483647L);
  }

  public void close()
  {
  }

  public int read()
  {
    if (this.a.b > 0L)
      return 0xFF & this.a.h();
    return -1;
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }

  public String toString()
  {
    return this.a + ".inputStream()";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.g
 * JD-Core Version:    0.6.0
 */