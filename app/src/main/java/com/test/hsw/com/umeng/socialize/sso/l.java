package com.umeng.socialize.sso;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.as;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import com.umeng.socialize.media.QQShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.utils.a;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.k;
import com.umeng.socialize.view.ShareActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

public class l extends UMTencentSsoHandler
{
  private static final String o = "UMQQSsoHandler";
  private WeakReference<Activity> m;
  private boolean n = false;
  private int p = 1;
  private Bundle q;

  public l(Activity paramActivity, String paramString1, String paramString2)
  {
    super(paramActivity, paramString1, paramString2);
    this.m = new WeakReference(paramActivity);
  }

  private SocializeListeners.UMAuthListener a(UMImage paramUMImage)
  {
    return new s(this, paramUMImage);
  }

  private void a(Context paramContext, String paramString)
  {
    new r(this, paramContext, "", paramString).c();
  }

  private void a(Bundle paramBundle)
  {
    e(this.F);
    String str1 = (String)this.H.get("image_path_local");
    String str2 = (String)this.H.get("image_path_url");
    if ((!TextUtils.isEmpty(str1)) && (a.a(str1)))
      paramBundle.putString("imageLocalUrl", str1);
    while (true)
    {
      if (!e())
        i.e("UMQQSsoHandler", "QQ不支持无客户端情况下纯图片分享...");
      return;
      if (TextUtils.isEmpty(str2))
        continue;
      paramBundle.putString("imageUrl", str2);
    }
  }

  private void b(Bundle paramBundle)
  {
    a(paramBundle);
  }

  private void c(Bundle paramBundle)
  {
    String str2;
    if ((this.F instanceof UMusic))
    {
      f(this.F);
      String str1 = (String)this.H.get("image_path_local");
      str2 = (String)this.H.get("image_path_url");
      if ((TextUtils.isEmpty(str1)) || (!a.a(str1)))
        break label106;
      paramBundle.putString("imageLocalUrl", str1);
    }
    while (true)
    {
      paramBundle.putString("audio_url", this.F.a());
      return;
      if (!(this.F instanceof UMVideo))
        break;
      g(this.F);
      break;
      label106: if (TextUtils.isEmpty(str2))
        continue;
      paramBundle.putString("imageUrl", str2);
    }
  }

