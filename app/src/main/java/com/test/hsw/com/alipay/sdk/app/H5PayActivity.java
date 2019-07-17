package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.widget.a;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class H5PayActivity extends Activity
{
  private WebView a;
  private a b;
  private Handler c;
  private boolean d;
  private boolean e;
  private Runnable f = new g(this);

  private static void a()
  {
    try
    {
      synchronized (PayTask.a)
      {
        ???.notify();
        label10: return;
      }
    }
    catch (Exception localException)
    {
      break label10;
    }
  }

  private void b()
  {
    if (this.b == null)
      this.b = new a(this);
    this.b.b();
  }

  private void c()
  {
    if ((this.b != null) && (this.b.a()))
      this.b.c();
    this.b = null;
  }

  public void finish()
  {
    try
    {
      synchronized (PayTask.a)
      {
        ???.notify();
        label10: super.finish();
        return;
      }
    }
    catch (Exception localException)
    {
      break label10;
    }
  }

  public void onBackPressed()
  {
    if (this.a.canGoBack())
    {
      if (this.d)
      {
        m localm = m.a(m.d.a());
        l.a = l.a(localm.a(), localm.b(), "");
        finish();
      }
      return;
    }
    l.a = l.a();
    finish();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    while (true)
    {
      Bundle localBundle;
      try
      {
        localBundle = getIntent().getExtras();
        if (localBundle == null)
        {
          finish();
          return;
        }
      }
      catch (Exception localException1)
      {
        finish();
        return;
      }
      String str1;
      try
      {
        str1 = localBundle.getString("url");
        if (!com.alipay.sdk.util.k.a(str1))
        {
          finish();
          return;
        }
      }
      catch (Exception localException2)
      {
        finish();
        return;
      }
      super.requestWindowFeature(1);
      this.c = new Handler(getMainLooper());
      String str2 = localBundle.getString("cookie");
      if (!TextUtils.isEmpty(str2))
      {
        CookieSyncManager.createInstance(getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(str1, str2);
        CookieSyncManager.getInstance().sync();
      }
      LinearLayout localLinearLayout = new LinearLayout(getApplicationContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      localLinearLayout.setOrientation(1);
      setContentView(localLinearLayout, localLayoutParams);
      this.a = new WebView(getApplicationContext());
      localLayoutParams.weight = 1.0F;
      this.a.setVisibility(0);
      localLinearLayout.addView(this.a, localLayoutParams);
      WebSettings localWebSettings1 = this.a.getSettings();
      localWebSettings1.setUserAgentString(localWebSettings1.getUserAgentString() + com.alipay.sdk.util.k.c(getApplicationContext()));
      localWebSettings1.setRenderPriority(WebSettings.RenderPriority.HIGH);
      localWebSettings1.setSupportMultipleWindows(true);
      localWebSettings1.setJavaScriptEnabled(true);
      localWebSettings1.setSavePassword(false);
      localWebSettings1.setJavaScriptCanOpenWindowsAutomatically(true);
      localWebSettings1.setMinimumFontSize(8 + localWebSettings1.getMinimumFontSize());
      localWebSettings1.setAllowFileAccess(false);
      localWebSettings1.setTextSize(WebSettings.TextSize.NORMAL);
      this.a.setVerticalScrollbarOverlay(true);
      this.a.setWebViewClient(new a(0));
      this.a.loadUrl(str1);
      if (Build.VERSION.SDK_INT >= 7);
      try
      {
        Class localClass = this.a.getSettings().getClass();
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Boolean.TYPE;
        Method localMethod2 = localClass.getMethod("setDomStorageEnabled", arrayOfClass);
        if (localMethod2 != null)
        {
          WebSettings localWebSettings2 = this.a.getSettings();
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Boolean.valueOf(true);
          localMethod2.invoke(localWebSettings2, arrayOfObject);
        }
        try
        {
          label414: Method localMethod1 = this.a.getClass().getMethod("removeJavascriptInterface", new Class[0]);
          if (localMethod1 == null)
            continue;
          localMethod1.invoke(this.a, new Object[] { "searchBoxJavaBridge_" });
          return;
        }
        catch (Exception localException3)
        {
          return;
        }
      }
      catch (Exception localException4)
      {
        break label414;
      }
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null)
    {
      this.a.removeAllViews();
      this.a.destroy();
      this.a = null;
    }
  }

  private final class a extends WebViewClient
  {
    private a()
    {
    }

    public final void onLoadResource(WebView paramWebView, String paramString)
    {
    }

    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      H5PayActivity.f(H5PayActivity.this);
      H5PayActivity.e(H5PayActivity.this).removeCallbacks(H5PayActivity.d(H5PayActivity.this));
    }

    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      H5PayActivity.c(H5PayActivity.this);
      H5PayActivity.e(H5PayActivity.this).postDelayed(H5PayActivity.d(H5PayActivity.this), 30000L);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      H5PayActivity.a(H5PayActivity.this);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }

    public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (H5PayActivity.b(H5PayActivity.this))
      {
        paramSslErrorHandler.proceed();
        H5PayActivity.a(H5PayActivity.this, false);
        return;
      }
      H5PayActivity.this.runOnUiThread(new h(this, paramSslErrorHandler));
    }

    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (paramString.startsWith("alipays://platformapi/startApp?"))
        return false;
      if ((TextUtils.equals(paramString, "sdklite://h5quit")) || (TextUtils.equals(paramString, "http://m.alipay.com/?action=h5quit")))
      {
        l.a = l.a();
        H5PayActivity.this.finish();
        return true;
      }
      if (paramString.startsWith("sdklite://h5quit?result="))
        try
        {
          String str1 = paramString.substring(24 + paramString.indexOf("sdklite://h5quit?result="));
          int i = Integer.parseInt(str1.substring(10 + str1.lastIndexOf("&end_code=")));
          if ((i == m.a.a()) || (i == m.f.a()))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            String str2 = URLDecoder.decode(paramString);
            String str3 = str2.substring(24 + str2.indexOf("sdklite://h5quit?result="), str2.lastIndexOf("&end_code="));
            if (str3.contains("&return_url=\""))
            {
              String str4 = str3.split("&return_url=\"")[0];
              int j = 13 + str3.indexOf("&return_url=\"");
              localStringBuilder.append(str4).append("&return_url=\"").append(str3.substring(j, str3.indexOf("\"&", j))).append(str3.substring(str3.indexOf("\"&", j)));
              str3 = localStringBuilder.toString();
            }
            m localm1 = m.a(i);
            l.a = l.a(localm1.a(), localm1.b(), str3);
          }
          while (true)
          {
            k localk = new k(this);
            H5PayActivity.this.runOnUiThread(localk);
            return true;
            m localm2 = m.a(m.b.a());
            l.a = l.a(localm2.a(), localm2.b(), "");
          }
        }
        catch (Exception localException)
        {
          while (true)
            l.a = l.b();
        }
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.app.H5PayActivity
 * JD-Core Version:    0.6.0
 */