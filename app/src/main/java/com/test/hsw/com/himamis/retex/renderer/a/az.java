package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.a.a;
import com.himamis.retex.renderer.a.g.a.e;
import com.himamis.retex.renderer.a.g.b;
import com.himamis.retex.renderer.a.g.c.c;
import java.util.HashMap;
import java.util.Map;

public class az extends i
{
  private static final c o = new com.himamis.retex.renderer.a.g.d().a(1, 1).c();
  private static final b p = new b();
  private static a q = p.a("Serif", 0, 10);
  private static e u;
  private static Integer v;
  private static e w;
  private static Integer x;
  private String r;
  private com.himamis.retex.renderer.a.g.a.g s;
  private float t;

  static
  {
    try
    {
      u = p.b("KERNING");
      v = p.c("KERNING_ON");
      w = p.b("LIGATURES");
      x = p.c("LIGATURES_ON");
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public az(String paramString, int paramInt, float paramFloat)
  {
    this(paramString, paramInt, paramFloat, q, true);
  }

  public az(String paramString, int paramInt, float paramFloat, a parama, boolean paramBoolean)
  {
    this.r = paramString;
    this.t = paramFloat;
    if ((paramBoolean) && (u != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(u, v);
      localHashMap.put(w, x);
      parama = parama.a(localHashMap);
    }
    this.s = p.a(paramString, parama.a(paramInt), o.e());
    com.himamis.retex.renderer.a.g.b.d locald = this.s.a();
    this.g = (float)(-locald.c() * paramFloat / 10.0D);
    this.h = ((float)(locald.e() * paramFloat / 10.0D) - this.g);
    this.f = (float)((0.4000000059604645D + (locald.d() + locald.b())) * paramFloat / 10.0D);
  }

  public static void a(String paramString)
  {
    q = p.a(paramString, 0, 10);
  }

  public void a(c paramc, float paramFloat1, float paramFloat2)
  {
    c(paramc, paramFloat1, paramFloat2);
    paramc.a(paramFloat1, paramFloat2);
    paramc.b(0.1D * this.t, 0.1D * this.t);
    this.s.a(paramc, 0, 0);
    paramc.b(10.0F / this.t, 10.0F / this.t);
    paramc.a(-paramFloat1, -paramFloat2);
  }

  public int h()
  {
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.az
 * JD-Core Version:    0.6.0
 */