package com.alipay.sdk.encrypt;

public final class a
{
  private static final int a = 128;
  private static final int b = 64;
  private static final int c = 24;
  private static final int d = 8;
  private static final int e = 16;
  private static final int f = 4;
  private static final int g = -128;
  private static final char h = '=';
  private static final byte[] i;
  private static final char[] j;

  static
  {
    int k = 0;
    i = new byte[''];
    j = new char[64];
    for (int m = 0; m < 128; m++)
      i[m] = -1;
    for (int n = 90; n >= 65; n--)
      i[n] = (byte)(n - 65);
    for (int i1 = 122; i1 >= 97; i1--)
      i[i1] = (byte)(26 + (i1 - 97));
    for (int i2 = 57; i2 >= 48; i2--)
      i[i2] = (byte)(52 + (i2 - 48));
    i[43] = 62;
    i[47] = 63;
    for (int i3 = 0; i3 <= 25; i3++)
      j[i3] = (char)(i3 + 65);
    int i4 = 26;
    for (int i5 = 0; i4 <= 51; i5++)
    {
      j[i4] = (char)(i5 + 97);
      i4++;
    }
    int i6 = 52;
    while (i6 <= 61)
    {
      j[i6] = (char)(k + 48);
      i6++;
      k++;
    }
    j[62] = '+';
    j[63] = '/';
  }

