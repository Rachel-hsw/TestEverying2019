package com.baidu.location.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

 enum f$b$1
{
  List a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    Iterator localIterator = paramJSONObject.keys();
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (true)
    {
      String str1;
      if (localIterator.hasNext())
        str1 = (String)localIterator.next();
      try
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str1);
        boolean bool1 = localJSONObject.has("cy");
        String str2 = null;
        if (bool1)
          str2 = localJSONObject.getString("cy");
        boolean bool2 = localJSONObject.has("cyc");
        String str3 = null;
        if (bool2)
          str3 = localJSONObject.getString("cyc");
        boolean bool3 = localJSONObject.has("prov");
        String str4 = null;
        if (bool3)
          str4 = localJSONObject.getString("prov");
        boolean bool4 = localJSONObject.has("ctc");
        String str5 = null;
        if (bool4)
          str5 = localJSONObject.getString("ctc");
        boolean bool5 = localJSONObject.has("ct");
        String str6 = null;
        if (bool5)
          str6 = localJSONObject.getString("ct");
        boolean bool6 = localJSONObject.has("dist");
        String str7 = null;
        if (bool6)
          str7 = localJSONObject.getString("dist");
        if (localStringBuffer1.length() > 0)
          localStringBuffer1.append(",");
        localStringBuffer1.append("(\"").append(str1).append("\",\"").append(str2).append("\",\"").append(str3).append("\",\"").append(str4).append("\",\"").append(str6).append("\",\"").append(str5).append("\",\"").append(str7).append("\",").append(System.currentTimeMillis() / 1000L).append(",\"\")");
        f.b.a(localStringBuffer2, str1, paramString, 0);
        label340: if ((i % 50 == 49) && (localStringBuffer1.length() > 0))
        {
          localArrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[] { "RGCAREA", localStringBuffer1 }));
          localArrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[] { "RGCUPDATE", localStringBuffer2 }));
          localStringBuffer1.setLength(0);
        }
        i++;
        continue;
        if (localStringBuffer1.length() > 0)
        {
          localArrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[] { "RGCAREA", localStringBuffer1 }));
          localArrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[] { "RGCUPDATE", localStringBuffer2 }));
          localStringBuffer1.setLength(0);
        }
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        localArrayList.add(String.format(localLocale, "DELETE FROM RGCAREA WHERE gridkey NOT IN (SELECT gridkey FROM RGCAREA LIMIT %d);", arrayOfObject));
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        break label340;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.f.b.1
 * JD-Core Version:    0.6.0
 */