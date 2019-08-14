package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.authjs.a.a;
import com.alipay.sdk.util.k;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthActivity extends Activity
{
  static final String a = "params";
  static final String b = "redirectUri";
  private WebView c;
  private String d;
  private com.alipay.sdk.widget.a e;
  private Handler f;
  private boolean g;
  private boolean h;
  private Runnable i = new d(this);

  private void a()
  {
    try
    {
      if (this.e == null)
        this.e = new com.alipay.sdk.widget.a(this);
      this.e.b();
      return;
    }
    catch (Exception localException)
    {
      this.e = null;
    }
  }

  private void a(com.alipay.sdk.authjs.a parama)
  {
    if ((this.c == null) || (parama == null))
      return;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("clientId", parama.i);
      localJSONObject.put("func", parama.k);
      localJSONObject.put("param", parama.m);
      localJSONObject.put("msgType", parama.l);
      runOnUiThread(new c(this, String.format("AlipayJSBridge._invokeJS(%s)", new Object[] { localJSONObject.toString() })));
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
      return false;
    while ((paramString.startsWith("http://")) || (paramString.startsWith("https://")));
    if (!"SDKLite://h5quit".equalsIgnoreCase(paramString))
    {
      if (TextUtils.equals(paramString, this.d))
        paramString = paramString + "?resultCode=150";
      h.a(this, paramString);
    }
    finish();
    return true;
  }

  private void b()
  {
    if ((this.e != null) && (this.e.a()))
      this.e.c();
    this.e = null;
  }

  private void b(String paramString)
  {
    com.alipay.sdk.authjs.c localc = new com.alipay.sdk.authjs.c(getApplicationContext(), new b(this));
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      String str2 = localJSONObject1.getString("clientId");
      try
      {
        if (TextUtils.isEmpty(str2))
          return;
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("param");
        if (!(localJSONObject2 instanceof JSONObject))
          break label166;
        localJSONObject3 = (JSONObject)localJSONObject2;
        String str3 = localJSONObject1.getString("func");
        String str4 = localJSONObject1.getString("bundleName");
        com.alipay.sdk.authjs.a locala = new com.alipay.sdk.authjs.a("call");
        locala.j = str4;
        locala.k = str3;
        locala.m = localJSONObject3;
        locala.i = str2;
        localc.a(locala);
        return;
      }
      catch (Exception localException2)
      {
        str1 = str2;
        if (TextUtils.isEmpty(str1))
          return;
      }
      try
      {
        localc.a(str1, a.a.d);
        return;
      }
      catch (JSONException localJSONException)
      {
        return;
      }
    }
    catch (Exception localException1)
    {
      while (true)
      {
        String str1 = null;
        continue;
        label166: JSONObject localJSONObject3 = null;
      }
    }
  }

  public void onBackPressed()
  {
    if (this.c.canGoBack())
    {
      if (this.h)
      {
        h.a(this, this.d + "?resultCode=150");
        finish();
      }
      return;
    }
    h.a(this, this.d + "?resultCode=150");
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
        this.d = localBundle.getString("redirectUri");
        str = localBundle.getString("params");
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
      this.f = new Handler(getMainLooper());
      LinearLayout localLinearLayout = new LinearLayout(getApplicationContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      localLinearLayout.setOrientation(1);
      setContentView(localLinearLayout, localLayoutParams);
      this.c = new WebView(getApplicationContext());
      localLayoutParams.weight = 1.0F;
      this.c.setVisibility(0);
      localLinearLayout.addView(this.c, localLayoutParams);
      WebSettings localWebSettings1 = this.c.getSettings();
      localWebSettings1.setUserAgentString(localWebSettings1.getUserAgentString() + k.c(getApplicationContext()));
      localWebSettings1.setRenderPriority(WebSettings.RenderPriority.HIGH);
      localWebSettings1.setSupportMultipleWindows(true);
      localWebSettings1.setJavaScriptEnabled(true);
      localWebSettings1.setSavePassword(false);
      localWebSettings1.setJavaScriptCanOpenWindowsAutomatically(true);
      localWebSettings1.setMinimumFontSize(8 + localWebSettings1.getMinimumFontSize());
      localWebSettings1.setAllowFileAccess(false);
      localWebSettings1.setTextSize(WebSettings.TextSize.NORMAL);
      this.c.setVerticalScrollbarOverlay(true);
      this.c.setWebViewClient(new b(0));
      this.c.setWebChromeClient(new a(0));
      this.c.setDownloadListener(new a(this));
      this.c.loadUrl(str);
      if (Build.VERSION.SDK_INT >= 7);
      try
      {
        Class localClass = this.c.getSettings().getClass();
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Boolean.TYPE;
        Method localMethod2 = localClass.getMethod("setDomStorageEnabled", arrayOfClass);
        if (localMethod2 != null)
        {
          WebSettings localWebSettings2 = this.c.getSettings();
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Boolean.valueOf(true);
          localMethod2.invoke(localWebSettings2, arrayOfObject);
        }
        try
        {
          label413: Method localMethod1 = this.c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
          if (localMethod1 == null)
            continue;
          localMethod1.invoke(this.c, new Object[] { "searchBoxJavaBridge_" });
          return;
        }
        catch (Exception localException3)
        {
          return;
        }
      }
      catch (Exception localException4)
      {
        break label413;
      }
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c != null)
    {
      this.c.removeAllViews();
      this.c.destroy();
      this.c = null;
    }
  }

  private final class a extends WebChromeClient
  {
    private a()
    {
    }

    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      String str1 = paramConsoleMessage.message();
      if (TextUtils.isEmpty(str1))
        return super.onConsoleMessage(paramConsoleMessage);
      boolean bool = str1.startsWith("h5container.message: ");
      String str2 = null;
      if (bool)
        str2 = str1.replaceFirst("h5container.message: ", "");
      if (TextUtils.isEmpty(str2))
        return super.onConsoleMessage(paramConsoleMessage);
      AuthActivity.b(AuthActivity.this, str2);
      return super.onConsoleMessage(paramConsoleMessage);
    }
  }

  private final class b extends WebViewClient
  {
    private b()
    {
    }

    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      AuthActivity.g(AuthActivity.this);
      AuthActivity.f(AuthActivity.this).removeCallbacks(AuthActivity.e(AuthActivity.this));
    }

    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AuthActivity.d(AuthActivity.this);
      AuthActivity.f(AuthActivity.this).postDelayed(AuthActivity.e(AuthActivity.this), 30000L);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AuthActivity.a(AuthActivity.this);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }

    public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (AuthActivity.b(AuthActivity.this))
      {
        paramSslErrorHandler.proceed();
        AuthActivity.a(AuthActivity.this, false);
        return;
      }
      AuthActivity.this.runOnUiThread(new e(this, paramSslErrorHandler));
    }

    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (AuthActivity.a(AuthActivity.this, paramString))
      {
        paramWebView.stopLoading();
        return true;
      }
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.auth.AuthActivity
 * JD-Core Version:    0.6.0
 */