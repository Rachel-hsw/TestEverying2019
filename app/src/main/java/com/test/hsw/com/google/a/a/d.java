package com.google.a.a;

import java.io.IOException;

public abstract class d
{
  public abstract int a();

  public abstract d a(a parama);

  public d a(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public abstract void a(b paramb);

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      b localb = b.a(paramArrayOfByte, paramInt1, paramInt2);
      a(localb);
      localb.c();
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
  }

  protected boolean a(a parama, int paramInt)
  {
    return parama.b(paramInt);
  }

  public d b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a locala = a.a(paramArrayOfByte, paramInt1, paramInt2);
      a(locala);
      locala.a(0);
      return this;
    }
    catch (c localc)
    {
      throw localc;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
  }

  public byte[] b()
  {
    byte[] arrayOfByte = new byte[a()];
    a(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.a.a.d
 * JD-Core Version:    0.6.0
 */