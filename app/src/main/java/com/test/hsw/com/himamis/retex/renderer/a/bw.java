package com.himamis.retex.renderer.a;

import java.util.HashMap;
import java.util.Map;

public final class bw
{
  public static final Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.length() == 0))
      return localHashMap;
    String[] arrayOfString1 = paramString.split(",");
    int i = 0;
    if (i >= arrayOfString1.length)
      return localHashMap;
    String[] arrayOfString2 = arrayOfString1[i].trim().split("=");
    if (arrayOfString2 != null)
    {
      if (arrayOfString2.length != 2)
        break label90;
      localHashMap.put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
    }
    while (true)
    {
      i++;
      break;
      label90: if (arrayOfString2.length != 1)
        continue;
      localHashMap.put(arrayOfString2[0].trim(), null);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bw
 * JD-Core Version:    0.6.0
 */