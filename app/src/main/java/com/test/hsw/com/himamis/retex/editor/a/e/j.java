package com.himamis.retex.editor.a.e;

import com.himamis.retex.renderer.a.g.a.a;
import com.himamis.retex.renderer.a.v;

public class j extends d
{
  private String d;
  private char e;
  private a f;

  j(String paramString1, String paramString2, String paramString3, char paramChar1, char paramChar2, char paramChar3, int paramInt1, int paramInt2)
  {
    this(paramString1, paramString2, paramString3, paramChar1, paramChar2, paramChar3, v.a(paramInt1), paramInt2);
  }

  j(String paramString1, String paramString2, String paramString3, char paramChar1, char paramChar2, char paramChar3, a parama, int paramInt)
  {
    super(paramString1, paramString2, paramString3, paramChar1, paramChar3, paramInt);
    this.e = paramChar2;
    this.f = parama;
    this.d = paramString2;
  }

  public a g()
  {
    return this.f;
  }

  public char h()
  {
    return this.e;
  }

  public String i()
  {
    return this.d;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.e.j
 * JD-Core Version:    0.6.0
 */