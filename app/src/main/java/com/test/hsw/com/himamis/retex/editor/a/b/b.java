package com.himamis.retex.editor.a.b;

import com.himamis.retex.editor.a.e.j;
import com.himamis.retex.editor.a.f.e;
import com.himamis.retex.editor.a.f.g;

public abstract class b extends a
{
  private final char a = '(';
  private final char e = ')';
  private final char f = '[';
  private final char g = ';';
  private final char h = '"';
  private char i;
  private char j;
  private char k;
  private char l;
  private char m;
  private char n;

  private void a(e parame, com.himamis.retex.editor.a.f.h paramh)
  {
    com.himamis.retex.editor.a.f.h localh;
    int i1;
    if ((parame.a_() instanceof com.himamis.retex.editor.a.f.h))
    {
      localh = (com.himamis.retex.editor.a.f.h)parame.a_();
      i1 = parame.s();
      localh.a(parame.s());
    }
    while (true)
    {
      if (paramh.t() <= 0)
      {
        this.c = localh;
        this.d = i1;
        return;
      }
      com.himamis.retex.editor.a.f.d locald = paramh.c(-1 + paramh.t());
      paramh.a(-1 + paramh.t());
      localh.b(i1, locald);
    }
  }

  private void b(int paramInt)
  {
    while (true)
    {
      if ((paramInt <= 0) || (this.d <= 0) || (!(this.c.c(-1 + this.d) instanceof com.himamis.retex.editor.a.f.c)));
      com.himamis.retex.editor.a.f.c localc;
      do
      {
        return;
        localc = (com.himamis.retex.editor.a.f.c)this.c.c(-1 + this.d);
      }
      while ((localc.h()) || (localc.i()));
      this.c.a(-1 + this.d);
      this.d = (-1 + this.d);
      paramInt--;
    }
  }

  private void c(e parame)
  {
    com.himamis.retex.editor.a.f.h localh = (com.himamis.retex.editor.a.f.h)parame.c(parame.x());
    while (true)
    {
      com.himamis.retex.editor.a.f.b localb;
      if ((this.d <= 0) || (!this.c.b(-1 + this.d)))
      {
        if (this.d > 0)
        {
          if (!(this.c.c(-1 + this.d) instanceof com.himamis.retex.editor.a.f.b))
            break;
          localb = (com.himamis.retex.editor.a.f.b)this.c.c(-1 + this.d);
          this.c.a(-1 + this.d);
          this.d = (-1 + this.d);
          if (localh.t() == 0)
            parame.a(parame.x(), localb.a(0));
        }
        else
        {
          return;
        }
      }
      else
      {
        g localg2 = (g)this.c.c(-1 + this.d);
        this.c.a(-1 + this.d);
        this.d = (-1 + this.d);
        localh.b(0, localg2);
        continue;
      }
      localh.b(0, localb);
      return;
    }
    if ((this.c.c(-1 + this.d) instanceof g))
    {
      g localg1 = (g)this.c.c(-1 + this.d);
      this.c.a(-1 + this.d);
      this.d = (-1 + this.d);
      localh.b(0, localg1);
      return;
    }
    d(parame);
  }

  private void d(e parame)
  {
    com.himamis.retex.editor.a.f.h localh = (com.himamis.retex.editor.a.f.h)parame.c(parame.x());
    while (true)
    {
      if ((this.d <= 0) || (!(this.c.c(-1 + this.d) instanceof com.himamis.retex.editor.a.f.c)));
      com.himamis.retex.editor.a.f.c localc;
      do
      {
        return;
        localc = (com.himamis.retex.editor.a.f.c)this.c.c(-1 + this.d);
      }
      while (localc.h());
      this.c.a(-1 + this.d);
      this.d = (-1 + this.d);
      localh.b(0, localc);
    }
  }

