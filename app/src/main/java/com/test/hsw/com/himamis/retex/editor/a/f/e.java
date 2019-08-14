package com.himamis.retex.editor.a.f;

import java.util.ArrayList;

public abstract class e extends d
{
  protected ArrayList<d> f = null;

  e(f paramf, int paramInt)
  {
    super(paramf);
    if (paramInt > 0)
      d(paramInt);
  }

  public abstract e a(f paramf);

  public void a(int paramInt, d paramd)
  {
    if (this.f == null)
      this.f = new ArrayList(paramInt + 1);
    if (paramd != null)
      paramd.a(this);
    this.f.set(paramInt, paramd);
  }

  public d c(int paramInt)
  {
    if (this.f != null)
      return (d)this.f.get(paramInt);
    return null;
  }

  protected void d(int paramInt)
  {
    if (this.f == null)
      this.f = new ArrayList(paramInt);
    while (true)
    {
      if (this.f.size() >= paramInt)
      {
        return;
        this.f.ensureCapacity(paramInt);
        continue;
      }
      this.f.add(null);
    }
  }

  public boolean e(int paramInt)
  {
    int i = paramInt + 1;
    if (this.f != null);
    for (int j = this.f.size(); ; j = 0)
    {
      if (i >= j)
        return false;
      if ((c(i) instanceof e))
        return true;
      i++;
      break;
    }
  }

  public int f(int paramInt)
  {
    int i = paramInt + 1;
    if (this.f != null);
    for (int j = this.f.size(); ; j = 0)
    {
      if (i >= j)
        throw new ArrayIndexOutOfBoundsException("Index out of array bounds.");
      if ((c(i) instanceof e))
        return i;
      i++;
      break;
    }
  }

  public boolean g(int paramInt)
  {
    for (int i = paramInt - 1; ; i--)
    {
      if (i < 0)
        return false;
      if ((c(i) instanceof e))
        return true;
    }
  }

  public int h(int paramInt)
  {
    for (int i = paramInt - 1; ; i--)
    {
      if (i < 0)
        throw new ArrayIndexOutOfBoundsException("Index out of array bounds.");
      if ((c(i) instanceof e))
        return i;
    }
  }

  public int t()
  {
    if (this.f != null)
      return this.f.size();
    return 0;
  }

  public int u()
  {
    return f(-1);
  }

  public int v()
  {
    if (this.f != null);
    for (int i = this.f.size(); ; i = 0)
      return h(i);
  }

  public boolean w()
  {
    int i = 0;
    if (this.f != null);
    for (int j = this.f.size(); ; j = 0)
    {
      if (i >= j)
        return false;
      if ((c(i) instanceof e))
        return true;
      i++;
      break;
    }
  }

  public int x()
  {
    return 0;
  }

  public int y()
  {
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.f.e
 * JD-Core Version:    0.6.0
 */