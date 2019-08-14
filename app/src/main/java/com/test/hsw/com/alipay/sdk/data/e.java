package com.alipay.sdk.data;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.encrypt.d;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

public final class e
{
  public a a;
  public WeakReference<c> b = null;
  public boolean c = true;
  boolean d = true;
  private JSONObject e;
  private JSONObject f;
  private long g;

  public e(a parama, JSONObject paramJSONObject)
  {
    this(parama, paramJSONObject, 0);
  }

  private e(a parama, JSONObject paramJSONObject, byte paramByte)
  {
    this.a = parama;
    this.e = paramJSONObject;
    this.f = null;
    this.b = new WeakReference(null);
  }

  private void a(long paramLong)
  {
    this.g = paramLong;
  }

  private void a(c paramc)
  {
    this.b = new WeakReference(paramc);
  }

  private void a(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
  }

  private void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  private boolean a()
  {
    return this.d;
  }

  private String b()
  {
    return this.a.a;
  }

  private void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  private long c()
  {
    return this.g;
  }

  private c d()
  {
    return (c)this.b.get();
  }

  private boolean e()
  {
    return this.c;
  }

  private a f()
  {
    return this.a;
  }

  public final JSONObject a(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("device", Build.MODEL);
      localJSONObject3 = new JSONObject();
      localJSONObject4 = com.alipay.sdk.util.c.a(localJSONObject2, this.f);
      localJSONObject4.put("namespace", this.a.b);
      localJSONObject4.put("api_name", this.a.e);
      localJSONObject4.put("api_version", this.a.d);
      if (this.e == null)
        this.e = new JSONObject();
      this.e.put("action", localJSONObject3);
      str1 = this.a.c;
      boolean bool = TextUtils.isEmpty(str1);
      if (bool);
    }
    catch (Exception localException1)
    {
      try
      {
        JSONObject localJSONObject3;
        JSONObject localJSONObject4;
        String str1;
        String[] arrayOfString = str1.split("/");
        localJSONObject3.put("type", arrayOfString[1]);
        if (arrayOfString.length > 1)
          localJSONObject3.put("method", arrayOfString[2]);
        label181: this.e.put("gzip", this.d);
        if (this.c)
        {
          JSONObject localJSONObject5 = new JSONObject();
          new StringBuilder("requestData before: ").append(this.e.toString()).toString();
          String str2 = this.e.toString();
          String str3 = d.a(paramString, com.alipay.sdk.cons.a.c);
          String str4 = com.alipay.sdk.encrypt.e.a(paramString, str2);
          Locale localLocale = Locale.getDefault();
          Object[] arrayOfObject = new Object[4];
          arrayOfObject[0] = Integer.valueOf(str3.length());
          arrayOfObject[1] = str3;
          arrayOfObject[2] = Integer.valueOf(str4.length());
          arrayOfObject[3] = str4;
          localJSONObject5.put("req_data", String.format(localLocale, "%08X%s%08X%s", arrayOfObject));
          localJSONObject4.put("params", localJSONObject5);
          localJSONObject1.put("data", localJSONObject4);
        }
        while (true)
        {
          new StringBuilder("requestData : ").append(localJSONObject1.toString()).toString();
          return localJSONObject1;
          localJSONObject4.put("params", this.e);
          break;
          localException1 = localException1;
        }
      }
      catch (Exception localException2)
      {
        break label181;
      }
    }
  }

  public final String toString()
  {
    return this.a.toString() + ", requestData = " + com.alipay.sdk.util.c.a(this.e, this.f) + ", timeStamp = " + this.g;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.data.e
 * JD-Core Version:    0.6.0
 */