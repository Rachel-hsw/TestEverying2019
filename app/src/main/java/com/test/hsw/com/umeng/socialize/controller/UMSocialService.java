package com.umeng.socialize.controller;

import android.content.Context;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.CallbackConfig.ICallbackListener;
import com.umeng.socialize.bean.as;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.FetchFriendsListener;
import com.umeng.socialize.controller.listener.SocializeListeners.FetchUserListener;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMediaObject;

public abstract interface UMSocialService extends AuthService, CommentService, LikeService, ShareService, UserCenterService
{
  public abstract void a(Context paramContext, p paramp, SocializeListeners.MulStatusListener paramMulStatusListener, String[] paramArrayOfString);

  public abstract void a(Context paramContext, p paramp, SocializeListeners.UMDataListener paramUMDataListener);

  public abstract void a(Context paramContext, SocializeListeners.FetchFriendsListener paramFetchFriendsListener, p paramp);

  public abstract void a(Context paramContext, SocializeListeners.FetchUserListener paramFetchUserListener);

  public abstract void a(as paramas);

  public abstract void a(ax paramax);

  public abstract void a(p paramp, String paramString);

  @Deprecated
  public abstract void a(UMImage paramUMImage);

  public abstract void a(String paramString);

  public abstract boolean a(CallbackConfig.ICallbackListener paramICallbackListener)
    throws a;

  public abstract boolean a(CallbackConfig.ICallbackListener paramICallbackListener, int paramInt)
    throws a;

  public abstract boolean a(UMediaObject paramUMediaObject);

  public abstract void b(ax paramax);

  public abstract void b(String paramString);

  public abstract boolean b(CallbackConfig.ICallbackListener paramICallbackListener);

  public abstract ax c();

  public abstract void c(String paramString);

  public abstract void d(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener);

  public abstract void d(String paramString);

  public abstract boolean d();

  public abstract boolean e();

  public abstract ay f();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.UMSocialService
 * JD-Core Version:    0.6.0
 */