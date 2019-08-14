package org.a.c.c;

public class b extends d
{
  private org.a.c.d a;
  private int b;

  public b(int paramInt)
  {
    this.a = new org.a.c.d(paramInt);
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this.a.a();
    if (paramInt2 > this.a.b() - this.b)
      paramInt2 = this.a.b() - this.b;
    if (paramInt2 > 0)
    {
      System.arraycopy(arrayOfByte, this.b, paramArrayOfByte, paramInt1, paramInt2);
      this.b = (paramInt2 + this.b);
    }
    return paramInt2;
  }

  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }

  public int g_()
  {
    return this.a.size();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.c.c.b
 * JD-Core Version:    0.6.0
 */