package com.himamis.retex.renderer.a;

public class bk extends d
{
  protected int a;
  protected int b;
  protected float f = 0.0F;
  protected d g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;

  public bk(int paramInt, String paramString, d paramd)
  {
    if (paramInt >= 1);
    while (true)
    {
      this.a = paramInt;
      this.g = paramd;
      this.b = a(paramString);
      return;
      paramInt = 1;
    }
  }

  private int a(String paramString)
  {
    int m = paramString.length();
    int n = 1;
    int i1 = 2;
    int i2 = 0;
    if (i2 >= m)
      return i1;
    switch (paramString.charAt(i2))
    {
    default:
    case 'l':
    case 'r':
    case 'c':
    case '|':
    }
    label173: 
    while (true)
    {
      i2++;
      break;
      n = 0;
      i1 = 0;
      continue;
      i1 = 1;
      n = 0;
      continue;
      i1 = 2;
      n = 0;
      continue;
      if (n != 0)
        this.h = 1;
      while (true)
      {
        i2++;
        if (i2 >= m)
          break label173;
        if (paramString.charAt(i2) != '|')
        {
          i2--;
          break;
          this.i = 1;
          continue;
        }
        if (n != 0)
        {
          this.h = (1 + this.h);
          continue;
        }
        this.i = (1 + this.i);
      }
    }
  }

  public i a(dp paramdp)
  {
    if (this.f == 0.0F);
    for (Object localObject = this.g.a(paramdp); ; localObject = new at(this.g.a(paramdp), this.f, this.b))
    {
      ((i)localObject).j = 12;
      return localObject;
    }
  }

  public void a(float paramFloat)
  {
    this.f = paramFloat;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
  }

  public int d()
  {
    return this.a;
  }

  public boolean e()
  {
    return this.i != 0;
  }

  public int f()
  {
    return this.j;
  }

  public int g()
  {
    return this.k;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bk
 * JD-Core Version:    0.6.0
 */