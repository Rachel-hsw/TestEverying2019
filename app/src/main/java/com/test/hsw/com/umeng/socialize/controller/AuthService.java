package com.umeng.socialize.controller;

import android.content.Context;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;

public abstract interface AuthService
{
  public abstract void a(Context paramContext, bf parambf, SocializeListeners.SocializeClientListener paramSocializeClientListener);

  public abstract void a(Context paramContext, p paramp, SocializeListeners.SocializeClientListener paramSocializeClientListener);

  public abstract void a(Context paramContext, p paramp, SocializeListeners.UMAuthListener paramUMAuthListener);

  public abstract void a(Context paramContext, SocializeListeners.UMDataListener paramUMDataListener);

  public abstract void a(Context paramContext, p[] paramArrayOfp, SocializeListeners.UMDataListener paramUMDataListener);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.AuthService
 * JD-Core Version:    0.6.0
 */