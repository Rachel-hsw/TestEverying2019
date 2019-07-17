package com.himamis.retex.renderer.android.c;

import android.graphics.Color;

public class b
  implements com.himamis.retex.renderer.a.g.c.b
{
  private int a;

  public b(int paramInt)
  {
    this.a = paramInt;
  }

  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = Color.rgb(paramInt1, paramInt2, paramInt3);
  }

  public Object a()
  {
    return new Integer(this.a);
  }

  public int b()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    b localb;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localb = (b)paramObject;
    }
    while (this.a == localb.a);
    return false;
  }

  public int hashCode()
  {
    return 31 + this.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.c.b
 * JD-Core Version:    0.6.0
 */