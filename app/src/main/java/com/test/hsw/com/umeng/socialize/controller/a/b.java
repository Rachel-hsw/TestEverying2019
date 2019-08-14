package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.b.j;
import com.umeng.socialize.b.m;
import com.umeng.socialize.b.z;
import com.umeng.socialize.bean.UMComment;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.av;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.bean.k;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.AuthService;
import com.umeng.socialize.controller.CommentService;
import com.umeng.socialize.controller.LikeService;
import com.umeng.socialize.controller.UserCenterService;
import com.umeng.socialize.controller.listener.SocializeListeners.FetchCommetsListener;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import com.umeng.socialize.media.UMediaObject;
import java.util.HashMap;

public class b extends a
{
  public b(ay paramay)
  {
    super(paramay);
  }

  public m a(Context paramContext, p paramp, String paramString)
    throws com.umeng.socialize.a.a
  {
    if (c(paramContext))
      return super.a(paramContext, paramp, paramString);
    return null;
  }

  public z a(Context paramContext, ar paramar)
  {
    if (c(paramContext))
      return super.a(paramContext, paramar);
    return null;
  }

  public k a(Context paramContext, ar paramar, String[] paramArrayOfString)
  {
    if (c(paramContext))
    {
      k localk = super.a(paramContext, paramar, paramArrayOfString);
      if (localk == null)
        localk = new k(-102);
      return localk;
    }
    return new k(-104);
  }

  public String a(Context paramContext, UMediaObject paramUMediaObject, String paramString)
  {
    if (c(paramContext))
      return super.a(paramContext, paramUMediaObject, paramString);
    return "";
  }

  protected void a(Context paramContext, long paramLong, SocializeListeners.FetchCommetsListener paramFetchCommetsListener)
    throws com.umeng.socialize.a.a
  {
    this.c.a(paramContext, paramFetchCommetsListener, paramLong);
  }

  public void a(Context paramContext, UMComment paramUMComment, SocializeListeners.MulStatusListener paramMulStatusListener, p[] paramArrayOfp)
  {
    this.c.a(paramContext, paramUMComment, paramMulStatusListener, paramArrayOfp);
  }

  protected void a(Context paramContext, p paramp, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    if (c(paramContext))
      this.e.a(paramContext, paramp, paramSocializeClientListener);
    do
      return;
    while (paramSocializeClientListener == null);
    paramSocializeClientListener.a(-104, this.a);
  }

  protected void a(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    this.d.a(paramContext, paramSocializeClientListener);
  }

  public void a(Context paramContext, SocializeListeners.UMDataListener paramUMDataListener)
  {
    if (c(paramContext))
    {
      this.e.a(paramContext, paramUMDataListener);
      return;
    }
    paramUMDataListener.a(-104, new HashMap());
  }

  protected void a(Context paramContext, boolean paramBoolean)
  {
    this.c.a(paramContext, paramBoolean);
  }

  public void a(Context paramContext, p[] paramArrayOfp, SocializeListeners.UMDataListener paramUMDataListener)
  {
    if (c(paramContext))
      this.e.a(paramContext, paramArrayOfp, paramUMDataListener);
  }

  protected void b(Context paramContext, av paramav, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    if (c(paramContext))
    {
      this.f.a(paramContext, paramav, paramSocializeClientListener);
      return;
    }
    paramSocializeClientListener.a(-104, this.a);
  }

  public void b(Context paramContext, bf parambf, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    if (c(paramContext))
    {
      this.e.a(paramContext, parambf, paramSocializeClientListener);
      return;
    }
    paramSocializeClientListener.a(-104, this.a);
  }

  protected void b(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    this.d.b(paramContext, paramSocializeClientListener);
  }

  protected void c(Context paramContext, p paramp, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    if (c(paramContext))
    {
      this.f.b(paramContext, paramp, paramSocializeClientListener);
      return;
    }
    paramSocializeClientListener.a(-104, this.a);
  }

  protected void c(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    this.d.c(paramContext, paramSocializeClientListener);
  }

  public j e(Context paramContext)
    throws com.umeng.socialize.a.a
  {
    if (c(paramContext))
      return super.e(paramContext);
    return null;
  }

  protected void f(Context paramContext, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
    if (c(paramContext))
    {
      this.f.e(paramContext, paramSocializeClientListener);
      return;
    }
    paramSocializeClientListener.a(-104, this.a);
  }

  public int g(Context paramContext)
  {
    if (c(paramContext))
      return super.g(paramContext);
    return -102;
  }

  public int h(Context paramContext)
  {
    if (c(paramContext))
      return super.h(paramContext);
    return -102;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.b
 * JD-Core Version:    0.6.0
 */