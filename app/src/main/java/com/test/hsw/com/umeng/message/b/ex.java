package com.umeng.message.b;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.CharBuffer;

class ex extends ep.b<ep>
{
  ex(ep paramep, Closeable paramCloseable, boolean paramBoolean, BufferedReader paramBufferedReader, Appendable paramAppendable)
  {
    super(paramCloseable, paramBoolean);
  }

  public ep a()
    throws IOException
  {
    CharBuffer localCharBuffer = CharBuffer.allocate(ep.a(this.a));
    while (true)
    {
      int i = this.b.read(localCharBuffer);
      if (i == -1)
        return this.a;
      localCharBuffer.rewind();
      this.c.append(localCharBuffer, 0, i);
      localCharBuffer.rewind();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ex
 * JD-Core Version:    0.6.0
 */