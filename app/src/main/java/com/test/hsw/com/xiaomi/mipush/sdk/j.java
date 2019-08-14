package com.xiaomi.mipush.sdk;

import com.xiaomi.f.a.a;
import com.xiaomi.f.a.i;
import com.xiaomi.push.service.w;
import java.util.HashMap;
import java.util.Map;

final class j
  implements Runnable
{
  public void run()
  {
    if (w.b(d.b()) != null)
    {
      i locali = new i();
      locali.b(h.a(d.b()).c());
      locali.c("client_info_update");
      locali.a(d.a());
      locali.a(new HashMap());
      locali.h().put("imei_md5", com.xiaomi.a.a.g.d.a(w.b(d.b())));
      n.a(d.b()).a(locali, a.i, false, null);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.j
 * JD-Core Version:    0.6.0
 */