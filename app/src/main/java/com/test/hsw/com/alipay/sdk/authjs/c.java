package com.alipay.sdk.authjs;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  b a;
  Context b;

  public c(Context paramContext, b paramb)
  {
    this.b = paramContext;
    this.a = paramb;
  }

  private static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null)
      return;
    if (Looper.getMainLooper() == Looper.myLooper());
    for (int i = 1; i != 0; i = 0)
    {
      paramRunnable.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }

  private void a(String paramString)
  {
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
          break label145;
        localJSONObject3 = (JSONObject)localJSONObject2;
        String str3 = localJSONObject1.getString("func");
        String str4 = localJSONObject1.getString("bundleName");
        a locala = new a("call");
        locala.j = str4;
        locala.k = str3;
        locala.m = localJSONObject3;
        locala.i = str2;
        a(locala);
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
        a(str1, a.a.d);
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
        label145: JSONObject localJSONObject3 = null;
      }
    }
  }

  private a.a b(a parama)
  {
    if ((parama != null) && ("toast".equals(parama.k)))
    {
      JSONObject localJSONObject = parama.m;
      String str = localJSONObject.optString("content");
      int i = localJSONObject.optInt("duration");
      int j = 1;
      if (i < 2500)
        j = 0;
      Toast.makeText(this.b, str, j).show();
      new Timer().schedule(new e(this, parama), j);
    }
    return a.a.a;
  }

  private void c(a parama)
  {
    JSONObject localJSONObject = parama.m;
    String str = localJSONObject.optString("content");
    int i = localJSONObject.optInt("duration");
    int j = 1;
    if (i < 2500)
      j = 0;
    Toast.makeText(this.b, str, j).show();
    new Timer().schedule(new e(this, parama), j);
  }

  public final void a(a parama)
    throws JSONException
  {
    if (parama == null)
      return;
    if (TextUtils.isEmpty(parama.k))
    {
      a(parama.i, a.a.c);
      return;
    }
    d locald = new d(this, parama);
    if (Looper.getMainLooper() == Looper.myLooper());
    for (int i = 1; i != 0; i = 0)
    {
      locald.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(locald);
  }

  public final void a(String paramString, a.a parama)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString))
      return;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("error", parama.ordinal());
    a locala = new a("callback");
    locala.m = localJSONObject;
    locala.i = paramString;
    this.a.a(locala);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.authjs.c
 * JD-Core Version:    0.6.0
 */