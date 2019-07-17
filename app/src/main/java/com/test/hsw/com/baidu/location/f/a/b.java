package com.baidu.location.f.a;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.f.b.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public final class b
{
  private static final boolean a = false;
  private static final String jdField_do = "DeviceId";
  private static final String jdField_for = "30212102dicudiab";
  private static final String jdField_if = "baidu/.cuid";
  private static final String jdField_int = "com.baidu.deviceid";

  public static String a(Context paramContext)
  {
    a(paramContext, "android.permission.WRITE_SETTINGS");
    a(paramContext, "android.permission.READ_PHONE_STATE");
    a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE");
    a locala = a.a(paramContext);
    String str1 = locala.jdField_if;
    int i;
    String str2;
    String str3;
    if (!locala.a)
    {
      i = 1;
      str2 = jdField_if(paramContext);
      if (i == 0)
        break label84;
      str3 = c.a(("com.baidu" + str2).getBytes(), true);
    }
    label84: String str4;
    do
    {
      return str3;
      i = 0;
      break;
      str3 = Settings.System.getString(paramContext.getContentResolver(), "com.baidu.deviceid");
      boolean bool = TextUtils.isEmpty(str3);
      str4 = null;
      if (bool)
      {
        str4 = c.a(("com.baidu" + str1 + str2).getBytes(), true);
        str3 = Settings.System.getString(paramContext.getContentResolver(), str4);
        if (!TextUtils.isEmpty(str3))
        {
          Settings.System.putString(paramContext.getContentResolver(), "com.baidu.deviceid", str3);
          a(str1, str3);
        }
      }
      if (!TextUtils.isEmpty(str3))
        continue;
      str3 = a(str1);
      if (TextUtils.isEmpty(str3))
        continue;
      Settings.System.putString(paramContext.getContentResolver(), str4, str3);
      Settings.System.putString(paramContext.getContentResolver(), "com.baidu.deviceid", str3);
    }
    while (!TextUtils.isEmpty(str3));
    String str5 = UUID.randomUUID().toString();
    String str6 = c.a((str1 + str2 + str5).getBytes(), true);
    Settings.System.putString(paramContext.getContentResolver(), str4, str6);
    Settings.System.putString(paramContext.getContentResolver(), "com.baidu.deviceid", str6);
    a(str1, str6);
    return str6;
  }

  private static String a(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString))
      str1 = "";
    while (true)
    {
      return str1;
      str1 = "";
      File localFile = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
      try
      {
        FileReader localFileReader = new FileReader(localFile);
        BufferedReader localBufferedReader = new BufferedReader(localFileReader);
        StringBuilder localStringBuilder = new StringBuilder();
        while (true)
        {
          String str2 = localBufferedReader.readLine();
          if (str2 == null)
            break;
          localStringBuilder.append(str2);
          localStringBuilder.append("\r\n");
        }
        localBufferedReader.close();
        localFileReader.close();
        String[] arrayOfString = new String(a.a("30212102dicudiab", "30212102dicudiab", com.baidu.location.f.b.b.a(localStringBuilder.toString().getBytes()))).split("=");
        if ((arrayOfString == null) || (arrayOfString.length != 2) || (!paramString.equals(arrayOfString[0])))
          continue;
        String str3 = arrayOfString[1];
        return str3;
      }
      catch (Exception localException)
      {
        return str1;
      }
      catch (IOException localIOException)
      {
        return str1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
      }
    }
    return str1;
  }

  private static void a(Context paramContext, String paramString)
  {
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0);
    for (int i = 1; ; i = 0)
    {
      if (i == 0)
        try
        {
          throw new SecurityException("Permission Denial: requires permission " + paramString);
        }
        catch (Exception localException)
        {
        }
      return;
    }
  }

  private static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("=");
    localStringBuilder.append(paramString2);
    File localFile = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
    try
    {
      new File(localFile.getParent()).mkdirs();
      FileWriter localFileWriter = new FileWriter(localFile, false);
      localFileWriter.write(com.baidu.location.f.b.b.a(a.jdField_if("30212102dicudiab", "30212102dicudiab", localStringBuilder.toString().getBytes()), "utf-8"));
      localFileWriter.flush();
      localFileWriter.close();
      return;
    }
    catch (IOException localIOException)
    {
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static String jdField_do(Context paramContext)
  {
    return a.a(paramContext).jdField_if;
  }

  public static String jdField_if(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if (TextUtils.isEmpty(str))
      str = "";
    return str;
  }

  static final class a
  {
    private static final String jdField_do = "bd_setting_i";
    public final boolean a;
    public final String jdField_if;

    private a(String paramString, boolean paramBoolean)
    {
      this.jdField_if = paramString;
      this.a = paramBoolean;
    }

    static a a(Context paramContext)
    {
      boolean bool = true;
      String str = "";
      try
      {
        str = Settings.System.getString(paramContext.getContentResolver(), "bd_setting_i");
        if (TextUtils.isEmpty(str))
          str = a(paramContext, "");
        Settings.System.putString(paramContext.getContentResolver(), "bd_setting_i", str);
        i = 0;
        if (i == 0)
          return new a(str, bool);
      }
      catch (Exception localException)
      {
        while (true)
        {
          Log.d("DeviceId", "Settings.System.getString or putString failed");
          if (TextUtils.isEmpty(str))
          {
            str = a(paramContext, "");
            i = bool;
            continue;
            bool = false;
            continue;
          }
          int i = bool;
        }
      }
    }

    private static String a(Context paramContext, String paramString)
    {
      String str1;
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        if (localTelephonyManager != null)
        {
          String str2 = localTelephonyManager.getDeviceId();
          str1 = str2;
          if (!TextUtils.isEmpty(str1))
            break label53;
          return paramString;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          Log.e("DeviceId", "Read IMEI failed", localException);
          str1 = null;
        }
      }
      label53: return str1;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.f.a.b
 * JD-Core Version:    0.6.0
 */