package com.umeng.socialize.sso;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.bean.l;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.c;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.k;
import com.umeng.socialize.utils.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class UMTencentSsoHandler extends v
{
  protected static Map<String, String> g;
  private static final String m = UMTencentSsoHandler.class.getName();
  private static final String n = "100424468";
  protected ax a = ax.b();
  protected ProgressDialog b = null;
  protected String c;
  protected String d;
  protected Tencent e;
  protected SocializeListeners.UMAuthListener f;
  protected String h = null;
  protected String i;
  protected String j;
  protected int k;
  protected int l;

  static
  {
    g = new HashMap();
  }

  public UMTencentSsoHandler(Activity paramActivity, String paramString1, String paramString2)
  {
    super(paramActivity);
    if (paramActivity == null)
    {
      i.b(m, "传入的activity为null，请传递一个非空Activity对象");
      return;
    }
    if (TextUtils.isEmpty(paramString2))
      i.b(m, "传递的APP KEY无效，请传一个有效的APP KEY");
    if (TextUtils.isEmpty(paramString1))
      i.b(m, "传递的APP ID无效，请传一个有效的APP ID");
    this.D = paramActivity.getApplicationContext();
    this.c = paramString1;
    this.d = paramString2;
    c();
    this.H.put("qzone_id", paramString1);
    this.H.put("qzone_secret", paramString2);
  }

  private void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      g.put(paramString1, paramString2);
      this.h = paramString2;
    }
  }

  private void c()
  {
    if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d)))
      k.a(this.D, this.c, this.d);
  }

  protected Bundle a(Object paramObject)
  {
    Bundle localBundle = new Bundle();
    if (paramObject == null);
    while (true)
    {
      return localBundle;
      String str = paramObject.toString().trim();
      if (TextUtils.isEmpty(str))
        continue;
      try
      {
        localJSONObject = new JSONObject(str);
        if (localJSONObject == null)
          continue;
        localBundle.putString("auth_time", localJSONObject.optString("auth_time", ""));
        localBundle.putString("pay_token", localJSONObject.optString("pay_token", ""));
        localBundle.putString("pf", localJSONObject.optString("pf", ""));
        localBundle.putInt("ret", localJSONObject.optInt("ret", -1));
        localBundle.putString("sendinstall", localJSONObject.optString("sendinstall", ""));
        localBundle.putString("page_type", localJSONObject.optString("page_type", ""));
        localBundle.putString("appid", localJSONObject.optString("appid", ""));
        localBundle.putString("openid", localJSONObject.optString("openid", ""));
        localBundle.putString("uid", localJSONObject.optString("openid", ""));
        localBundle.putString("expires_in", localJSONObject.optString("expires_in", ""));
        localBundle.putString("pfkey", localJSONObject.optString("pfkey", ""));
        localBundle.putString("access_token", localJSONObject.optString("access_token", ""));
        return localBundle;
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          localJSONException.printStackTrace();
          JSONObject localJSONObject = null;
        }
      }
    }
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public void a(Activity paramActivity)
  {
    this.D = paramActivity.getApplicationContext();
  }

  protected void a(Context paramContext, Object paramObject, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    Bundle localBundle = a(paramObject);
    bf localbf = b(paramObject);
    if (localbf == null)
      return;
    if (!c.f(this.D))
      Toast.makeText(paramContext, "您的网络不可用,请检查网络连接...", 0).show();
    new y(this, paramUMAuthListener, paramContext, localbf, localBundle).c();
  }

  public void a(UMediaObject paramUMediaObject, String paramString, ObtainImageUrlListener paramObtainImageUrlListener)
  {
    com.umeng.socialize.controller.a.b localb = new com.umeng.socialize.controller.a.b(new ay("com.umeng.share.uploadImage", l.a));
    long l1 = System.currentTimeMillis();
    new z(this, this.D, "", paramUMediaObject, localb, paramString, l1, paramObtainImageUrlListener).c();
  }

  protected void a(ObtainAppIdListener paramObtainAppIdListener)
  {
    if (!c.f(this.D))
    {
      Toast.makeText(this.D, "您的网络不可用,请检查网络连接...", 0).show();
      return;
    }
    new x(this, this.D, "获取AppID中...", paramObtainAppIdListener).c();
  }

  protected boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString));
    p localp;
    label77: 
    do
      while (true)
      {
        return false;
        localp = ax.o();
        boolean bool = e();
        if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")));
        for (int i1 = 1; (!bool) && (i1 != 0); i1 = 0)
        {
          if ((localp != p.g) || ((paramInt != 2) && (paramInt != 1)))
            break label77;
          return true;
        }
      }
    while ((localp != p.f) || ((paramInt != 1) && (paramInt != 2)));
    return true;
  }

  protected bf b(Object paramObject)
  {
    Bundle localBundle = a(paramObject);
    if (localBundle == null)
      return null;
    String str1 = localBundle.getString("access_token");
    String str2 = localBundle.getString("openid");
    String str3 = localBundle.getString("expires_in");
    bf localbf = bf.a(new ar(ax.o().toString(), str2), str1, str2);
    localbf.d(this.d);
    localbf.c(this.c);
    localbf.e(str3);
    return localbf;
  }

  protected abstract void b();

  public int c(Object paramObject)
  {
    if (paramObject == null);
    while (true)
    {
      return -1;
      String str = paramObject.toString().trim();
      if (TextUtils.isEmpty(str))
        continue;
      try
      {
        localJSONObject = new JSONObject(str);
        if ((localJSONObject == null) || (!localJSONObject.has("ret")))
          continue;
        return localJSONObject.optInt("ret");
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          localJSONException.printStackTrace();
          JSONObject localJSONObject = null;
        }
      }
    }
  }

  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      i.e(m, "your appid is null...");
      return;
    }
    this.c = paramString;
  }

  protected com.umeng.socialize.bean.b d()
  {
    b();
    this.G = new com.umeng.socialize.bean.b(this.j, this.i, this.k);
    this.G.d = this.l;
    this.G.k = new w(this);
    return this.G;
  }

  public boolean e()
  {
    return c.a("com.tencent.mobileqq", this.D);
  }

  public boolean e_()
  {
    return true;
  }

  protected boolean g()
  {
    i.c("", "#### qzone app id  = " + this.c);
    this.e = Tencent.createInstance(this.c, this.D);
    if (this.e == null)
    {
      i.b(m, "Tencent变量初始化失败，请检查你的app id跟AndroidManifest.xml文件中AuthActivity的scheme是否填写正确");
      return false;
    }
    return true;
  }

  protected boolean l()
  {
    return (this.e != null) && (this.e.getAppId().equals(this.c));
  }

  protected String m()
  {
    String str = "";
    if ((TextUtils.isEmpty(ay.f)) && (this.D != null))
    {
      CharSequence localCharSequence = this.D.getApplicationInfo().loadLabel(this.D.getPackageManager());
      if (!TextUtils.isEmpty(localCharSequence))
      {
        str = localCharSequence.toString();
        ay.f = str;
      }
      return str;
    }
    return ay.f;
  }

  public void n()
  {
  }

  protected static abstract interface ObtainAppIdListener
  {
    public abstract void a();
  }

  public static abstract interface ObtainImageUrlListener
  {
    public abstract void a(String paramString);
  }

  static abstract class a<T> extends s<T>
  {
    private ProgressDialog a = null;
    private String b;

    public a(Context paramContext, String paramString)
    {
      b(paramString);
      if ((paramContext instanceof Activity))
        this.a = a((Activity)paramContext, this.b);
    }

    private ProgressDialog a(Activity paramActivity, String paramString)
    {
      Context localContext = paramActivity.getApplicationContext();
      int i = com.umeng.socialize.common.b.a(localContext, b.a.d, "Theme.UMDialog");
      if (TextUtils.isEmpty(paramString))
        if (ax.o() != p.f)
          break label77;
      label77: for (String str = "umeng_socialize_text_waitting_qzone"; ; str = "umeng_socialize_text_waitting_qq")
      {
        paramString = localContext.getString(com.umeng.socialize.common.b.a(localContext, b.a.e, str));
        this.a = new ProgressDialog(paramActivity, i);
        this.a.setMessage(paramString);
        return this.a;
      }
    }

    protected void a()
    {
      super.a();
      m.b(this.a);
    }

    protected void a(T paramT)
    {
      super.a(paramT);
      m.a(this.a);
    }

    public void b(String paramString)
    {
      this.b = paramString;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.UMTencentSsoHandler
 * JD-Core Version:    0.6.0
 */