package com.tencent.wxop.stat.b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

final class m
{
  static int D()
  {
    String str1 = "";
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1)
        str1 = str1 + new String(arrayOfByte);
      localInputStream.close();
      String str2 = str1.trim();
      int j = str2.length();
      i = 0;
      if (j > 0)
      {
        int k = Integer.valueOf(str2).intValue();
        i = k;
      }
      return i * 1000;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        l.K().b(localThrowable);
        int i = 0;
      }
    }
  }

  static int aA()
  {
    String str1 = "";
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1)
        str1 = str1 + new String(arrayOfByte);
      localInputStream.close();
      String str2 = str1.trim();
      int j = str2.length();
      i = 0;
      if (j > 0)
      {
        int k = Integer.valueOf(str2).intValue();
        i = k;
      }
      return i * 1000;
    }
    catch (Exception localException)
    {
      while (true)
      {
        l.K().b(localException);
        int i = 0;
      }
    }
  }

  static String ax()
  {
    int i = 2;
    String[] arrayOfString1 = new String[i];
    arrayOfString1[0] = "";
    arrayOfString1[1] = "";
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
      String[] arrayOfString2 = localBufferedReader.readLine().split("\\s+");
      while (i < arrayOfString2.length)
      {
        arrayOfString1[0] = (arrayOfString1[0] + arrayOfString2[i] + " ");
        i++;
      }
      localBufferedReader.close();
      label96: return arrayOfString1[0];
    }
    catch (IOException localIOException)
    {
      break label96;
    }
  }

  static int r()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new n()).length;
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 1;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b.m
 * JD-Core Version:    0.6.0
 */