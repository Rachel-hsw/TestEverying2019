package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.n;
import java.util.HashMap;

public class be
{
  public static HashMap<String, be> a = new HashMap(300);
  public static HashMap<String, Object> b = new HashMap();
  public int c;
  public boolean d = false;
  public int e;
  public bd f;

  public be(int paramInt)
  {
    this(null, paramInt);
  }

  public be(int paramInt1, int paramInt2)
  {
    this(null, paramInt1, paramInt2);
  }

  public be(bd parambd, int paramInt)
  {
    this.f = parambd;
    this.c = paramInt;
  }

  public be(bd parambd, int paramInt1, int paramInt2)
  {
    this(parambd, paramInt1);
    this.e = paramInt2;
    this.d = true;
  }

  public Object a(dv paramdv, String[] paramArrayOfString)
    throws n
  {
    return this.f.a(paramdv, paramArrayOfString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.be
 * JD-Core Version:    0.6.0
 */