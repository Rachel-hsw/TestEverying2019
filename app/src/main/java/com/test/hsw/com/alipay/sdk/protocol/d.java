package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.data.a;
import com.alipay.sdk.data.f;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.tid.b;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static c a(c paramc)
    throws NetErrorException
  {
    new e();
    g localg = e.a(paramc);
    if (localg == null);
    while (true)
    {
      f localf = paramc.b;
      JSONObject localJSONObject1 = paramc.c;
      a locala1 = paramc.a.a;
      a locala2 = paramc.b.l;
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
          label231: localf.g = ((String)localObject);
          localf.h = localJSONObject1.optString("memo", "");
          return paramc;
          if (!localJSONObject1.has("session"))
            continue;
          JSONObject localJSONObject3 = new JSONObject();
          try
          {
            localJSONObject3.put("session", localJSONObject1.optString("session"));
            String str2 = b.a().a;
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
          break label231;
        }
      }
      paramc = localg;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.protocol.d
 * JD-Core Version:    0.6.0
 */