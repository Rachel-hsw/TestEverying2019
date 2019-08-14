package com.umeng.socialize.controller;

import android.content.Context;
import com.umeng.socialize.bean.UMComment;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.FetchCommetsListener;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;

public abstract interface CommentService
{
  public abstract void a(Context paramContext, UMComment paramUMComment, SocializeListeners.MulStatusListener paramMulStatusListener, p[] paramArrayOfp);

  public abstract void a(Context paramContext, SocializeListeners.FetchCommetsListener paramFetchCommetsListener, long paramLong);

  public abstract void a(Context paramContext, boolean paramBoolean);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.CommentService
 * JD-Core Version:    0.6.0
 */