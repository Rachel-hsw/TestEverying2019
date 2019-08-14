package com.umeng.message.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

class er extends ep.b<ep>
{
  er(ep paramep, Closeable paramCloseable, boolean paramBoolean, Reader paramReader, Writer paramWriter)
  {
    super(paramCloseable, paramBoolean);
  }

  public ep a()
    throws IOException
  {
    char[] arrayOfChar = new char[ep.a(this.a)];
    while (true)
    {
      int i = this.b.read(arrayOfChar);
      if (i == -1)
        return this.a;
      this.c.write(arrayOfChar, 0, i);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.er
 * JD-Core Version:    0.6.0
 */