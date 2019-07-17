package com.withustudy.koudaizikao.g;

import android.content.Context;
import android.widget.Toast;
import java.io.PrintStream;

public class h
{
  private static boolean a = false;

  public static void a(Context paramContext, Object paramObject)
  {
    if (a)
      Toast.makeText(paramContext, paramObject.toString(), 0).show();
  }

  public static void a(Object paramObject)
  {
    if (a)
      System.out.println(paramObject);
  }

  public static void a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (a)
      System.out.println(paramObject1 + " ------> " + paramObject2 + " ------> " + paramObject3);
  }

  public static void a(String paramString, Object paramObject)
  {
    if (a)
      System.out.println(paramString + " ------> " + paramObject);
  }

  public static boolean a()
  {
    return a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.h
 * JD-Core Version:    0.6.0
 */