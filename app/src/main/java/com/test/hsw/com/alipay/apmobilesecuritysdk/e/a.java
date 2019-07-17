package com.alipay.apmobilesecuritysdk.e;

import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

public final class a
{
  public static String a(Map<String, Integer> paramMap, String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() <= 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2 + ":");
    if ((paramString1 == null) || (paramString1.length() <= 0))
      return localStringBuilder.toString();
    String[] arrayOfString = paramString1.split(",");
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
      return localStringBuilder.toString();
    if ((paramMap == null) || (paramMap.size() <= 0))
      return localStringBuilder.toString();
    Set localSet = paramMap.keySet();
    if ((localSet == null) || (localSet.size() <= 0))
      return localStringBuilder.toString();
    try
    {
      byte[] arrayOfByte = new byte[1 + arrayOfString.length / 8];
      for (int i = 0; i < arrayOfByte.length; i++)
        arrayOfByte[i] = 0;
      int j = arrayOfString.length;
      int k = 0;
      int m = 0;
      while (k < j)
      {
        String str = arrayOfString[k];
        int n = arrayOfByte[(m / 8)];
        if (localSet.contains(str))
        {
          n |= 128 >> m % 8;
          System.out.println(m);
        }
        arrayOfByte[(m / 8)] = (byte)(n & 0xFF);
        m++;
        k++;
      }
      localStringBuilder.append(com.alipay.security.mobile.module.a.a.a.a(arrayOfByte));
      label270: return localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      break label270;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.e.a
 * JD-Core Version:    0.6.0
 */