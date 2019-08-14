package org.android.agoo.c.c;

import android.text.TextUtils;
import com.umeng.message.b.ay;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
{
  public static final String a = "SUCCESS";
  public static final String b = "FAIL";
  private static final String c = "MtopResponseHelper";

  public static i a(String paramString)
    throws Throwable
  {
    i locali = new i();
    while (true)
    {
      int j;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        JSONArray localJSONArray = localJSONObject.getJSONArray("ret");
        int i = localJSONArray.length();
        j = 0;
        if (j >= i)
          continue;
        String str = localJSONArray.getString(j);
        if (!TextUtils.isEmpty(str))
        {
          String[] arrayOfString = str.split("::");
          if ((arrayOfString != null) && (2 == arrayOfString.length))
          {
            locali.c(arrayOfString[0]);
            locali.b(arrayOfString[1]);
            if (!"SUCCESS".equals(arrayOfString[0]))
              continue;
            locali.a(localJSONObject.getString("data"));
            locali.a(true);
            locali.a(200);
            ay.c("MtopResponseHelper", "MtopResponseHelper:[" + locali.toString() + "]");
            return locali;
            locali.a(false);
            locali.a(localJSONObject.getString("data"));
          }
        }
      }
      catch (Throwable localThrowable)
      {
        locali.a(false);
        locali.a(paramString);
        locali.a(302);
        continue;
      }
      j++;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.c.g
 * JD-Core Version:    0.6.0
 */