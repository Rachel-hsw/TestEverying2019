package com.gensee.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AppExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  public static final String TAG = "ExceptionHandler";
  private IAppController appController;
  private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
  private Map<String, String> infos = new HashMap();
  private Thread.UncaughtExceptionHandler mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();

  private boolean handleException(Throwable paramThrowable)
  {
    if (paramThrowable == null)
      return false;
    saveCrashInfo2File(paramThrowable);
    return true;
  }

  private void saveCrashInfo2File(Throwable paramThrowable)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.infos.entrySet().iterator();
    while (true)
    {
      PrintWriter localPrintWriter;
      Throwable localThrowable;
      if (!localIterator.hasNext())
      {
        StringWriter localStringWriter = new StringWriter();
        localPrintWriter = new PrintWriter(localStringWriter);
        paramThrowable.printStackTrace(localPrintWriter);
        localThrowable = paramThrowable.getCause();
        if (localThrowable != null)
          break label210;
        localPrintWriter.close();
        localStringBuffer.append(localStringWriter.toString());
        localStringBuffer.append("os.version=" + Build.MODEL + "," + Build.VERSION.SDK_INT + "," + Build.VERSION.RELEASE);
      }
      try
      {
        GenseeLog.wirteCrashInfo(localStringBuffer.toString());
        return;
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str1 = (String)localEntry.getKey();
        String str2 = (String)localEntry.getValue();
        localStringBuffer.append(str1 + "=" + str2 + "\n");
        continue;
        label210: localThrowable.printStackTrace(localPrintWriter);
        localThrowable = localThrowable.getCause();
      }
      catch (Exception localException)
      {
        Log.e("ExceptionHandler", "an error occured while writing file...", localException);
      }
    }
  }

  public void collectDeviceInfo(Context paramContext)
  {
    while (true)
    {
      int j;
      Field localField;
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 1);
        if (localPackageInfo == null)
          continue;
        if (localPackageInfo.versionName != null)
          continue;
        String str1 = "null";
        String str2 = localPackageInfo.versionCode;
        this.infos.put("versionName", str1);
        this.infos.put("versionCode", str2);
        arrayOfField = Build.class.getDeclaredFields();
        int i = arrayOfField.length;
        j = 0;
        if (j >= i)
        {
          return;
          str1 = localPackageInfo.versionName;
          continue;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Field[] arrayOfField;
        Log.e("ExceptionHandler", "an error occured when collect package info", localNameNotFoundException);
        continue;
        localField = arrayOfField[j];
      }
      try
      {
        localField.setAccessible(true);
        this.infos.put(localField.getName(), localField.get(null).toString());
        Log.d("ExceptionHandler", localField.getName() + " : " + localField.get(null));
        j++;
      }
      catch (Exception localException)
      {
        while (true)
          Log.e("ExceptionHandler", "an error occured when collect crash info", localException);
      }
    }
  }

  public void init(IAppController paramIAppController)
  {
    Thread.setDefaultUncaughtExceptionHandler(this);
    this.appController = paramIAppController;
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((!handleException(paramThrowable)) && (this.mDefaultHandler != null))
      this.mDefaultHandler.uncaughtException(paramThread, paramThrowable);
    while (true)
    {
      return;
      try
      {
        Thread.sleep(1000L);
        if (this.appController == null)
          continue;
        this.appController.restartApp();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          Log.e("ExceptionHandler", "error : ", localInterruptedException);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.utils.AppExceptionHandler
 * JD-Core Version:    0.6.0
 */