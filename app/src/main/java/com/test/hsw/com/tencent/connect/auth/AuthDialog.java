package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.c.c;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.Util;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.open.web.security.b;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthDialog extends Dialog
{
  private static final String a = f.d + ".authDlg";
  private String b;
  private OnTimeListener c;
  private IUiListener d;
  private Handler e;
  private FrameLayout f;
  private LinearLayout g;
  private FrameLayout h;
  private ProgressBar i;
  private String j;
  private c k;
  private Context l;
  private b m;
  private boolean n = false;
  private int o;
  private String p;
  private String q;
  private long r = 0L;
  private long s = 30000L;
  private HashMap<String, Runnable> t;

  static
  {
    try
    {
      Context localContext = Global.getContext();
      if (localContext != null)
      {
        if (new File(localContext.getFilesDir().toString() + "/" + "libwbsafeedit.so").exists())
        {
          System.load(localContext.getFilesDir().toString() + "/" + "libwbsafeedit.so");
          f.b(a, "-->load wbsafeedit lib success.");
          return;
        }
        f.b(a, "-->load wbsafeedit lib fail, because so is not exists.");
        return;
      }
    }
    catch (Exception localException)
    {
      f.b(a, "-->load wbsafeedit lib error.", localException);
      return;
    }
    f.b(a, "-->load wbsafeedit lib fail, because context is null.");
  }

  public AuthDialog(Context paramContext, String paramString1, String paramString2, IUiListener paramIUiListener, QQToken paramQQToken)
  {
    super(paramContext, 16973840);
    this.l = paramContext;
    this.b = paramString2;
    this.c = new OnTimeListener(paramString1, paramString2, paramQQToken.getAppId(), paramIUiListener);
    this.e = new THandler(this.c, paramContext.getMainLooper());
    this.d = paramIUiListener;
    this.j = paramString1;
    this.m = new b();
    getWindow().setSoftInputMode(32);
  }

  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if ((!TextUtils.isEmpty(this.q)) && (this.q.length() >= 4))
    {
      String str = this.q.substring(-4 + this.q.length());
      localStringBuilder.append("_u_").append(str);
    }
    return localStringBuilder.toString();
  }

  private String b()
  {
    String str1 = this.b.substring(1 + this.b.indexOf("?"));
    String str2 = "http://qzs.qq.com/open/mobile/login/qzsjump.html?" + str1;
    f.c(a, "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
    return str2;
  }

  private static void b(Context paramContext, String paramString)
  {
    try
    {
      JSONObject localJSONObject = Util.parseJson(paramString);
      int i1 = localJSONObject.getInt("type");
      String str = localJSONObject.getString("msg");
      Toast.makeText(paramContext.getApplicationContext(), str, i1).show();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  private void c()
  {
    d();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.k = new c(this.l);
    this.k.setLayoutParams(localLayoutParams);
    this.f = new FrameLayout(this.l);
    localLayoutParams.gravity = 17;
    this.f.setLayoutParams(localLayoutParams);
    this.f.addView(this.k);
    this.f.addView(this.h);
    setContentView(this.f);
  }

  private void d()
  {
    this.i = new ProgressBar(this.l);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    this.i.setLayoutParams(localLayoutParams1);
    this.g = new LinearLayout(this.l);
    boolean bool = this.j.equals("action_login");
    TextView localTextView = null;
    LinearLayout.LayoutParams localLayoutParams2;
    if (bool)
    {
      localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2.gravity = 16;
      localLayoutParams2.leftMargin = 5;
      localTextView = new TextView(this.l);
      if (!Locale.getDefault().getLanguage().equals("zh"))
        break label301;
      localTextView.setText("登录中...");
    }
    while (true)
    {
      localTextView.setTextColor(Color.rgb(255, 255, 255));
      localTextView.setTextSize(18.0F);
      localTextView.setLayoutParams(localLayoutParams2);
      FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams3.gravity = 17;
      this.g.setLayoutParams(localLayoutParams3);
      this.g.addView(this.i);
      if (localTextView != null)
        this.g.addView(localTextView);
      this.h = new FrameLayout(this.l);
      FrameLayout.LayoutParams localLayoutParams4 = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams4.leftMargin = 80;
      localLayoutParams4.rightMargin = 80;
      localLayoutParams4.topMargin = 40;
      localLayoutParams4.bottomMargin = 40;
      localLayoutParams4.gravity = 17;
      this.h.setLayoutParams(localLayoutParams4);
      this.h.setBackgroundResource(17301504);
      this.h.addView(this.g);
      return;
      label301: localTextView.setText("Logging in...");
    }
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private void e()
  {
    this.k.setVerticalScrollBarEnabled(false);
    this.k.setHorizontalScrollBarEnabled(false);
    this.k.setWebViewClient(new LoginWebViewClient(null));
    this.k.setWebChromeClient(new WebChromeClient());
    this.k.clearFormData();
    this.k.clearSslPreferences();
    this.k.setOnLongClickListener(new AuthDialog.1(this));
    this.k.setOnTouchListener(new AuthDialog.2(this));
    WebSettings localWebSettings = this.k.getSettings();
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setNeedInitialFocus(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDatabasePath(this.l.getDir("databases", 0).getPath());
    localWebSettings.setDomStorageEnabled(true);
    f.b(a, "-->mUrl : " + this.b);
    this.p = this.b;
    this.k.loadUrl(this.b);
    this.k.setVisibility(4);
    this.k.getSettings().setSavePassword(false);
    this.m.a(new SecureJsInterface(), "SecureJsInterface");
    SecureJsInterface.isPWDEdit = false;
    super.setOnDismissListener(new AuthDialog.3(this));
  }

  private boolean f()
  {
    AuthMap localAuthMap = AuthMap.getInstance();
    String str1 = localAuthMap.makeKey();
    AuthMap.Auth localAuth = new AuthMap.Auth();
    localAuth.listener = this.d;
    localAuth.dialog = this;
    localAuth.key = str1;
    String str2 = localAuthMap.set(localAuth);
    String str3 = this.b.substring(0, this.b.indexOf("?"));
    Bundle localBundle = Util.parseUrl(this.b);
    localBundle.putString("token_key", str1);
    localBundle.putString("serial", str2);
    localBundle.putString("browser", "1");
    this.b = (str3 + "?" + Util.encodeUrl(localBundle));
    return Util.openBrowser(this.l, this.b);
  }

  public void callJs(String paramString1, String paramString2)
  {
    String str = "javascript:" + paramString1 + "(" + paramString2 + ");void(" + System.currentTimeMillis() + ");";
    this.k.loadUrl(str);
  }

  public void dismiss()
  {
    this.t.clear();
    this.e.removeCallbacksAndMessages(null);
    if (isShowing())
      super.dismiss();
    if (this.k != null)
    {
      this.k.destroy();
      this.k = null;
    }
  }

  public void onBackPressed()
  {
    if (!this.n)
      this.c.onCancel();
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    c();
    e();
    this.t = new HashMap();
  }

  protected void onStop()
  {
    super.onStop();
  }

  private class LoginWebViewClient extends WebViewClient
  {
    private LoginWebViewClient()
    {
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      f.b(AuthDialog.a(), "-->onPageFinished, url: " + paramString);
      AuthDialog.g(AuthDialog.this).setVisibility(8);
      if (AuthDialog.e(AuthDialog.this) != null)
        AuthDialog.e(AuthDialog.this).setVisibility(0);
      if (!TextUtils.isEmpty(paramString))
        AuthDialog.n(AuthDialog.this).removeCallbacks((Runnable)AuthDialog.p(AuthDialog.this).remove(paramString));
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      f.b(AuthDialog.a(), "-->onPageStarted, url: " + paramString);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      AuthDialog.g(AuthDialog.this).setVisibility(0);
      AuthDialog.a(AuthDialog.this, SystemClock.elapsedRealtime());
      if (!TextUtils.isEmpty(AuthDialog.i(AuthDialog.this)))
        AuthDialog.n(AuthDialog.this).removeCallbacks((Runnable)AuthDialog.p(AuthDialog.this).remove(AuthDialog.i(AuthDialog.this)));
      AuthDialog.c(AuthDialog.this, paramString);
      AuthDialog.TimeOutRunable localTimeOutRunable = new AuthDialog.TimeOutRunable(AuthDialog.this, AuthDialog.i(AuthDialog.this));
      AuthDialog.p(AuthDialog.this).put(paramString, localTimeOutRunable);
      AuthDialog.n(AuthDialog.this).postDelayed(localTimeOutRunable, 120000L);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      f.c(AuthDialog.a(), "-->onReceivedError, errorCode: " + paramInt + " | description: " + paramString1);
      if (!Util.checkNetWork(AuthDialog.a(AuthDialog.this)))
      {
        AuthDialog.f(AuthDialog.this).onError(new UiError(9001, "当前网络不可用，请稍后重试！", paramString2));
        AuthDialog.this.dismiss();
        return;
      }
      if (!AuthDialog.i(AuthDialog.this).startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?"))
      {
        long l = SystemClock.elapsedRealtime() - AuthDialog.j(AuthDialog.this);
        if ((AuthDialog.k(AuthDialog.this) < 1) && (l < AuthDialog.l(AuthDialog.this)))
        {
          AuthDialog.m(AuthDialog.this);
          AuthDialog.n(AuthDialog.this).postDelayed(new AuthDialog.LoginWebViewClient.1(this), 500L);
          return;
        }
        AuthDialog.e(AuthDialog.this).loadUrl(AuthDialog.o(AuthDialog.this));
        return;
      }
      AuthDialog.f(AuthDialog.this).onError(new UiError(paramInt, paramString1, paramString2));
      AuthDialog.this.dismiss();
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      paramSslErrorHandler.cancel();
      AuthDialog.f(AuthDialog.this).onError(new UiError(paramSslError.getPrimaryError(), "请求不合法，请检查手机安全设置，如系统时间、代理等。", "ssl error"));
      AuthDialog.this.dismiss();
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      f.b(AuthDialog.a(), "-->Redirect URL: " + paramString);
      if (paramString.startsWith("auth://browser"))
      {
        JSONObject localJSONObject = Util.parseUrlToJson(paramString);
        AuthDialog.a(AuthDialog.this, AuthDialog.b(AuthDialog.this));
        if (AuthDialog.c(AuthDialog.this));
        while (true)
        {
          return true;
          if (localJSONObject.optString("fail_cb", null) != null)
          {
            AuthDialog.this.callJs(localJSONObject.optString("fail_cb"), "");
            continue;
          }
          if (localJSONObject.optInt("fall_to_wv") == 1)
          {
            AuthDialog localAuthDialog = AuthDialog.this;
            if (AuthDialog.d(AuthDialog.this).indexOf("?") > -1);
            for (String str2 = "&"; ; str2 = "?")
            {
              AuthDialog.a(localAuthDialog, str2);
              AuthDialog.a(AuthDialog.this, "browser_error=1");
              AuthDialog.e(AuthDialog.this).loadUrl(AuthDialog.d(AuthDialog.this));
              break;
            }
          }
          String str1 = localJSONObject.optString("redir", null);
          if (str1 == null)
            continue;
          AuthDialog.e(AuthDialog.this).loadUrl(str1);
        }
      }
      if (paramString.startsWith("auth://tauth.qq.com/"))
      {
        AuthDialog.f(AuthDialog.this).onComplete(Util.parseUrlToJson(paramString));
        AuthDialog.this.dismiss();
        return true;
      }
      if (paramString.startsWith("auth://cancel"))
      {
        AuthDialog.f(AuthDialog.this).onCancel();
        AuthDialog.this.dismiss();
        return true;
      }
      if (paramString.startsWith("auth://close"))
      {
        AuthDialog.this.dismiss();
        return true;
      }
      if (paramString.startsWith("download://"))
        try
        {
          Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(paramString.substring("download://".length()))));
          localIntent.addFlags(268435456);
          AuthDialog.a(AuthDialog.this).startActivity(localIntent);
          return true;
        }
        catch (Exception localException3)
        {
          while (true)
            f.b(AuthDialog.a(), "-->start download activity exception, e: " + localException3.getMessage());
        }
      if (paramString.startsWith("auth://progress"))
      {
        try
        {
          List localList2 = Uri.parse(paramString).getPathSegments();
          if (localList2.isEmpty())
            return true;
          int i = Integer.valueOf((String)localList2.get(0)).intValue();
          if (i == 0)
          {
            AuthDialog.g(AuthDialog.this).setVisibility(8);
            AuthDialog.e(AuthDialog.this).setVisibility(0);
            break label586;
          }
          if (i != 1)
            break label586;
          AuthDialog.g(AuthDialog.this).setVisibility(0);
        }
        catch (Exception localException2)
        {
          return true;
        }
      }
      else
      {
        if (paramString.startsWith("auth://onLoginSubmit"));
        try
        {
          List localList1 = Uri.parse(paramString).getPathSegments();
          if (!localList1.isEmpty())
            AuthDialog.b(AuthDialog.this, (String)localList1.get(0));
          label546: return true;
          if (AuthDialog.h(AuthDialog.this).a(AuthDialog.e(AuthDialog.this), paramString))
            return true;
          f.c(AuthDialog.a(), "-->Redirect URL: return false");
          return false;
        }
        catch (Exception localException1)
        {
          break label546;
        }
      }
      label586: return true;
    }
  }

  private class OnTimeListener
    implements IUiListener
  {
    String a;
    String b;
    private String d;
    private IUiListener e;

    public OnTimeListener(String paramString1, String paramString2, String paramIUiListener, IUiListener arg5)
    {
      this.d = paramString1;
      this.a = paramString2;
      this.b = paramIUiListener;
      Object localObject;
      this.e = localObject;
    }

    private void a(String paramString)
    {
      try
      {
        onComplete(Util.parseJson(paramString));
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        onError(new UiError(-4, "服务器返回数据格式有误!", paramString));
      }
    }

    public void onCancel()
    {
      if (this.e != null)
      {
        this.e.onCancel();
        this.e = null;
      }
    }

    public void onComplete(Object paramObject)
    {
      JSONObject localJSONObject = (JSONObject)paramObject;
      g.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, localJSONObject.optInt("ret", -6), this.a, false);
      if (this.e != null)
      {
        this.e.onComplete(localJSONObject);
        this.e = null;
      }
    }

    public void onError(UiError paramUiError)
    {
      if (paramUiError.errorMessage != null);
      for (String str = paramUiError.errorMessage + this.a; ; str = this.a)
      {
        g.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, paramUiError.errorCode, str, false);
        AuthDialog.a(AuthDialog.this, str);
        if (this.e != null)
        {
          this.e.onError(paramUiError);
          this.e = null;
        }
        return;
      }
    }
  }

  private class THandler extends Handler
  {
    private AuthDialog.OnTimeListener b;

    public THandler(AuthDialog.OnTimeListener paramLooper, Looper arg3)
    {
      super();
      this.b = paramLooper;
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        AuthDialog.OnTimeListener.a(this.b, (String)paramMessage.obj);
        return;
      case 2:
        this.b.onCancel();
        return;
      case 3:
      }
      AuthDialog.a(AuthDialog.a(AuthDialog.this), (String)paramMessage.obj);
    }
  }

  class TimeOutRunable
    implements Runnable
  {
    String a = "";

    public TimeOutRunable(String arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    public void run()
    {
      f.b(AuthDialog.a(), "-->timeoutUrl: " + this.a + " | mRetryUrl: " + AuthDialog.i(AuthDialog.this));
      if (this.a.equals(AuthDialog.i(AuthDialog.this)))
      {
        AuthDialog.f(AuthDialog.this).onError(new UiError(9002, "请求页面超时，请稍后重试！", AuthDialog.i(AuthDialog.this)));
        AuthDialog.this.dismiss();
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.AuthDialog
 * JD-Core Version:    0.6.0
 */