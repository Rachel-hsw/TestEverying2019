package com.umeng.message.b;

import android.text.TextUtils;
import java.util.Map;

public class cn
{
  public static final String a = "wjas";
  public static final String b = "apoll";
  public static final String c = "nginx";
  public static final String d = "server";
  private static final String e = "ServerUtil";

  public static final boolean a(String paramString)
  {
    try
    {
      String str = paramString.toLowerCase();
      if (!TextUtils.equals(str, "wjas"))
      {
        boolean bool = TextUtils.equals(str, "nginx");
        if (!bool);
      }
      else
      {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static final boolean a(Map<String, String> paramMap, int paramInt)
  {
    if (paramMap != null);
    int i;
    try
    {
      if (paramMap.isEmpty())
      {
        ay.c("ServerUtil", "chechHttp--->[headers==null]");
        return false;
      }
      String str = (String)paramMap.get("server");
      if (TextUtils.isEmpty(str))
      {
        ay.c("ServerUtil", "chechHttp--->[serverName==null]");
        return false;
      }
      if (!a(str))
      {
        ay.c("ServerUtil", "chechHttp--->[serverName!=wjas]");
        return false;
      }
      if (paramInt == 302)
      {
        ay.d("ServerUtil", "chechHttp---->[failed][" + paramInt + "]");
        return false;
      }
      i = 1;
    }
    catch (Throwable localThrowable)
    {
      i = 0;
    }
    return i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cn
 * JD-Core Version:    0.6.0
 */