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
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.util.k;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class H5AuthActivity extends Activity
{
  private WebView a;
  private com.alipay.sdk.widget.a b;
  private Handler c;
  private boolean d;
  private boolean e;
  private Runnable f = new b(this);

  private static void a()
  {
    try
    {
      synchronized (AuthTask.a)
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
      this.b = new com.alipay.sdk.widget.a(this);
    try
    {
      this.b.b();
      return;
    }
    catch (Exception localException)
    {
      this.b = null;
    }
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
      synchronized (AuthTask.a)
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
      if (this.e)
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
      String str;
      try
      {
        str = localBundle.getString("url");
        if (!k.a(str))
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
      LinearLayout localLinearLayout = new LinearLayout(getApplicationContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      localLinearLayout.setOrientation(1);
      setContentView(localLinearLayout, localLayoutParams);
      this.a = new WebView(getApplicationContext());
      localLayoutParams.weight = 1.0F;
      this.a.setVisibility(0);
      localLinearLayout.addView(this.a, localLayoutParams);
      WebSettings localWebSettings1 = this.a.getSettings();
      localWebSettings1.setUserAgentString(localWebSettings1.getUserAgentString() + k.c(getApplicationContext()));
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
      this.a.setDownloadListener(new a(this));
      this.a.loadUrl(str);
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
          label387: Method localMethod1 = this.a.getClass().getMethod("removeJavascriptInterface", new Class[0]);
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
        break label387;
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

    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      H5AuthActivity.f(H5AuthActivity.this);
      H5AuthActivity.e(H5AuthActivity.this).removeCallbacks(H5AuthActivity.d(H5AuthActivity.this));
    }

    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      H5AuthActivity.c(H5AuthActivity.this);
      H5AuthActivity.e(H5AuthActivity.this).postDelayed(H5AuthActivity.d(H5AuthActivity.this), 30000L);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      H5AuthActivity.a(H5AuthActivity.this);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }

    public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (H5AuthActivity.b(H5AuthActivity.this))
      {
        paramSslErrorHandler.proceed();
        H5AuthActivity.a(H5AuthActivity.this, false);
        return;
      }
      H5AuthActivity.this.runOnUiThread(new c(this, paramSslErrorHandler));
    }

    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((TextUtils.equals(paramString, "sdklite://h5quit")) || (TextUtils.equals(paramString, "http://m.alipay.com/?action=h5quit")))
      {
        l.a = l.a();
        H5AuthActivity.this.finish();
        return true;
      }
      if (paramString.startsWith("sdklite://h5quit?result="))
        try
        {
          String str1 = paramString.substring(24 + paramString.indexOf("sdklite://h5quit?result="));
          int i = Integer.parseInt(str1.substring(10 + str1.lastIndexOf("&end_code=")));
          if (i == m.a.a())
          {
            String str2 = URLDecoder.decode(paramString);
            String str3 = str2.substring(24 + str2.indexOf("sdklite://h5quit?result="), str2.lastIndexOf("&end_code="));
            m localm2 = m.a(i);
            l.a = l.a(localm2.a(), localm2.b(), str3);
          }
          while (true)
          {
            f localf = new f(this);
            H5AuthActivity.this.runOnUiThread(localf);
            return true;
            m localm1 = m.a(m.b.a());
            l.a = l.a(localm1.a(), localm1.b(), "");
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
 * Qualified Name:     com.alipay.sdk.app.H5AuthActivity
 * JD-Core Version:    0.6.0
 */