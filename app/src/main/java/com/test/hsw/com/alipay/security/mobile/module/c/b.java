package com.alipay.security.mobile.module.c;

import android.os.Environment;
import com.alipay.security.mobile.module.c.a.a;
import java.io.File;

public final class b
{
  public static String a(String paramString)
  {
    try
    {
      if (a())
      {
        File localFile = new File(Environment.getExternalStorageDirectory(), paramString);
        if (localFile.exists())
        {
          String str = a.b(localFile.getAbsolutePath());
          return str;
        }
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static boolean a()
  {
    String str = Environment.getExternalStorageState();
    return (str != null) && (str.length() > 0) && ((str.equals("mounted")) || (str.equals("mounted_ro"))) && (Environment.getExternalStorageDirectory() != null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.c.b
 * JD-Core Version:    0.6.0
 */