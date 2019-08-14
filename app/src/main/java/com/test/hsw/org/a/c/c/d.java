package org.a.c.c;

public abstract class d
{
  public abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  public void a(int paramInt)
  {
  }

  public byte[] a()
  {
    return null;
  }

  public int b()
  {
    return 0;
  }

  public void b(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  public int c()
  {
    return -1;
  }

  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j <= 0)
        throw new e("Cannot read. Remote side has closed. Tried to read " + paramInt2 + " bytes, but only got " + i + " bytes.");
      i += j;
    }
    return i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.c.c.d
 * JD-Core Version:    0.6.0
 */