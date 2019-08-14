package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.a.a;
import com.tencent.open.a.f;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a.a
{
  private static final String d = f.d + ".SL";
  private String e;

  public c(WebView paramWebView, long paramLong, String paramString1, String paramString2)
  {
    super(paramWebView, paramLong, paramString1);
    this.e = paramString2;
  }

  private void b(String paramString)
  {
    WebView localWebView = (WebView)this.a.get();
    if (localWebView != null)
    {
      StringBuffer localStringBuffer = new StringBuffer("javascript:");
      localStringBuffer.append("if(!!").append(this.e).append("){");
      localStringBuffer.append(this.e);
      localStringBuffer.append("(");
      localStringBuffer.append(paramString);
      localStringBuffer.append(")}");
      String str = localStringBuffer.toString();
      f.b(f.d, "-->callback, callback: " + str);
      localWebView.loadUrl(str);
    }
  }

  public void a()
  {
    f.b(d, "-->onNoMatchMethod...");
  }

  public void a(Object paramObject)
  {
    f.b(d, "-->onComplete, result: " + paramObject);
  }

  public void a(String paramString)
  {
    f.b(d, "-->onCustomCallback, js: " + paramString);
    JSONObject localJSONObject = new JSONObject();
    boolean bool = com.tencent.open.c.c.a;
    int i = 0;
    if (!bool)
      i = -4;
    try
    {
      localJSONObject.put("result", i);
      localJSONObject.put("sn", this.b);
      localJSONObject.put("data", paramString);
      b(localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.web.security.c
 * JD-Core Version:    0.6.0
 */