package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.c;
import com.himamis.retex.renderer.a.g.c.e;
import com.himamis.retex.renderer.a.g.c.g;
import java.util.Map;

public class ap extends d
{
  private g a = null;
  private g b;
  private e f;
  private int g;
  private int h;
  private d i;
  private boolean j = true;
  private int k = -1;

  public ap(String paramString1, String paramString2)
  {
    this.a = new com.himamis.retex.renderer.a.g.d().a(paramString1);
    d();
    a(paramString2);
  }

  public i a(dp paramdp)
  {
    if (this.a != null)
    {
      if (this.j)
      {
        this.j = false;
        return this.i.a(paramdp);
      }
      paramdp.a = true;
      float f1 = this.g * cu.a(2, paramdp);
      float f2 = this.h * cu.a(2, paramdp);
      return new aq(this.b, f1, f2, paramdp.i(), this.k);
    }
    return new dr("\\text{ No such image file ! }").u.a(paramdp);
  }

  protected void a(String paramString)
  {
    this.i = this;
    Map localMap = bw.a(paramString);
    if ((localMap.containsKey("width")) || (localMap.containsKey("height")))
      this.i = new cg(this.i, (String)localMap.get("width"), (String)localMap.get("height"), localMap.containsKey("keepaspectratio"));
    if (localMap.containsKey("scale"))
    {
      double d = Double.parseDouble((String)localMap.get("scale"));
      this.i = new cn(this.i, d, d);
    }
    if ((localMap.containsKey("angle")) || (localMap.containsKey("origin")))
      this.i = new ci(this.i, (String)localMap.get("angle"), (String)localMap.get("origin"));
    String str;
    if (localMap.containsKey("interpolation"))
    {
      str = (String)localMap.get("interpolation");
      if (!str.equalsIgnoreCase("bilinear"))
        break label220;
      this.k = 0;
    }
    label220: 
    do
    {
      return;
      if (!str.equalsIgnoreCase("bicubic"))
        continue;
      this.k = 2;
      return;
    }
    while (!str.equalsIgnoreCase("nearest_neighbor"));
    this.k = 1;
  }

  public void d()
  {
    if (this.a != null)
    {
      this.g = this.a.a();
      this.h = this.a.b();
      this.b = new com.himamis.retex.renderer.a.g.d().b(this.g, this.h, 2);
      c localc = this.b.c();
      localc.a(this.a, 0, 0);
      localc.f();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ap
 * JD-Core Version:    0.6.0
 */