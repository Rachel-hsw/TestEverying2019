package org.a.a.a.a;

import org.a.a.a.p;

public class h
  implements a<String>
{
  private static volatile i a = i.a;
  private final StringBuffer b;
  private final Object c;
  private final i d;

  public h(Object paramObject)
  {
    this(paramObject, null, null);
  }

  public h(Object paramObject, i parami)
  {
    this(paramObject, parami, null);
  }

  public h(Object paramObject, i parami, StringBuffer paramStringBuffer)
  {
    if (parami == null)
      parami = f();
    if (paramStringBuffer == null)
      paramStringBuffer = new StringBuffer(512);
    this.b = paramStringBuffer;
    this.d = parami;
    this.c = paramObject;
    parami.a(paramStringBuffer, paramObject);
  }

  public static <T> String a(T paramT, i parami, boolean paramBoolean, Class<? super T> paramClass)
  {
    return f.a(paramT, parami, paramBoolean, false, paramClass);
  }

  public static void a(i parami)
  {
    if (parami == null)
      throw new IllegalArgumentException("The style must not be null");
    a = parami;
  }

  public static String b(Object paramObject, i parami)
  {
    return f.a(paramObject, parami);
  }

  public static String b(Object paramObject, i parami, boolean paramBoolean)
  {
    return f.a(paramObject, parami, paramBoolean, false, null);
  }

  public static String c(Object paramObject)
  {
    return f.a(paramObject);
  }

  public static i f()
  {
    return a;
  }

  public h a(byte paramByte)
  {
    this.d.a(this.b, null, paramByte);
    return this;
  }

  public h a(char paramChar)
  {
    this.d.a(this.b, null, paramChar);
    return this;
  }

  public h a(double paramDouble)
  {
    this.d.a(this.b, null, paramDouble);
    return this;
  }

  public h a(float paramFloat)
  {
    this.d.a(this.b, null, paramFloat);
    return this;
  }

  public h a(int paramInt)
  {
    this.d.a(this.b, null, paramInt);
    return this;
  }

  public h a(long paramLong)
  {
    this.d.a(this.b, null, paramLong);
    return this;
  }

  public h a(String paramString)
  {
    if (paramString != null)
      this.d.a(this.b, paramString);
    return this;
  }

  public h a(String paramString, byte paramByte)
  {
    this.d.a(this.b, paramString, paramByte);
    return this;
  }

  public h a(String paramString, char paramChar)
  {
    this.d.a(this.b, paramString, paramChar);
    return this;
  }

  public h a(String paramString, double paramDouble)
  {
    this.d.a(this.b, paramString, paramDouble);
    return this;
  }

  public h a(String paramString, float paramFloat)
  {
    this.d.a(this.b, paramString, paramFloat);
    return this;
  }

  public h a(String paramString, int paramInt)
  {
    this.d.a(this.b, paramString, paramInt);
    return this;
  }

  public h a(String paramString, long paramLong)
  {
    this.d.a(this.b, paramString, paramLong);
    return this;
  }

  public h a(String paramString, Object paramObject)
  {
    this.d.a(this.b, paramString, paramObject, null);
    return this;
  }

  public h a(String paramString, Object paramObject, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramObject, Boolean.valueOf(paramBoolean));
    return this;
  }

  public h a(String paramString, short paramShort)
  {
    this.d.a(this.b, paramString, paramShort);
    return this;
  }

  public h a(String paramString, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramBoolean);
    return this;
  }

  public h a(String paramString, byte[] paramArrayOfByte)
  {
    this.d.a(this.b, paramString, paramArrayOfByte, null);
    return this;
  }

  public h a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramArrayOfByte, Boolean.valueOf(paramBoolean));
    return this;
  }

  public h a(String paramString, char[] paramArrayOfChar)
  {
    this.d.a(this.b, paramString, paramArrayOfChar, null);
    return this;
  }

  public h a(String paramString, char[] paramArrayOfChar, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramArrayOfChar, Boolean.valueOf(paramBoolean));
    return this;
  }

  public h a(String paramString, double[] paramArrayOfDouble)
  {
    this.d.a(this.b, paramString, paramArrayOfDouble, null);
    return this;
  }

  public h a(String paramString, double[] paramArrayOfDouble, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramArrayOfDouble, Boolean.valueOf(paramBoolean));
    return this;
  }

  public h a(String paramString, float[] paramArrayOfFloat)
  {
    this.d.a(this.b, paramString, paramArrayOfFloat, null);
    return this;
  }

  public h a(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramArrayOfFloat, Boolean.valueOf(paramBoolean));
    return this;
  }

  public h a(String paramString, int[] paramArrayOfInt)
  {
    this.d.a(this.b, paramString, paramArrayOfInt, null);
    return this;
  }

  public h a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramArrayOfInt, Boolean.valueOf(paramBoolean));
    return this;
  }

  public h a(String paramString, long[] paramArrayOfLong)
  {
    this.d.a(this.b, paramString, paramArrayOfLong, null);
    return this;
  }

  public h a(String paramString, long[] paramArrayOfLong, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramArrayOfLong, Boolean.valueOf(paramBoolean));
    return this;
  }

  public h a(String paramString, Object[] paramArrayOfObject)
  {
    this.d.a(this.b, paramString, paramArrayOfObject, null);
    return this;
  }

  public h a(String paramString, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramArrayOfObject, Boolean.valueOf(paramBoolean));
    return this;
  }

  public h a(String paramString, short[] paramArrayOfShort)
  {
    this.d.a(this.b, paramString, paramArrayOfShort, null);
    return this;
  }

  public h a(String paramString, short[] paramArrayOfShort, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramArrayOfShort, Boolean.valueOf(paramBoolean));
    return this;
  }

  public h a(String paramString, boolean[] paramArrayOfBoolean)
  {
    this.d.a(this.b, paramString, paramArrayOfBoolean, null);
    return this;
  }

  public h a(String paramString, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    this.d.a(this.b, paramString, paramArrayOfBoolean, Boolean.valueOf(paramBoolean));
    return this;
  }

  public h a(short paramShort)
  {
    this.d.a(this.b, null, paramShort);
    return this;
  }

  public h a(byte[] paramArrayOfByte)
  {
    this.d.a(this.b, null, paramArrayOfByte, null);
    return this;
  }

  public h a(char[] paramArrayOfChar)
  {
    this.d.a(this.b, null, paramArrayOfChar, null);
    return this;
  }

  public h a(double[] paramArrayOfDouble)
  {
    this.d.a(this.b, null, paramArrayOfDouble, null);
    return this;
  }

  public h a(float[] paramArrayOfFloat)
  {
    this.d.a(this.b, null, paramArrayOfFloat, null);
    return this;
  }

  public h a(int[] paramArrayOfInt)
  {
    this.d.a(this.b, null, paramArrayOfInt, null);
    return this;
  }

  public h a(long[] paramArrayOfLong)
  {
    this.d.a(this.b, null, paramArrayOfLong, null);
    return this;
  }

  public h a(short[] paramArrayOfShort)
  {
    this.d.a(this.b, null, paramArrayOfShort, null);
    return this;
  }

  public h a(boolean[] paramArrayOfBoolean)
  {
    this.d.a(this.b, null, paramArrayOfBoolean, null);
    return this;
  }

  public h b(String paramString)
  {
    if (paramString != null)
      this.d.b(this.b, paramString);
    return this;
  }

  public h b(Object[] paramArrayOfObject)
  {
    this.d.a(this.b, null, paramArrayOfObject, null);
    return this;
  }

  public h c(boolean paramBoolean)
  {
    this.d.a(this.b, null, paramBoolean);
    return this;
  }

  public h d(Object paramObject)
  {
    this.d.a(this.b, null, paramObject, null);
    return this;
  }

  public h e(Object paramObject)
  {
    p.a(h(), paramObject);
    return this;
  }

  public Object g()
  {
    return this.c;
  }

  public StringBuffer h()
  {
    return this.b;
  }

  public i i()
  {
    return this.d;
  }

  public String j()
  {
    return toString();
  }

  public String toString()
  {
    if (g() == null)
      h().append(i().p());
    while (true)
    {
      return h().toString();
      this.d.b(h(), g());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.a.h
 * JD-Core Version:    0.6.0
 */