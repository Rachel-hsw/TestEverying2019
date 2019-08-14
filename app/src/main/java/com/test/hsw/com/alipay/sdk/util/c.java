package com.alipay.sdk.util;

import com.alipay.sdk.cons.a;
import com.alipay.sdk.encrypt.d;
import com.alipay.sdk.encrypt.e;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static String a(String paramString1, String paramString2)
  {
    String str1 = d.a(paramString1, a.c);
    String str2 = e.a(paramString1, paramString2);
    Locale localLocale = Locale.getDefault();
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(str1.length());
    arrayOfObject[1] = str1;
    arrayOfObject[2] = Integer.valueOf(str2.length());
    arrayOfObject[3] = str2;
    return String.format(localLocale, "%08X%s%08X%s", arrayOfObject);
  }

  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    while (true)
    {
      int j;
      try
      {
        JSONObject[] arrayOfJSONObject = { paramJSONObject1, paramJSONObject2 };
        int i = arrayOfJSONObject.length;
        j = 0;
        if (j < i)
        {
          JSONObject localJSONObject2 = arrayOfJSONObject[j];
          if (localJSONObject2 == null)
            break label96;
          Iterator localIterator = localJSONObject2.keys();
          if (!localIterator.hasNext())
            break label96;
          String str = (String)localIterator.next();
          localJSONObject1.put(str, localJSONObject2.get(str));
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
      }
      return localJSONObject1;
      label96: j++;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.util.c
 * JD-Core Version:    0.6.0
 */