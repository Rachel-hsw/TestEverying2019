package com.umeng.socialize.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.umeng.socialize.bean.aw;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.a;
import com.umeng.socialize.utils.m;
import com.umeng.socialize.view.abs.SocialPopupDialog;
import com.umeng.socialize.view.abs.SocialPopupDialog.a;
import com.umeng.socialize.view.abs.SocialPopupDialog.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class a
{
  private SocialPopupDialog a;
  private Context b;
  private UMSocialService c;
  private List<aw> d;
  private Map<aw, View> e;
  private SocializeListeners.a f;

  public a(Context paramContext, String paramString, SocializeListeners.a parama)
  {
    this.b = paramContext;
    this.f = parama;
    this.c = com.umeng.socialize.controller.a.a(paramString);
    this.d = com.umeng.socialize.common.p.a(paramContext, this.c.c());
    this.e = a(this.d);
    b localb = new b(this, paramContext, paramContext);
    Set localSet = this.e.keySet();
    if ((localSet == null) || (localSet.size() == 0))
      localb.a(8);
    while (true)
    {
      localb.a(paramContext.getResources().getString(com.umeng.socialize.common.b.a(paramContext, b.a.e, "umeng_socialize_text_choose_account")));
      localb.b(0);
      localb.b("");
      SocialPopupDialog.b localb1 = new SocialPopupDialog.b(paramContext);
      localb1.a(com.umeng.socialize.common.b.a(paramContext, b.a.c, "umeng_socialize_default_avatar"));
      localb1.a(paramContext.getResources().getString(com.umeng.socialize.common.b.a(paramContext, b.a.e, "umeng_socialize_text_visitor")));
      localb1.a(new d(this));
      localb.b(localb1.a(), null);
      if (m.d(paramContext))
      {
        int[] arrayOfInt = m.c(paramContext);
        localb.a(arrayOfInt[0], arrayOfInt[1]);
      }
      this.a = localb.a();
      if ((paramContext instanceof Activity))
        this.a.setOwnerActivity((Activity)paramContext);
      this.a.a(new e(this));
      return;
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        aw localaw = (aw)localIterator.next();
        localb.a((View)this.e.get(localaw), null);
      }
    }
  }

  private Map<aw, View> a(List<aw> paramList)
  {
    Map localMap = c();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      aw localaw = (aw)localIterator.next();
      SocialPopupDialog.b localb = new SocialPopupDialog.b(this.b);
      if (localaw.a.equals("qzone"))
      {
        localb.a(com.umeng.socialize.common.b.a(this.b, b.a.c, "umeng_socialize_qzone_on"));
        localb.a(this.b.getResources().getString(com.umeng.socialize.common.b.a(this.b, b.a.e, "umeng_socialize_login_qq")));
      }
      while (true)
      {
        localb.a(new f(this, localaw));
        localMap.put(localaw, localb.a());
        break;
        localb.a(localaw.c);
        localb.a(localaw.b);
      }
    }
    return localMap;
  }

  private void a(com.umeng.socialize.bean.p paramp)
  {
    if (paramp != null)
    {
      this.c.b(this.b, paramp, new h(this, paramp));
      return;
    }
    this.c.e(this.b, new i(this));
  }

  public void a()
  {
    if ((com.umeng.socialize.utils.j.c(this.b)) || (com.umeng.socialize.utils.j.d(this.b)))
    {
      if (this.f != null)
        this.f.a(com.umeng.socialize.utils.j.b(this.b), true);
      return;
    }
    m.b(this.a);
  }

  public void b()
  {
    m.a(this.a);
  }

  public Map<aw, View> c()
  {
    return new TreeMap(new j(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.a
 * JD-Core Version:    0.6.0
 */