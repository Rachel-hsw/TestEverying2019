package com.umeng.message.b;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ek
{
  public static String a(Map<String, Object> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
      return paramString;
    StringBuilder localStringBuilder1 = new StringBuilder(paramString);
    Set localSet = paramMap.keySet();
    if (!paramString.endsWith("?"))
      localStringBuilder1.append("?");
    Iterator localIterator = localSet.iterator();
    if (!localIterator.hasNext())
    {
      localStringBuilder1.deleteCharAt(-1 + localStringBuilder1.length());
      return localStringBuilder1.toString();
    }
    String str1 = (String)localIterator.next();
    StringBuilder localStringBuilder2 = new StringBuilder(String.valueOf(URLEncoder.encode(str1))).append("=");
    if (paramMap.get(str1) == null);
    for (String str2 = ""; ; str2 = paramMap.get(str1).toString())
    {
      localStringBuilder1.append(URLEncoder.encode(str2) + "&");
      break;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ek
 * JD-Core Version:    0.6.0
 */