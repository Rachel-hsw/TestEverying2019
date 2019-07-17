package org.android.agoo.impl;

import android.content.Context;
import com.umeng.message.b.af;
import com.umeng.message.b.co;
import org.android.agoo.c.c.a;
import org.android.agoo.c.c.c;
import org.android.agoo.c.c.d;
import org.android.agoo.c.c.i;
import org.android.agoo.client.f;
import org.android.agoo.client.g;

public final class MtopService
  implements org.android.agoo.b
{
  public final org.android.agoo.client.h getV3(Context paramContext, f paramf)
  {
    org.android.agoo.client.h localh1 = null;
    if (paramContext != null)
    {
      localh1 = null;
      if (paramf == null);
    }
    org.android.agoo.client.h localh2;
    try
    {
      d locald = new d();
      locald.c(paramf.e());
      locald.d(paramf.f());
      locald.a(org.android.agoo.client.b.getRegistrationId(paramContext));
      if (!co.a(paramf.g()))
        locald.e(paramf.g());
      locald.g(af.f(paramContext));
      locald.h(af.j(paramContext));
      locald.b(paramf.i());
      locald.a(paramf.c());
      org.android.agoo.c.c.h localh = new org.android.agoo.c.c.h();
      localh.c(af.G(paramContext));
      i locali = localh.a(paramContext, locald);
      localh1 = null;
      if (locali != null)
      {
        localh1 = new org.android.agoo.client.h();
        localh1.a(locali.b());
        localh1.a(locali.c());
        localh1.b(locali.d());
        localh1.c(locali.e());
      }
      return localh1;
    }
    catch (Throwable localThrowable)
    {
      localh2 = new org.android.agoo.client.h();
      localh2.a(false);
      localh2.b(localThrowable.getMessage());
    }
    return localh2;
  }

  public final void sendMtop(Context paramContext, f paramf)
  {
    if ((paramContext != null) && (paramf != null));
    try
    {
      d locald = new d();
      locald.c(paramf.e());
      locald.d(paramf.f());
      locald.a(org.android.agoo.client.b.getRegistrationId(paramContext));
      if (!co.a(paramf.g()))
        locald.e(paramf.g());
      locald.b(paramf.i());
      locald.a(paramf.c());
      c localc = new c();
      localc.a(af.f(paramContext));
      localc.b(af.j(paramContext));
      localc.c(af.G(paramContext));
      localc.a(paramContext, locald, new MtopService.2(this));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void sendMtop(Context paramContext, f paramf, g paramg)
  {
    if ((paramContext != null) && (paramf != null) && (paramg != null));
    try
    {
      d locald = new d();
      locald.c(paramf.e());
      locald.d(paramf.f());
      locald.a(org.android.agoo.client.b.getRegistrationId(paramContext));
      if (!co.a(paramf.g()))
        locald.e(paramf.g());
      locald.b(paramf.i());
      locald.a(paramf.c());
      c localc = new c();
      localc.a(af.f(paramContext));
      localc.b(af.j(paramContext));
      localc.c(af.G(paramContext));
      localc.a(paramContext, locald, new MtopService.1(this, paramg));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.impl.MtopService
 * JD-Core Version:    0.6.0
 */