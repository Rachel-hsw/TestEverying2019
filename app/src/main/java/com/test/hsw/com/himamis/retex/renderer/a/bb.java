package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.b.a.c;
import java.util.Map;

public class bb extends d
{
  public i a(dp paramdp)
  {
    dp localdp = paramdp.a(paramdp.m().a());
    localdp.m().b(true);
    float f1 = localdp.m().b();
    dr.a locala = (dr.a)dr.r.get(a.c.a);
    if (locala != null)
      dr.r.put(a.c.a, null);
    cl localcl = (cl)((ch)new dr("\\mathrm{XETL}").u).a;
    if (locala != null)
      dr.r.put(a.c.a, locala);
    at localat = new at(localcl.d().a(localdp));
    localat.a(new cu(0, -0.35F * f1, 0.0F, 0.0F).a(localdp));
    float f2 = new cu(1, 0.45F * f1, 0.0F, 0.0F).a(localdp).c();
    float f3 = new cu(1, 0.5F * f1, 0.0F, 0.0F).a(localdp).c();
    o localo = new o(localdp.m().a('A', "mathnormal", localdp.r().j()));
    localo.d(-f2);
    localat.a(localo);
    localat.a(new cu(0, -0.15F * f1, 0.0F, 0.0F).a(localdp));
    localat.a(localcl.d().a(localdp));
    localat.a(new cu(0, -0.15F * f1, 0.0F, 0.0F).a(localdp));
    i locali = localcl.d().a(localdp);
    locali.d(f3);
    localat.a(locali);
    localat.a(new cu(0, f1 * -0.15F, 0.0F, 0.0F).a(localdp));
    localat.a(localcl.d().a(localdp));
    return localat;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bb
 * JD-Core Version:    0.6.0
 */