  private void p()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.D);
    TextView localTextView1 = new TextView(this.D);
    localTextView1.setText("分享失败原因");
    localTextView1.setPadding(0, 20, 0, 20);
    localTextView1.setTextColor(-1);
    localTextView1.setGravity(17);
    localTextView1.setTextSize(16.0F);
    localBuilder.setCustomTitle(localTextView1);
    TextView localTextView2 = new TextView(this.D);
    localTextView2.setText("请添加QQ平台到SDK \n添加方式：\nUMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(getActivity(), \"你的APP ID\",\"你的APP KEY\");\nqqSsoHandler.addToSocialSDK(); \n参考文档：\nhttp://dev.umeng.com/social/android/share/quick-integration#social_qq_sso");
    localTextView2.setTextColor(-1);
    localTextView2.setTextSize(16.0F);
    localTextView2.setAutoLinkMask(1);
    localBuilder.setView(localTextView2);
    localBuilder.show().show();
  }

  private void q()
  {
    if (l())
      this.e.logout(this.D);
    do
    {
      if (B != null)
        B.a(this.D, com.umeng.socialize.bean.p.g, 3);
      i.a("UMQQSsoHandler", "QQ oauth login...");
      this.e.login((Activity)this.m.get(), "all", new o(this));
      return;
    }
    while (((this.e != null) && (!TextUtils.isEmpty(this.e.getAppId()))) || (g()));
  }

  private void r()
  {
    if ((this.F instanceof QQShareContent))
    {
      QQShareContent localQQShareContent = (QQShareContent)this.F;
      this.E = localQQShareContent.k();
      this.v = localQQShareContent.j();
      this.w = localQQShareContent.i();
      this.F = localQQShareContent.c();
    }
  }

  private void s()
  {
    if (this.n)
    {
      Activity localActivity = (Activity)this.m.get();
      if (localActivity == null)
      {
        i.b("UMQQSsoHandler", "Activity is null");
        return;
      }
      com.umeng.socialize.utils.m.a(this.b);
      Intent localIntent = new Intent(localActivity, ShareActivity.class);
      localIntent.putExtra("QQ-SSO", true);
      localIntent.putExtra("sns", com.umeng.socialize.bean.p.g.toString());
      if ((B != null) && (!TextUtils.isEmpty(B.a)))
        localIntent.putExtra("dc", B.a);
      localActivity.startActivity(localIntent);
      return;
    }
    e_();
  }

  private void t()
  {
    com.umeng.socialize.utils.m.a(this.b);
    v();
    i.c("UMQQSsoHandler", "invoke Tencent.shareToQQ method...");
    this.e.shareToQQ((Activity)this.m.get(), this.q, new p(this));
    this.q = null;
    B.a(as.b);
  }

  private boolean u()
  {
    String str1 = (String)this.H.get("image_path_url");
    String str2 = (String)this.H.get("image_path_local");
    return (this.p == 5) && (e()) && (!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2));
  }

  private void v()
  {
    this.q = new Bundle();
    this.q.putString("summary", this.E);
    if (((this.F instanceof UMImage)) && (TextUtils.isEmpty(this.E)))
    {
      this.p = 5;
      a(this.q);
    }
    while (true)
    {
      this.q.putInt("req_type", this.p);
      if (TextUtils.isEmpty(this.w))
        this.w = "分享到QQ";
      if (TextUtils.isEmpty(this.v))
        this.v = "http://www.umeng.com/social";
      this.q.putString("targetUrl", this.v);
      this.q.putString("title", this.w);
      this.q.putString("appName", m());
      return;
      if (((this.F instanceof UMusic)) || ((this.F instanceof UMVideo)))
      {
        this.p = 2;
        c(this.q);
        continue;
      }
      b(this.q);
    }
  }

  public void a(Activity paramActivity, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    this.f = paramUMAuthListener;
    a(paramActivity);
    if (TextUtils.isEmpty(this.c))
    {
      this.c = ((String)k.c(this.D).get("appid"));
      this.d = ((String)k.c(this.D).get("appkey"));
    }
    if (TextUtils.isEmpty(this.c))
    {
      a(new n(this));
      return;
    }
    q();
  }

  protected void a(com.umeng.socialize.bean.b paramb, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    if ("deault_id".equals(this.c))
      p();
    m localm;
    while (true)
    {
      return;
      this.a.b(paramSnsPostListener);
      this.I = true;
      ax.e(com.umeng.socialize.bean.p.g);
      this.p = 1;
      if (paramay != null)
      {
        B = paramay;
        UMShareMsg localUMShareMsg = B.p();
        if ((localUMShareMsg == null) || (B.j() != as.a))
          break label232;
        this.E = localUMShareMsg.a;
        this.F = localUMShareMsg.a();
      }
      while (true)
      {
        r();
        String[] arrayOfString = k.b(this.D);
        localm = new m(this);
        if (arrayOfString == null)
          break;
        if (TextUtils.isEmpty(this.c))
        {
          this.c = ((String)k.c(this.D).get("appid"));
          this.d = ((String)k.c(this.D).get("appkey"));
        }
        if (!TextUtils.isEmpty(this.c))
        {
          this.e = Tencent.createInstance(this.c, this.D);
          this.e.setOpenId(arrayOfString[1]);
          this.e.setAccessToken(arrayOfString[0], arrayOfString[2]);
          s();
          return;
          label232: this.E = paramay.d();
          this.F = paramay.a();
          continue;
        }
        a(localm);
        return;
      }
      if (TextUtils.isEmpty(this.c))
        break;
      if (!g())
        continue;
      s();
      return;
    }
    a(localm);
  }

  public void a(SocializeListeners.UMDataListener paramUMDataListener)
  {
    paramUMDataListener.b();
    if (this.e == null)
    {
      paramUMDataListener.a(-101, null);
      return;
    }
    new UserInfo(this.D, this.e.getQQToken()).getUserInfo(new u(this, paramUMDataListener));
  }

  public void a(String paramString)
  {
    this.E = paramString;
    e_();
  }

  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  protected void b()
  {
    this.j = "qq";
    this.i = com.umeng.socialize.common.b.a(this.D, "umeng_socialize_text_qq_key");
    this.k = com.umeng.socialize.common.b.a(this.D, b.a.c, "umeng_socialize_qq_on");
    this.l = com.umeng.socialize.common.b.a(this.D, b.a.c, "umeng_socialize_qq_off");
  }

  public void b(String paramString)
  {
    this.w = paramString;
  }

  protected void b(boolean paramBoolean)
  {
    if (B.c != null)
      com.umeng.socialize.utils.m.a(this.D, B.c, this.E, this.F, "qq");
    try
    {
      com.umeng.socialize.utils.n.a(this.D, com.umeng.socialize.bean.p.g, 16);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void c()
  {
    if (l())
    {
      this.a.b(SocializeListeners.SnsPostListener.class);
      String str1 = (String)this.H.get("image_path_local");
      if (u())
      {
        String str2 = (String)this.H.get("image_path_url");
        a(this.D, str2);
        return;
      }
      if (a(str1, this.p))
      {
        UMImage localUMImage = new UMImage(this.D, new File(str1));
        i.e("UMQQSsoHandler", "未安装QQ客户端的情况下，QQ不支持音频，图文是为本地图片的分享。此时将上传本地图片到相册，请确保在QQ互联申请了upload_pic权限.");
        SocializeListeners.UMAuthListener localUMAuthListener = a(localUMImage);
        a((Activity)this.m.get(), localUMAuthListener);
        return;
      }
      t();
      return;
    }
    i.c("UMQQSsoHandler", "QQ平台还没有授权");
    f();
    a((Activity)this.m.get(), this.f);
  }

  public boolean e_()
  {
    c();
    return true;
  }

  public void f()
  {
    this.f = new q(this);
  }

  public int f_()
  {
    return 5658;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.l
 * JD-Core Version:    0.6.0
 */