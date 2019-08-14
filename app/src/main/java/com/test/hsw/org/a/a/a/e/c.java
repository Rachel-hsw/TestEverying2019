package org.a.a.a.e;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.a.a.a.v;

public class c
{
  public static final Long a = Long.valueOf(0L);
  public static final Long b = Long.valueOf(1L);
  public static final Long c = Long.valueOf(-1L);
  public static final Integer d = Integer.valueOf(0);
  public static final Integer e = Integer.valueOf(1);
  public static final Integer f = Integer.valueOf(-1);
  public static final Short g = Short.valueOf(0);
  public static final Short h = Short.valueOf(1);
  public static final Short i = Short.valueOf(-1);
  public static final Byte j = Byte.valueOf(0);
  public static final Byte k = Byte.valueOf(1);
  public static final Byte l = Byte.valueOf(-1);
  public static final Double m = Double.valueOf(0.0D);
  public static final Double n = Double.valueOf(1.0D);
  public static final Double o = Double.valueOf(-1.0D);
  public static final Float p = Float.valueOf(0.0F);
  public static final Float q = Float.valueOf(1.0F);
  public static final Float r = Float.valueOf(-1.0F);

  public static byte a(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    if (paramByte2 < paramByte1);
    for (byte b1 = paramByte2; ; b1 = paramByte1)
    {
      if (paramByte3 < b1)
        return paramByte3;
      return b1;
    }
  }

  public static byte a(String paramString, byte paramByte)
  {
    if (paramString == null)
      return paramByte;
    try
    {
      int i1 = Byte.parseByte(paramString);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramByte;
  }

  public static byte a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfByte.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    int i1 = paramArrayOfByte[0];
    for (int i2 = 1; i2 < paramArrayOfByte.length; i2++)
    {
      if (paramArrayOfByte[i2] >= i1)
        continue;
      i1 = paramArrayOfByte[i2];
    }
    return i1;
  }

