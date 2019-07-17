package com.umeng.socialize.controller.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.umeng.socialize.bean.aw;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.AuthService;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import com.umeng.socialize.sso.v;
import com.umeng.socialize.view.aa;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
  implements AuthService
{
  ay a;
  ax b = ax.b();
  private Map<String, String> c;
  private Map<String, Object> d;
  private final String e = c.class.getSimpleName();

  public c(ay paramay)
  {
    this.a = paramay;
  }

  private void a(Activity paramActivity, p paramp, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    this.a.a(paramActivity.getApplicationContext(), paramp, 18);
    g localg = new g(this, paramActivity, paramUMAuthListener);
    aa localaa = new aa(paramActivity, this.a, paramp, localg);
    if (localg != null)
      localg.b(paramp);
    com.umeng.socialize.utils.m.b(localaa);
  }

  private void a(Activity paramActivity, p paramp, SocializeListeners.UMAuthListener paramUMAuthListener, v paramv)
  {
    this.a.a(paramActivity, paramp, 12);
    a locala = new a(paramActivity, paramp, new h(this, paramUMAuthListener, paramActivity), paramv);
    if ((this.c == null) || (this.d == null))
    {
      this.c = com.umeng.socialize.utils.m.f(paramActivity);
      this.d = com.umeng.socialize.utils.m.e(paramActivity);
    }
    if (a(paramp))
    {
      v localv = this.b.a(paramp.c());
      String str1 = "";
      String str2 = "";
      if ((paramp == p.i) || (paramp == p.j))
      {
        str1 = (String)localv.H.get("wx_appid");
        str2 = (String)localv.H.get("wx_secret");
        this.a.a("wx_appid", str1);
        this.a.a("wx_secret", str2);
      }
      while (true)
      {
        Map localMap = this.d;
        String str3 = null;
        if (localMap != null)
        {
          Object localObject = this.d.get(paramp.toString());
          str3 = null;
          if (localObject != null)
            str3 = this.d.get(paramp.toString()).toString();
        }
        if (str1.equals(str3))
          break;
        this.d.put(paramp.toString(), str1);
        this.c.put(paramp.toString(), str2);
        com.umeng.socialize.utils.m.a(paramActivity, this.d);
        com.umeng.socialize.utils.m.b(paramActivity, this.c);
        a(paramActivity, this.d, locala);
        return;
        if ((paramp != p.g) && (paramp != p.f))
          continue;
        str1 = (String)localv.H.get("qzone_id");
        str2 = (String)localv.H.get("qzone_secret");
        this.a.a("qzone_id", str1);
        this.a.a("qzone_secret", str2);
      }
    }
    if (b(paramp))
    {
      locala.b();
      locala.a(200, this.d);
      a(paramActivity, com.umeng.socialize.utils.d.c());
      return;
    }
    a(paramActivity, locala);
  }

  private void a(Context paramContext, p paramp, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("usid");
    String str2 = paramBundle.getString("access_key");
    String str3 = paramBundle.getString("access_secret");
    String str4 = paramBundle.getString("access_token");
    String str5 = paramBundle.getString("uid");
    if ((!TextUtils.isEmpty(str1)) && (paramp == p.k))
    {
      str5 = this.a.c("user_id");
      paramBundle.putString("uid", str5);
    }
    if (TextUtils.isEmpty(str3))
      str3 = paramBundle.getString("openid");
    String str6 = paramBundle.getString("expires_in");
    if (TextUtils.isEmpty(str6))
      str6 = this.a.c("expires_in");
    com.umeng.socialize.utils.k.a(paramContext, paramp, str6);
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
      com.umeng.socialize.utils.k.a(paramContext, paramp, str2, str3);
    if (!TextUtils.isEmpty(str5))
      com.umeng.socialize.utils.k.b(paramContext, paramp, str5);
    if ((paramp != null) && (!TextUtils.isEmpty(str4)))
      com.umeng.socialize.utils.k.a(paramContext, paramp, str4, "null");
    if ((paramp == p.i) || (paramp == p.j))
    {
      com.umeng.socialize.utils.k.c(paramContext, paramp, paramBundle.getString("refresh_token"));
      com.umeng.socialize.utils.k.a(paramContext, paramp, paramBundle.getLong("refresh_token_expires"));
    }
  }

  private void a(Context paramContext, Map<String, Object> paramMap, SocializeListeners.UMDataListener paramUMDataListener)
  {
    new i(this, paramContext, paramUMDataListener, paramMap).c();
  }

  private boolean a(Context paramContext, p paramp)
  {
    aw localaw = (aw)this.b.c().get(paramp.toString());
    if (!paramp.b())
    {
      if (localaw != null)
        Toast.makeText(paramContext, localaw.b + "不支持授权.", 0).show();
      return false;
    }
    return true;
  }

  private boolean a(p paramp)
  {
    return (paramp == p.i) || (paramp == p.j) || (paramp == p.g) || (paramp == p.f);
  }

  private p[] a(p[] paramArrayOfp)
  {
    int i = 0;
    if ((paramArrayOfp == null) || (paramArrayOfp.length == 0))
      return new p[0];
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfp.length;
    if (i < j)
    {
      p localp = paramArrayOfp[i];
      if (localp.b())
        localArrayList.add(localp);
      while (true)
      {
        i++;
        break;
        com.umeng.socialize.utils.i.e(this.e, localp.toString() + "does't support to Token expires check");
      }
    }
    if (localArrayList.contains(p.m))
    {
      localArrayList.remove(p.m);
      com.umeng.socialize.utils.i.e(this.e, "facebook does't support to Token expires check");
    }
    return (p[])localArrayList.toArray(new p[localArrayList.size()]);
  }

  private SocializeListeners.UMAuthListener b(Context paramContext, p paramp, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    return new f(this, paramContext, paramUMAuthListener, (SocializeListeners.UMAuthListener[])this.b.a(SocializeListeners.UMAuthListener.class));
  }

  private boolean b(Context paramContext, p paramp)
  {
    boolean bool = true;
    if (paramp == p.e)
      bool = ax.a(paramContext);
    do
    {
      return bool;
      if (paramp == p.k)
        return ax.c(paramContext);
      if (paramp != p.h)
        continue;
      v localv = this.b.a(p.h.c());
      if (localv == null)
        return false;
      return localv.e();
    }
    while ((paramp == p.i) || (paramp != p.j));
    return bool;
  }

  private boolean b(p paramp)
  {
    String str = paramp.toString();
    return (this.d != null) && (this.d.size() > 0) && (this.d.containsKey(str)) && (!TextUtils.isEmpty(this.d.get(str).toString())) && (this.c != null) && (this.c.size() > 0) && (this.c.containsKey(str)) && (!TextUtils.isEmpty((CharSequence)this.c.get(str)));
  }

  private boolean c(p paramp)
  {
    return (paramp == p.m) || (paramp == p.i) || (paramp == p.j);
  }

  public int a(Context paramContext, bf parambf)
  {
    if ((parambf != null) && (parambf.j()))
    {
      com.umeng.socialize.b.h localh = (com.umeng.socialize.b.h)new com.umeng.socialize.b.a.a().a(new com.umeng.socialize.b.g(paramContext, this.a, parambf));
      if (localh != null)
      {
        if ((this.a != null) && (!TextUtils.isEmpty(localh.a)))
        {
          this.a.a("user_id", localh.a);
          this.a.a("sina_expires_in", localh.b);
        }
        return localh.n;
      }
      return -102;
    }
    return -105;
  }

  public void a(Context paramContext, bf parambf, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    new k(this, new j(this, paramSocializeClientListener, parambf, paramContext), paramContext, parambf).c();
  }

  public void a(Context paramContext, p paramp, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    if ((paramp == p.m) || (paramp == p.i) || (paramp == p.j))
    {
      v localv = this.b.a(paramp.c());
      if (localv != null)
      {
        localv.a(this.a, paramp, paramSocializeClientListener);
        return;
      }
    }
    new e(this, paramSocializeClientListener, paramContext, paramp).c();
  }

  public void a(Context paramContext, p paramp, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    Context localContext = paramContext.getApplicationContext();
    if (!com.umeng.socialize.utils.m.a(localContext, paramp));
    do
    {
      return;
      if (paramUMAuthListener == null)
        paramUMAuthListener = com.umeng.socialize.utils.d.b();
      this.a.a(localContext, paramp, 3);
    }
    while (!a(localContext, paramp));
    SocializeListeners.UMAuthListener localUMAuthListener = b(localContext, paramp, paramUMAuthListener);
    v localv = this.b.a(paramp.c());
    com.umeng.socialize.utils.i.c(this.e, "######## doOauthVerify -->  " + paramp.toString());
    if (!(paramContext instanceof Activity))
    {
      com.umeng.socialize.utils.i.b(this.e, "传入参数必须为Activity实例");
      return;
    }
    Activity localActivity = (Activity)paramContext;
    if ((paramp == p.m) && (localv != null))
    {
      localv.a(localActivity, paramUMAuthListener);
      return;
    }
    if ((localv != null) && (b(localContext, paramp)))
    {
      ax.e(paramp);
      a(localActivity, paramp, localUMAuthListener, localv);
      return;
    }
    a(localActivity, paramp, localUMAuthListener);
  }

  public void a(Context paramContext, SocializeListeners.UMDataListener paramUMDataListener)
  {
    new d(this, paramUMDataListener, paramContext).c();
  }

  public void a(Context paramContext, p[] paramArrayOfp, SocializeListeners.UMDataListener paramUMDataListener)
  {
    new l(this, paramUMDataListener, paramContext, a(paramArrayOfp)).c();
  }

  private class a
    implements SocializeListeners.UMDataListener
  {
    p a;
    SocializeListeners.UMAuthListener b;
    v c;
    Activity d;
    Bundle e;
    SocializeListeners.UMAuthListener f;

    public a(Activity paramp, p paramUMAuthListener, SocializeListeners.UMAuthListener paramv, v arg5)
    {
      this.a = paramUMAuthListener;
      this.b = paramv;
      Object localObject;
      this.c = localObject;
      this.d = paramp;
      this.f = c();
    }

    private SocializeListeners.UMAuthListener c()
    {
      return new m(this);
    }

    protected SocializeListeners.SocializeClientListener a()
    {
      return new n(this);
    }

    public void a(int paramInt, Map<String, Object> paramMap)
    {
      String str1 = this.a.toString();
      int i;
      String str3;
      if ((paramMap != null) && (paramMap.containsKey(str1)))
      {
        i = 1;
        if ((i == 0) && (!c.a(c.this, this.a)))
          break label168;
        if (i != 0)
        {
          String str2 = paramMap.get(str1).toString();
          if (c.a(c.this) == null)
            break label161;
          str3 = (String)c.a(c.this).get(str1);
          label89: this.c.H.put("appKey", str2);
          this.c.H.put("appSecret", str3);
          if (v.B == null)
            v.B = c.this.a;
        }
        this.c.a(this.d, this.f);
      }
      label161: label168: 
      do
      {
        return;
        i = 0;
        break;
        str3 = "";
        break label89;
      }
      while (this.b == null);
      this.b.a(new com.umeng.socialize.a.a("no appkey on " + str1), this.a);
    }

    public void b()
    {
      if (this.b != null)
        this.b.b(this.a);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.c
 * JD-Core Version:    0.6.0
 */