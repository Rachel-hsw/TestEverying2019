package com.xiaomi.push.b;

import com.google.a.a.b;
import com.google.a.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static final class a extends d
  {
    private boolean a;
    private int b = 0;
    private boolean c;
    private boolean d = false;
    private boolean e;
    private int f = 0;
    private boolean g;
    private boolean h = false;
    private List<String> i = Collections.emptyList();
    private int j = -1;

    public static a b(byte[] paramArrayOfByte)
    {
      return (a)(a)new a().a(paramArrayOfByte);
    }

    public static a c(com.google.a.a.a parama)
    {
      return new a().b(parama);
    }

    public int a()
    {
      int k = 0;
      if (d());
      for (int m = 0 + b.d(1, c()); ; m = 0)
      {
        if (f())
          m += b.b(2, e());
        if (h())
          m += b.c(3, g());
        if (j());
        for (int n = m + b.b(4, i()); ; n = m)
        {
          Iterator localIterator = k().iterator();
          while (localIterator.hasNext())
            k += b.b((String)localIterator.next());
          int i1 = n + k + 1 * k().size();
          this.j = i1;
          return i1;
        }
      }
    }

    public a a(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }

    public a a(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException();
      if (this.i.isEmpty())
        this.i = new ArrayList();
      this.i.add(paramString);
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.c = true;
      this.d = paramBoolean;
      return this;
    }

    public void a(b paramb)
    {
      if (d())
        paramb.b(1, c());
      if (f())
        paramb.a(2, e());
      if (h())
        paramb.a(3, g());
      if (j())
        paramb.a(4, i());
      Iterator localIterator = k().iterator();
      while (localIterator.hasNext())
        paramb.a(5, (String)localIterator.next());
    }

    public a b(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }

    public a b(com.google.a.a.a parama)
    {
      while (true)
      {
        int k = parama.a();
        switch (k)
        {
        default:
          if (a(parama, k))
            continue;
        case 0:
          return this;
        case 8:
          a(parama.f());
          break;
        case 16:
          a(parama.d());
          break;
        case 24:
          b(parama.c());
          break;
        case 32:
          b(parama.d());
          break;
        case 42:
        }
        a(parama.e());
      }
    }

    public a b(boolean paramBoolean)
    {
      this.g = true;
      this.h = paramBoolean;
      return this;
    }

    public int c()
    {
      return this.b;
    }

    public boolean d()
    {
      return this.a;
    }

    public boolean e()
    {
      return this.d;
    }

    public boolean f()
    {
      return this.c;
    }

    public int g()
    {
      return this.f;
    }

    public boolean h()
    {
      return this.e;
    }

    public boolean i()
    {
      return this.h;
    }

    public boolean j()
    {
      return this.g;
    }

    public List<String> k()
    {
      return this.i;
    }

    public int l()
    {
      return this.i.size();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.b.a
 * JD-Core Version:    0.6.0
 */