package com.gensee.net;

import android.content.Context;
import com.gensee.entity.LoginResEntity;

public class RtmpReq extends AbsRoomSite
{
  private Callback mCallback;

  public RtmpReq(Context paramContext, Callback paramCallback)
  {
    super(paramContext);
    this.mCallback = paramCallback;
  }

  protected void onErr(int paramInt)
  {
    if (this.mCallback != null)
      this.mCallback.onErr(paramInt);
  }

  protected void onLoginEnd(LoginResEntity paramLoginResEntity)
  {
    if (this.mCallback != null)
      this.mCallback.onResult(paramLoginResEntity);
  }

  public void setCallback(Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }

  public static abstract interface Callback
  {
    public abstract void onErr(int paramInt);

    public abstract void onResult(LoginResEntity paramLoginResEntity);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.RtmpReq
 * JD-Core Version:    0.6.0
 */