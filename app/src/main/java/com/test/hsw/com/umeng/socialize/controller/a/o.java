package com.umeng.socialize.controller.a;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Toast;
import com.umeng.socialize.b.a.f;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.as;
import com.umeng.socialize.bean.aw;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.controller.ShareService;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMShareBoardListener;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.utils.d;
import com.umeng.socialize.utils.h;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;
import com.umeng.socialize.view.ShareActivity;
import com.umeng.socialize.view.ak;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class o
  implements ShareService
{
  public static SocializeListeners.SnsPostListener d = null;
  ay a;
  UMSocialService b;
  ax c = ax.b();
  private boolean e = false;
  private ak f = null;
  private boolean g = false;
  private final String h = o.class.getSimpleName();
  private SocializeListeners.UMShareBoardListener i;

  public o(ay paramay)
  {
    this.a = paramay;
  }

  private com.umeng.socialize.bean.k a(Context paramContext, ar[] paramArrayOfar, UMShareMsg paramUMShareMsg)
  {
    if (paramUMShareMsg == null)
      return new com.umeng.socialize.bean.k(-102);
    String str = paramUMShareMsg.d;
    if ((paramArrayOfar == null) || (paramArrayOfar.length < 1))
      return new com.umeng.socialize.bean.k(-105);
    if (!TextUtils.isEmpty(str))
    {
      f localf = new com.umeng.socialize.b.a.a().a(new com.umeng.socialize.b.r(paramContext, this.a, paramArrayOfar[0].a, paramArrayOfar[0].b, paramUMShareMsg));
      if (localf == null)
        return new com.umeng.socialize.bean.k(-103);
      return new com.umeng.socialize.bean.k(localf.n, localf.m);
    }
    com.umeng.socialize.b.q localq = (com.umeng.socialize.b.q)new com.umeng.socialize.b.a.a().a(new com.umeng.socialize.b.p(paramContext, this.a, paramArrayOfar, paramUMShareMsg));
    if (localq == null)
      return new com.umeng.socialize.bean.k(-103);
    i.c("", "#### ShareMultiResponse toString : " + localq.toString());
    if (localq.c != null)
      this.a.a(localq.c.toString(), localq.b);
    com.umeng.socialize.bean.k localk = new com.umeng.socialize.bean.k(localq.n, localq.m);
    localk.a(localq.a);
    return localk;
  }

  private Object a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = Class.forName(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return null;
    }
    catch (InstantiationException localInstantiationException)
    {
      while (true)
        localInstantiationException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        localIllegalAccessException.printStackTrace();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        localIllegalArgumentException.printStackTrace();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        localInvocationTargetException.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        localClassNotFoundException.printStackTrace();
    }
  }

  private void a(Activity paramActivity)
  {
    b(paramActivity);
    c(paramActivity);
    ax localax = ax.b();
    com.umeng.socialize.bean.p[] arrayOfp = new com.umeng.socialize.bean.p[2];
    arrayOfp[0] = com.umeng.socialize.bean.p.l;
    arrayOfp[1] = com.umeng.socialize.bean.p.h;
    localax.b(arrayOfp);
  }

  private void a(Context paramContext, b paramb)
  {
    new t(this, paramb, paramContext).c();
  }

  private void a(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
  }

  private void b(Activity paramActivity)
  {
    Class[] arrayOfClass1 = { Context.class, String.class, String.class };
    Object[] arrayOfObject1 = { paramActivity, "deault_id", "deault_id" };
    Class[] arrayOfClass2 = new Class[1];
    arrayOfClass2[0] = Boolean.TYPE;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Boolean.valueOf(true);
    if (this.c.a(com.umeng.socialize.bean.p.i.c()) == null)
    {
      Object localObject2 = a("com.umeng.socialize.weixin.controller.UMWXHandler", arrayOfClass1, arrayOfObject1);
      if (localObject2 != null)
        a(localObject2, "addToSocialSDK", null, null);
    }
    if (this.c.a(com.umeng.socialize.bean.p.j.c()) == null)
    {
      Object localObject1 = a("com.umeng.socialize.weixin.controller.UMWXHandler", arrayOfClass1, arrayOfObject1);
      if (localObject1 != null)
      {
        a(localObject1, "setToCircle", arrayOfClass2, arrayOfObject2);
        a(localObject1, "addToSocialSDK", null, null);
      }
    }
  }

  private void b(Activity paramActivity, String paramString, byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(paramString))
      this.b.a(paramString);
    if (paramArrayOfByte != null)
    {
      this.b.a(new UMImage(paramActivity, paramArrayOfByte));
      return;
    }
    this.b.a(null);
  }

  private final void c()
  {
    if ((this.b == null) && (this.a != null))
      this.b = com.umeng.socialize.controller.a.a(this.a.c);
  }

  private void c(Activity paramActivity)
  {
    Class[] arrayOfClass = { Activity.class, String.class, String.class };
    Object[] arrayOfObject = { paramActivity, "deault_id", "deault_id" };
    if (this.c.a(com.umeng.socialize.bean.p.f.c()) == null)
    {
      Object localObject2 = a("com.umeng.socialize.sso.QZoneSsoHandler", arrayOfClass, arrayOfObject);
      if (localObject2 != null)
        a(localObject2, "addToSocialSDK", null, null);
    }
    if (this.c.a(com.umeng.socialize.bean.p.g.c()) == null)
    {
      Object localObject1 = a("com.umeng.socialize.sso.UMQQSsoHandler", arrayOfClass, arrayOfObject);
      if (localObject1 != null)
        a(localObject1, "addToSocialSDK", null, null);
    }
  }

  private void c(Context paramContext, com.umeng.socialize.bean.p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    Intent localIntent = new Intent(paramContext, ShareActivity.class);
    localIntent.putExtra("dc", this.a.c);
    localIntent.putExtra("sns", paramp.toString());
    if (com.umeng.socialize.utils.k.b(paramContext, paramp))
    {
      if (this.e)
      {
        String str = com.umeng.socialize.utils.k.e(paramContext, paramp);
        this.e = false;
        a(paramContext, str, paramp, paramSnsPostListener);
        return;
      }
      if (this.c.c(paramSnsPostListener) <= 0)
        this.c.b(paramSnsPostListener);
      paramContext.startActivity(localIntent);
      return;
    }
    ProgressDialog localProgressDialog = h.a(paramContext, paramp, "", false);
    r localr = new r(this, localProgressDialog, paramContext, paramSnsPostListener, localIntent);
    m.b(localProgressDialog);
    this.b.a(paramContext, paramp, localr);
  }

  private boolean c(Context paramContext)
  {
    if ((this.b instanceof b));
    for (boolean bool = ((b)this.b).c(paramContext); ; bool = false)
    {
      if ((bool) && ("-1".equals(this.a.a)))
        this.a.a = this.b.f().a;
      return bool;
    }
  }

  private void d()
  {
    if ((m.b != null) && (m.b.size() > 0))
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = m.b.iterator();
      while (localIterator.hasNext())
      {
        Uri localUri = (Uri)localIterator.next();
        localHashSet.add(localUri.getScheme() + "://" + localUri.getAuthority() + localUri.getPath());
      }
      m.a(localHashSet, com.umeng.socialize.utils.a.b + "image_uri_cache");
    }
  }

  private void d(Activity paramActivity)
  {
    q localq = new q(this, paramActivity);
    this.b.a(paramActivity, localq);
  }

  private void d(Context paramContext)
  {
    if (d == null)
      d = new w(this, paramContext);
  }

  private void d(Context paramContext, com.umeng.socialize.bean.p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    com.umeng.socialize.bean.p localp = com.umeng.socialize.bean.p.a(paramp.toString());
    String str = com.umeng.socialize.utils.k.e(paramContext, localp);
    if (com.umeng.socialize.utils.k.b(paramContext, localp))
    {
      a(paramContext, str, paramp, paramSnsPostListener);
      return;
    }
    this.e = true;
    a(paramContext, paramp, paramSnsPostListener);
  }

  private void e(Context paramContext, com.umeng.socialize.bean.p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    aw localaw = (aw)this.c.c().get(paramp.toString());
    if (localaw != null)
      localaw.a(paramContext, this.a, paramSnsPostListener);
  }

  private boolean e(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      i.b(this.h, "### activity == null");
      return false;
    }
    if ((this.f != null) && (this.f.isShowing()))
    {
      Toast.makeText(paramActivity, "分享面板已打开", 0).show();
      return false;
    }
    if (this.c.a(paramActivity, this.b).size() == 0)
    {
      i.b(this.h, "### 平台数量为0");
      Toast.makeText(paramActivity, "平台数量为0", 0).show();
      return false;
    }
    return true;
  }

  public void a()
  {
    if ((this.f != null) && (this.f.isShowing()))
    {
      this.f.dismiss();
      this.f = null;
    }
  }

  @Deprecated
  public void a(Activity paramActivity, com.umeng.socialize.bean.p paramp, String paramString, byte[] paramArrayOfByte)
  {
    c();
    b(paramActivity, paramString, paramArrayOfByte);
    a(paramActivity, paramp, null);
  }

  public void a(Activity paramActivity, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    c();
    if (!e(paramActivity))
      return;
    a(paramActivity);
    this.a.a(paramActivity, com.umeng.socialize.bean.p.b, 1);
    this.f = null;
    com.umeng.socialize.view.abs.a locala = new com.umeng.socialize.view.abs.a(paramActivity);
    locala.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.f = new ak(paramActivity, locala, com.umeng.socialize.controller.a.a(this.a.c));
    this.f.setFocusable(true);
    this.f.setBackgroundDrawable(new BitmapDrawable());
    this.f.a(this.i);
    locala.a(new p(this));
    if (paramSnsPostListener != null)
      this.c.b(paramSnsPostListener);
    if (this.g)
    {
      d(paramActivity);
      return;
    }
    this.f.showAtLocation(paramActivity.getWindow().getDecorView(), 80, 0, 0);
  }

  @Deprecated
  public void a(Activity paramActivity, String paramString, byte[] paramArrayOfByte)
  {
    c();
    b(paramActivity, paramString, paramArrayOfByte);
    a(paramActivity, false);
  }

  public void a(Activity paramActivity, boolean paramBoolean)
  {
    this.g = paramBoolean;
    a(paramActivity, null);
  }

  public void a(Context paramContext)
  {
    ((aw)this.c.c().get(com.umeng.socialize.bean.p.c.toString())).a(paramContext, this.a, null);
  }

  public void a(Context paramContext, com.umeng.socialize.bean.p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    if (!m.a(paramContext, paramp))
      return;
    if (paramSnsPostListener == null)
      paramSnsPostListener = d.a();
    c();
    this.a.a(paramContext, paramp, 2);
    ax.e(paramp);
    d(paramContext.getApplicationContext());
    this.c.b(d);
    if (paramp.a())
    {
      e(paramContext, paramp, paramSnsPostListener);
      return;
    }
    c(paramContext, paramp, paramSnsPostListener);
  }

  public void a(Context paramContext, SocializeListeners.MulStatusListener paramMulStatusListener, com.umeng.socialize.bean.p[] paramArrayOfp)
  {
    if (paramContext == null)
    {
      i.b(this.h, "请传递一个有效的Context对象");
      return;
    }
    if ((paramArrayOfp == null) || (paramArrayOfp.length == 0))
    {
      i.b(this.h, "分享的平台为空，请传递有效的分享平台");
      return;
    }
    c();
    HashMap localHashMap = new HashMap();
    List localList = Arrays.asList(com.umeng.socialize.bean.p.e());
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfp != null)
    {
      int j = paramArrayOfp.length;
      int k = 0;
      if (k < j)
      {
        com.umeng.socialize.bean.p localp = paramArrayOfp[k];
        if (localList.contains(localp))
          localArrayList.add(localp);
        while (true)
        {
          k++;
          break;
          i.e(this.h, localp.toString() + "不支持一键分享到多个平台");
        }
      }
    }
    for (com.umeng.socialize.bean.p[] arrayOfp = (com.umeng.socialize.bean.p[])localArrayList.toArray(new com.umeng.socialize.bean.p[localArrayList.size()]); ; arrayOfp = paramArrayOfp)
    {
      ar[] arrayOfar = m.a(paramContext, localHashMap, arrayOfp);
      UMShareMsg localUMShareMsg = new UMShareMsg();
      localUMShareMsg.a = this.a.d();
      localUMShareMsg.a(this.a.a());
      if ((arrayOfar != null) && (arrayOfar.length > 0))
      {
        new u(this, paramMulStatusListener, paramContext, arrayOfar, localUMShareMsg, localHashMap).c();
        return;
      }
      if (paramMulStatusListener == null)
        break;
      paramMulStatusListener.a();
      com.umeng.socialize.bean.k localk = new com.umeng.socialize.bean.k(-105);
      localk.a(localHashMap);
      paramMulStatusListener.a(localk, -105, this.a);
      return;
    }
  }

  public void a(Context paramContext, String paramString, com.umeng.socialize.bean.p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    if (!m.a(paramp))
      return;
    c();
    UMShareMsg localUMShareMsg;
    if (this.a.p() != null)
    {
      localUMShareMsg = this.a.p();
      this.a.a(null);
    }
    while (true)
    {
      this.a.b(true);
      a(paramContext, paramString, paramp.toString(), localUMShareMsg, paramSnsPostListener);
      return;
      localUMShareMsg = new UMShareMsg();
      localUMShareMsg.a = this.a.d();
      localUMShareMsg.a(this.a.a());
    }
  }

  public void a(Context paramContext, String paramString1, String paramString2, UMShareMsg paramUMShareMsg, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    com.umeng.socialize.bean.p localp = com.umeng.socialize.bean.p.a(paramString2);
    c();
    new s(this, paramSnsPostListener, paramString2, paramString1, paramContext, paramUMShareMsg, localp).c();
  }

  public void a(Context paramContext, String paramString1, String paramString2, com.umeng.socialize.bean.p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    c();
    new v(this, paramSnsPostListener, paramp, paramString2, paramString1, paramContext).c();
  }

  public void a(SocializeListeners.UMShareBoardListener paramUMShareBoardListener)
  {
    this.i = paramUMShareBoardListener;
  }

  public void b(Context paramContext)
  {
    ((aw)this.c.c().get(com.umeng.socialize.bean.p.d.toString())).a(paramContext, this.a, null);
  }

  public void b(Context paramContext, com.umeng.socialize.bean.p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    if (!m.a(paramContext, paramp))
      return;
    if (paramSnsPostListener == null)
      paramSnsPostListener = d.a();
    c();
    this.a.a(paramContext, paramp, 8);
    if (this.a.j() == as.b)
      ax.e(paramp);
    while (true)
    {
      d(paramContext.getApplicationContext());
      this.c.b(d);
      if (!paramp.a())
        break;
      e(paramContext, paramp, paramSnsPostListener);
      return;
      ax.e(com.umeng.socialize.bean.p.b);
    }
    d(paramContext, paramp, paramSnsPostListener);
  }

  public boolean b()
  {
    return (this.f != null) && (this.f.isShowing());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.o
 * JD-Core Version:    0.6.0
 */