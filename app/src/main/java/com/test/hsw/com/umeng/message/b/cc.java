package com.umeng.message.b;

import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public final class cc
{
  public static boolean a(String paramString1, String paramString2, StringBuilder paramStringBuilder)
  {
    Log.w("TAG.", paramString2);
    try
    {
      Process localProcess = Runtime.getRuntime().exec("sh");
      DataInputStream localDataInputStream = new DataInputStream(localProcess.getInputStream());
      DataOutputStream localDataOutputStream = new DataOutputStream(localProcess.getOutputStream());
      if ((paramString1 != null) && (!"".equals(paramString1.trim())))
        localDataOutputStream.writeBytes("cd " + paramString1 + "\n");
      localDataOutputStream.writeBytes(paramString2 + " &\n");
      localDataOutputStream.writeBytes("exit \n");
      localDataOutputStream.flush();
      localProcess.waitFor();
      byte[] arrayOfByte = new byte[localDataInputStream.available()];
      localDataInputStream.read(arrayOfByte);
      String str = new String(arrayOfByte);
      if (str.length() != 0)
        paramStringBuilder.append(str);
      return true;
    }
    catch (Exception localException)
    {
      paramStringBuilder.append("Exception:" + localException.getMessage());
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cc
 * JD-Core Version:    0.6.0
 */