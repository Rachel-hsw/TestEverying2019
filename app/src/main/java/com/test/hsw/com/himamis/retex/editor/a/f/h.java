package com.himamis.retex.editor.a.f;

import java.util.ArrayList;

public class h extends e
{
  public h(f paramf)
  {
    super(paramf, 0);
    d(0);
  }

  h(f paramf, int paramInt)
  {
    super(paramf, paramInt);
    d(paramInt);
  }

  public h(f paramf, String paramString)
  {
    this(paramf, paramString.length());
    for (int i = 0; ; i++)
    {
      if (i >= paramString.length())
        return;
      a(i, new c(paramf, paramf.a().b(paramString.charAt(i))));
    }
  }

  public e a(f paramf)
  {
    h localh = new h(paramf);
    for (int i = 0; ; i++)
    {
      if (i >= this.f.size())
        return localh;
      localh.b(i, c(i).a(paramf));
    }
  }

  public void a(int paramInt)
  {
    this.f.remove(paramInt);
  }

  public void a(d paramd)
  {
    if (paramd != null)
      paramd.a(this);
    this.f.add(paramd);
  }

  public boolean a()
  {
    for (int i = 0; ; i++)
    {
      if (i >= t())
        return false;
      if (j(i))
        return true;
      if (((c(i) instanceof g)) && ("^".equals(((g)c(i)).b())))
        return true;
    }
  }

  public void b(int paramInt, d paramd)
  {
    if (paramd != null)
      paramd.a(this);
    this.f.add(paramInt, paramd);
  }

  public boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < t()) && ((c(paramInt) instanceof g)) && (("^".equals(((g)c(paramInt)).b())) || ("_".equals(((g)c(paramInt)).b())));
  }

  public boolean i(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < t()) && ((c(paramInt) instanceof c)) && (((c)c(paramInt)).g());
  }

  public boolean j(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < t()) && ((c(paramInt) instanceof c)) && (((c)c(paramInt)).h());
  }

  public boolean k(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < t()) && ((c(paramInt) instanceof c)) && (((c)c(paramInt)).i());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.f.h
 * JD-Core Version:    0.6.0
 */