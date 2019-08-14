package com.umeng.socialize.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.umeng.socialize.b.b.d;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.common.b;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.utils.c;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class aa extends Dialog
{
  private static final String a = aa.class.getName();
  private static final String p = "sina2/main?uid";
  private static final String q = "tenc2/main?uid";
  private static final String r = "renr2/main?uid";
  private static final String s = "douban/main?uid";
  private WebView b;
  private SocializeListeners.UMAuthListener c;
  private View d;
  private View e;
  private CheckBox f;
  private int g = 0;
  private Bundle h;
  private UMSocialService i;
  private String j = "error";
  private Context k;
  private Activity l;
  private com.umeng.socialize.bean.p m;
  private Set<String> n;
  private SocializeListeners.MulStatusListener o;
  private Handler t = new ab(this);

  public aa(Activity paramActivity, ay paramay, com.umeng.socialize.bean.p paramp, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    super(paramActivity, b.a(paramActivity.getApplicationContext(), b.a.d, "umeng_socialize_popup_dialog"));
    this.k = paramActivity.getApplicationContext();
    this.l = paramActivity;
    this.c = paramUMAuthListener;
    this.m = paramp;
    this.i = com.umeng.socialize.controller.a.a(paramay.c);
    ax localax = this.i.c();
    this.n = localax.a(paramp);
    this.o = localax.h();
    View localView1;
    int i4;
    label261: int i5;
    label278: label294: WindowManager.LayoutParams localLayoutParams;
    switch (aj.a[paramp.ordinal()])
    {
    default:
      LayoutInflater localLayoutInflater = (LayoutInflater)this.l.getSystemService("layout_inflater");
      int i1 = b.a(this.k, b.a.a, "umeng_socialize_oauth_dialog");
      int i2 = b.a(this.k, b.a.b, "umeng_socialize_follow");
      int i3 = b.a(this.k, b.a.b, "umeng_socialize_follow_check");
      this.d = localLayoutInflater.inflate(i1, null);
      localView1 = this.d.findViewById(i2);
      this.f = ((CheckBox)this.d.findViewById(i3));
      if ((this.n == null) || (this.n.size() <= 0))
        break;
      i4 = 1;
      if ((paramp == com.umeng.socialize.bean.p.e) || (paramp == com.umeng.socialize.bean.p.k))
      {
        i5 = 1;
        if ((i4 == 0) || (i5 == 0))
          break label656;
        localView1.setVisibility(0);
        int i6 = b.a(this.k, b.a.b, "progress_bar_parent");
        int i7 = b.a(this.k, b.a.b, "umeng_socialize_title_bar_leftBt");
        int i8 = b.a(this.k, b.a.b, "umeng_socialize_title_bar_rightBt");
        int i9 = b.a(this.k, b.a.b, "umeng_socialize_title_bar_middleTv");
        int i10 = b.a(this.k, b.a.b, "umeng_socialize_titlebar");
        this.e = this.d.findViewById(i6);
        this.e.setVisibility(0);
        ((Button)this.d.findViewById(i7)).setOnClickListener(new ac(this));
        this.d.findViewById(i8).setVisibility(8);
        ((TextView)this.d.findViewById(i9)).setText("授权" + com.umeng.socialize.common.p.a(this.k, paramp));
        b();
        View localView2 = this.d.findViewById(i10);
        int i11 = m.a(this.k, 200.0F);
        ad localad = new ad(this, this.k, localView1, localView2, i11);
        localad.addView(this.d, -1, -1);
        setContentView(localad);
        localLayoutParams = getWindow().getAttributes();
        if (!m.d(this.k))
          break label666;
        int[] arrayOfInt = m.c(this.k);
        localLayoutParams.width = arrayOfInt[0];
        localLayoutParams.height = arrayOfInt[1];
      }
    case 1:
    case 2:
    case 3:
    case 4:
    }
    for (int i12 = b.a(getContext(), b.a.d, "umeng_socialize_dialog_anim_fade"); ; i12 = b.a(getContext(), b.a.d, "umeng_socialize_dialog_animations"))
    {
      localLayoutParams.gravity = 17;
      getWindow().getAttributes().windowAnimations = i12;
      return;
      this.j = "sina2/main?uid";
      break;
      this.j = "tenc2/main?uid";
      break;
      this.j = "renr2/main?uid";
      break;
      this.j = "douban/main?uid";
      break;
      i4 = 0;
      break label261;
      i5 = 0;
      break label278;
      label656: localView1.setVisibility(8);
      break label294;
      label666: localLayoutParams.height = -1;
      localLayoutParams.width = -1;
    }
  }

  private String a(ay paramay, com.umeng.socialize.bean.p paramp)
  {
    String str1 = m.a(this.k);
    String str2 = "http://log.umsns.com/share/auth/" + str1 + "/" + paramay.a + "/?";
    Map localMap = d.a(this.k, paramay, 10);
    StringBuilder localStringBuilder = new StringBuilder("via=" + paramp + "&");
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str5 = (String)localIterator.next();
      localStringBuilder.append(str5 + "=" + localMap.get(str5) + "&");
    }
    if (localStringBuilder.length() > 0)
      localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    try
    {
      String str3 = "ud_get=" + com.umeng.socialize.b.b.a.a(localStringBuilder.toString(), "UTF-8");
      String str4 = str2 + str3;
      return str4;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str2;
  }

  private String a(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("ud_get=");
      arrayOfString[1] = com.umeng.socialize.b.b.a.b(arrayOfString[1], "UTF-8").trim();
      String str = arrayOfString[0] + arrayOfString[1];
      return str;
    }
    catch (Exception localException)
    {
      i.b(a, "### AuthWebViewClient解密失败");
      localException.printStackTrace();
    }
    return paramString;
  }

  private boolean b()
  {
    this.b = ((WebView)this.d.findViewById(b.a(this.k, b.a.b, "webView")));
    this.b.setWebViewClient(c());
    this.b.setWebChromeClient(new ag(this));
    this.b.requestFocusFromTouch();
    this.b.setVerticalScrollBarEnabled(false);
    this.b.setHorizontalScrollBarEnabled(false);
    this.b.setScrollBarStyle(0);
    this.b.getSettings().setCacheMode(2);
    WebSettings localWebSettings = this.b.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 8)
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    localWebSettings.setUseWideViewPort(true);
    if (Build.VERSION.SDK_INT >= 8)
    {
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setDatabaseEnabled(true);
      localWebSettings.setDomStorageEnabled(true);
      localWebSettings.setGeolocationEnabled(true);
      localWebSettings.setAppCacheEnabled(true);
    }
    if (Build.VERSION.SDK_INT >= 11);
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      Method localMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", arrayOfClass);
      localMethod.setAccessible(true);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(false);
      localMethod.invoke(localWebSettings, arrayOfObject);
      try
      {
        label247: if (this.m == com.umeng.socialize.bean.p.h)
        {
          CookieSyncManager.createInstance(this.k);
          CookieManager.getInstance().removeAllCookie();
        }
        return true;
      }
      catch (Exception localException1)
      {
        return true;
      }
    }
    catch (Exception localException2)
    {
      break label247;
    }
  }

  private WebViewClient c()
  {
    int i1 = 1;
    try
    {
      Method localMethod = WebViewClient.class.getMethod("onReceivedSslError", new Class[] { WebView.class, SslErrorHandler.class, SslError.class });
      if (localMethod != null)
      {
        i2 = i1;
        if (i2 != 0)
        {
          i.a(a, "has method onReceivedSslError : ");
          return new ah(this);
        }
        i.a(a, "has no method onReceivedSslError : ");
        return new a(null);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        i2 = 0;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
      {
        int i2 = 0;
        continue;
        i1 = 0;
      }
    }
  }

  private void d()
  {
    if ((this.n != null) && (this.n.size() > 0))
    {
      String[] arrayOfString = new String[this.n.size()];
      Iterator localIterator = this.n.iterator();
      int i2;
      for (int i1 = 0; localIterator.hasNext(); i1 = i2)
      {
        String str = (String)localIterator.next();
        i2 = i1 + 1;
        arrayOfString[i1] = str;
      }
      this.i.a(this.k, this.m, this.o, arrayOfString);
      e();
    }
  }

  private void e()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.k.getSharedPreferences("umeng_follow", 0).edit();
      localEditor.putBoolean(this.m.toString(), false);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void dismiss()
  {
    if (this.h != null)
      if (TextUtils.isEmpty(this.h.getString("uid")))
        if (this.c != null)
          this.c.a(new com.umeng.socialize.a.a("unfetch usid..."), this.m);
    while (true)
    {
      super.dismiss();
      return;
      i.c(a, "### dismiss ");
      if (this.c == null)
        continue;
      this.c.a(this.h, this.m);
      if ((this.f == null) || (!this.f.isChecked()))
        continue;
      this.t.sendEmptyMessage(2);
      continue;
      if (this.c == null)
        continue;
      this.c.a(this.m);
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public void show()
  {
    super.show();
    this.h = null;
    ay localay = this.i.f();
    if (localay.e)
    {
      String str = a(localay, this.m);
      this.b.loadUrl(str);
      return;
    }
    this.i.d(this.k, new ai(this));
  }

  private class a extends WebViewClient
  {
    private a()
    {
    }

    private void a(String paramString)
    {
      i.c(aa.a(), "OauthDialog " + paramString);
      aa.a(aa.this, 1);
      aa.a(aa.this, m.a(paramString));
      if (aa.this.isShowing())
        m.a(aa.this);
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      aa.d(aa.this).sendEmptyMessage(1);
      super.onPageFinished(paramWebView, paramString);
      if ((aa.g(aa.this) == 0) && (paramString.contains(aa.f(aa.this))))
        a(paramString);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      if (paramString.contains("?ud_get="))
        paramString = aa.a(aa.this, paramString);
      if ((paramString.contains("access_key")) && (paramString.contains("access_secret")))
      {
        if (paramString.contains(aa.f(aa.this)))
          a(paramString);
        return;
      }
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      i.b(aa.a(), "onReceivedError: " + paramString2 + "\nerrCode: " + paramInt + " description:" + paramString1);
      if (aa.a(aa.this).getVisibility() == 0)
        aa.a(aa.this).setVisibility(8);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      m.a(aa.this);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (!c.f(aa.c(aa.this)))
      {
        Toast.makeText(aa.c(aa.this), "抱歉,您的网络不可用...", 0).show();
        return true;
      }
      if (paramString.contains("?ud_get="))
        paramString = aa.a(aa.this, paramString);
      if (paramString.contains(aa.f(aa.this)))
        a(paramString);
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.aa
 * JD-Core Version:    0.6.0
 */