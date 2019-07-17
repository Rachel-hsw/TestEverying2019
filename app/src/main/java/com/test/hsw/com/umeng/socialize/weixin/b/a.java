package com.umeng.socialize.weixin.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class a
{
  private static String a(InputStream paramInputStream)
    throws IOException
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    String str2;
    for (String str1 = ""; ; str1 = str1 + str2)
    {
      str2 = localBufferedReader.readLine();
      if (str2 == null)
        break;
    }
    return str1.trim();
  }

  public static String a(String paramString)
  {
    try
    {
      URLConnection localURLConnection = new URL(paramString).openConnection();
      if (localURLConnection == null)
        return "";
      localURLConnection.connect();
      InputStream localInputStream = localURLConnection.getInputStream();
      if (localInputStream != null)
      {
        String str = a(localInputStream);
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.weixin.b.a
 * JD-Core Version:    0.6.0
 */