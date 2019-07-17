package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.a.f;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenConfig
{
  private static HashMap<String, OpenConfig> a = null;
  private static String b = null;
  private Context c = null;
  private String d = null;
  private JSONObject e = null;
  private long f = 0L;
  private int g = 0;
  private boolean h = true;

  private OpenConfig(Context paramContext, String paramString)
  {
    this.c = paramContext.getApplicationContext();
    this.d = paramString;
    a();
    b();
  }

  // ERROR //
  private String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/open/utils/OpenConfig:d	Ljava/lang/String;
    //   4: ifnull +121 -> 125
    //   7: new 61	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   14: aload_1
    //   15: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 68
    //   20: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 34	com/tencent/open/utils/OpenConfig:d	Ljava/lang/String;
    //   27: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 16
    //   35: aload_0
    //   36: getfield 32	com/tencent/open/utils/OpenConfig:c	Landroid/content/Context;
    //   39: aload 16
    //   41: invokevirtual 76	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   44: astore 17
    //   46: aload 17
    //   48: astore 5
    //   50: new 78	java/io/BufferedReader
    //   53: dup
    //   54: new 80	java/io/InputStreamReader
    //   57: dup
    //   58: aload 5
    //   60: ldc 82
    //   62: invokestatic 88	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   65: invokespecial 91	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   68: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   71: astore 6
    //   73: new 96	java/lang/StringBuffer
    //   76: dup
    //   77: invokespecial 97	java/lang/StringBuffer:<init>	()V
    //   80: astore 7
    //   82: aload 6
    //   84: invokevirtual 100	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   87: astore 12
    //   89: aload 12
    //   91: ifnull +69 -> 160
    //   94: aload 7
    //   96: aload 12
    //   98: invokevirtual 103	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   101: pop
    //   102: goto -20 -> 82
    //   105: astore 10
    //   107: aload 10
    //   109: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   112: aload 5
    //   114: invokevirtual 111	java/io/InputStream:close	()V
    //   117: aload 6
    //   119: invokevirtual 112	java/io/BufferedReader:close	()V
    //   122: ldc 114
    //   124: areturn
    //   125: aload_1
    //   126: astore 16
    //   128: goto -93 -> 35
    //   131: astore_2
    //   132: aload_0
    //   133: getfield 32	com/tencent/open/utils/OpenConfig:c	Landroid/content/Context;
    //   136: invokevirtual 118	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   139: aload_1
    //   140: invokevirtual 124	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   143: astore 4
    //   145: aload 4
    //   147: astore 5
    //   149: goto -99 -> 50
    //   152: astore_3
    //   153: aload_3
    //   154: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   157: ldc 114
    //   159: areturn
    //   160: aload 7
    //   162: invokevirtual 125	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   165: astore 14
    //   167: aload 5
    //   169: invokevirtual 111	java/io/InputStream:close	()V
    //   172: aload 6
    //   174: invokevirtual 112	java/io/BufferedReader:close	()V
    //   177: aload 14
    //   179: areturn
    //   180: astore 15
    //   182: aload 15
    //   184: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   187: aload 14
    //   189: areturn
    //   190: astore 11
    //   192: aload 11
    //   194: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   197: ldc 114
    //   199: areturn
    //   200: astore 8
    //   202: aload 5
    //   204: invokevirtual 111	java/io/InputStream:close	()V
    //   207: aload 6
    //   209: invokevirtual 112	java/io/BufferedReader:close	()V
    //   212: aload 8
    //   214: athrow
    //   215: astore 9
    //   217: aload 9
    //   219: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   222: goto -10 -> 212
    //
    // Exception table:
    //   from	to	target	type
    //   82	89	105	java/io/IOException
    //   94	102	105	java/io/IOException
    //   160	167	105	java/io/IOException
    //   0	35	131	java/io/FileNotFoundException
    //   35	46	131	java/io/FileNotFoundException
    //   132	145	152	java/io/IOException
    //   167	177	180	java/io/IOException
    //   112	122	190	java/io/IOException
    //   82	89	200	finally
    //   94	102	200	finally
    //   107	112	200	finally
    //   160	167	200	finally
    //   202	212	215	java/io/IOException
  }

  private void a()
  {
    String str = a("com.tencent.open.config.json");
    try
    {
      this.e = new JSONObject(str);
      return;
    }
    catch (JSONException localJSONException)
    {
      this.e = new JSONObject();
    }
  }

  private void a(String paramString1, String paramString2)
  {
    try
    {
      if (this.d != null)
        paramString1 = paramString1 + "." + this.d;
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(this.c.openFileOutput(paramString1, 0), Charset.forName("UTF-8"));
      localOutputStreamWriter.write(paramString2);
      localOutputStreamWriter.flush();
      localOutputStreamWriter.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  private void a(JSONObject paramJSONObject)
  {
    b("cgi back, do update");
    this.e = paramJSONObject;
    a("com.tencent.open.config.json", paramJSONObject.toString());
    this.f = SystemClock.elapsedRealtime();
  }

  private void b()
  {
    if (this.g != 0)
    {
      b("update thread is running, return");
      return;
    }
    this.g = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.d);
    localBundle.putString("appid_for_getting_config", this.d);
    localBundle.putString("status_os", Build.VERSION.RELEASE);
    localBundle.putString("status_machine", Build.MODEL);
    localBundle.putString("status_version", Build.VERSION.SDK);
    localBundle.putString("sdkv", "2.8.lite");
    localBundle.putString("sdkp", "a");
    new OpenConfig.1(this, localBundle).start();
  }

  private void b(String paramString)
  {
    if (this.h)
      f.b("OpenConfig", paramString + "; appid: " + this.d);
  }

  private void c()
  {
    int i = this.e.optInt("Common_frequency");
    if (i == 0)
      i = 1;
    long l = i * 3600000;
    if (SystemClock.elapsedRealtime() - this.f >= l)
      b();
  }

  public static OpenConfig getInstance(Context paramContext, String paramString)
  {
    if (a == null)
      a = new HashMap();
    if (paramString != null)
      b = paramString;
    if (paramString == null)
      if (b == null)
        break label74;
    label74: for (paramString = b; ; paramString = "0")
    {
      OpenConfig localOpenConfig = (OpenConfig)a.get(paramString);
      if (localOpenConfig == null)
      {
        localOpenConfig = new OpenConfig(paramContext, paramString);
        a.put(paramString, localOpenConfig);
      }
      return localOpenConfig;
    }
  }

  public boolean getBoolean(String paramString)
  {
    b("get " + paramString);
    c();
    Object localObject = this.e.opt(paramString);
    if (localObject == null);
    do
    {
      return false;
      if (!(localObject instanceof Integer))
        continue;
      if (!localObject.equals(Integer.valueOf(0)));
      for (int i = 1; ; i = 0)
        return i;
    }
    while (!(localObject instanceof Boolean));
    return ((Boolean)localObject).booleanValue();
  }

  public int getInt(String paramString)
  {
    b("get " + paramString);
    c();
    return this.e.optInt(paramString);
  }

  public long getLong(String paramString)
  {
    b("get " + paramString);
    c();
    return this.e.optLong(paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.OpenConfig
 * JD-Core Version:    0.6.0
 */