  private String q()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = this.d;
    while (true)
    {
      if ((i1 <= 0) || (!(this.c.c(i1 - 1) instanceof com.himamis.retex.editor.a.f.c)));
      com.himamis.retex.editor.a.f.c localc;
      do
      {
        return localStringBuffer.toString();
        localc = (com.himamis.retex.editor.a.f.c)this.c.c(i1 - 1);
      }
      while ((localc.h()) || (localc.i()));
      i1--;
      localStringBuffer.insert(0, localc.b());
    }
  }

  public void a(char paramChar)
  {
    String str = q();
    if ((paramChar == '(') && (this.b.a().g(str)))
    {
      b(str.length());
      a(str);
      return;
    }
    if ((paramChar == '(') && (this.b.a().i(str)))
    {
      b(str.length());
      a(str);
      return;
    }
    int i1 = 1;
    if (paramChar == '"')
      i1 = 4;
    if (paramChar == '[')
      i1 = 2;
    com.himamis.retex.editor.a.f.b localb = new com.himamis.retex.editor.a.f.b(this.b, i1);
    this.c.b(this.d, localb);
    com.himamis.retex.editor.a.f.h localh = new com.himamis.retex.editor.a.f.h(this.b);
    localb.a(0, localh);
    this.c = localh;
    this.d = 0;
  }

  public void a(int paramInt)
  {
    com.himamis.retex.editor.a.e.c localc = this.b.a().a();
    com.himamis.retex.editor.a.f.a locala = new com.himamis.retex.editor.a.f.a(this.b, localc, paramInt);
    this.c.b(this.d, locala);
    com.himamis.retex.editor.a.f.h localh = new com.himamis.retex.editor.a.f.h(this.b);
    locala.a(0, localh);
    for (int i1 = 1; ; i1++)
    {
      if (i1 >= paramInt)
      {
        this.c = localh;
        this.d = 0;
        return;
      }
      locala.a(i1, new com.himamis.retex.editor.a.f.h(this.b));
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    com.himamis.retex.editor.a.e.c localc = this.b.a().b();
    com.himamis.retex.editor.a.f.a locala = new com.himamis.retex.editor.a.f.a(this.b, localc, paramInt1, paramInt2);
    this.c.b(this.d, locala);
    com.himamis.retex.editor.a.f.h localh = new com.himamis.retex.editor.a.f.h(this.b);
    locala.a(0, localh);
    for (int i1 = 1; ; i1++)
    {
      if (i1 >= locala.t())
      {
        this.c = localh;
        this.d = 0;
        return;
      }
      locala.a(i1, new com.himamis.retex.editor.a.f.h(this.b));
    }
  }

  public void a(com.himamis.retex.editor.a.e.d paramd)
  {
    this.c.b(this.d, new com.himamis.retex.editor.a.f.c(this.b, paramd));
    this.d = (1 + this.d);
  }

  public void a(com.himamis.retex.editor.a.f.f paramf)
  {
    super.a(paramf);
    this.i = paramf.a().a().e();
    this.k = paramf.a().b().e();
    this.j = paramf.a().a().g();
    this.l = paramf.a().b().g();
    this.m = paramf.a().a().i();
    this.n = paramf.a().b().k();
  }

  public void a(String paramString)
  {
    a(paramString, 0);
  }

  public void a(String paramString, int paramInt)
  {
    int i1 = 0;
    if (("^".equals(paramString)) && (this.d > 0) && ((this.c.c(-1 + this.d) instanceof g)))
    {
      g localg2 = (g)this.c.c(-1 + this.d);
      if (("sqrt".equals(localg2.b())) || ("nthroot".equals(localg2.b())) || ("frac".equals(localg2.b())))
      {
        this.c.a(-1 + this.d);
        com.himamis.retex.editor.a.f.b localb = new com.himamis.retex.editor.a.f.b(this.b, 1);
        this.c.b(-1 + this.d, localb);
        com.himamis.retex.editor.a.f.h localh = new com.himamis.retex.editor.a.f.h(this.b);
        localb.a(0, localh);
        localh.b(0, localg2);
      }
    }
    g localg1;
    if (this.b.a().g(paramString))
    {
      com.himamis.retex.editor.a.e.f localf2 = this.b.a().h(paramString);
      localg1 = new g(this.b, localf2);
    }
    while (true)
    {
      if (i1 >= localg1.t())
      {
        if (("frac".equals(paramString)) || ("factorial".equals(paramString)))
          c(localg1);
        this.c.b(this.d, localg1);
        if (!localg1.w())
          break;
        a(localg1.a(paramInt));
        this.d = this.c.t();
        return;
        com.himamis.retex.editor.a.e.f localf1 = this.b.a().j(paramString);
        localg1 = new g(this.b, localf1);
        i1 = 0;
        continue;
      }
      localg1.a(i1, new com.himamis.retex.editor.a.f.h(this.b));
      i1++;
    }
    this.d = (1 + this.d);
  }

  public abstract void a(boolean paramBoolean);

  public void b(char paramChar)
  {
    com.himamis.retex.editor.a.e.d locald = this.b.a().d(paramChar);
    this.c.b(this.d, new com.himamis.retex.editor.a.f.c(this.b, locald));
    this.d = (1 + this.d);
  }

  public void b(String paramString)
  {
    int i1 = this.d;
    if ((i1 <= 0) || (!(this.c.c(i1 - 1) instanceof g)));
    label25: for (int i2 = this.d; ; i2++)
    {
      if ((i2 >= this.c.t()) || (!(this.c.c(i2) instanceof g)));
      g localg1;
      do
      {
        if ((this.d > 0) && ((this.c.c(-1 + this.d) instanceof g)) && ("^".equals(((g)this.c.c(-1 + this.d)).b())) && ("_".equals(paramString)))
          this.d = (-1 + this.d);
        if ((this.d < this.c.t()) && ((this.c.c(this.d) instanceof g)) && ("_".equals(((g)this.c.c(this.d)).b())) && ("^".equals(paramString)))
          this.d = (1 + this.d);
        a(paramString);
        do
        {
          g localg2;
          do
          {
            return;
            localg2 = (g)this.c.c(i1 - 1);
          }
          while (paramString.equals(localg2.b()));
          if ((!"^".equals(localg2.b())) && (!"_".equals(localg2.b())))
            break label25;
          i1--;
          break;
          localg1 = (g)this.c.c(i2);
        }
        while (paramString.equals(localg1.b()));
      }
      while ((!"^".equals(localg1.b())) && (!"_".equals(localg1.b())));
    }
  }

  public void c(char paramChar)
  {
    j localj = this.b.a().f(paramChar);
    this.c.b(this.d, new com.himamis.retex.editor.a.f.c(this.b, localj));
    this.d = (1 + this.d);
  }

  public void d(char paramChar)
  {
    com.himamis.retex.editor.a.e.d locald = this.b.a().b(paramChar);
    this.c.b(this.d, new com.himamis.retex.editor.a.f.c(this.b, locald));
    this.d = (1 + this.d);
  }

  public void e(char paramChar)
  {
    com.himamis.retex.editor.a.f.a locala;
    com.himamis.retex.editor.a.f.h localh;
    if ((this.c.a_() instanceof com.himamis.retex.editor.a.f.a))
    {
      locala = (com.himamis.retex.editor.a.f.a)this.c.a_();
      if ((paramChar == this.m) && ((locala.l()) || (locala.n())))
      {
        int i1 = this.c.s();
        localh = new com.himamis.retex.editor.a.f.h(this.b);
        locala.b(i1 + 1, localh);
        if (this.c.t() <= this.d)
        {
          this.c = localh;
          this.d = 0;
        }
      }
    }
    label734: 
    do
    {
      do
      {
        do
        {
          return;
          com.himamis.retex.editor.a.f.d locald = this.c.c(this.d);
          this.c.a(this.d);
          localh.b(localh.t(), locald);
          break;
          if ((paramChar == this.m) && (this.d == this.c.t()) && (locala.t() > 1 + this.c.s()) && ((1 + this.c.s()) % locala.p() != 0))
          {
            this.c = locala.a(1 + this.c.s());
            this.d = 0;
            return;
          }
          if ((paramChar == this.n) && (this.d == this.c.t()) && (locala.t() == 1 + this.c.s()))
          {
            locala.a();
            this.c = locala.a(locala.t() - locala.p());
            this.d = 0;
            return;
          }
          if ((paramChar != this.n) || (this.d != this.c.t()) || ((1 + this.c.s()) % locala.p() != 0))
            continue;
          this.c = locala.a(1 + this.c.s());
          this.d = 0;
          return;
        }
        while (((paramChar != this.j) || (!locala.m())) && ((paramChar != this.l) || (!locala.o()) || (locala.t() != 1 + this.c.s()) || (this.d != this.c.t())));
        this.d = (1 + locala.s());
        this.c = ((com.himamis.retex.editor.a.f.h)locala.a_());
        return;
        if (this.c.a_() == null)
          break label734;
        e locale = this.c.a_();
        if ((paramChar == this.m) && (this.d == this.c.t()) && ((locale instanceof g)) && (locale.t() > 1 + this.c.s()))
        {
          this.c = ((com.himamis.retex.editor.a.f.h)locale.c(1 + this.c.s()));
          this.d = 0;
          return;
        }
        if ((paramChar == ')') && (this.d == this.c.t()) && ((locale instanceof g)) && (locale.t() == 1 + this.c.s()))
        {
          this.d = (1 + locale.s());
          this.c = ((com.himamis.retex.editor.a.f.h)locale.a_());
          return;
        }
        if ((paramChar == ')') && (this.d == this.c.t()) && ((locale instanceof com.himamis.retex.editor.a.f.b)) && (locale.t() == 1 + this.c.s()) && (((com.himamis.retex.editor.a.f.b)locale).b() == 1))
        {
          this.d = (1 + locale.s());
          this.c = ((com.himamis.retex.editor.a.f.h)locale.a_());
          return;
        }
        if ((paramChar != '"') || (this.d != this.c.t()) || (!(locale instanceof com.himamis.retex.editor.a.f.b)) || (((com.himamis.retex.editor.a.f.b)locale).b() != 4))
          continue;
        this.d = (1 + locale.s());
        this.c = ((com.himamis.retex.editor.a.f.h)locale.a_());
        return;
      }
      while (paramChar != this.m);
      d(paramChar);
      return;
    }
    while ((paramChar != ';') && (paramChar != this.m));
    d(paramChar);
  }

  public boolean f(char paramChar)
  {
    if ((paramChar == this.m) || (paramChar == this.n) || (paramChar == this.j) || (paramChar == this.l) || (paramChar == ')') || (paramChar == ';') || ((paramChar == '"') && ((this.c.a_() instanceof com.himamis.retex.editor.a.f.b)) && (((com.himamis.retex.editor.a.f.b)this.c.a_()).b() == 4)))
    {
      e(paramChar);
      p();
      return true;
    }
    if ((paramChar == '(') || (paramChar == '"') || (paramChar == '['))
    {
      a(paramChar);
      p();
      return true;
    }
    if (paramChar == '!')
    {
      a("factorial");
      p();
      return true;
    }
    if (paramChar == '^')
    {
      b("^");
      p();
      return true;
    }
    if (paramChar == '_')
    {
      b("_");
      p();
      return true;
    }
    if (paramChar == '\\')
    {
      a("frac", 1);
      p();
      return true;
    }
    if (paramChar == this.i)
    {
      a(1);
      p();
      return true;
    }
    if (paramChar == this.k)
    {
      a(1, 1);
      p();
      return true;
    }
    if (this.b.a().c(paramChar))
    {
      b(paramChar);
      p();
      return true;
    }
    if (this.b.a().e(paramChar))
    {
      c(paramChar);
      p();
      return true;
    }
    if (this.b.a().a(paramChar))
    {
      d(paramChar);
      p();
      return true;
    }
    return false;
  }

  public void k()
  {
    for (String str = q(); ; str = str.substring(1, str.length()))
    {
      if (str.length() <= 0)
        return;
      if (this.b.a().e(str))
      {
        b(str.length());
        j localj = this.b.a().f(str);
        this.c.b(this.d, new com.himamis.retex.editor.a.f.c(this.b, localj));
        this.d = (1 + this.d);
        return;
      }
      if (!this.b.a().c(str))
        continue;
      b(str.length());
      com.himamis.retex.editor.a.e.d locald = this.b.a().d(str);
      this.c.b(this.d, new com.himamis.retex.editor.a.f.c(this.b, locald));
      this.d = (1 + this.d);
      return;
    }
  }

  public void l()
  {
    g localg;
    if ((this.c.a_() instanceof g))
    {
      localg = (g)this.c.a_();
      if ("frac".equals(localg.b()))
        if ((this.c.s() == 1) && (this.c.t() == 0))
        {
          int i3 = localg.a(0).t();
          a(localg, localg.a(0));
          this.d = (i3 + this.d);
        }
    }
    label93: 
    do
    {
      do
        while (true)
        {
          break label93;
          do
            return;
          while ((this.c.s() != 1) || (localg.a(0).t() != 0));
          a(localg, this.c);
          return;
          if (!this.b.a().g(localg.b()))
            break;
          if (this.c.s() != localg.x())
            continue;
          a(localg, this.c);
          return;
        }
      while (this.c.s() != 0);
      a(localg, this.c);
      return;
      if (((this.c.a_() instanceof com.himamis.retex.editor.a.f.b)) && (this.c.t() == 0))
      {
        com.himamis.retex.editor.a.f.b localb = (com.himamis.retex.editor.a.f.b)this.c.a_();
        a(localb, localb.a(0));
        return;
      }
      if ((!(this.c.a_() instanceof com.himamis.retex.editor.a.f.a)) || (this.c.a_().t() != 1) || (this.c.t() != 0))
        continue;
      com.himamis.retex.editor.a.f.a locala2 = (com.himamis.retex.editor.a.f.a)this.c.a_();
      a(locala2, locala2.a(0));
      return;
    }
    while ((!(this.c.a_() instanceof com.himamis.retex.editor.a.f.a)) || ((!((com.himamis.retex.editor.a.f.a)this.c.a_()).l()) && (!((com.himamis.retex.editor.a.f.a)this.c.a_()).n())) || (this.c.s() <= 0));
    int i1 = this.c.s();
    com.himamis.retex.editor.a.f.a locala1 = (com.himamis.retex.editor.a.f.a)this.c.a_();
    com.himamis.retex.editor.a.f.h localh = locala1.a(i1 - 1);
    int i2 = localh.t();
    this.d = 0;
    while (true)
    {
      if (this.c.t() <= 0)
      {
        locala1.b(i1);
        this.c = localh;
        this.d = i2;
        return;
      }
      com.himamis.retex.editor.a.f.d locald = this.c.c(0);
      this.c.a(0);
      localh.b(localh.t(), locald);
    }
  }

  public void m()
  {
    g localg;
    if ((this.c.a_() instanceof g))
    {
      localg = (g)this.c.a_();
      if ("frac".equals(localg.b()))
      {
        if ((this.c.s() != 0) || (localg.a(1).t() != 0))
          break label93;
        int i5 = localg.a(0).t();
        a(localg, this.c);
        this.d = (i5 + this.d);
      }
    }
    label93: 
    do
    {
      do
        return;
      while ((this.c.s() != 0) || (this.c.t() != 0));
      a(localg, localg.a(1));
      return;
      if (((this.c.a_() instanceof com.himamis.retex.editor.a.f.b)) && (this.c.t() == 0))
      {
        com.himamis.retex.editor.a.f.b localb = (com.himamis.retex.editor.a.f.b)this.c.a_();
        int i4 = localb.a(0).t();
        a(localb, localb.a(0));
        this.d = (i4 + this.d);
        return;
      }
      if ((!(this.c.a_() instanceof com.himamis.retex.editor.a.f.a)) || (this.c.a_().t() != 1) || (this.c.t() != 0))
        continue;
      com.himamis.retex.editor.a.f.a locala2 = (com.himamis.retex.editor.a.f.a)this.c.a_();
      int i3 = locala2.a(0).t();
      a(locala2, locala2.a(0));
      this.d = (i3 + this.d);
      return;
    }
    while ((!(this.c.a_() instanceof com.himamis.retex.editor.a.f.a)) || ((!((com.himamis.retex.editor.a.f.a)this.c.a_()).l()) && (!((com.himamis.retex.editor.a.f.a)this.c.a_()).n())) || (1 + this.c.s() >= this.c.a_().t()));
    int i1 = this.c.s();
    com.himamis.retex.editor.a.f.a locala1 = (com.himamis.retex.editor.a.f.a)this.c.a_();
    com.himamis.retex.editor.a.f.h localh = locala1.a(i1 + 1);
    int i2 = this.c.t();
    this.d = 0;
    while (true)
    {
      if (this.c.t() <= 0)
      {
        locala1.b(i1);
        this.c = localh;
        this.d = i2;
        return;
      }
      com.himamis.retex.editor.a.f.d locald = this.c.c(0);
      this.c.a(0);
      localh.b(localh.t(), locald);
    }
  }

  public void n()
  {
    if (this.d > 0)
    {
      this.c.a(-1 + this.d);
      this.d = (-1 + this.d);
      return;
    }
    l();
  }

  public void o()
  {
    if (this.d < this.c.t())
    {
      this.c.a(this.d);
      return;
    }
    m();
  }

  public void p()
  {
    a(false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.b.b
 * JD-Core Version:    0.6.0
 */