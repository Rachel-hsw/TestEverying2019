package com.gensee.download;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SDCardUtil
{
  public static long getSDAllSize()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    return localStatFs.getBlockSizeLong() * localStatFs.getBlockCountLong() / 1024L / 1024L;
  }

  public static long getSDAllSize(String paramString)
  {
    StatFs localStatFs = new StatFs(paramString);
    return localStatFs.getBlockSizeLong() * localStatFs.getBlockCountLong() / 1024L / 1024L;
  }

  public static long getSDFreeSize()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    return localStatFs.getBlockSizeLong() * localStatFs.getAvailableBlocksLong() / 1024L;
  }

  public static long getSDFreeSize(String paramString)
  {
    StatFs localStatFs = new StatFs(paramString);
    return localStatFs.getBlockSizeLong() * localStatFs.getAvailableBlocksLong() / 1024L / 1024L;
  }

  public static String[] getVolumePaths(Activity paramActivity)
  {
    String[] arrayOfString1 = new String[0];
    StorageManager localStorageManager = (StorageManager)paramActivity.getSystemService("storage");
    try
    {
      String[] arrayOfString2 = (String[])localStorageManager.getClass().getMethod("getVolumePaths", null).invoke(localStorageManager, null);
      return arrayOfString2;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return arrayOfString1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return arrayOfString1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
      return arrayOfString1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    return arrayOfString1;
  }

  public static String getVolumeState(Activity paramActivity, String paramString)
  {
    StorageManager localStorageManager = (StorageManager)paramActivity.getSystemService("storage");
    try
    {
      String str = (String)localStorageManager.getClass().getMethod("getVolumeState", new Class[] { String.class }).invoke(localStorageManager, new Object[] { paramString });
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return "";
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return "";
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
      return "";
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    return "";
  }

  public static boolean isExistSDCard()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.SDCardUtil
 * JD-Core Version:    0.6.0
 */