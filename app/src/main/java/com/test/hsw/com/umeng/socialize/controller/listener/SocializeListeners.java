package com.umeng.socialize.controller.listener;

import android.content.Context;
import android.os.Bundle;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.CallbackConfig.ICallbackListener;
import com.umeng.socialize.bean.UMComment;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.az;
import com.umeng.socialize.bean.bc;
import com.umeng.socialize.bean.k;
import com.umeng.socialize.bean.p;
import java.util.List;
import java.util.Map;

public abstract class SocializeListeners
{
  public static abstract interface FetchCommetsListener
  {
    public abstract void a();

    public abstract void a(int paramInt, List<UMComment> paramList, ay paramay);
  }

  public static abstract interface FetchFriendsListener
  {
    public abstract void a();

    public abstract void a(int paramInt, List<bc> paramList);
  }

  public static abstract interface FetchUserListener
  {
    public abstract void a();

    public abstract void a(int paramInt, az paramaz);
  }

  public static abstract interface MulStatusListener extends CallbackConfig.ICallbackListener
  {
    public abstract void a();

    public abstract void a(k paramk, int paramInt, ay paramay);
  }

  public static abstract interface OnSnsPlatformClickListener
  {
    public abstract void a(Context paramContext, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener);
  }

  public static abstract interface SnsPostListener extends CallbackConfig.ICallbackListener
  {
    public abstract void a();

    public abstract void a(p paramp, int paramInt, ay paramay);
  }

  public static abstract interface SocializeClientListener extends CallbackConfig.ICallbackListener
  {
    public abstract void a();

    public abstract void a(int paramInt, ay paramay);
  }

  public static abstract interface UMAuthListener extends CallbackConfig.ICallbackListener
  {
    public abstract void a(Bundle paramBundle, p paramp);

    public abstract void a(a parama, p paramp);

    public abstract void a(p paramp);

    public abstract void b(p paramp);
  }

  public static abstract interface UMDataListener
  {
    public abstract void a(int paramInt, Map<String, Object> paramMap);

    public abstract void b();
  }

  public static abstract interface UMShareBoardListener
  {
    public abstract void a();

    public abstract void b();
  }

  public static abstract class a
  {
    public void a()
    {
    }

    public void a(int paramInt)
    {
    }

    public void a(p paramp, boolean paramBoolean)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.listener.SocializeListeners
 * JD-Core Version:    0.6.0
 */