package com.squareup.a;

import com.squareup.a.a.b.a;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class e extends FilterOutputStream
{
  e(c.a parama, OutputStream paramOutputStream, c paramc, b.a parama1)
  {
    super(paramOutputStream);
  }

  public void close()
    throws IOException
  {
    synchronized (this.c.a)
    {
      if (c.a.a(this.c))
        return;
      c.a.a(this.c, true);
      c.b(this.c.a);
      super.close();
      this.b.a();
      return;
    }
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.e
 * JD-Core Version:    0.6.0
 */