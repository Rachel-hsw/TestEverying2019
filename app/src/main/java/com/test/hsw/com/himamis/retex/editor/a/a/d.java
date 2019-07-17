package com.himamis.retex.editor.a.a;

import com.himamis.retex.editor.a.f.a;
import com.himamis.retex.editor.a.f.b;
import com.himamis.retex.editor.a.f.e;
import com.himamis.retex.editor.a.f.f;
import com.himamis.retex.editor.a.f.g;
import com.himamis.retex.editor.a.f.h;

public abstract class d
  implements c
{
  protected h a = null;
  protected int b = 0;
  protected boolean c = true;

  public String a(e parame, h paramh, int paramInt)
  {
    this.a = paramh;
    this.b = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    a(parame, localStringBuilder);
    return localStringBuilder.toString();
  }

  public String a(f paramf)
  {
    return a(paramf, null, 0);
  }

  public String a(f paramf, h paramh, int paramInt)
  {
    this.a = paramh;
    this.b = paramInt;
    if (paramh != null);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      StringBuilder localStringBuilder = new StringBuilder();
      a(paramf.b(), localStringBuilder);
      return localStringBuilder.toString();
    }
  }

  abstract void a(a parama, StringBuilder paramStringBuilder);

  abstract void a(b paramb, StringBuilder paramStringBuilder);

  abstract void a(com.himamis.retex.editor.a.f.c paramc, StringBuilder paramStringBuilder);

  public void a(com.himamis.retex.editor.a.f.d paramd, StringBuilder paramStringBuilder)
  {
    if ((paramd instanceof com.himamis.retex.editor.a.f.c))
      a((com.himamis.retex.editor.a.f.c)paramd, paramStringBuilder);
    do
    {
      return;
      if ((paramd instanceof h))
      {
        a((h)paramd, paramStringBuilder);
        return;
      }
      if ((paramd instanceof a))
      {
        a((a)paramd, paramStringBuilder);
        return;
      }
      if (!(paramd instanceof b))
        continue;
      a((b)paramd, paramStringBuilder);
      return;
    }
    while (!(paramd instanceof g));
    a((g)paramd, paramStringBuilder);
  }

  abstract void a(g paramg, StringBuilder paramStringBuilder);

  abstract void a(h paramh, StringBuilder paramStringBuilder);

  abstract void a(h paramh, StringBuilder paramStringBuilder, int paramInt1, int paramInt2);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.a.d
 * JD-Core Version:    0.6.0
 */