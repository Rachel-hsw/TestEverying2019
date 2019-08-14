package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class u extends ByteArrayOutputStream
{
  private static final int a = 256;
  private final d b;

  public u(d paramd)
  {
    this(paramd, 256);
  }

  public u(d paramd, int paramInt)
  {
    this.b = paramd;
    this.buf = this.b.a(Math.max(paramInt, 256));
  }

  private void a(int paramInt)
  {
    if (paramInt + this.count <= this.buf.length)
      return;
    byte[] arrayOfByte = this.b.a(2 * (paramInt + this.count));
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.b.a(this.buf);
    this.buf = arrayOfByte;
  }

  public void close()
    throws IOException
  {
    this.b.a(this.buf);
    this.buf = null;
    super.close();
  }

  public void finalize()
  {
    this.b.a(this.buf);
  }

  public void write(int paramInt)
  {
    monitorenter;
    try
    {
      a(1);
      super.write(paramInt);
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

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    monitorenter;
    try
    {
      a(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
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

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.u
 * JD-Core Version:    0.6.0
 */