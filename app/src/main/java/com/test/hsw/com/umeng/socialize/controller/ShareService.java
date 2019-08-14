package com.umeng.socialize.controller;

import android.app.Activity;
import android.content.Context;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMShareBoardListener;

public abstract interface ShareService
{
  public abstract void a();

  @Deprecated
  public abstract void a(Activity paramActivity, p paramp, String paramString, byte[] paramArrayOfByte);

  public abstract void a(Activity paramActivity, SocializeListeners.SnsPostListener paramSnsPostListener);

  @Deprecated
  public abstract void a(Activity paramActivity, String paramString, byte[] paramArrayOfByte);

  public abstract void a(Activity paramActivity, boolean paramBoolean);

  public abstract void a(Context paramContext);

  public abstract void a(Context paramContext, p paramp, SocializeListeners.SnsPostListener paramSnsPostListener);

  public abstract void a(Context paramContext, SocializeListeners.MulStatusListener paramMulStatusListener, p[] paramArrayOfp);

  public abstract void a(Context paramContext, String paramString, p paramp, SocializeListeners.SnsPostListener paramSnsPostListener);

  public abstract void a(Context paramContext, String paramString1, String paramString2, UMShareMsg paramUMShareMsg, SocializeListeners.SnsPostListener paramSnsPostListener);

  public abstract void a(Context paramContext, String paramString1, String paramString2, p paramp, SocializeListeners.SnsPostListener paramSnsPostListener);

  public abstract void a(SocializeListeners.UMShareBoardListener paramUMShareBoardListener);

  public abstract void b(Context paramContext);

  public abstract void b(Context paramContext, p paramp, SocializeListeners.SnsPostListener paramSnsPostListener);

  public abstract boolean b();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.ShareService
 * JD-Core Version:    0.6.0
 */