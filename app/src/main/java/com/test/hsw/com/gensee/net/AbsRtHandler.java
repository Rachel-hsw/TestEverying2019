package com.gensee.net;

import android.content.Context;
import com.gensee.entity.AccessResEntity;
import com.gensee.entity.LoginResEntity;

public abstract class AbsRtHandler
{
  protected Context context;
  protected boolean isBox = false;

  public AbsRtHandler(Context paramContext)
  {
    this.context = paramContext;
  }

  public boolean is3GOrWifi()
  {
    return AbsHandler.is3GOrWifi(this.context);
  }

  protected abstract AccessResEntity onAccessInfoRes(String paramString);

  protected AccessResEntity onAccessUrlInfoRes(String paramString)
  {
    return null;
  }

  protected abstract void onError(int paramInt, String paramString);

  protected abstract void onLoginFinish(Object paramObject);

  protected abstract LoginResEntity onLoginInfoRes(String paramString, boolean paramBoolean);

  public void setBox(boolean paramBoolean)
  {
    this.isBox = paramBoolean;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.AbsRtHandler
 * JD-Core Version:    0.6.0
 */