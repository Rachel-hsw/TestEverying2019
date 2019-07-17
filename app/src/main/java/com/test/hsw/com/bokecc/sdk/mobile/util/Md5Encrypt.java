package com.bokecc.sdk.mobile.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encrypt
{
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      String str = a.a(MessageDigest.getInstance(paramString2).digest(paramString1.getBytes()));
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return null;
  }

  public static String md5(File paramFile)
  {
    MessageDigest localMessageDigest;
    FileInputStream localFileInputStream;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      localFileInputStream = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[1024];
      while (true)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        localMessageDigest.update(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      Log.e("Md5 Error", localException.getMessage());
      return "";
    }
    localFileInputStream.close();
    String str = a.a(localMessageDigest.digest());
    return str;
  }

  public static String md5(String paramString)
  {
    return a(paramString, "MD5");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.util.Md5Encrypt
 * JD-Core Version:    0.6.0
 */