  public static double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return Math.min(Math.min(paramDouble1, paramDouble2), paramDouble3);
  }

  public static double a(String paramString, double paramDouble)
  {
    if (paramString == null)
      return paramDouble;
    try
    {
      double d1 = Double.parseDouble(paramString);
      return d1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramDouble;
  }

  public static double a(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfDouble.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    double d1 = paramArrayOfDouble[0];
    for (int i1 = 1; ; i1++)
    {
      if (i1 < paramArrayOfDouble.length)
      {
        if (Double.isNaN(paramArrayOfDouble[i1]))
          d1 = (0.0D / 0.0D);
      }
      else
        return d1;
      if (paramArrayOfDouble[i1] >= d1)
        continue;
      d1 = paramArrayOfDouble[i1];
    }
  }

  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.min(paramFloat1, paramFloat2), paramFloat3);
  }

  public static float a(String paramString, float paramFloat)
  {
    if (paramString == null)
      return paramFloat;
    try
    {
      float f1 = Float.parseFloat(paramString);
      return f1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramFloat;
  }

  public static float a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfFloat.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    float f1 = paramArrayOfFloat[0];
    for (int i1 = 1; ; i1++)
    {
      if (i1 < paramArrayOfFloat.length)
      {
        if (Float.isNaN(paramArrayOfFloat[i1]))
          f1 = (0.0F / 0.0F);
      }
      else
        return f1;
      if (paramArrayOfFloat[i1] >= f1)
        continue;
      f1 = paramArrayOfFloat[i1];
    }
  }

  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < paramInt1);
    for (int i1 = paramInt2; ; i1 = paramInt1)
    {
      if (paramInt3 < i1)
        return paramInt3;
      return i1;
    }
  }

  public static int a(String paramString)
  {
    return a(paramString, 0);
  }

  public static int a(String paramString, int paramInt)
  {
    if (paramString == null)
      return paramInt;
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramInt;
  }

  public static int a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfInt.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    int i1 = paramArrayOfInt[0];
    for (int i2 = 1; i2 < paramArrayOfInt.length; i2++)
    {
      if (paramArrayOfInt[i2] >= i1)
        continue;
      i1 = paramArrayOfInt[i2];
    }
    return i1;
  }

  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1;
    if (paramLong2 < paramLong1)
      l1 = paramLong2;
    while (true)
    {
      if (paramLong3 < l1)
        return paramLong3;
      return l1;
      l1 = paramLong1;
    }
  }

  public static long a(String paramString, long paramLong)
  {
    if (paramString == null)
      return paramLong;
    try
    {
      long l1 = Long.parseLong(paramString);
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramLong;
  }

  public static long a(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfLong.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    long l1 = paramArrayOfLong[0];
    for (int i1 = 1; i1 < paramArrayOfLong.length; i1++)
    {
      if (paramArrayOfLong[i1] >= l1)
        continue;
      l1 = paramArrayOfLong[i1];
    }
    return l1;
  }

  public static short a(String paramString, short paramShort)
  {
    if (paramString == null)
      return paramShort;
    try
    {
      int i1 = Short.parseShort(paramString);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramShort;
  }

  public static short a(short paramShort1, short paramShort2, short paramShort3)
  {
    if (paramShort2 < paramShort1);
    for (short s = paramShort2; ; s = paramShort1)
    {
      if (paramShort3 < s)
        return paramShort3;
      return s;
    }
  }

  public static short a(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfShort.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    int i1 = paramArrayOfShort[0];
    for (int i2 = 1; i2 < paramArrayOfShort.length; i2++)
    {
      if (paramArrayOfShort[i2] >= i1)
        continue;
      i1 = paramArrayOfShort[i2];
    }
    return i1;
  }

  public static byte b(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    if (paramByte2 > paramByte1);
    for (byte b1 = paramByte2; ; b1 = paramByte1)
    {
      if (paramByte3 > b1)
        return paramByte3;
      return b1;
    }
  }

  public static byte b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfByte.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    int i1 = paramArrayOfByte[0];
    for (int i2 = 1; i2 < paramArrayOfByte.length; i2++)
    {
      if (paramArrayOfByte[i2] <= i1)
        continue;
      i1 = paramArrayOfByte[i2];
    }
    return i1;
  }

  public static double b(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return Math.max(Math.max(paramDouble1, paramDouble2), paramDouble3);
  }

  public static double b(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfDouble.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    double d1 = paramArrayOfDouble[0];
    for (int i1 = 1; ; i1++)
    {
      if (i1 < paramArrayOfDouble.length)
      {
        if (Double.isNaN(paramArrayOfDouble[i1]))
          d1 = (0.0D / 0.0D);
      }
      else
        return d1;
      if (paramArrayOfDouble[i1] <= d1)
        continue;
      d1 = paramArrayOfDouble[i1];
    }
  }

  public static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }

  public static float b(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfFloat.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    float f1 = paramArrayOfFloat[0];
    for (int i1 = 1; ; i1++)
    {
      if (i1 < paramArrayOfFloat.length)
      {
        if (Float.isNaN(paramArrayOfFloat[i1]))
          f1 = (0.0F / 0.0F);
      }
      else
        return f1;
      if (paramArrayOfFloat[i1] <= f1)
        continue;
      f1 = paramArrayOfFloat[i1];
    }
  }

  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt1);
    for (int i1 = paramInt2; ; i1 = paramInt1)
    {
      if (paramInt3 > i1)
        return paramInt3;
      return i1;
    }
  }

  public static int b(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfInt.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    int i1 = paramArrayOfInt[0];
    for (int i2 = 1; i2 < paramArrayOfInt.length; i2++)
    {
      if (paramArrayOfInt[i2] <= i1)
        continue;
      i1 = paramArrayOfInt[i2];
    }
    return i1;
  }

  public static long b(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1;
    if (paramLong2 > paramLong1)
      l1 = paramLong2;
    while (true)
    {
      if (paramLong3 > l1)
        return paramLong3;
      return l1;
      l1 = paramLong1;
    }
  }

  public static long b(String paramString)
  {
    return a(paramString, 0L);
  }

  public static long b(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfLong.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    long l1 = paramArrayOfLong[0];
    for (int i1 = 1; i1 < paramArrayOfLong.length; i1++)
    {
      if (paramArrayOfLong[i1] <= l1)
        continue;
      l1 = paramArrayOfLong[i1];
    }
    return l1;
  }

  public static short b(short paramShort1, short paramShort2, short paramShort3)
  {
    if (paramShort2 > paramShort1);
    for (short s = paramShort2; ; s = paramShort1)
    {
      if (paramShort3 > s)
        return paramShort3;
      return s;
    }
  }

  public static short b(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfShort.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    int i1 = paramArrayOfShort[0];
    for (int i2 = 1; i2 < paramArrayOfShort.length; i2++)
    {
      if (paramArrayOfShort[i2] <= i1)
        continue;
      i1 = paramArrayOfShort[i2];
    }
    return i1;
  }

  public static float c(String paramString)
  {
    return a(paramString, 0.0F);
  }

  public static double d(String paramString)
  {
    return a(paramString, 0.0D);
  }

  public static byte e(String paramString)
  {
    return a(paramString, 0);
  }

  public static short f(String paramString)
  {
    return a(paramString, 0);
  }

  // ERROR //
  public static java.lang.Number g(String paramString)
    throws NumberFormatException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aload_1
    //   7: areturn
    //   8: aload_0
    //   9: invokestatic 200	org/a/a/a/v:c	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +13 -> 25
    //   15: new 109	java/lang/NumberFormatException
    //   18: dup
    //   19: ldc 202
    //   21: invokespecial 203	java/lang/NumberFormatException:<init>	(Ljava/lang/String;)V
    //   24: athrow
    //   25: aload_0
    //   26: ldc 205
    //   28: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   31: istore_2
    //   32: aconst_null
    //   33: astore_1
    //   34: iload_2
    //   35: ifne -29 -> 6
    //   38: aload_0
    //   39: ldc 213
    //   41: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   44: ifne +30 -> 74
    //   47: aload_0
    //   48: ldc 215
    //   50: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   53: ifne +21 -> 74
    //   56: aload_0
    //   57: ldc 217
    //   59: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   62: ifne +12 -> 74
    //   65: aload_0
    //   66: ldc 219
    //   68: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   71: ifeq +8 -> 79
    //   74: aload_0
    //   75: invokestatic 222	org/a/a/a/e/c:j	(Ljava/lang/String;)Ljava/lang/Integer;
    //   78: areturn
    //   79: aload_0
    //   80: iconst_m1
    //   81: aload_0
    //   82: invokevirtual 226	java/lang/String:length	()I
    //   85: iadd
    //   86: invokevirtual 230	java/lang/String:charAt	(I)C
    //   89: istore_3
    //   90: aload_0
    //   91: bipush 46
    //   93: invokevirtual 234	java/lang/String:indexOf	(I)I
    //   96: istore 4
    //   98: iconst_1
    //   99: aload_0
    //   100: bipush 101
    //   102: invokevirtual 234	java/lang/String:indexOf	(I)I
    //   105: aload_0
    //   106: bipush 69
    //   108: invokevirtual 234	java/lang/String:indexOf	(I)I
    //   111: iadd
    //   112: iadd
    //   113: istore 5
    //   115: iload 4
    //   117: iconst_m1
    //   118: if_icmple +262 -> 380
    //   121: iload 5
    //   123: iconst_m1
    //   124: if_icmple +243 -> 367
    //   127: iload 5
    //   129: iload 4
    //   131: if_icmplt +12 -> 143
    //   134: iload 5
    //   136: aload_0
    //   137: invokevirtual 226	java/lang/String:length	()I
    //   140: if_icmple +30 -> 170
    //   143: new 109	java/lang/NumberFormatException
    //   146: dup
    //   147: new 236	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   154: aload_0
    //   155: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 243
    //   160: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokespecial 203	java/lang/NumberFormatException:<init>	(Ljava/lang/String;)V
    //   169: athrow
    //   170: aload_0
    //   171: iload 4
    //   173: iconst_1
    //   174: iadd
    //   175: iload 5
    //   177: invokevirtual 251	java/lang/String:substring	(II)Ljava/lang/String;
    //   180: astore 8
    //   182: aload_0
    //   183: iconst_0
    //   184: iload 4
    //   186: invokevirtual 251	java/lang/String:substring	(II)Ljava/lang/String;
    //   189: astore 7
    //   191: iload_3
    //   192: invokestatic 257	java/lang/Character:isDigit	(C)Z
    //   195: ifne +417 -> 612
    //   198: iload_3
    //   199: bipush 46
    //   201: if_icmpeq +411 -> 612
    //   204: aconst_null
    //   205: astore 21
    //   207: iload 5
    //   209: iconst_m1
    //   210: if_icmple +37 -> 247
    //   213: iconst_m1
    //   214: aload_0
    //   215: invokevirtual 226	java/lang/String:length	()I
    //   218: iadd
    //   219: istore 32
    //   221: aconst_null
    //   222: astore 21
    //   224: iload 5
    //   226: iload 32
    //   228: if_icmpge +19 -> 247
    //   231: aload_0
    //   232: iload 5
    //   234: iconst_1
    //   235: iadd
    //   236: iconst_m1
    //   237: aload_0
    //   238: invokevirtual 226	java/lang/String:length	()I
    //   241: iadd
    //   242: invokevirtual 251	java/lang/String:substring	(II)Ljava/lang/String;
    //   245: astore 21
    //   247: aload_0
    //   248: iconst_0
    //   249: iconst_m1
    //   250: aload_0
    //   251: invokevirtual 226	java/lang/String:length	()I
    //   254: iadd
    //   255: invokevirtual 251	java/lang/String:substring	(II)Ljava/lang/String;
    //   258: astore 22
    //   260: aload 7
    //   262: invokestatic 259	org/a/a/a/e/c:p	(Ljava/lang/String;)Z
    //   265: ifeq +182 -> 447
    //   268: aload 21
    //   270: invokestatic 259	org/a/a/a/e/c:p	(Ljava/lang/String;)Z
    //   273: ifeq +174 -> 447
    //   276: iconst_1
    //   277: istore 23
    //   279: iload_3
    //   280: lookupswitch	default:+60->340, 68:+290->570, 70:+259->539, 76:+173->453, 100:+290->570, 102:+259->539, 108:+173->453
    //   341: nop
    //   342: ldiv
    //   343: dup
    //   344: new 236	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   351: aload_0
    //   352: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 243
    //   357: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokespecial 203	java/lang/NumberFormatException:<init>	(Ljava/lang/String;)V
    //   366: athrow
    //   367: aload_0
    //   368: iload 4
    //   370: iconst_1
    //   371: iadd
    //   372: invokevirtual 262	java/lang/String:substring	(I)Ljava/lang/String;
    //   375: astore 8
    //   377: goto -195 -> 182
    //   380: iload 5
    //   382: iconst_m1
    //   383: if_icmple +58 -> 441
    //   386: iload 5
    //   388: aload_0
    //   389: invokevirtual 226	java/lang/String:length	()I
    //   392: if_icmple +30 -> 422
    //   395: new 109	java/lang/NumberFormatException
    //   398: dup
    //   399: new 236	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   406: aload_0
    //   407: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: ldc 243
    //   412: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokespecial 203	java/lang/NumberFormatException:<init>	(Ljava/lang/String;)V
    //   421: athrow
    //   422: aload_0
    //   423: iconst_0
    //   424: iload 5
    //   426: invokevirtual 251	java/lang/String:substring	(II)Ljava/lang/String;
    //   429: astore 6
    //   431: aload 6
    //   433: astore 7
    //   435: aconst_null
    //   436: astore 8
    //   438: goto -247 -> 191
    //   441: aload_0
    //   442: astore 6
    //   444: goto -13 -> 431
    //   447: iconst_0
    //   448: istore 23
    //   450: goto -171 -> 279
    //   453: aload 8
    //   455: ifnonnull +57 -> 512
    //   458: aload 21
    //   460: ifnonnull +52 -> 512
    //   463: aload 22
    //   465: iconst_0
    //   466: invokevirtual 230	java/lang/String:charAt	(I)C
    //   469: bipush 45
    //   471: if_icmpne +15 -> 486
    //   474: aload 22
    //   476: iconst_1
    //   477: invokevirtual 262	java/lang/String:substring	(I)Ljava/lang/String;
    //   480: invokestatic 264	org/a/a/a/e/c:n	(Ljava/lang/String;)Z
    //   483: ifne +11 -> 494
    //   486: aload 22
    //   488: invokestatic 264	org/a/a/a/e/c:n	(Ljava/lang/String;)Z
    //   491: ifeq +21 -> 512
    //   494: aload 22
    //   496: invokestatic 267	org/a/a/a/e/c:k	(Ljava/lang/String;)Ljava/lang/Long;
    //   499: astore 31
    //   501: aload 31
    //   503: areturn
    //   504: astore 30
    //   506: aload 22
    //   508: invokestatic 270	org/a/a/a/e/c:l	(Ljava/lang/String;)Ljava/math/BigInteger;
    //   511: areturn
    //   512: new 109	java/lang/NumberFormatException
    //   515: dup
    //   516: new 236	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   523: aload_0
    //   524: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc 243
    //   529: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokespecial 203	java/lang/NumberFormatException:<init>	(Ljava/lang/String;)V
    //   538: athrow
    //   539: aload 22
    //   541: invokestatic 273	org/a/a/a/e/c:h	(Ljava/lang/String;)Ljava/lang/Float;
    //   544: astore_1
    //   545: aload_1
    //   546: invokevirtual 277	java/lang/Float:isInfinite	()Z
    //   549: ifne +21 -> 570
    //   552: aload_1
    //   553: invokevirtual 281	java/lang/Float:floatValue	()F
    //   556: fstore 29
    //   558: fload 29
    //   560: fconst_0
    //   561: fcmpl
    //   562: ifne -556 -> 6
    //   565: iload 23
    //   567: ifne -561 -> 6
    //   570: aload 22
    //   572: invokestatic 284	org/a/a/a/e/c:i	(Ljava/lang/String;)Ljava/lang/Double;
    //   575: astore_1
    //   576: aload_1
    //   577: invokevirtual 285	java/lang/Double:isInfinite	()Z
    //   580: ifne +22 -> 602
    //   583: aload_1
    //   584: invokevirtual 286	java/lang/Double:floatValue	()F
    //   587: fstore 27
    //   589: fload 27
    //   591: f2d
    //   592: dconst_0
    //   593: dcmpl
    //   594: ifne -588 -> 6
    //   597: iload 23
    //   599: ifne -593 -> 6
    //   602: aload 22
    //   604: invokestatic 289	org/a/a/a/e/c:m	(Ljava/lang/String;)Ljava/math/BigDecimal;
    //   607: astore 26
    //   609: aload 26
    //   611: areturn
    //   612: aconst_null
    //   613: astore 9
    //   615: iload 5
    //   617: iconst_m1
    //   618: if_icmple +35 -> 653
    //   621: iconst_m1
    //   622: aload_0
    //   623: invokevirtual 226	java/lang/String:length	()I
    //   626: iadd
    //   627: istore 20
    //   629: aconst_null
    //   630: astore 9
    //   632: iload 5
    //   634: iload 20
    //   636: if_icmpge +17 -> 653
    //   639: aload_0
    //   640: iload 5
    //   642: iconst_1
    //   643: iadd
    //   644: aload_0
    //   645: invokevirtual 226	java/lang/String:length	()I
    //   648: invokevirtual 251	java/lang/String:substring	(II)Ljava/lang/String;
    //   651: astore 9
    //   653: aload 8
    //   655: ifnonnull +35 -> 690
    //   658: aload 9
    //   660: ifnonnull +30 -> 690
    //   663: aload_0
    //   664: invokestatic 222	org/a/a/a/e/c:j	(Ljava/lang/String;)Ljava/lang/Integer;
    //   667: astore 19
    //   669: aload 19
    //   671: areturn
    //   672: astore 16
    //   674: aload_0
    //   675: invokestatic 267	org/a/a/a/e/c:k	(Ljava/lang/String;)Ljava/lang/Long;
    //   678: astore 18
    //   680: aload 18
    //   682: areturn
    //   683: astore 17
    //   685: aload_0
    //   686: invokestatic 270	org/a/a/a/e/c:l	(Ljava/lang/String;)Ljava/math/BigInteger;
    //   689: areturn
    //   690: aload 7
    //   692: invokestatic 259	org/a/a/a/e/c:p	(Ljava/lang/String;)Z
    //   695: ifeq +79 -> 774
    //   698: aload 9
    //   700: invokestatic 259	org/a/a/a/e/c:p	(Ljava/lang/String;)Z
    //   703: ifeq +71 -> 774
    //   706: iconst_1
    //   707: istore 10
    //   709: aload_0
    //   710: invokestatic 273	org/a/a/a/e/c:h	(Ljava/lang/String;)Ljava/lang/Float;
    //   713: astore_1
    //   714: aload_1
    //   715: invokevirtual 277	java/lang/Float:isInfinite	()Z
    //   718: ifne +21 -> 739
    //   721: aload_1
    //   722: invokevirtual 281	java/lang/Float:floatValue	()F
    //   725: fstore 15
    //   727: fload 15
    //   729: fconst_0
    //   730: fcmpl
    //   731: ifne -725 -> 6
    //   734: iload 10
    //   736: ifne -730 -> 6
    //   739: aload_0
    //   740: invokestatic 284	org/a/a/a/e/c:i	(Ljava/lang/String;)Ljava/lang/Double;
    //   743: astore_1
    //   744: aload_1
    //   745: invokevirtual 285	java/lang/Double:isInfinite	()Z
    //   748: ifne +21 -> 769
    //   751: aload_1
    //   752: invokevirtual 293	java/lang/Double:doubleValue	()D
    //   755: dstore 13
    //   757: dload 13
    //   759: dconst_0
    //   760: dcmpl
    //   761: ifne -755 -> 6
    //   764: iload 10
    //   766: ifne -760 -> 6
    //   769: aload_0
    //   770: invokestatic 289	org/a/a/a/e/c:m	(Ljava/lang/String;)Ljava/math/BigDecimal;
    //   773: areturn
    //   774: iconst_0
    //   775: istore 10
    //   777: goto -68 -> 709
    //   780: astore 25
    //   782: goto -442 -> 340
    //   785: astore 12
    //   787: goto -18 -> 769
    //   790: astore 11
    //   792: goto -53 -> 739
    //   795: astore 24
    //   797: goto -195 -> 602
    //   800: astore 28
    //   802: goto -232 -> 570
    //
    // Exception table:
    //   from	to	target	type
    //   494	501	504	java/lang/NumberFormatException
    //   663	669	672	java/lang/NumberFormatException
    //   674	680	683	java/lang/NumberFormatException
    //   602	609	780	java/lang/NumberFormatException
    //   739	757	785	java/lang/NumberFormatException
    //   709	727	790	java/lang/NumberFormatException
    //   570	589	795	java/lang/NumberFormatException
    //   539	558	800	java/lang/NumberFormatException
  }

  public static Float h(String paramString)
  {
    if (paramString == null)
      return null;
    return Float.valueOf(paramString);
  }

  public static Double i(String paramString)
  {
    if (paramString == null)
      return null;
    return Double.valueOf(paramString);
  }

  public static Integer j(String paramString)
  {
    if (paramString == null)
      return null;
    return Integer.decode(paramString);
  }

  public static Long k(String paramString)
  {
    if (paramString == null)
      return null;
    return Long.decode(paramString);
  }

  public static BigInteger l(String paramString)
  {
    if (paramString == null)
      return null;
    return new BigInteger(paramString);
  }

  public static BigDecimal m(String paramString)
  {
    if (paramString == null)
      return null;
    if (v.c(paramString))
      throw new NumberFormatException("A blank string is not a valid number");
    return new BigDecimal(paramString);
  }

  public static boolean n(String paramString)
  {
    if (v.a(paramString))
      return false;
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= paramString.length())
        break label36;
      if (!Character.isDigit(paramString.charAt(i1)))
        break;
    }
    label36: return true;
  }

  public static boolean o(String paramString)
  {
    int i1 = 1;
    if (v.a(paramString));
    label143: label145: int i6;
    int i9;
    while (true)
    {
      return false;
      char[] arrayOfChar = paramString.toCharArray();
      int i2 = arrayOfChar.length;
      if (arrayOfChar[0] == '-');
      for (int i3 = i1; ; i3 = 0)
      {
        if ((i2 <= i3 + 1) || (arrayOfChar[i3] != '0') || (arrayOfChar[(i3 + 1)] != 'x'))
          break label145;
        int i10 = i3 + 2;
        if (i10 == i2)
          break;
        while (true)
        {
          if (i10 >= arrayOfChar.length)
            break label143;
          if (((arrayOfChar[i10] < '0') || (arrayOfChar[i10] > '9')) && ((arrayOfChar[i10] < 'a') || (arrayOfChar[i10] > 'f')) && ((arrayOfChar[i10] < 'A') || (arrayOfChar[i10] > 'F')))
            break;
          i10++;
        }
      }
      return i1;
      int i4 = i2 - 1;
      int i5 = i3;
      i6 = 0;
      int i7 = 0;
      int i8 = 0;
      i9 = 0;
      label166: if ((i5 < i4) || ((i5 < i4 + 1) && (i6 != 0) && (i9 == 0)))
      {
        if ((arrayOfChar[i5] >= '0') && (arrayOfChar[i5] <= '9'))
        {
          i9 = i1;
          i6 = 0;
        }
        while (true)
        {
          i5++;
          break label166;
          if (arrayOfChar[i5] == '.')
          {
            if ((i7 != 0) || (i8 != 0))
              break;
            i7 = i1;
            continue;
          }
          if ((arrayOfChar[i5] == 'e') || (arrayOfChar[i5] == 'E'))
          {
            if ((i8 != 0) || (i9 == 0))
              break;
            i6 = i1;
            i8 = i1;
            continue;
          }
          if (((arrayOfChar[i5] != '+') && (arrayOfChar[i5] != '-')) || (i6 == 0))
            break;
          i9 = 0;
          i6 = 0;
        }
      }
      if (i5 >= arrayOfChar.length)
        break;
      if ((arrayOfChar[i5] >= '0') && (arrayOfChar[i5] <= '9'))
        return i1;
      if ((arrayOfChar[i5] == 'e') || (arrayOfChar[i5] == 'E'))
        continue;
      if (arrayOfChar[i5] == '.')
        if ((i7 == 0) && (i8 == 0))
          return i9;
      if ((i6 == 0) && ((arrayOfChar[i5] == 'd') || (arrayOfChar[i5] == 'D') || (arrayOfChar[i5] == 'f') || (arrayOfChar[i5] == 'F')))
        return i9;
      if ((arrayOfChar[i5] != 'l') && (arrayOfChar[i5] != 'L'))
        continue;
      if ((i9 != 0) && (i8 == 0) && (i7 == 0));
      while (true)
      {
        return i1;
        i1 = 0;
      }
    }
    if ((i6 == 0) && (i9 != 0));
    while (true)
    {
      return i1;
      i1 = 0;
    }
  }

  private static boolean p(String paramString)
  {
    if (paramString == null);
    do
    {
      return true;
      for (int i1 = -1 + paramString.length(); i1 >= 0; i1--)
        if (paramString.charAt(i1) != '0')
          return false;
    }
    while (paramString.length() > 0);
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.e.c
 * JD-Core Version:    0.6.0
 */