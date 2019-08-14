package com.a.a.c;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class g
{
  private static final String a = "android.permission.WRITE_EXTERNAL_STORAGE";
  private static final String b = "uil-images";

  public static File a(Context paramContext)
  {
    return a(paramContext, true);
  }

  public static File a(Context paramContext, String paramString)
  {
    boolean bool1 = "mounted".equals(Environment.getExternalStorageState());
    File localFile = null;
    if (bool1)
    {
      boolean bool2 = d(paramContext);
      localFile = null;
      if (bool2)
        localFile = new File(Environment.getExternalStorageDirectory(), paramString);
    }
    if ((localFile == null) || ((!localFile.exists()) && (!localFile.mkdirs())))
      localFile = paramContext.getCacheDir();
    return localFile;
  }

  public static File a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      String str3 = Environment.getExternalStorageState();
      str1 = str3;
      File localFile = null;
      if (paramBoolean)
      {
        boolean bool1 = "mounted".equals(str1);
        localFile = null;
        if (bool1)
        {
          boolean bool2 = d(paramContext);
          localFile = null;
          if (bool2)
            localFile = c(paramContext);
        }
      }
      if (localFile == null)
        localFile = paramContext.getCacheDir();
      if (localFile == null)
      {
        String str2 = "/data/data/" + paramContext.getPackageName() + "/cache/";
        d.c("Can't define system cache directory! '%s' will be used.", new Object[] { str2 });
        localFile = new File(str2);
      }
      return localFile;
    }
    catch (NullPointerException localNullPointerException)
    {
      while (true)
        String str1 = "";
    }
  }

  public static File b(Context paramContext)
  {
    File localFile1 = a(paramContext);
    File localFile2 = new File(localFile1, "uil-images");
    if ((!localFile2.exists()) && (!localFile2.mkdir()))
      return localFile1;
    return localFile2;
  }

  private static File c(Context paramContext)
  {
    File localFile = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), paramContext.getPackageName()), "cache");
    if (!localFile.exists())
    {
      if (!localFile.mkdirs())
      {
        d.c("Unable to create external cache directory", new Object[0]);
        localFile = null;
      }
    }
    else
      return localFile;
    try
    {
      new File(localFile, ".nomedia").createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      d.b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
    }
    return localFile;
  }

  private static boolean d(Context paramContext)
  {
    return paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.c.g
 * JD-Core Version:    0.6.0
 */