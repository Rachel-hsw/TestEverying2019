package com.umeng.socialize.controller;

import android.content.Context;
import com.umeng.socialize.bean.av;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.a;

public abstract interface UserCenterService
{
  public abstract void a(Context paramContext, av paramav, SocializeListeners.SocializeClientListener paramSocializeClientListener);

  public abstract void a(Context paramContext, SocializeListeners.a parama);

  public abstract void a(Context paramContext, int[] paramArrayOfInt);

  public abstract void b(Context paramContext, p paramp, SocializeListeners.SocializeClientListener paramSocializeClientListener);

  public abstract void e(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.UserCenterService
 * JD-Core Version:    0.6.0
 */