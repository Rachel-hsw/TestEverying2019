package com.himamis.retex.editor.a.f;

import com.himamis.retex.editor.a.a.b;

public class f
{
  private com.himamis.retex.editor.a.e.h a;
  private h b;

  public f(com.himamis.retex.editor.a.e.h paramh)
  {
    this.a = paramh;
  }

  public static f a(com.himamis.retex.editor.a.e.h paramh)
  {
    f localf = new f(paramh);
    localf.a(new h(localf));
    return localf;
  }

  public static f a(com.himamis.retex.editor.a.e.h paramh, b paramb, String paramString)
  {
    if ((paramString == null) || (paramb == null))
      return a(paramh);
    return paramb.a(paramh, paramString);
  }

  public com.himamis.retex.editor.a.e.h a()
  {
    return this.a;
  }

  public void a(h paramh)
  {
    this.b = paramh;
    paramh.a(null);
  }

  public h b()
  {
    return this.b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.f.f
 * JD-Core Version:    0.6.0
 */