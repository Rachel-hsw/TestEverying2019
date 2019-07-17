package com.alipay.sdk.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.exception.NetErrorException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static g a(c paramc)
    throws NetErrorException
  {
    com.alipay.sdk.data.e locale = paramc.a;
    com.alipay.sdk.data.f localf = paramc.b;
    JSONObject localJSONObject = paramc.c;
    g localg1;
    if (localJSONObject.has("form"))
    {
      localg1 = new g(locale, localf);
      localg1.a(paramc.c);
    }
    boolean bool;
    do
    {
      return localg1;
      bool = localJSONObject.has("status");
      localg1 = null;
    }
    while (!bool);
    f localf1 = f.a(localJSONObject.optString("status"));
    switch (1.a[localf1.ordinal()])
    {
    default:
      return null;
    case 1:
    case 2:
    case 3:
      g localg2 = new g(locale, localf);
      localg2.a(localJSONObject);
      return localg2;
    case 4:
    }
    Context localContext = com.alipay.sdk.sys.b.a().a;
    String str1 = com.alipay.sdk.util.b.a(localContext).a();
    String str2 = com.alipay.sdk.util.b.a(localContext).b();
    com.alipay.sdk.tid.a locala = new com.alipay.sdk.tid.a(localContext);
    locala.a(str1, str2);
    locala.close();
    return null;
  }

  private static void b(c paramc)
    throws NetErrorException
  {
    com.alipay.sdk.data.f localf = paramc.b;
    JSONObject localJSONObject1 = paramc.c;
    com.alipay.sdk.data.a locala1 = paramc.a.a;
    com.alipay.sdk.data.a locala2 = paramc.b.l;
    if (TextUtils.isEmpty(locala2.c))
      locala2.c = locala1.c;
    if (TextUtils.isEmpty(locala2.d))
      locala2.d = locala1.d;
    if (TextUtils.isEmpty(locala2.b))
      locala2.b = locala1.b;
    if (TextUtils.isEmpty(locala2.a))
      locala2.a = locala1.a;
    JSONObject localJSONObject2 = localJSONObject1.optJSONObject("reflected_data");
    if (localJSONObject2 != null)
    {
      new StringBuilder("session = ").append(localJSONObject2.optString("session", "")).toString();
      paramc.b.i = localJSONObject2;
    }
    while (true)
    {
      localf.f = localJSONObject1.optString("end_code", "0");
      localf.j = localJSONObject1.optString("user_id", "");
      Object localObject = localJSONObject1.optString("result");
      try
      {
        String str1 = URLDecoder.decode(localJSONObject1.optString("result"), "UTF-8");
        localObject = str1;
        label203: localf.g = ((String)localObject);
        localf.h = localJSONObject1.optString("memo", "");
        return;
        if (!localJSONObject1.has("session"))
          continue;
        JSONObject localJSONObject3 = new JSONObject();
        try
        {
          localJSONObject3.put("session", localJSONObject1.optString("session"));
          String str2 = com.alipay.sdk.tid.b.a().a;
          if (!TextUtils.isEmpty(str2))
            localJSONObject3.put("tid", str2);
          localf.i = localJSONObject3;
        }
        catch (JSONException localJSONException)
        {
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label203;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.protocol.e
 * JD-Core Version:    0.6.0
 */