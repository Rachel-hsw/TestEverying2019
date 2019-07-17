package com.alipay.sdk.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

public final class b
{
  String a;
  String b;
  String c;
  String d;
  String e;
  boolean f;
  boolean g = true;
  boolean h = true;
  String i;
  String j;
  String k;
  JSONObject l;

  private b(String paramString)
  {
    this.a = paramString;
  }

  private static b a(String paramString, a parama)
  {
    return a(paramString, parama.f(), parama.l(), parama.g(), parama.h(), parama.i(), parama.j(), parama.k(), parama.c(), parama.d(), parama.b(), parama.a());
  }

  private static b a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString6, String paramString7, String paramString8, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString1))
      return null;
    b localb = new b(paramString1);
    localb.a = paramString1;
    boolean bool = TextUtils.isEmpty(paramString2);
    String str = null;
    if (bool);
    while (true)
    {
      localb.b = str;
      localb.c = paramString3;
      localb.d = paramString4;
      localb.e = paramString5;
      localb.f = paramBoolean1;
      localb.g = paramBoolean2;
      localb.h = paramBoolean3;
      localb.i = paramString6;
      localb.j = paramString7;
      localb.k = paramString8;
      localb.l = paramJSONObject;
      return localb;
      str = paramString2.trim();
    }
  }

  private static b a(JSONObject paramJSONObject)
  {
    boolean bool1 = true;
    if ((paramJSONObject != null) && (paramJSONObject.has("name")));
    for (String str1 = paramJSONObject.optString("name"); ; str1 = null)
    {
      if ((paramJSONObject != null) && (paramJSONObject.has("host")));
      for (String str2 = paramJSONObject.optString("host"); ; str2 = null)
      {
        if ((paramJSONObject != null) && (paramJSONObject.has("params")));
        for (String str3 = paramJSONObject.optString("params"); ; str3 = null)
        {
          if ((paramJSONObject != null) && (paramJSONObject.has("enctype")));
          for (String str4 = paramJSONObject.optString("enctype"); ; str4 = null)
          {
            String str5 = null;
            if (paramJSONObject != null)
            {
              boolean bool4 = paramJSONObject.has("request_param");
              str5 = null;
              if (bool4)
                str5 = paramJSONObject.optString("request_param");
            }
            if ((paramJSONObject != null) && (paramJSONObject.has("validate")));
            for (boolean bool2 = paramJSONObject.optBoolean("validate", bool1); ; bool2 = bool1)
            {
              boolean bool3;
              if ((paramJSONObject != null) && (paramJSONObject.has("https")))
                if (!paramJSONObject.optBoolean("https"))
                  bool3 = bool1;
              while (true)
              {
                if ((paramJSONObject != null) && (paramJSONObject.has("formSubmit")))
                  bool1 = paramJSONObject.optBoolean("formSubmit");
                String str6 = "";
                if ((paramJSONObject != null) && (paramJSONObject.has("namespace")))
                  str6 = paramJSONObject.optString("namespace");
                String str7 = "";
                if ((paramJSONObject != null) && (paramJSONObject.has("apiVersion")))
                  str7 = paramJSONObject.optString("apiVersion");
                String str8 = "";
                if ((paramJSONObject != null) && (paramJSONObject.has("apiName")))
                  str8 = paramJSONObject.optString("apiName");
                return a(str1, str2, str3, str4, str5, bool2, bool3, bool1, str6, str7, str8, paramJSONObject);
                bool3 = false;
                continue;
                bool3 = bool1;
              }
            }
          }
        }
      }
    }
  }

  public static b a(JSONObject paramJSONObject, String paramString)
  {
    boolean bool1 = true;
    JSONObject localJSONObject = paramJSONObject.optJSONObject(paramString);
    if ((localJSONObject != null) && (localJSONObject.has("name")));
    for (String str1 = localJSONObject.optString("name"); ; str1 = null)
    {
      if ((localJSONObject != null) && (localJSONObject.has("host")));
      for (String str2 = localJSONObject.optString("host"); ; str2 = null)
      {
        if ((localJSONObject != null) && (localJSONObject.has("params")));
        for (String str3 = localJSONObject.optString("params"); ; str3 = null)
        {
          if ((localJSONObject != null) && (localJSONObject.has("enctype")));
          for (String str4 = localJSONObject.optString("enctype"); ; str4 = null)
          {
            String str5 = null;
            if (localJSONObject != null)
            {
              boolean bool4 = localJSONObject.has("request_param");
              str5 = null;
              if (bool4)
                str5 = localJSONObject.optString("request_param");
            }
            if ((localJSONObject != null) && (localJSONObject.has("validate")));
            for (boolean bool2 = localJSONObject.optBoolean("validate", bool1); ; bool2 = bool1)
            {
              boolean bool3;
              if ((localJSONObject != null) && (localJSONObject.has("https")))
                if (!localJSONObject.optBoolean("https"))
                  bool3 = bool1;
              while (true)
              {
                if ((localJSONObject != null) && (localJSONObject.has("formSubmit")))
                  bool1 = localJSONObject.optBoolean("formSubmit");
                String str6 = "";
                if ((localJSONObject != null) && (localJSONObject.has("namespace")))
                  str6 = localJSONObject.optString("namespace");
                String str7 = "";
                if ((localJSONObject != null) && (localJSONObject.has("apiVersion")))
                  str7 = localJSONObject.optString("apiVersion");
                String str8 = "";
                if ((localJSONObject != null) && (localJSONObject.has("apiName")))
                  str8 = localJSONObject.optString("apiName");
                return a(str1, str2, str3, str4, str5, bool2, bool3, bool1, str6, str7, str8, localJSONObject);
                bool3 = false;
                continue;
                bool3 = bool1;
              }
            }
          }
        }
      }
    }
  }

  private JSONObject b()
  {
    return this.l;
  }

  private String c()
  {
    return this.k;
  }

  private String d()
  {
    return this.i;
  }

  private String e()
  {
    return this.j;
  }

  private String f()
  {
    return this.a;
  }

  private String g()
  {
    if (TextUtils.isEmpty(this.b))
      this.b = com.alipay.sdk.cons.a.b;
    return this.b;
  }

  private String h()
  {
    return this.c;
  }

  private String i()
  {
    return this.d;
  }

  private String j()
  {
    return this.e;
  }

  private boolean k()
  {
    return this.f;
  }

  private boolean l()
  {
    return this.g;
  }

  private boolean m()
  {
    return this.h;
  }

  public final JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.c);
      return localJSONObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.protocol.b
 * JD-Core Version:    0.6.0
 */