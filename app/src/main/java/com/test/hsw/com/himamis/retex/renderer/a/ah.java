package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.a.a;
import java.util.HashMap;
import java.util.Map;

public class ah
{
  public static final int a = 256;
  private static Map<Integer, ah> g = new HashMap();
  private int A;
  protected final String b;
  protected final String c;
  protected final String d;
  protected final String e;
  protected final String f;
  private final int h;
  private a i;
  private final Object j;
  private final String k;
  private final String l;
  private final Map<a, Character> m = new HashMap();
  private final Map<a, Float> n = new HashMap();
  private float[][] o;
  private p[] p;
  private int[][] q;
  private HashMap<Character, Character> r = null;
  private char s = 65535;
  private final float t;
  private final float u;
  private final float v;
  private int w;
  private int x;
  private int y;
  private int z;

  public ah(int paramInt1, Object paramObject, String paramString1, String paramString2, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.h = paramInt1;
    this.j = paramObject;
    this.k = paramString1;
    this.l = paramString2;
    this.t = paramFloat1;
    this.u = paramFloat2;
    this.v = paramFloat3;
    this.b = paramString3;
    this.c = paramString4;
    this.d = paramString5;
    this.e = paramString6;
    this.f = paramString7;
    if (paramInt2 != 0)
      this.r = new HashMap(paramInt2);
    while (true)
    {
      this.o = new float[paramInt2][];
      this.p = new p[paramInt2];
      this.q = new int[paramInt2][];
      g.put(Integer.valueOf(paramInt1), this);
      return;
      paramInt2 = 256;
    }
  }

  public static a f(int paramInt)
  {
    return ((ah)g.get(Integer.valueOf(paramInt))).i();
  }

  public char a()
  {
    return this.s;
  }

  public float a(float paramFloat)
  {
    return paramFloat * this.v;
  }

  public p a(char paramChar1, char paramChar2)
  {
    Object localObject = this.m.get(new a(paramChar1, paramChar2));
    if (localObject == null)
      return null;
    return new p(((Character)localObject).charValue(), this.h);
  }

  public void a(char paramChar1, char paramChar2, char paramChar3)
  {
    this.m.put(new a(paramChar1, paramChar2), new Character(paramChar3));
  }

  public void a(char paramChar1, char paramChar2, float paramFloat)
  {
    this.n.put(new a(paramChar1, paramChar2), new Float(paramFloat));
  }

  public void a(char paramChar1, char paramChar2, int paramInt)
  {
    if (this.r == null)
    {
      this.p[paramChar1] = new p(paramChar2, paramInt);
      return;
    }
    if (!this.r.containsKey(Character.valueOf(paramChar1)))
    {
      char c1 = (char)this.r.size();
      this.r.put(Character.valueOf(paramChar1), Character.valueOf(c1));
      this.p[c1] = new p(paramChar2, paramInt);
      return;
    }
    this.p[((Character)this.r.get(Character.valueOf(paramChar1))).charValue()] = new p(paramChar2, paramInt);
  }

  public void a(char paramChar, float[] paramArrayOfFloat)
  {
    if (this.r == null)
    {
      this.o[paramChar] = paramArrayOfFloat;
      return;
    }
    if (!this.r.containsKey(Character.valueOf(paramChar)))
    {
      char c1 = (char)this.r.size();
      this.r.put(Character.valueOf(paramChar), Character.valueOf(c1));
      this.o[c1] = paramArrayOfFloat;
      return;
    }
    this.o[((Character)this.r.get(Character.valueOf(paramChar))).charValue()] = paramArrayOfFloat;
  }

  public void a(char paramChar, int[] paramArrayOfInt)
  {
    if (this.r == null)
    {
      this.q[paramChar] = paramArrayOfInt;
      return;
    }
    if (!this.r.containsKey(Character.valueOf(paramChar)))
    {
      char c1 = (char)this.r.size();
      this.r.put(Character.valueOf(paramChar), Character.valueOf(c1));
      this.q[c1] = paramArrayOfInt;
      return;
    }
    this.q[((Character)this.r.get(Character.valueOf(paramChar))).charValue()] = paramArrayOfInt;
  }

  public void a(int paramInt)
  {
    if (paramInt == -1)
      paramInt = this.h;
    this.y = paramInt;
  }

  public int[] a(char paramChar)
  {
    if (this.r == null)
      return this.q[paramChar];
    return this.q[((Character)this.r.get(Character.valueOf(paramChar))).charValue()];
  }

  public float b(char paramChar1, char paramChar2, float paramFloat)
  {
    Object localObject = this.n.get(new a(paramChar1, paramChar2));
    if (localObject == null)
      return 0.0F;
    return paramFloat * ((Float)localObject).floatValue();
  }

  public float b(float paramFloat)
  {
    return paramFloat * this.u;
  }

  public void b(int paramInt)
  {
    if (paramInt == -1)
      paramInt = this.h;
    this.z = paramInt;
  }

  public boolean b()
  {
    return this.u > 1.0E-007F;
  }

  public float[] b(char paramChar)
  {
    if (this.r == null)
      return this.o[paramChar];
    return this.o[((Character)this.r.get(Character.valueOf(paramChar))).charValue()];
  }

  public float c(float paramFloat)
  {
    return paramFloat * this.t;
  }

  public int c()
  {
    return this.h;
  }

  public p c(char paramChar)
  {
    if (this.r == null)
      return this.p[paramChar];
    return this.p[((Character)this.r.get(Character.valueOf(paramChar))).charValue()];
  }

  public void c(int paramInt)
  {
    if (paramInt == -1)
      paramInt = this.h;
    this.A = paramInt;
  }

  public int d()
  {
    return this.w;
  }

  public void d(char paramChar)
  {
    this.s = paramChar;
  }

  public void d(int paramInt)
  {
    if (paramInt == -1)
      paramInt = this.h;
    this.x = paramInt;
  }

  public int e()
  {
    return this.x;
  }

  public void e(int paramInt)
  {
    if (paramInt == -1)
      paramInt = this.h;
    this.w = paramInt;
  }

  public int f()
  {
    return this.z;
  }

  public int g()
  {
    return this.A;
  }

  public int h()
  {
    return this.y;
  }

  public a i()
  {
    if (this.i == null)
      if (this.j != null)
        break label30;
    label30: for (this.i = w.a(this.k); ; this.i = w.a(this.j, this.k))
      return this.i;
  }

  private class a
  {
    private final char b;
    private final char c;

    a(char paramChar1, char arg3)
    {
      this.b = paramChar1;
      char c1;
      this.c = c1;
    }

    public boolean equals(Object paramObject)
    {
      a locala = (a)paramObject;
      return (this.b == locala.b) && (this.c == locala.c);
    }

    public int hashCode()
    {
      return (this.b + this.c) % 128;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ah
 * JD-Core Version:    0.6.0
 */