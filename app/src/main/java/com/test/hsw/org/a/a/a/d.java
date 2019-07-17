package org.a.a.a;

public class d
{
  private final int a;
  private final int b;

  public d(int paramInt)
  {
    this.a = paramInt;
    int i = 0;
    if (paramInt != 0)
      while ((paramInt & 0x1) == 0)
      {
        i++;
        paramInt >>= 1;
      }
    this.b = i;
  }

  public byte a(byte paramByte)
  {
    return (byte)e(paramByte);
  }

  public byte a(byte paramByte, boolean paramBoolean)
  {
    if (paramBoolean)
      return b(paramByte);
    return a(paramByte);
  }

  public int a(int paramInt)
  {
    return b(paramInt) >> this.b;
  }

  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 & (0xFFFFFFFF ^ this.a) | paramInt2 << this.b & this.a;
  }

  public int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      return f(paramInt);
    return e(paramInt);
  }

  public short a(short paramShort)
  {
    return (short)a(paramShort);
  }

  public short a(short paramShort1, short paramShort2)
  {
    return (short)a(paramShort1, paramShort2);
  }

  public short a(short paramShort, boolean paramBoolean)
  {
    if (paramBoolean)
      return d(paramShort);
    return c(paramShort);
  }

  public byte b(byte paramByte)
  {
    return (byte)f(paramByte);
  }

  public int b(int paramInt)
  {
    return paramInt & this.a;
  }

  public short b(short paramShort)
  {
    return (short)b(paramShort);
  }

  public short c(short paramShort)
  {
    return (short)e(paramShort);
  }

  public boolean c(int paramInt)
  {
    return (paramInt & this.a) != 0;
  }

  public short d(short paramShort)
  {
    return (short)f(paramShort);
  }

  public boolean d(int paramInt)
  {
    return (paramInt & this.a) == this.a;
  }

  public int e(int paramInt)
  {
    return paramInt & (0xFFFFFFFF ^ this.a);
  }

  public int f(int paramInt)
  {
    return paramInt | this.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.d
 * JD-Core Version:    0.6.0
 */