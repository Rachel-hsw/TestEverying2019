package a.a.a.d;

import a.a.a.e;
import java.util.Arrays;

public final class c<T>
{
  private a<T>[] a;
  private int b;
  private int c;
  private int d;

  public c()
  {
    this(16);
  }

  public c(int paramInt)
  {
    this.b = paramInt;
    this.c = (paramInt * 4 / 3);
    this.a = new a[paramInt];
  }

  public T a(long paramLong, T paramT)
  {
    int i = (0x7FFFFFFF & ((int)(paramLong >>> 32) ^ (int)paramLong)) % this.b;
    a locala1 = this.a[i];
    for (a locala2 = locala1; ; locala2 = locala2.c)
    {
      if (locala2 == null)
      {
        this.a[i] = new a(paramLong, paramT, locala1);
        this.d = (1 + this.d);
        if (this.d > this.c)
          a(2 * this.b);
        return null;
      }
      if (locala2.a != paramLong)
        continue;
      Object localObject = locala2.b;
      locala2.b = paramT;
      return localObject;
    }
  }

  public void a()
  {
    this.d = 0;
    Arrays.fill(this.a, null);
  }

  public void a(int paramInt)
  {
    a[] arrayOfa = new a[paramInt];
    int i = this.a.length;
    int j = 0;
    if (j >= i)
    {
      this.a = arrayOfa;
      this.b = paramInt;
      this.c = (paramInt * 4 / 3);
      return;
    }
    a locala;
    for (Object localObject = this.a[j]; ; localObject = locala)
    {
      if (localObject == null)
      {
        j++;
        break;
      }
      long l = ((a)localObject).a;
      int k = (0x7FFFFFFF & ((int)(l >>> 32) ^ (int)l)) % paramInt;
      locala = ((a)localObject).c;
      ((a)localObject).c = arrayOfa[k];
      arrayOfa[k] = localObject;
    }
  }

  public boolean a(long paramLong)
  {
    int i = (0x7FFFFFFF & ((int)(paramLong >>> 32) ^ (int)paramLong)) % this.b;
    for (a locala = this.a[i]; ; locala = locala.c)
    {
      if (locala == null)
        return false;
      if (locala.a == paramLong)
        return true;
    }
  }

  public int b()
  {
    return this.d;
  }

  public T b(long paramLong)
  {
    int i = (0x7FFFFFFF & ((int)(paramLong >>> 32) ^ (int)paramLong)) % this.b;
    for (a locala = this.a[i]; ; locala = locala.c)
    {
      if (locala == null)
        return null;
      if (locala.a == paramLong)
        return locala.b;
    }
  }

  public void b(int paramInt)
  {
    a(paramInt * 5 / 3);
  }

  public T c(long paramLong)
  {
    int i = (0x7FFFFFFF & ((int)(paramLong >>> 32) ^ (int)paramLong)) % this.b;
    Object localObject1 = this.a[i];
    Object localObject2 = null;
    while (true)
    {
      if (localObject1 == null)
        return null;
      a locala = ((a)localObject1).c;
      if (((a)localObject1).a == paramLong)
      {
        if (localObject2 == null)
          this.a[i] = locala;
        while (true)
        {
          this.d = (-1 + this.d);
          return ((a)localObject1).b;
          localObject2.c = locala;
        }
      }
      localObject2 = localObject1;
      localObject1 = locala;
    }
  }

  public void c()
  {
    a[] arrayOfa = this.a;
    int i = arrayOfa.length;
    int j = 0;
    int k = 0;
    if (j >= i)
    {
      e.b("load: " + this.d / this.b + ", size: " + this.d + ", capa: " + this.b + ", collisions: " + k + ", collision ratio: " + k / this.d);
      return;
    }
    for (a locala = arrayOfa[j]; ; locala = locala.c)
    {
      if ((locala == null) || (locala.c == null))
      {
        j++;
        break;
      }
      k++;
    }
  }

  static final class a<T>
  {
    final long a;
    T b;
    a<T> c;

    a(long paramLong, T paramT, a<T> parama)
    {
      this.a = paramLong;
      this.b = paramT;
      this.c = parama;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.d.c
 * JD-Core Version:    0.6.0
 */