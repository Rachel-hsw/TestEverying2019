package com.umeng.socialize.sso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.b;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;
import java.util.HashMap;
import java.util.Map;

public abstract class v
{
  protected static final String A = "audio_url";
  public static ay B;
  private static final String a = v.class.getName();
  public static final String r = "appKey";
  public static final String s = "appSecret";
  public static final String t = "secretKey";
  protected static final String u = "http://www.umeng.com/social";
  protected static final String x = "image_target_url";
  protected static final String y = "image_path_local";
  protected static final String z = "image_path_url";
  protected ax C = ax.b();
  protected Context D = null;
  public String E = "";
  public UMediaObject F = null;
  public b G = null;
  public Map<String, String> H = new HashMap();
  protected boolean I = true;
  protected String v;
  protected String w;

  static
  {
    B = null;
  }

  public v()
  {
  }

  public v(Context paramContext)
  {
    if (paramContext != null)
    {
      this.D = paramContext.getApplicationContext();
      com.umeng.socialize.b.b.a.a(m.a(this.D));
    }
  }

  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);

  public abstract void a(Activity paramActivity, SocializeListeners.UMAuthListener paramUMAuthListener);

  public void a(ay paramay, p paramp, SocializeListeners.SocializeClientListener paramSocializeClientListener)
  {
  }

  protected abstract void a(b paramb, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener);

  public void a(SocializeListeners.UMDataListener paramUMDataListener)
  {
  }

  protected abstract void b(boolean paramBoolean);

  public void c(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }

  protected abstract b d();

  public void d(String paramString)
  {
    this.v = paramString;
  }

  protected void e(UMediaObject paramUMediaObject)
  {
    if ((paramUMediaObject == null) || (!(paramUMediaObject instanceof UMImage)))
    {
      i.e(a, "parse image params error , uMediaObject is null or isn't instance of UMImage");
      return;
    }
    UMImage localUMImage = (UMImage)paramUMediaObject;
    if (!localUMImage.n())
      localUMImage.o();
    if (TextUtils.isEmpty(this.v))
      if (TextUtils.isEmpty(localUMImage.e()))
        break label115;
    label115: for (this.v = localUMImage.e(); ; this.v = localUMImage.a())
    {
      String str1 = localUMImage.a();
      String str2 = localUMImage.k();
      if (!com.umeng.socialize.utils.a.a(str2))
        str2 = "";
      this.H.put("image_path_local", str2);
      this.H.put("image_path_url", str1);
      return;
    }
  }

  public abstract boolean e();

  public abstract boolean e_();

  protected void f(UMediaObject paramUMediaObject)
  {
    UMusic localUMusic = (UMusic)paramUMediaObject;
    this.H.put("audio_url", localUMusic.a());
    boolean bool = TextUtils.isEmpty(this.v);
    if (!TextUtils.isEmpty(localUMusic.d()))
      this.H.put("image_path_url", localUMusic.d());
    while (true)
    {
      if (!TextUtils.isEmpty(localUMusic.c()))
        this.w = localUMusic.c();
      if (bool)
      {
        if (TextUtils.isEmpty(localUMusic.e()))
          break;
        this.v = localUMusic.e();
      }
      return;
      e(localUMusic.j());
    }
    this.v = localUMusic.a();
  }

  public abstract int f_();

  protected void g(UMediaObject paramUMediaObject)
  {
    UMVideo localUMVideo = (UMVideo)paramUMediaObject;
    this.H.put("audio_url", localUMVideo.a());
    boolean bool = TextUtils.isEmpty(this.v);
    if (!TextUtils.isEmpty(localUMVideo.d()))
      this.H.put("image_path_url", localUMVideo.d());
    while (true)
    {
      if (!TextUtils.isEmpty(localUMVideo.c()))
        this.w = localUMVideo.c();
      if (bool)
      {
        if (TextUtils.isEmpty(localUMVideo.e()))
          break;
        this.v = localUMVideo.e();
      }
      return;
      e(localUMVideo.i());
    }
    this.v = localUMVideo.a();
  }

  public final b h()
  {
    if (this.G != null)
      return this.G;
    return d();
  }

  public void i()
  {
    this.C.a(h());
    this.C.a(this);
  }

  public boolean j()
  {
    return this.I;
  }

  public Context k()
  {
    return this.D;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.v
 * JD-Core Version:    0.6.0
 */