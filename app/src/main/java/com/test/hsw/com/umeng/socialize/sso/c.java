package com.umeng.socialize.sso;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.as;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.media.QZoneShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.k;
import com.umeng.socialize.utils.m;
import com.umeng.socialize.utils.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class c extends UMTencentSsoHandler
{
  private static final String n = c.class.getName();
  private WeakReference<Activity> m;
  private IUiListener o = new e(this);

  public c(Activity paramActivity, String paramString1, String paramString2)
  {
    super(paramActivity, paramString1, paramString2);
    this.m = new WeakReference(paramActivity);
  }

  private Bundle a(UMShareMsg paramUMShareMsg)
  {
    Bundle localBundle = new Bundle();
    String str1 = paramUMShareMsg.a;
    UMediaObject localUMediaObject = paramUMShareMsg.a();
    if ((localUMediaObject instanceof QZoneShareContent))
    {
      QZoneShareContent localQZoneShareContent = (QZoneShareContent)localUMediaObject;
      this.w = localQZoneShareContent.i();
      str1 = localQZoneShareContent.k();
      if (!TextUtils.isEmpty(localQZoneShareContent.j()))
        this.v = localQZoneShareContent.j();
      localUMediaObject = localQZoneShareContent.c();
    }
    int i;
    if (((localUMediaObject instanceof UMImage)) && (TextUtils.isEmpty(str1)))
    {
      c(localBundle, localUMediaObject);
      i = 5;
    }
    while (true)
    {
      localBundle.putString("summary", str1);
      ArrayList localArrayList = new ArrayList();
      String str2 = localBundle.getString("imageUrl");
      localBundle.remove("imageUrl");
      if (!TextUtils.isEmpty(str2))
        localArrayList.add(str2);
      localBundle.putStringArrayList("imageUrl", localArrayList);
      localBundle.putInt("req_type", i);
      if (TextUtils.isEmpty(localBundle.getString("title")))
        localBundle.putString("title", "分享到QQ空间");
      if (TextUtils.isEmpty(localBundle.getString("targetUrl")))
      {
        localBundle.putString("targetUrl", "http://www.umeng.com/social");
        i.e(n, "没有设置QZone targetUrl，分享将采用友盟默认targetUrl");
      }
      localBundle.putString("appName", m());
      this.H.clear();
      this.H.put("qzone_id", this.c);
      this.H.put("qzone_secret", this.d);
      return localBundle;
      if (((localUMediaObject instanceof UMVideo)) || ((localUMediaObject instanceof UMusic)))
      {
        b(localBundle, localUMediaObject);
        i = 2;
        continue;
      }
      a(localBundle, localUMediaObject);
      i = 1;
    }
  }

  private SocializeListeners.UMAuthListener a(Bundle paramBundle, UMImage paramUMImage)
  {
    return new h(this, paramUMImage, paramBundle);
  }

  private void a(Bundle paramBundle)
  {
    this.a.b(SocializeListeners.SnsPostListener.class);
    i.c(n, "invoke Tencent.shareToQzone method...");
    if (this.e != null)
      this.e.shareToQzone((Activity)this.m.get(), paramBundle, p());
  }

  private void a(Bundle paramBundle, UMediaObject paramUMediaObject)
  {
    c(paramBundle, paramUMediaObject);
  }

  private void b(Bundle paramBundle, UMediaObject paramUMediaObject)
  {
    if ((paramUMediaObject == null) || ((!(paramUMediaObject instanceof UMusic)) && (!(paramUMediaObject instanceof UMVideo))))
    {
      i.b(n, "请设置分享媒体...");
      return;
    }
    if ((paramUMediaObject instanceof UMusic))
      f(paramUMediaObject);
    while (true)
    {
      String str = (String)this.H.get("image_path_local");
      if (TextUtils.isEmpty(str))
        str = (String)this.H.get("image_path_url");
      paramBundle.putString("imageUrl", str);
      paramBundle.putString("targetUrl", this.v);
      paramBundle.putString("audio_url", paramUMediaObject.a());
      paramBundle.putString("title", this.w);
      return;
      if (!(paramUMediaObject instanceof UMVideo))
        continue;
      g(paramUMediaObject);
    }
  }

  private void c(Bundle paramBundle, UMediaObject paramUMediaObject)
  {
    e(paramUMediaObject);
    String str = (String)this.H.get("image_path_local");
    if (TextUtils.isEmpty(str))
      str = (String)this.H.get("image_path_url");
    paramBundle.putString("imageUrl", str);
    if (TextUtils.isEmpty(this.v))
      this.v = ((String)this.H.get("image_target_url"));
    if (TextUtils.isEmpty(this.v))
    {
      this.v = "http://www.umeng.com/social";
      i.e(n, "没有设置QZone targetUrl，分享将采用友盟默认targetUrl");
    }
    paramBundle.putString("targetUrl", this.v);
    paramBundle.putString("title", this.w);
    i.e(n, "QZone不支持纯图片分享");
  }

  private void f()
  {
    if (!g());
    do
    {
      return;
      if (!l())
        continue;
      this.e.reAuth((Activity)this.m.get(), "all", this.o);
      return;
    }
    while (this.e == null);
    this.e.login((Activity)this.m.get(), "all", this.o);
  }

  private IUiListener p()
  {
    return new f(this);
  }

  private UMShareMsg q()
  {
    if (B.p() != null)
    {
      UMShareMsg localUMShareMsg2 = B.p();
      B.a(null);
      return localUMShareMsg2;
    }
    UMShareMsg localUMShareMsg1 = new UMShareMsg();
    localUMShareMsg1.a = B.d();
    localUMShareMsg1.a(B.a());
    return localUMShareMsg1;
  }

  private void r()
  {
    if (!g())
      return;
    Bundle localBundle = a(q());
    int i = localBundle.getInt("req_type");
    ArrayList localArrayList = localBundle.getStringArrayList("imageUrl");
    String str = null;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      str = null;
      if (j > 0)
        str = (String)localArrayList.get(0);
    }
    if (a(str, i))
    {
      SocializeListeners.UMAuthListener localUMAuthListener = a(localBundle, new UMImage(this.D, str));
      a((Activity)this.m.get(), localUMAuthListener);
    }
    while (true)
    {
      B.a(as.b);
      return;
      a(localBundle);
    }
  }

  private void s()
  {
    Toast.makeText(this.D, "分享失败，详情见Logcat", 0).show();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("请添加QZone平台到SDK \n");
    localStringBuilder.append("添加方式：\nQZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(getActivity(), \"你的APP ID\",\"你的APP KEY\");\n");
    localStringBuilder.append("qZoneSsoHandler.addToSocialSDK();\n");
    localStringBuilder.append("参考文档：\nhttp://dev.umeng.com/social/android/share/quick-integration#social_qzone_sso");
    i.b(n, localStringBuilder.toString());
  }

  public void a(Activity paramActivity, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    Context localContext = paramActivity.getApplicationContext();
    this.m = new WeakReference(paramActivity);
    if ((this.e != null) && (this.e.isSessionValid()))
      this.e.logout(this.D);
    this.f = paramUMAuthListener;
    ax.e(p.f);
    if (TextUtils.isEmpty(this.c))
    {
      this.c = ((String)k.c(localContext).get("appid"));
      this.d = ((String)k.c(localContext).get("appkey"));
    }
    if (!TextUtils.isEmpty(this.c))
    {
      f();
      return;
    }
    a(new d(this));
  }

  protected void a(com.umeng.socialize.bean.b paramb, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    if ("deault_id".equals(this.c))
    {
      s();
      return;
    }
    this.a.b(paramSnsPostListener);
    B = paramay;
    ax.e(p.f);
    if (TextUtils.isEmpty(this.c))
    {
      this.c = ((String)k.c(this.D).get("appid"));
      this.d = ((String)k.c(this.D).get("appkey"));
    }
    if (!TextUtils.isEmpty(this.c))
    {
      r();
      return;
    }
    a(new g(this));
  }

  protected void b()
  {
    this.j = "qzone";
    this.i = com.umeng.socialize.common.b.a(this.D, "umeng_socialize_text_qq_zone_key");
    this.k = com.umeng.socialize.common.b.a(this.D, b.a.c, "umeng_socialize_qzone_on");
    this.l = com.umeng.socialize.common.b.a(this.D, b.a.c, "umeng_socialize_qzone_off");
  }

  protected void b(boolean paramBoolean)
  {
    UMShareMsg localUMShareMsg = q();
    m.a(this.D, B.c, localUMShareMsg.a, localUMShareMsg.a(), "qzone");
    try
    {
      n.a(this.D, p.f, 25);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public int f_()
  {
    return 5657;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.c
 * JD-Core Version:    0.6.0
 */