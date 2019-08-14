package com.squareup.a.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract interface a
{
  public abstract void a();

  public abstract void a(int paramInt);

  public abstract void b(int paramInt);

  public abstract boolean c(int paramInt);

  public abstract void d(int paramInt);

  public static final class a
    implements a
  {
    long a = 0L;

    private static int e(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 63))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        throw new IllegalArgumentException(String.format("input must be between 0 and 63: %s", arrayOfObject));
      }
      return paramInt;
    }

    public void a()
    {
      this.a = 0L;
    }

    public void a(int paramInt)
    {
      this.a |= 1L << e(paramInt);
    }

    public a b()
    {
      return new a.b(this, null);
    }

    public void b(int paramInt)
    {
      this.a ^= 1L << e(paramInt);
    }

    public boolean c(int paramInt)
    {
      return (1L & this.a >> e(paramInt)) == 1L;
    }

    public void d(int paramInt)
    {
      this.a <<= e(paramInt);
    }

    public String toString()
    {
      return Long.toBinaryString(this.a);
    }
  }

  public static final class b
    implements a
  {
    long[] a;
    private int b;

    public b()
    {
      this.a = new long[1];
    }

    private b(a.a parama)
    {
      long[] arrayOfLong = new long[2];
      arrayOfLong[0] = parama.a;
      arrayOfLong[1] = 0L;
      this.a = arrayOfLong;
    }

    private void e(int paramInt)
    {
      long[] arrayOfLong = new long[paramInt];
      if (this.a != null)
        System.arraycopy(this.a, 0, arrayOfLong, 0, this.a.length);
      this.a = arrayOfLong;
    }

    private int f(int paramInt)
    {
      int i = (paramInt + this.b) / 64;
      if (i > -1 + this.a.length)
        e(i + 1);
      return i;
    }

    private int g(int paramInt)
    {
      return (paramInt + this.b) % 64;
    }

    private static int h(int paramInt)
    {
      if (paramInt < 0)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        throw new IllegalArgumentException(String.format("input must be a positive number: %s", arrayOfObject));
      }
      return paramInt;
    }

    public void a()
    {
      Arrays.fill(this.a, 0L);
    }

    public void a(int paramInt)
    {
      h(paramInt);
      int i = f(paramInt);
      long[] arrayOfLong = this.a;
      arrayOfLong[i] |= 1L << g(paramInt);
    }

    List<Integer> b()
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = 64 * this.a.length - this.b;
      while (i < j)
      {
        if (c(i))
          localArrayList.add(Integer.valueOf(i));
        i++;
      }
      return localArrayList;
    }

    public void b(int paramInt)
    {
      h(paramInt);
      int i = f(paramInt);
      long[] arrayOfLong = this.a;
      arrayOfLong[i] ^= 1L << g(paramInt);
    }

    public boolean c(int paramInt)
    {
      h(paramInt);
      int i = f(paramInt);
      return (this.a[i] & 1L << g(paramInt)) != 0L;
    }

    public void d(int paramInt)
    {
      this.b -= h(paramInt);
      if (this.b < 0)
      {
        int i = 1 + this.b / -64;
        long[] arrayOfLong = new long[i + this.a.length];
        System.arraycopy(this.a, 0, arrayOfLong, i, this.a.length);
        this.a = arrayOfLong;
        this.b = (64 + this.b % 64);
      }
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      List localList = b();
      int i = 0;
      int j = localList.size();
      while (i < j)
      {
        if (i > 0)
          localStringBuilder.append(',');
        localStringBuilder.append(localList.get(i));
        i++;
      }
      return '}';
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a
 * JD-Core Version:    0.6.0
 */