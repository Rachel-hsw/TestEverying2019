package com.squareup.a.a.a;

import com.squareup.a.v;
import com.squareup.a.w;
import java.net.Proxy.Type;
import java.net.URL;

public final class m
{
  public static String a(v paramv)
  {
    if (paramv == v.a)
      return "HTTP/1.0";
    return "HTTP/1.1";
  }

  static String a(w paramw, Proxy.Type paramType, v paramv)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramw.d());
    localStringBuilder.append(" ");
    if (a(paramw, paramType))
      localStringBuilder.append(paramw.a());
    while (true)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(a(paramv));
      return localStringBuilder.toString();
      localStringBuilder.append(a(paramw.a()));
    }
  }

  public static String a(URL paramURL)
  {
    String str = paramURL.getFile();
    if (str == null)
      str = "/";
    do
      return str;
    while (str.startsWith("/"));
    return "/" + str;
  }

  private static boolean a(w paramw, Proxy.Type paramType)
  {
    return (!paramw.j()) && (paramType == Proxy.Type.HTTP);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.m
 * JD-Core Version:    0.6.0
 */