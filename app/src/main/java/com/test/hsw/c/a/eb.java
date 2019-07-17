package c.a;

public abstract class eb
{
  public abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws ec;

  public void a(int paramInt)
  {
  }

  public abstract boolean a();

  public abstract void b()
    throws ec;

  public void b(byte[] paramArrayOfByte)
    throws ec
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws ec;

  public abstract void c();

  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws ec
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j <= 0)
        throw new ec("Cannot read. Remote side has closed. Tried to read " + paramInt2 + " bytes, but only got " + i + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
      i += j;
    }
    return i;
  }

  public void d()
    throws ec
  {
  }

  public byte[] f()
  {
    return null;
  }

  public int g()
  {
    return 0;
  }

  public int h()
  {
    return -1;
  }

  public boolean i()
  {
    return a();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.eb
 * JD-Core Version:    0.6.0
 */