package com.xiaomi.d.e;

import android.content.Context;
import android.util.Base64;
import com.xiaomi.a.a.c.c;
import com.xiaomi.push.service.w;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class h
{
  private static Context a;
  private static String b;

  public static Context a()
  {
    return a;
  }

  public static void a(Context paramContext)
  {
    a = paramContext;
  }

  public static String b()
  {
    String str;
    if (b == null)
    {
      str = w.b(a);
      if (str == null);
    }
    try
    {
      b = Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(str.getBytes()), 8).substring(0, 16);
      return b;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
        c.a(localNoSuchAlgorithmException);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.e.h
 * JD-Core Version:    0.6.0
 */