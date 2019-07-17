package com.umeng.socialize.controller.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.bean.CallbackConfig.ICallbackListener;
import com.umeng.socialize.bean.UMComment;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.as;
import com.umeng.socialize.bean.av;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.AuthService;
import com.umeng.socialize.controller.ShareService;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.UserCenterService;
import com.umeng.socialize.controller.listener.SocializeListeners.FetchCommetsListener;
import com.umeng.socialize.controller.listener.SocializeListeners.FetchFriendsListener;
import com.umeng.socialize.controller.listener.SocializeListeners.FetchUserListener;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMShareBoardListener;
import com.umeng.socialize.controller.listener.SocializeListeners.a;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.sso.v;
import com.umeng.socialize.utils.d;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;
import java.util.HashMap;
import java.util.Map;

public final class x extends b
  implements UMSocialService
{
  public static volatile Map<String, ay> g;
  private static final String h = x.class.getName();
  private static ax i = ax.b();

  static
  {
    g = new HashMap();
  }

  public x(ay paramay)
  {
    super(paramay);
  }

  public void a()
  {
    this.b.a();
  }

  @Deprecated
  public void a(Activity paramActivity, p paramp, String paramString, byte[] paramArrayOfByte)
  {
    this.b.a(paramActivity, paramp, paramString, paramArrayOfByte);
  }

  public void a(Activity paramActivity, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    this.b.a(paramActivity, paramSnsPostListener);
  }

  @Deprecated
  public void a(Activity paramActivity, String paramString, byte[] paramArrayOfByte)
  {
    this.b.a(paramActivity, paramString, paramArrayOfByte);
  }

  public void a(Activity paramActivity, boolean paramBoolean)
  {
    this.b.a(paramActivity, paramBoolean);
  }

  public void a(Context paramContext)
  {
    this.b.a(paramContext);
  }

  public void a(Context paramContext, UMComment paramUMComment, SocializeListeners.MulStatusListener paramMulStatusListener, p[] paramArrayOfp)
  {
    super.a(paramContext, paramUMComment, paramMulStatusListener, paramArrayOfp);
  }

  public void a(Context paramContext, av paramav, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    super.b(paramContext, paramav, paramSocializeClientListener);
  }

  public void a(Context paramContext, bf parambf, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    super.b(paramContext, parambf, paramSocializeClientListener);
  }

  public void a(Context paramContext, p paramp, SocializeListeners.MulStatusListener paramMulStatusListener, String[] paramArrayOfString)
  {
    if (!com.umeng.socialize.utils.k.b(paramContext, paramp))
    {
      if (paramMulStatusListener != null)
      {
        paramMulStatusListener.a();
        paramMulStatusListener.a(new com.umeng.socialize.bean.k(-101), -101, this.a);
      }
      return;
    }
    String str = com.umeng.socialize.utils.k.e(paramContext, paramp);
    new ab(this, paramMulStatusListener, this, paramContext, new ar(paramp.toString(), str), paramArrayOfString, paramp).c();
  }

  public void a(Context paramContext, p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    this.b.a(paramContext, paramp, paramSnsPostListener);
  }

  public void a(Context paramContext, p paramp, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    super.a(paramContext, paramp, paramSocializeClientListener);
  }

  public void a(Context paramContext, p paramp, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    this.e.a(paramContext, paramp, paramUMAuthListener);
  }

  public void a(Context paramContext, p paramp, SocializeListeners.UMDataListener paramUMDataListener)
  {
    if (paramUMDataListener == null);
    for (SocializeListeners.UMDataListener localUMDataListener = d.c(); ; localUMDataListener = paramUMDataListener)
    {
      if ((!com.umeng.socialize.utils.k.a(paramContext, paramp)) && (paramp != p.m))
      {
        localUMDataListener.b();
        localUMDataListener.a(-101, null);
        return;
      }
      if ((paramp == p.i) || (paramp == p.j) || (paramp == p.g) || (paramp == p.m))
      {
        v localv = c().a(paramp.c());
        if (localv == null)
        {
          i.e("", "请添加" + paramp.toString() + "平台");
          return;
        }
        localv.a(localUMDataListener);
        return;
      }
      String str = com.umeng.socialize.utils.k.e(paramContext, paramp);
      new ac(this, localUMDataListener, this, paramContext, new ar(paramp.toString(), str)).c();
      return;
    }
  }

  public void a(Context paramContext, SocializeListeners.FetchCommetsListener paramFetchCommetsListener, long paramLong)
  {
    super.a(paramContext, paramLong, paramFetchCommetsListener);
  }

  public void a(Context paramContext, SocializeListeners.FetchFriendsListener paramFetchFriendsListener, p paramp)
  {
    String str = com.umeng.socialize.utils.k.e(paramContext, paramp);
    if (TextUtils.isEmpty(str))
    {
      if (paramFetchFriendsListener != null)
        paramFetchFriendsListener.a();
      if (paramFetchFriendsListener != null)
        paramFetchFriendsListener.a(-101, null);
    }
    new aa(this, paramFetchFriendsListener, this, paramContext, paramp, str).c();
  }

  public void a(Context paramContext, SocializeListeners.FetchUserListener paramFetchUserListener)
  {
    new z(this, paramFetchUserListener, this, paramContext).c();
  }

  public void a(Context paramContext, SocializeListeners.MulStatusListener paramMulStatusListener, p[] paramArrayOfp)
  {
    this.b.a(paramContext, paramMulStatusListener, paramArrayOfp);
  }

  public void a(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    super.a(paramContext, paramSocializeClientListener);
  }

  public void a(Context paramContext, SocializeListeners.UMDataListener paramUMDataListener)
  {
    super.a(paramContext, paramUMDataListener);
  }

  public void a(Context paramContext, SocializeListeners.a parama)
  {
    this.f.a(paramContext, parama);
  }

  public void a(Context paramContext, String paramString, p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    this.b.a(paramContext, paramString, paramp, paramSnsPostListener);
  }

  public void a(Context paramContext, String paramString1, String paramString2, UMShareMsg paramUMShareMsg, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    this.b.a(paramContext, paramString1, paramString2, paramUMShareMsg, paramSnsPostListener);
  }

  public void a(Context paramContext, String paramString1, String paramString2, p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    this.b.a(paramContext, paramString1, paramString2, paramp, paramSnsPostListener);
  }

  public void a(Context paramContext, boolean paramBoolean)
  {
    super.a(paramContext, paramBoolean);
  }

  public void a(Context paramContext, int[] paramArrayOfInt)
  {
    this.f.a(paramContext, paramArrayOfInt);
  }

  public void a(Context paramContext, p[] paramArrayOfp, SocializeListeners.UMDataListener paramUMDataListener)
  {
    super.a(paramContext, paramArrayOfp, paramUMDataListener);
  }

  public void a(as paramas)
  {
    this.a.a(paramas);
  }

  public void a(ax paramax)
  {
    if (paramax == null)
      return;
    this.a.a(paramax);
  }

  public void a(p paramp, String paramString)
  {
    ay.a(paramp, paramString);
  }

  public void a(SocializeListeners.UMShareBoardListener paramUMShareBoardListener)
  {
    this.b.a(paramUMShareBoardListener);
  }

  public void a(UMImage paramUMImage)
  {
    this.a.a(paramUMImage);
  }

  public void a(String paramString)
  {
    this.a.b(paramString);
  }

  public boolean a(CallbackConfig.ICallbackListener paramICallbackListener)
    throws com.umeng.socialize.a.a
  {
    return c().b(paramICallbackListener);
  }

  public boolean a(CallbackConfig.ICallbackListener paramICallbackListener, int paramInt)
    throws com.umeng.socialize.a.a
  {
    return c().b(paramICallbackListener, paramInt);
  }

  public boolean a(UMediaObject paramUMediaObject)
  {
    if (paramUMediaObject == null)
    {
      this.a.a(null);
      return true;
    }
    if (paramUMediaObject.h())
    {
      this.a.a(paramUMediaObject);
      return true;
    }
    i.e(h, "unable set share media.type is no support.");
    return false;
  }

  public void b(Context paramContext)
  {
    this.b.b(paramContext);
  }

  public void b(Context paramContext, p paramp, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    this.b.b(paramContext, paramp, paramSnsPostListener);
  }

  public void b(Context paramContext, p paramp, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    super.c(paramContext, paramp, paramSocializeClientListener);
  }

  public void b(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    super.b(paramContext, paramSocializeClientListener);
  }

  public void b(ax paramax)
  {
    if (paramax == null)
      return;
    i = paramax;
  }

  public void b(String paramString)
  {
    this.a.d = paramString;
  }

  public boolean b()
  {
    return this.b.b();
  }

  public boolean b(CallbackConfig.ICallbackListener paramICallbackListener)
  {
    return c().d(paramICallbackListener);
  }

  public ax c()
  {
    if (this.a.n() == null)
    {
      if (i == null)
        i = ax.b();
      return i;
    }
    return this.a.n();
  }

  public void c(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    super.c(paramContext, paramSocializeClientListener);
  }

  public void c(String paramString)
  {
    this.a.a(paramString);
  }

  public void d(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    com.umeng.socialize.b.b.a.a(m.a(paramContext));
    new y(this, paramSocializeClientListener, this, paramContext).c();
  }

  public void d(String paramString)
  {
    a(p.b, paramString);
  }

  public boolean d()
  {
    return (this.a != null) && (this.a.a() != null);
  }

  public void e(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    super.f(paramContext, paramSocializeClientListener);
  }

  public boolean e()
  {
    return (this.a != null) && (!TextUtils.isEmpty(this.a.d()));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.x
 * JD-Core Version:    0.6.0
 */