package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class o<T>
  implements Comparable<o<T>>
{
  private static final String a = "UTF-8";
  private static final long o = 3000L;
  private static long s;
  private final y.a b;
  private final int c;
  private final String d;
  private String e;
  private String f;
  private final int g;
  private final s.a h;
  private Integer i;
  private q j;
  private boolean k;
  private boolean l;
  private boolean m;
  private long n;
  private u p;
  private b.a q;
  private Object r;

  public o(int paramInt, String paramString, s.a parama)
  {
    if (y.a.a);
    for (y.a locala = new y.a(); ; locala = null)
    {
      this.b = locala;
      this.k = true;
      this.l = false;
      this.m = false;
      this.n = 0L;
      this.q = null;
      this.c = paramInt;
      this.d = paramString;
      this.f = a(paramInt, paramString);
      this.h = parama;
      a(new e());
      this.g = d(paramString);
      return;
    }
  }

  @Deprecated
  public o(String paramString, s.a parama)
  {
    this(-1, paramString, parama);
  }

  private static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("Request:").append(paramInt).append(":").append(paramString).append(":").append(System.currentTimeMillis()).append(":");
    long l1 = s;
    s = 1L + l1;
    return h.a(l1);
  }

  private byte[] a(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return localStringBuilder.toString().getBytes(paramString);
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), paramString));
        localStringBuilder.append('=');
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), paramString));
        localStringBuilder.append('&');
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException("Encoding not supported: " + paramString, localUnsupportedEncodingException);
  }

  private static int d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Uri localUri = Uri.parse(paramString);
      if (localUri != null)
      {
        String str = localUri.getHost();
        if (str != null)
          return str.hashCode();
      }
    }
    return 0;
  }

  public boolean A()
  {
    return this.m;
  }

  public int a(o<T> paramo)
  {
    b localb1 = w();
    b localb2 = paramo.w();
    if (localb1 == localb2)
      return this.i.intValue() - paramo.i.intValue();
    return localb2.ordinal() - localb1.ordinal();
  }

  public final o<?> a(int paramInt)
  {
    this.i = Integer.valueOf(paramInt);
    return this;
  }

  public o<?> a(b.a parama)
  {
    this.q = parama;
    return this;
  }

  public o<?> a(q paramq)
  {
    this.j = paramq;
    return this;
  }

  public o<?> a(u paramu)
  {
    this.p = paramu;
    return this;
  }

  public final o<?> a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }

  protected abstract s<T> a(l paraml);

  protected x a(x paramx)
  {
    return paramx;
  }

  protected Map<String, String> a()
    throws a
  {
    return null;
  }

  protected abstract void a(T paramT);

  public void a(String paramString)
  {
    if (y.a.a)
      this.b.a(paramString, Thread.currentThread().getId());
    do
      return;
    while (this.n != 0L);
    this.n = SystemClock.elapsedRealtime();
  }

  public o<?> b(Object paramObject)
  {
    this.r = paramObject;
    return this;
  }

  public Map<String, String> b()
    throws a
  {
    return Collections.emptyMap();
  }

  public void b(x paramx)
  {
    if (this.h != null)
      this.h.a(paramx);
  }

  void b(String paramString)
  {
    if (this.j != null)
      this.j.b(this);
    long l2;
    if (y.a.a)
    {
      l2 = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper())
        new Handler(Looper.getMainLooper()).post(new p(this, paramString, l2));
    }
    long l1;
    do
    {
      return;
      this.b.a(paramString, l2);
      this.b.a(toString());
      return;
      l1 = SystemClock.elapsedRealtime() - this.n;
    }
    while (l1 < 3000L);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(l1);
    arrayOfObject[1] = toString();
    y.b("%d ms: %s", arrayOfObject);
  }

  public String c()
  {
    return "application/x-www-form-urlencoded; charset=" + u();
  }

  public void c(String paramString)
  {
    this.e = paramString;
  }

  public byte[] d()
    throws a
  {
    Map localMap = a();
    if ((localMap != null) && (localMap.size() > 0))
      return a(localMap, u());
    return null;
  }

  public int e()
  {
    return this.c;
  }

  public Object f()
  {
    return this.r;
  }

  public s.a g()
  {
    return this.h;
  }

  public int h()
  {
    return this.g;
  }

  public final int i()
  {
    if (this.i == null)
      throw new IllegalStateException("getSequence called before setSequence");
    return this.i.intValue();
  }

  public String j()
  {
    if (this.e != null)
      return this.e;
    return this.d;
  }

  public String k()
  {
    return this.d;
  }

  public String l()
  {
    return this.f;
  }

  public String m()
  {
    return j();
  }

  public b.a n()
  {
    return this.q;
  }

  public void o()
  {
    this.l = true;
  }

  public boolean p()
  {
    return this.l;
  }

  @Deprecated
  protected Map<String, String> q()
    throws a
  {
    return a();
  }

  @Deprecated
  protected String r()
  {
    return u();
  }

  @Deprecated
  public String s()
  {
    return c();
  }

  @Deprecated
  public byte[] t()
    throws a
  {
    Map localMap = q();
    if ((localMap != null) && (localMap.size() > 0))
      return a(localMap, r());
    return null;
  }

  public String toString()
  {
    String str1 = "0x" + Integer.toHexString(h());
    if (this.l);
    for (String str2 = "[X] "; ; str2 = "[ ] ")
      return str2 + j() + " " + str1 + " " + w() + " " + this.i;
  }

  protected String u()
  {
    return "UTF-8";
  }

  public final boolean v()
  {
    return this.k;
  }

  public b w()
  {
    return b.b;
  }

  public final int x()
  {
    return this.p.a();
  }

  public u y()
  {
    return this.p;
  }

  public void z()
  {
    this.m = true;
  }

  public static abstract interface a
  {
    public static final int a = -1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 6;
    public static final int i = 7;
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[4];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      e = arrayOfb;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.o
 * JD-Core Version:    0.6.0
 */