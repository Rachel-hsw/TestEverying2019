package com.withustudy.koudaizikao.g;

import android.content.Context;
import com.withustudy.koudaizikao.e.a;
import com.withustudy.koudaizikao.entity.content.ProvMajorsContent;

public class c
{
  public static void a(Context paramContext)
  {
    a locala = a.a(paramContext);
    new Thread(new e(locala.c(), locala.d())).start();
  }

  public static void a(Context paramContext, ProvMajorsContent paramProvMajorsContent)
  {
    a locala = a.a(paramContext);
    new Thread(new d(paramProvMajorsContent, locala.c(), locala.d())).start();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.c
 * JD-Core Version:    0.6.0
 */