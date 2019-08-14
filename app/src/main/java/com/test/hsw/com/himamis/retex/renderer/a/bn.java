package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.n;
import java.util.HashMap;

public class bn extends bm
{
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
    throws n
  {
    a(paramString1 + "@env", paramString2 + " #" + (paramInt + 1) + " " + paramString3, paramInt + 1);
  }

  public static void b(String paramString1, String paramString2, String paramString3, int paramInt)
    throws n
  {
    if (a.get(paramString1 + "@env") == null)
      throw new n("Environment " + paramString1 + "is not defined ! Use newenvironment instead ...");
    b(paramString1 + "@env", paramString2 + " #" + (paramInt + 1) + " " + paramString3, paramInt + 1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bn
 * JD-Core Version:    0.6.0
 */