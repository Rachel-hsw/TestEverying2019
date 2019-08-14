package org.a.a.a.a;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.a.a.a.l;
import org.a.a.a.p;
import org.a.a.a.w;

public abstract class i
  implements Serializable
{
  public static final i a = new a();
  public static final i b = new b();
  public static final i c = new c();
  public static final i d = new d();
  public static final i e = new e();
  private static final long f = -2587890625525655916L;
  private static final ThreadLocal<WeakHashMap<Object, Object>> g = new ThreadLocal();
  private String A = ">";
  private boolean h = true;
  private boolean i = true;
  private boolean j = false;
  private boolean k = true;
  private String l = "[";
  private String m = "]";
  private String n = "=";
  private boolean o = false;
  private boolean p = false;
  private String q = ",";
  private String r = "{";
  private String s = ",";
  private boolean t = true;
  private String u = "}";
  private boolean v = true;
  private String w = "<null>";
  private String x = "<size=";
  private String y = ">";
  private String z = "<";

  static boolean a(Object paramObject)
  {
    Map localMap = u();
    return (localMap != null) && (localMap.containsKey(paramObject));
  }

  static void b(Object paramObject)
  {
    if (paramObject != null)
    {
      if (u() == null)
        g.set(new WeakHashMap());
      u().put(paramObject, null);
    }
  }

  static void c(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = u();
      if (localMap != null)
      {
        localMap.remove(paramObject);
        if (localMap.isEmpty())
          g.remove();
      }
    }
  }

  static Map<Object, Object> u()
  {
    return (Map)g.get();
  }

  protected String a(Class<?> paramClass)
  {
    return l.a(paramClass);
  }

  protected void a(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.r = paramString;
  }

  protected void a(StringBuffer paramStringBuffer)
  {
    int i1 = paramStringBuffer.length();
    int i2 = this.q.length();
    int i3;
    int i4;
    if ((i1 > 0) && (i2 > 0) && (i1 >= i2))
    {
      i3 = 0;
      if (i3 >= i2)
        break label91;
      int i5 = paramStringBuffer.charAt(i1 - 1 - i3);
      int i6 = this.q.charAt(i2 - 1 - i3);
      i4 = 0;
      if (i5 == i6)
        break label85;
    }
    while (true)
    {
      if (i4 != 0)
        paramStringBuffer.setLength(i1 - i2);
      return;
      label85: i3++;
      break;
      label91: i4 = 1;
    }
  }

  public void a(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (paramObject != null)
    {
      c(paramStringBuffer, paramObject);
      d(paramStringBuffer, paramObject);
      b(paramStringBuffer);
      if (this.o)
        d(paramStringBuffer);
    }
  }

  public void a(StringBuffer paramStringBuffer, String paramString)
  {
    b(paramStringBuffer, paramString);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, byte paramByte)
  {
    d(paramStringBuffer, paramString);
    b(paramStringBuffer, paramString, paramByte);
    e(paramStringBuffer, paramString);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, char paramChar)
  {
    d(paramStringBuffer, paramString);
    b(paramStringBuffer, paramString, paramChar);
    e(paramStringBuffer, paramString);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, double paramDouble)
  {
    d(paramStringBuffer, paramString);
    b(paramStringBuffer, paramString, paramDouble);
    e(paramStringBuffer, paramString);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, float paramFloat)
  {
    d(paramStringBuffer, paramString);
    b(paramStringBuffer, paramString, paramFloat);
    e(paramStringBuffer, paramString);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, int paramInt)
  {
    d(paramStringBuffer, paramString);
    b(paramStringBuffer, paramString, paramInt);
    e(paramStringBuffer, paramString);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, long paramLong)
  {
    d(paramStringBuffer, paramString);
    b(paramStringBuffer, paramString, paramLong);
    e(paramStringBuffer, paramString);
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, Object paramObject)
  {
    paramStringBuffer.append(paramObject);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, Object paramObject, Boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    if (paramObject == null)
      c(paramStringBuffer, paramString);
    while (true)
    {
      e(paramStringBuffer, paramString);
      return;
      a(paramStringBuffer, paramString, paramObject, a(paramBoolean));
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, Object paramObject, boolean paramBoolean)
  {
    if ((a(paramObject)) && (!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Character)))
    {
      b(paramStringBuffer, paramString, paramObject);
      return;
    }
    b(paramObject);
    while (true)
    {
      try
      {
        if ((paramObject instanceof Collection))
        {
          if (!paramBoolean)
            continue;
          a(paramStringBuffer, paramString, (Collection)paramObject);
          return;
          c(paramStringBuffer, paramString, ((Collection)paramObject).size());
          continue;
        }
      }
      finally
      {
        c(paramObject);
      }
      if ((paramObject instanceof Map))
      {
        if (paramBoolean)
        {
          a(paramStringBuffer, paramString, (Map)paramObject);
          continue;
        }
        c(paramStringBuffer, paramString, ((Map)paramObject).size());
        continue;
      }
      if ((paramObject instanceof long[]))
      {
        if (paramBoolean)
        {
          a(paramStringBuffer, paramString, (long[])(long[])paramObject);
          continue;
        }
        b(paramStringBuffer, paramString, (long[])(long[])paramObject);
        continue;
      }
      if ((paramObject instanceof int[]))
      {
        if (paramBoolean)
        {
          a(paramStringBuffer, paramString, (int[])(int[])paramObject);
          continue;
        }
        b(paramStringBuffer, paramString, (int[])(int[])paramObject);
        continue;
      }
      if ((paramObject instanceof short[]))
      {
        if (paramBoolean)
        {
          a(paramStringBuffer, paramString, (short[])(short[])paramObject);
          continue;
        }
        b(paramStringBuffer, paramString, (short[])(short[])paramObject);
        continue;
      }
      if ((paramObject instanceof byte[]))
      {
        if (paramBoolean)
        {
          a(paramStringBuffer, paramString, (byte[])(byte[])paramObject);
          continue;
        }
        b(paramStringBuffer, paramString, (byte[])(byte[])paramObject);
        continue;
      }
      if ((paramObject instanceof char[]))
      {
        if (paramBoolean)
        {
          a(paramStringBuffer, paramString, (char[])(char[])paramObject);
          continue;
        }
        b(paramStringBuffer, paramString, (char[])(char[])paramObject);
        continue;
      }
      if ((paramObject instanceof double[]))
      {
        if (paramBoolean)
        {
          a(paramStringBuffer, paramString, (double[])(double[])paramObject);
          continue;
        }
        b(paramStringBuffer, paramString, (double[])(double[])paramObject);
        continue;
      }
      if ((paramObject instanceof float[]))
      {
        if (paramBoolean)
        {
          a(paramStringBuffer, paramString, (float[])(float[])paramObject);
          continue;
        }
        b(paramStringBuffer, paramString, (float[])(float[])paramObject);
        continue;
      }
      if ((paramObject instanceof boolean[]))
      {
        if (paramBoolean)
        {
          a(paramStringBuffer, paramString, (boolean[])(boolean[])paramObject);
          continue;
        }
        b(paramStringBuffer, paramString, (boolean[])(boolean[])paramObject);
        continue;
      }
      if (paramObject.getClass().isArray())
      {
        if (paramBoolean)
        {
          a(paramStringBuffer, paramString, (Object[])(Object[])paramObject);
          continue;
        }
        b(paramStringBuffer, paramString, (Object[])(Object[])paramObject);
        continue;
      }
      if (paramBoolean)
      {
        a(paramStringBuffer, paramString, paramObject);
        continue;
      }
      c(paramStringBuffer, paramString, paramObject);
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, Collection<?> paramCollection)
  {
    paramStringBuffer.append(paramCollection);
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, Map<?, ?> paramMap)
  {
    paramStringBuffer.append(paramMap);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, short paramShort)
  {
    d(paramStringBuffer, paramString);
    b(paramStringBuffer, paramString, paramShort);
    e(paramStringBuffer, paramString);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    b(paramStringBuffer, paramString, paramBoolean);
    e(paramStringBuffer, paramString);
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfByte)
  {
    paramStringBuffer.append(this.r);
    for (int i1 = 0; i1 < paramArrayOfByte.length; i1++)
    {
      if (i1 > 0)
        paramStringBuffer.append(this.s);
      b(paramStringBuffer, paramString, paramArrayOfByte[i1]);
    }
    paramStringBuffer.append(this.u);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfByte, Boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    if (paramArrayOfByte == null)
      c(paramStringBuffer, paramString);
    while (true)
    {
      e(paramStringBuffer, paramString);
      return;
      if (a(paramBoolean))
      {
        a(paramStringBuffer, paramString, paramArrayOfByte);
        continue;
      }
      b(paramStringBuffer, paramString, paramArrayOfByte);
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfChar)
  {
    paramStringBuffer.append(this.r);
    for (int i1 = 0; i1 < paramArrayOfChar.length; i1++)
    {
      if (i1 > 0)
        paramStringBuffer.append(this.s);
      b(paramStringBuffer, paramString, paramArrayOfChar[i1]);
    }
    paramStringBuffer.append(this.u);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfChar, Boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    if (paramArrayOfChar == null)
      c(paramStringBuffer, paramString);
    while (true)
    {
      e(paramStringBuffer, paramString);
      return;
      if (a(paramBoolean))
      {
        a(paramStringBuffer, paramString, paramArrayOfChar);
        continue;
      }
      b(paramStringBuffer, paramString, paramArrayOfChar);
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfDouble)
  {
    paramStringBuffer.append(this.r);
    for (int i1 = 0; i1 < paramArrayOfDouble.length; i1++)
    {
      if (i1 > 0)
        paramStringBuffer.append(this.s);
      b(paramStringBuffer, paramString, paramArrayOfDouble[i1]);
    }
    paramStringBuffer.append(this.u);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfDouble, Boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    if (paramArrayOfDouble == null)
      c(paramStringBuffer, paramString);
    while (true)
    {
      e(paramStringBuffer, paramString);
      return;
      if (a(paramBoolean))
      {
        a(paramStringBuffer, paramString, paramArrayOfDouble);
        continue;
      }
      b(paramStringBuffer, paramString, paramArrayOfDouble);
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOfFloat)
  {
    paramStringBuffer.append(this.r);
    for (int i1 = 0; i1 < paramArrayOfFloat.length; i1++)
    {
      if (i1 > 0)
        paramStringBuffer.append(this.s);
      b(paramStringBuffer, paramString, paramArrayOfFloat[i1]);
    }
    paramStringBuffer.append(this.u);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOfFloat, Boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    if (paramArrayOfFloat == null)
      c(paramStringBuffer, paramString);
    while (true)
    {
      e(paramStringBuffer, paramString);
      return;
      if (a(paramBoolean))
      {
        a(paramStringBuffer, paramString, paramArrayOfFloat);
        continue;
      }
      b(paramStringBuffer, paramString, paramArrayOfFloat);
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfInt)
  {
    paramStringBuffer.append(this.r);
    for (int i1 = 0; i1 < paramArrayOfInt.length; i1++)
    {
      if (i1 > 0)
        paramStringBuffer.append(this.s);
      b(paramStringBuffer, paramString, paramArrayOfInt[i1]);
    }
    paramStringBuffer.append(this.u);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfInt, Boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    if (paramArrayOfInt == null)
      c(paramStringBuffer, paramString);
    while (true)
    {
      e(paramStringBuffer, paramString);
      return;
      if (a(paramBoolean))
      {
        a(paramStringBuffer, paramString, paramArrayOfInt);
        continue;
      }
      b(paramStringBuffer, paramString, paramArrayOfInt);
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOfLong)
  {
    paramStringBuffer.append(this.r);
    for (int i1 = 0; i1 < paramArrayOfLong.length; i1++)
    {
      if (i1 > 0)
        paramStringBuffer.append(this.s);
      b(paramStringBuffer, paramString, paramArrayOfLong[i1]);
    }
    paramStringBuffer.append(this.u);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOfLong, Boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    if (paramArrayOfLong == null)
      c(paramStringBuffer, paramString);
    while (true)
    {
      e(paramStringBuffer, paramString);
      return;
      if (a(paramBoolean))
      {
        a(paramStringBuffer, paramString, paramArrayOfLong);
        continue;
      }
      b(paramStringBuffer, paramString, paramArrayOfLong);
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject)
  {
    paramStringBuffer.append(this.r);
    int i1 = 0;
    if (i1 < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i1];
      if (i1 > 0)
        paramStringBuffer.append(this.s);
      if (localObject == null)
        c(paramStringBuffer, paramString);
      while (true)
      {
        i1++;
        break;
        a(paramStringBuffer, paramString, localObject, this.t);
      }
    }
    paramStringBuffer.append(this.u);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject, Boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    if (paramArrayOfObject == null)
      c(paramStringBuffer, paramString);
    while (true)
    {
      e(paramStringBuffer, paramString);
      return;
      if (a(paramBoolean))
      {
        a(paramStringBuffer, paramString, paramArrayOfObject);
        continue;
      }
      b(paramStringBuffer, paramString, paramArrayOfObject);
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfShort)
  {
    paramStringBuffer.append(this.r);
    for (int i1 = 0; i1 < paramArrayOfShort.length; i1++)
    {
      if (i1 > 0)
        paramStringBuffer.append(this.s);
      b(paramStringBuffer, paramString, paramArrayOfShort[i1]);
    }
    paramStringBuffer.append(this.u);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfShort, Boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    if (paramArrayOfShort == null)
      c(paramStringBuffer, paramString);
    while (true)
    {
      e(paramStringBuffer, paramString);
      return;
      if (a(paramBoolean))
      {
        a(paramStringBuffer, paramString, paramArrayOfShort);
        continue;
      }
      b(paramStringBuffer, paramString, paramArrayOfShort);
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfBoolean)
  {
    paramStringBuffer.append(this.r);
    for (int i1 = 0; i1 < paramArrayOfBoolean.length; i1++)
    {
      if (i1 > 0)
        paramStringBuffer.append(this.s);
      b(paramStringBuffer, paramString, paramArrayOfBoolean[i1]);
    }
    paramStringBuffer.append(this.u);
  }

  public void a(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfBoolean, Boolean paramBoolean)
  {
    d(paramStringBuffer, paramString);
    if (paramArrayOfBoolean == null)
      c(paramStringBuffer, paramString);
    while (true)
    {
      e(paramStringBuffer, paramString);
      return;
      if (a(paramBoolean))
      {
        a(paramStringBuffer, paramString, paramArrayOfBoolean);
        continue;
      }
      b(paramStringBuffer, paramString, paramArrayOfBoolean);
    }
  }

  protected void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  protected boolean a()
  {
    return this.i;
  }

  protected boolean a(Boolean paramBoolean)
  {
    if (paramBoolean == null)
      return this.v;
    return paramBoolean.booleanValue();
  }

  protected void b(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.u = paramString;
  }

  protected void b(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.l);
  }

  public void b(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (!this.p)
      a(paramStringBuffer);
    c(paramStringBuffer);
    c(paramObject);
  }

  public void b(StringBuffer paramStringBuffer, String paramString)
  {
    if (paramString != null)
    {
      int i1 = paramString.indexOf(this.l) + this.l.length();
      int i2 = paramString.lastIndexOf(this.m);
      if ((i1 != i2) && (i1 >= 0) && (i2 >= 0))
      {
        String str = paramString.substring(i1, i2);
        if (this.o)
          a(paramStringBuffer);
        paramStringBuffer.append(str);
        d(paramStringBuffer);
      }
    }
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, byte paramByte)
  {
    paramStringBuffer.append(paramByte);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, char paramChar)
  {
    paramStringBuffer.append(paramChar);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, double paramDouble)
  {
    paramStringBuffer.append(paramDouble);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, float paramFloat)
  {
    paramStringBuffer.append(paramFloat);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, int paramInt)
  {
    paramStringBuffer.append(paramInt);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, long paramLong)
  {
    paramStringBuffer.append(paramLong);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, Object paramObject)
  {
    p.a(paramStringBuffer, paramObject);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, short paramShort)
  {
    paramStringBuffer.append(paramShort);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, boolean paramBoolean)
  {
    paramStringBuffer.append(paramBoolean);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfByte)
  {
    c(paramStringBuffer, paramString, paramArrayOfByte.length);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfChar)
  {
    c(paramStringBuffer, paramString, paramArrayOfChar.length);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfDouble)
  {
    c(paramStringBuffer, paramString, paramArrayOfDouble.length);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOfFloat)
  {
    c(paramStringBuffer, paramString, paramArrayOfFloat.length);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfInt)
  {
    c(paramStringBuffer, paramString, paramArrayOfInt.length);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOfLong)
  {
    c(paramStringBuffer, paramString, paramArrayOfLong.length);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject)
  {
    c(paramStringBuffer, paramString, paramArrayOfObject.length);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfShort)
  {
    c(paramStringBuffer, paramString, paramArrayOfShort.length);
  }

  protected void b(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfBoolean)
  {
    c(paramStringBuffer, paramString, paramArrayOfBoolean.length);
  }

  protected void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  protected boolean b()
  {
    return this.j;
  }

  protected void c(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.s = paramString;
  }

  protected void c(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.m);
  }

  protected void c(StringBuffer paramStringBuffer, Object paramObject)
  {
    if ((this.i) && (paramObject != null))
    {
      b(paramObject);
      if (this.j)
        paramStringBuffer.append(a(paramObject.getClass()));
    }
    else
    {
      return;
    }
    paramStringBuffer.append(paramObject.getClass().getName());
  }

  protected void c(StringBuffer paramStringBuffer, String paramString)
  {
    paramStringBuffer.append(this.w);
  }

  protected void c(StringBuffer paramStringBuffer, String paramString, int paramInt)
  {
    paramStringBuffer.append(this.x);
    paramStringBuffer.append(paramInt);
    paramStringBuffer.append(this.y);
  }

  protected void c(StringBuffer paramStringBuffer, String paramString, Object paramObject)
  {
    paramStringBuffer.append(this.z);
    paramStringBuffer.append(a(paramObject.getClass()));
    paramStringBuffer.append(this.A);
  }

  protected void c(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  protected boolean c()
  {
    return this.k;
  }

  protected void d(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.l = paramString;
  }

  protected void d(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.q);
  }

  protected void d(StringBuffer paramStringBuffer, Object paramObject)
  {
    if ((c()) && (paramObject != null))
    {
      b(paramObject);
      paramStringBuffer.append('@');
      paramStringBuffer.append(Integer.toHexString(System.identityHashCode(paramObject)));
    }
  }

  protected void d(StringBuffer paramStringBuffer, String paramString)
  {
    if ((this.h) && (paramString != null))
    {
      paramStringBuffer.append(paramString);
      paramStringBuffer.append(this.n);
    }
  }

  protected void d(StringBuffer paramStringBuffer, String paramString, Object paramObject)
  {
    paramStringBuffer.append(this.r);
    int i1 = Array.getLength(paramObject);
    int i2 = 0;
    if (i2 < i1)
    {
      Object localObject = Array.get(paramObject, i2);
      if (i2 > 0)
        paramStringBuffer.append(this.s);
      if (localObject == null)
        c(paramStringBuffer, paramString);
      while (true)
      {
        i2++;
        break;
        a(paramStringBuffer, paramString, localObject, this.t);
      }
    }
    paramStringBuffer.append(this.u);
  }

  protected void d(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  protected boolean d()
  {
    return this.h;
  }

  protected void e(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.m = paramString;
  }

  protected void e(StringBuffer paramStringBuffer, String paramString)
  {
    d(paramStringBuffer);
  }

  protected void e(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }

  protected boolean e()
  {
    return this.v;
  }

  protected void f(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.n = paramString;
  }

  protected void f(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }

  protected boolean f()
  {
    return this.t;
  }

  protected String g()
  {
    return this.r;
  }

  protected void g(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.q = paramString;
  }

  protected void g(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  protected String h()
  {
    return this.u;
  }

  protected void h(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.w = paramString;
  }

  protected void h(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  protected String i()
  {
    return this.s;
  }

  protected void i(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.x = paramString;
  }

  protected String j()
  {
    return this.l;
  }

  protected void j(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.y = paramString;
  }

  protected String k()
  {
    return this.m;
  }

  protected void k(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.z = paramString;
  }

  protected String l()
  {
    return this.n;
  }

  protected void l(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.A = paramString;
  }

  protected String m()
  {
    return this.q;
  }

  protected boolean n()
  {
    return this.o;
  }

  protected boolean o()
  {
    return this.p;
  }

  protected String p()
  {
    return this.w;
  }

  protected String q()
  {
    return this.x;
  }

  protected String r()
  {
    return this.y;
  }

  protected String s()
  {
    return this.z;
  }

  protected String t()
  {
    return this.A;
  }

  private static final class a extends i
  {
    private static final long f = 1L;

    private Object v()
    {
      return i.a;
    }
  }

  private static final class b extends i
  {
    private static final long f = 1L;

    b()
    {
      d("[");
      g(w.F + "  ");
      g(true);
      e(w.F + "]");
    }

    private Object v()
    {
      return i.b;
    }
  }

  private static final class c extends i
  {
    private static final long f = 1L;

    c()
    {
      d(false);
    }

    private Object v()
    {
      return i.c;
    }
  }

  private static final class d extends i
  {
    private static final long f = 1L;

    d()
    {
      b(true);
      c(false);
    }

    private Object v()
    {
      return i.d;
    }
  }

  private static final class e extends i
  {
    private static final long f = 1L;

    e()
    {
      a(false);
      c(false);
      d(false);
      d("");
      e("");
    }

    private Object v()
    {
      return i.e;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.a.i
 * JD-Core Version:    0.6.0
 */