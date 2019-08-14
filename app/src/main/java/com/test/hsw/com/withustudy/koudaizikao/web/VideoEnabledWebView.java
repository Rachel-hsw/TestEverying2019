package com.withustudy.koudaizikao.web;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Map;

public class VideoEnabledWebView extends WebView
{
  private a a;
  private boolean b = false;

  public VideoEnabledWebView(Context paramContext)
  {
    super(paramContext);
  }

  public VideoEnabledWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public VideoEnabledWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void b()
  {
    if (!this.b)
    {
      addJavascriptInterface(new a(), "_VideoEnabledWebView");
      this.b = true;
    }
  }

  public boolean a()
  {
    return (this.a != null) && (this.a.a());
  }

  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    b();
    super.loadData(paramString1, paramString2, paramString3);
  }

  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    b();
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }

  public void loadUrl(String paramString)
  {
    b();
    super.loadUrl(paramString);
  }

  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    b();
    super.loadUrl(paramString, paramMap);
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    getSettings().setJavaScriptEnabled(true);
    if ((paramWebChromeClient instanceof a))
      this.a = ((a)paramWebChromeClient);
    super.setWebChromeClient(paramWebChromeClient);
  }

  public class a
  {
    public a()
    {
    }

    @JavascriptInterface
    public void notifyVideoEnd()
    {
      Log.d("___", "GOT IT");
      new Handler(Looper.getMainLooper()).post(new b(this));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.web.VideoEnabledWebView
 * JD-Core Version:    0.6.0
 */