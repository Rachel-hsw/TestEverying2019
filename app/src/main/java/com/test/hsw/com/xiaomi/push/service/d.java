package com.xiaomi.push.service;

import com.xiaomi.a.a.g.a;
import java.io.PrintStream;

public class d
{
  private static int a = 8;
  private byte[] b = new byte[256];
  private int c = 0;
  private int d = 0;
  private int e = -666;

  public static int a(byte paramByte)
  {
    if (paramByte >= 0)
      return paramByte;
    return paramByte + 256;
  }

  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    return String.valueOf(a.a(a(paramArrayOfByte, paramString.getBytes())));
  }

  private void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    for (int k = 0; k < 256; k++)
      this.b[k] = (byte)k;
    this.d = 0;
    for (this.c = 0; this.c < paramInt; this.c = (1 + this.c))
    {
      this.d = ((this.d + a(this.b[this.c]) + a(paramArrayOfByte[(this.c % j)])) % 256);
      a(this.b, this.c, this.d);
    }
    if (paramInt != 256)
      this.e = ((this.d + a(this.b[paramInt]) + a(paramArrayOfByte[(paramInt % j)])) % 256);
    if (paramBoolean)
    {
      System.out.print("S_" + (paramInt - 1) + ":");
      while (i <= paramInt)
      {
        System.out.print(" " + a(this.b[i]));
        i++;
      }
      System.out.print("   j_" + (paramInt - 1) + "=" + this.d);
      System.out.print("   j_" + paramInt + "=" + this.e);
      System.out.print("   S_" + (paramInt - 1) + "[j_" + (paramInt - 1) + "]=" + a(this.b[this.d]));
      System.out.print("   S_" + (paramInt - 1) + "[j_" + paramInt + "]=" + a(this.b[this.e]));
      if (this.b[1] != 0)
        System.out.print("   S[1]!=0");
      System.out.println();
    }
  }

  private void a(byte[] paramArrayOfByte)
  {
    a(256, paramArrayOfByte, false);
  }

  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[paramInt1];
    paramArrayOfByte[paramInt1] = paramArrayOfByte[paramInt2];
    paramArrayOfByte[paramInt2] = i;
  }

  public static byte[] a(String paramString1, String paramString2)
  {
    int i = 0;
    byte[] arrayOfByte1 = a.a(paramString1);
    byte[] arrayOfByte2 = paramString2.getBytes();
    byte[] arrayOfByte3 = new byte[1 + arrayOfByte1.length + arrayOfByte2.length];
    for (int j = 0; j < arrayOfByte1.length; j++)
      arrayOfByte3[j] = arrayOfByte1[j];
    arrayOfByte3[arrayOfByte1.length] = 95;
    while (i < arrayOfByte2.length)
    {
      arrayOfByte3[(i + (1 + arrayOfByte1.length))] = arrayOfByte2[i];
      i++;
    }
    return arrayOfByte3;
  }

  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte2.length];
    d locald = new d();
    locald.a(paramArrayOfByte1);
    locald.b();
    for (int i = 0; i < paramArrayOfByte2.length; i++)
      arrayOfByte[i] = (byte)(paramArrayOfByte2[i] ^ locald.a());
    return arrayOfByte;
  }

  private void b()
  {
    this.d = 0;
    this.c = 0;
  }

  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, a.a(paramString));
  }

  byte a()
  {
    this.c = ((1 + this.c) % 256);
    this.d = ((this.d + a(this.b[this.c])) % 256);
    a(this.b, this.c, this.d);
    return this.b[((a(this.b[this.c]) + a(this.b[this.d])) % 256)];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.d
 * JD-Core Version:    0.6.0
 */