  private static int a(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null)
    {
      n = 0;
      return n;
    }
    int k = paramArrayOfChar.length;
    int m = 0;
    int n = 0;
    label15: int i2;
    label56: int i3;
    if (m < k)
    {
      int i1 = paramArrayOfChar[m];
      if ((i1 != 32) && (i1 != 13) && (i1 != 10) && (i1 != 9))
        break label81;
      i2 = 1;
      if (i2 != 0)
        break label87;
      i3 = n + 1;
      paramArrayOfChar[n] = paramArrayOfChar[m];
    }
    while (true)
    {
      m++;
      n = i3;
      break label15;
      break;
      label81: i2 = 0;
      break label56;
      label87: i3 = n;
    }
  }

  public static String a(byte[] paramArrayOfByte)
  {
    int k = 0;
    if (paramArrayOfByte == null)
      return null;
    int m = 8 * paramArrayOfByte.length;
    if (m == 0)
      return "";
    int n = m % 24;
    int i1 = m / 24;
    int i2;
    char[] arrayOfChar;
    int i3;
    int i4;
    label56: int i21;
    int i23;
    int i24;
    int i25;
    int i26;
    int i27;
    int i28;
    label127: int i29;
    if (n != 0)
    {
      i2 = i1 + 1;
      arrayOfChar = new char[i2 * 4];
      i3 = 0;
      i4 = 0;
      if (i3 >= i1)
        break label302;
      int i20 = k + 1;
      i21 = paramArrayOfByte[k];
      int i22 = i20 + 1;
      i23 = paramArrayOfByte[i20];
      i24 = i22 + 1;
      i25 = paramArrayOfByte[i22];
      i26 = (byte)(i23 & 0xF);
      i27 = (byte)(i21 & 0x3);
      if ((i21 & 0xFFFFFF80) != 0)
        break label259;
      i28 = (byte)(i21 >> 2);
      if ((i23 & 0xFFFFFF80) != 0)
        break label273;
      i29 = (byte)(i23 >> 4);
      label142: if ((i25 & 0xFFFFFF80) != 0)
        break label287;
    }
    label259: label273: label287: for (int i30 = (byte)(i25 >> 6); ; i30 = (byte)(0xFC ^ i25 >> 6))
    {
      int i31 = i4 + 1;
      arrayOfChar[i4] = j[i28];
      int i32 = i31 + 1;
      arrayOfChar[i31] = j[(i29 | i27 << 4)];
      int i33 = i32 + 1;
      arrayOfChar[i32] = j[(i30 | i26 << 2)];
      int i34 = i33 + 1;
      arrayOfChar[i33] = j[(i25 & 0x3F)];
      i3++;
      i4 = i34;
      k = i24;
      break label56;
      i2 = i1;
      break;
      i28 = (byte)(0xC0 ^ i21 >> 2);
      break label127;
      i29 = (byte)(0xF0 ^ i23 >> 4);
      break label142;
    }
    label302: int i14;
    int i16;
    if (n == 8)
    {
      i14 = paramArrayOfByte[k];
      int i15 = (byte)(i14 & 0x3);
      if ((i14 & 0xFFFFFF80) == 0)
      {
        i16 = (byte)(i14 >> 2);
        int i17 = i4 + 1;
        arrayOfChar[i4] = j[i16];
        int i18 = i17 + 1;
        arrayOfChar[i17] = j[(i15 << 4)];
        int i19 = i18 + 1;
        arrayOfChar[i18] = '=';
        arrayOfChar[i19] = '=';
      }
    }
    do
    {
      return new String(arrayOfChar);
      i16 = (byte)(0xC0 ^ i14 >> 2);
      break;
    }
    while (n != 16);
    int i5 = paramArrayOfByte[k];
    int i6 = paramArrayOfByte[(k + 1)];
    int i7 = (byte)(i6 & 0xF);
    int i8 = (byte)(i5 & 0x3);
    int i9;
    if ((i5 & 0xFFFFFF80) == 0)
    {
      i9 = (byte)(i5 >> 2);
      label463: if ((i6 & 0xFFFFFF80) != 0)
        break label560;
    }
    label560: for (int i10 = (byte)(i6 >> 4); ; i10 = (byte)(0xF0 ^ i6 >> 4))
    {
      int i11 = i4 + 1;
      arrayOfChar[i4] = j[i9];
      int i12 = i11 + 1;
      arrayOfChar[i11] = j[(i10 | i8 << 4)];
      int i13 = i12 + 1;
      arrayOfChar[i12] = j[(i7 << 2)];
      arrayOfChar[i13] = '=';
      break;
      i9 = (byte)(0xC0 ^ i5 >> 2);
      break label463;
    }
  }

  private static boolean a(char paramChar)
  {
    return (paramChar == ' ') || (paramChar == '\r') || (paramChar == '\n') || (paramChar == '\t');
  }

  public static byte[] a(String paramString)
  {
    if (paramString == null)
      return null;
    char[] arrayOfChar = paramString.toCharArray();
    int n;
    int m;
    label35: int i2;
    label76: int i3;
    if (arrayOfChar == null)
    {
      n = 0;
      if (n % 4 != 0)
        return null;
    }
    else
    {
      int k = arrayOfChar.length;
      m = 0;
      n = 0;
      if (m < k)
      {
        int i1 = arrayOfChar[m];
        if ((i1 != 32) && (i1 != 13) && (i1 != 10) && (i1 != 9))
          break label104;
        i2 = 1;
        if (i2 != 0)
          break label682;
        i3 = n + 1;
        arrayOfChar[n] = arrayOfChar[m];
      }
    }
    while (true)
    {
      m++;
      n = i3;
      break label35;
      break;
      label104: i2 = 0;
      break label76;
      int i4 = n / 4;
      if (i4 == 0)
        return new byte[0];
      byte[] arrayOfByte1 = new byte[i4 * 3];
      int i5 = 0;
      int i6 = 0;
      for (int i7 = 0; i7 < i4 - 1; i7++)
      {
        int i19 = i5 + 1;
        char c5 = arrayOfChar[i5];
        char c6;
        char c7;
        char c8;
        if (c(c5))
        {
          int i20 = i19 + 1;
          c6 = arrayOfChar[i19];
          if (c(c6))
          {
            int i21 = i20 + 1;
            c7 = arrayOfChar[i20];
            if (c(c7))
            {
              i5 = i21 + 1;
              c8 = arrayOfChar[i21];
              if (c(c8))
                break label233;
            }
          }
        }
        return null;
        label233: int i22 = i[c5];
        int i23 = i[c6];
        int i24 = i[c7];
        int i25 = i[c8];
        int i26 = i6 + 1;
        arrayOfByte1[i6] = (byte)(i22 << 2 | i23 >> 4);
        int i27 = i26 + 1;
        arrayOfByte1[i26] = (byte)((i23 & 0xF) << 4 | 0xF & i24 >> 2);
        i6 = i27 + 1;
        arrayOfByte1[i27] = (byte)(i25 | i24 << 6);
      }
      int i8 = i5 + 1;
      char c1 = arrayOfChar[i5];
      int i9;
      char c2;
      if (c(c1))
      {
        i9 = i8 + 1;
        c2 = arrayOfChar[i8];
        if (c(c2));
      }
      else
      {
        return null;
      }
      int i10 = i[c1];
      int i11 = i[c2];
      int i12 = i9 + 1;
      char c3 = arrayOfChar[i9];
      char c4 = arrayOfChar[i12];
      if ((!c(c3)) || (!c(c4)))
      {
        if ((b(c3)) && (b(c4)))
        {
          if ((i11 & 0xF) != 0)
            return null;
          byte[] arrayOfByte3 = new byte[1 + i7 * 3];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, i7 * 3);
          arrayOfByte3[i6] = (byte)(i10 << 2 | i11 >> 4);
          return arrayOfByte3;
        }
        if ((!b(c3)) && (b(c4)))
        {
          int i13 = i[c3];
          if ((i13 & 0x3) != 0)
            return null;
          byte[] arrayOfByte2 = new byte[2 + i7 * 3];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i7 * 3);
          int i14 = i6 + 1;
          arrayOfByte2[i6] = (byte)(i10 << 2 | i11 >> 4);
          arrayOfByte2[i14] = (byte)((i11 & 0xF) << 4 | 0xF & i13 >> 2);
          return arrayOfByte2;
        }
        return null;
      }
      int i15 = i[c3];
      int i16 = i[c4];
      int i17 = i6 + 1;
      arrayOfByte1[i6] = (byte)(i10 << 2 | i11 >> 4);
      int i18 = i17 + 1;
      arrayOfByte1[i17] = (byte)((i11 & 0xF) << 4 | 0xF & i15 >> 2);
      arrayOfByte1[i18] = (byte)(i16 | i15 << 6);
      return arrayOfByte1;
      label682: i3 = n;
    }
  }

  private static boolean b(char paramChar)
  {
    return paramChar == '=';
  }

  private static boolean c(char paramChar)
  {
    return (paramChar < '') && (i[paramChar] != -1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.encrypt.a
 * JD-Core Version:    0.6.0
 */