package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.n;
import com.himamis.retex.renderer.a.h.a;
import java.util.HashMap;

public class bm
  implements bd
{
  protected static HashMap<String, String> a = new HashMap();
  protected static HashMap<String, String> b = new HashMap();

  public static void a(String paramString1, String paramString2, int paramInt)
    throws n
  {
    a.put(paramString1, paramString2);
    be.a.put(paramString1, new be(new bm(), paramInt));
  }

  public static void a(String paramString1, String paramString2, int paramInt, String paramString3)
    throws n
  {
    if (a.get(paramString1) != null)
      throw new n("Command " + paramString1 + " already exists ! Use renewcommand instead ...");
    a.put(paramString1, paramString2);
    b.put(paramString1, paramString3);
    be.a.put(paramString1, new be(new bm(), paramInt, 1));
  }

  public static boolean a(String paramString)
  {
    return a.containsKey(paramString);
  }

  public static void b(String paramString1, String paramString2, int paramInt)
  {
    if (a.get(paramString1) == null)
      throw new n("Command " + paramString1 + " is not defined ! Use newcommand instead ...");
    a.put(paramString1, paramString2);
    be.a.put(paramString1, new be(new bm(), paramInt));
  }

  public String a(dv paramdv, String[] paramArrayOfString)
  {
    int i = 1;
    String str1 = (String)a.get(paramArrayOfString[0]);
    int j = -11 + paramArrayOfString.length;
    String str2;
    int k;
    if (paramArrayOfString[(j + 1)] != null)
    {
      str2 = str1.replaceAll("#1", a.a(paramArrayOfString[(j + 1)]));
      k = i;
    }
    while (true)
    {
      if (i > j)
      {
        return str2;
        if (b.get(paramArrayOfString[0]) != null)
        {
          str2 = str1.replaceAll("#1", a.a((String)b.get(paramArrayOfString[0])));
          k = i;
          continue;
        }
      }
      else
      {
        String str3 = a.a(paramArrayOfString[i]);
        str2 = str2.replaceAll("#" + (i + k), str3);
        i++;
        continue;
      }
      str2 = str1;
      k = 0;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bm
 * JD-Core Version:    0.6.0
 */