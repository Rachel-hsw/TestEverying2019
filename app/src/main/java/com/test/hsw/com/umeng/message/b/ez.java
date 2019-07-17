package com.umeng.message.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class ez extends ep.b<ep>
{
  ez(ep paramep, Closeable paramCloseable, boolean paramBoolean, InputStream paramInputStream, OutputStream paramOutputStream)
  {
    super(paramCloseable, paramBoolean);
  }

  public ep a()
    throws IOException
  {
    byte[] arrayOfByte = new byte[ep.a(this.a)];
    while (true)
    {
      int i = this.b.read(arrayOfByte);
      if (i == -1)
        return this.a;
      this.c.write(arrayOfByte, 0, i);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ez
 * JD-Core Version:    0.6.0
 */