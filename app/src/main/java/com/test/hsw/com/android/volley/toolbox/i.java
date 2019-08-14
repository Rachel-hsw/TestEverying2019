package com.android.volley.toolbox;

import com.android.volley.b.a;
import com.android.volley.l;
import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class i
{
  public static long a(String paramString)
  {
    try
    {
      long l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException localDateParseException)
    {
    }
    return 0L;
  }

  public static b.a a(l paraml)
  {
    long l1 = System.currentTimeMillis();
    Map localMap = paraml.c;
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    String str1 = (String)localMap.get("Date");
    if (str1 != null)
      l2 = a(str1);
    String str2 = (String)localMap.get("Cache-Control");
    String[] arrayOfString;
    int k;
    int i;
    long l9;
    long l10;
    if (str2 != null)
    {
      arrayOfString = str2.split(",");
      k = 0;
      i = 0;
      l9 = l4;
      l10 = l3;
      if (k >= arrayOfString.length)
      {
        l3 = l10;
        l4 = l9;
      }
    }
    for (int j = 1; ; j = 0)
    {
      String str3 = (String)localMap.get("Expires");
      long l5;
      if (str3 != null)
        l5 = a(str3);
      while (true)
      {
        String str4 = (String)localMap.get("Last-Modified");
        long l6;
        if (str4 != null)
          l6 = a(str4);
        while (true)
        {
          String str5 = (String)localMap.get("ETag");
          long l8;
          long l7;
          if (j != 0)
          {
            l8 = l1 + 1000L * l3;
            if (i != 0)
              l7 = l8;
          }
          while (true)
            while (true)
            {
              label190: b.a locala = new b.a();
              locala.a = paraml.b;
              locala.b = str5;
              locala.f = l8;
              locala.e = l7;
              locala.c = l2;
              locala.d = l6;
              locala.g = localMap;
              return locala;
              String str6 = arrayOfString[k].trim();
              if ((str6.equals("no-cache")) || (str6.equals("no-store")))
                return null;
              if (str6.startsWith("max-age="));
              try
              {
                long l12 = Long.parseLong(str6.substring(8));
                l10 = l12;
                while (true)
                  while (true)
                  {
                    label310: k++;
                    break;
                    if (str6.startsWith("stale-while-revalidate="));
                    try
                    {
                      long l11 = Long.parseLong(str6.substring(23));
                      l9 = l11;
                      continue;
                      if ((!str6.equals("must-revalidate")) && (!str6.equals("proxy-revalidate")))
                        continue;
                      i = 1;
                      continue;
                      l7 = l8 + 1000L * l4;
                      break label190;
                      if ((l2 <= 0L) || (l5 < l2))
                        break label426;
                      l7 = l1 + (l5 - l2);
                      l8 = l7;
                    }
                    catch (Exception localException1)
                    {
                    }
                  }
              }
              catch (Exception localException2)
              {
                break label310;
                label426: l7 = 0L;
                l8 = 0L;
              }
            }
          l6 = 0L;
        }
        l5 = 0L;
      }
      i = 0;
    }
  }

  public static String a(Map<String, String> paramMap)
  {
    return a(paramMap, "ISO-8859-1");
  }

  public static String a(Map<String, String> paramMap, String paramString)
  {
    String str = (String)paramMap.get("Content-Type");
    String[] arrayOfString1;
    if (str != null)
      arrayOfString1 = str.split(";");
    for (int i = 1; ; i++)
    {
      if (i >= arrayOfString1.length)
        return paramString;
      String[] arrayOfString2 = arrayOfString1[i].trim().split("=");
      if ((arrayOfString2.length == 2) && (arrayOfString2[0].equals("charset")))
        return arrayOfString2[1];
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.i
 * JD-Core Version:    0.6.0
 */