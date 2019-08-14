package com.himamis.retex.renderer.android.a;

import android.graphics.Typeface;
import com.himamis.retex.renderer.a.g.a.e;
import java.util.Map;

public class a
  implements com.himamis.retex.renderer.a.g.a.a
{
  private Typeface d;
  private int e;
  private String f;

  public a(String paramString, int paramInt1, int paramInt2)
  {
    this.d = Typeface.create(paramString, b(paramInt1));
    this.f = paramString;
    this.e = paramInt2;
  }

  public a(String paramString, Typeface paramTypeface, int paramInt)
  {
    this.f = paramString;
    this.d = paramTypeface;
    this.e = paramInt;
  }

  private static int b(int paramInt)
  {
    if (paramInt == 1)
      return 1;
    if (paramInt == 2)
      return 2;
    if (paramInt == 3)
      return 3;
    return 0;
  }

  public Typeface a()
  {
    return this.d;
  }

  public com.himamis.retex.renderer.a.g.a.a a(int paramInt)
  {
    return null;
  }

  public com.himamis.retex.renderer.a.g.a.a a(Map<e, Object> paramMap)
  {
    return null;
  }

  public int b()
  {
    return this.e;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.a.a
 * JD-Core Version:    0.6.0
 */